/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author BESAN
 */
public class Files {

    public static void isFound(File f) throws IOException {
        if (!f.exists()) {
            System.out.println("A file was created " + " in the path " + Colors.ANSI_BLUE + "(" + f.getPath() + ")" + Colors.ANSI_RESET);
            f.createNewFile();
        } else {
            System.out.println("File " + f.getName() + " is in the path " + Colors.ANSI_BLUE + "(" + f.getPath() + ")" + Colors.ANSI_RESET);
        }
    }
                                                                                
    public static void save(File f, ArrayList<Product> p) {
        try {
            try (FileWriter fw = new FileWriter(f)) {
                PrintWriter pw = new PrintWriter(fw);
                for (int i = 0; i < p.size(); i++) {
                    pw.println(p.get(i).toString());
                }
                pw.close();
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    //
    public static void read(File f, ArrayList<Product> p) throws FileNotFoundException {
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] trim = line.split(",");
                if (line.endsWith("D") || line.endsWith("d")) {
                    Dimensional d = new Dimensional();
                    d.setId(Integer.parseInt(trim[0]));
                    d.setName(trim[1]);
                    d.setDesc(trim[2]);
                    d.setPrice(Float.parseFloat(trim[3]));
                    d.setWidth(Float.parseFloat(trim[4]));
                    d.setLength(Float.parseFloat(trim[5]));
                    p.add(d);
                } else if (line.endsWith("W")||line.endsWith("w")) {
                    Weighted w = new Weighted();
                    w.setId(Integer.parseInt(trim[0]));
                    w.setName(trim[1]);
                    w.setDesc(trim[2]);
                    w.setPrice(Float.parseFloat(trim[3]));
                    w.setWeight(Float.parseFloat(trim[3]));
                    p.add(w);
                }
            }

        } catch (FileNotFoundException | NumberFormatException | Exceptions e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
}
