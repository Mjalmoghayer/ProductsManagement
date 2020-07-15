// Programming labII - Final Project
package market;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaTest {

    public static void main(String[] args) throws Exceptions, FileNotFoundException, IOException {
        ArrayList<Product> products = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        File file = new File(System.getProperty("user.dir"), "Products.txt");
        Files.isFound(file);
        Files.read(file, products);

        while (true) {
            Scanner in = new Scanner(System.in);
            Product.msg();
            int choice = 0;
            try {
                choice = in.nextInt();

            } catch (InputMismatchException e) {
            }
            switch (choice) {
                case 1:
                    //show all items
                    in.nextLine();
                    System.out.print(Colors.ANSI_BLUE + "Enter product type (D/W):" + Colors.ANSI_BLUE);
                    String in1 = in.nextLine();
                    if (in1.equalsIgnoreCase("D")) {
                        Dimensional.disply(products);
                    } else if (in1.equalsIgnoreCase("W")) {
                        Weighted.disply(products);

                    } else {
                        System.out.println(Colors.ANSI_RED + "Invalid value" + Colors.ANSI_RESET);
                    }
                    System.out.print(Colors.ANSI_BLACK);
                    break;
                //Add new item
                case 2:
                    in.nextLine();
                    System.out.print(Colors.ANSI_BLUE + "Enter product type (D/W):" + Colors.ANSI_BLUE);
                    String in2 = in.nextLine();
                    if (in2.equalsIgnoreCase("D")) {
                        Dimensional d = new Dimensional();//Dimensional
                        d.inputScanner(in);
                        products.add(d);

                    } else if (in2.equalsIgnoreCase("W")) {
                        Weighted w = new Weighted();//Weighted
                        w.inputScanner(in);
                        products.add(w);
                    } else {
                        System.out.println(Colors.ANSI_RED + "Invalid value" + Colors.ANSI_RESET);
                    }
                    System.out.print(Colors.ANSI_BLACK);
                    break;
                // delete item
                case 3:
                    in.nextLine();
                    System.out.print(Colors.ANSI_BLUE + "Enter product type (D/W):" + Colors.ANSI_BLUE);
                    String in3 = in.nextLine();
                    if (in3.equalsIgnoreCase("D")) {

                        while (true) {
                            try {
                                System.out.println("Enter the product ID you would like to delete");
                                int id = in.nextInt();
                                Dimensional.delete(products, id);
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                    } else if (in3.equalsIgnoreCase("W")) {
                        System.out.println("Enter the product ID you would like to delete");
                        try {
                            int id = in.nextInt();
                            Weighted.delete(products, id);
                        } catch (InputMismatchException e) {
                            System.out.println(e.getMessage());
                        }

                    } else {
                        System.out.println(Colors.ANSI_RED + "Invalid value" + Colors.ANSI_RESET);
                    }
                    System.out.print(Colors.ANSI_BLACK);
                    break;
                //edit item
                case 4:
                    in.nextLine();
                    System.out.print(Colors.ANSI_BLUE + "Enter product type (D/W):" + Colors.ANSI_BLUE);
                    String in4 = in.nextLine();
                    if (in4.equalsIgnoreCase("D")) {
                        System.out.println("Enter the product ID number you would like to edit.");
                        try {
                            int id = in.nextInt();
                            Dimensional.edit(products, id, in);
                        } catch (InputMismatchException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (in4.equalsIgnoreCase("W")) {
                        System.out.println("Enter the product ID number you would like to edit.");
                        try {
                            int id = in.nextInt();
                            Weighted.edit(products, id, in);
                        } catch (InputMismatchException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println(Colors.ANSI_RED + "Invalid value" + Colors.ANSI_RESET);
                    }
                    System.out.print(Colors.ANSI_BLACK);
                    break;
                //calc total items
                case 5:
                    float TotalPrice = 0;
                    for (int i = 0; i < products.size(); i++) {
                        TotalPrice += products.get(i).calcPay();
                    }
                    System.out.println("The total price of all products = " + TotalPrice);

                    System.out.print(Colors.ANSI_BLACK);
                    break;
                case 6:
                    System.out.println("The data was saved in a file (" + Colors.ANSI_BLUE + file.getName() + ")" + Colors.ANSI_RESET);
                    Files.save(file, products);
                    break;
                case 7:
                    System.out.println(Colors.ANSI_RED + "Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println(Colors.ANSI_RED + "Invalid value" + Colors.ANSI_RESET);
                    break;
            }
        }
    }
}
