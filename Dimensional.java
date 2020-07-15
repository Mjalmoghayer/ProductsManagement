package market;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dimensional extends Product {

    private float width;
    private float length;

    @Override
    public float calcPay() {
        return this.width * this.length * this.getPrice();
    }

    /**
     * @return the width
     */
    public float getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     * @throws market.Exceptions
     */
    public void setWidth(float width) throws Exceptions {

        try {
            if (width > 0) {
                this.width = width;

            } else {
                throw new Exceptions("Invalid value, The width cannot be zero") {
                };
            }
        } catch (Exceptions e) {
            System.out.println(this.ANSI_RED + e.getMessage() + this.ANSI_RESET);

        }

    }

    /**
     * @return the length
     */
    public float getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(float length) throws Exceptions {
        try {
            if (length > 0) {
                this.length = length;
            } else {
                throw new Exceptions("Invalid value, The length cannot be zero") {
                };
            }
        } catch (Exceptions e) {
            System.out.println(this.ANSI_RED + e.getMessage() + this.ANSI_RESET);
        }

    }

    @Override
    public String toString() {
        return this.getId() + "," + this.getName() + "," + this.getDesc() + "," + this.getPrice() + "," + this.getWidth() + "," + this.getLength() + "," + this.isInstanceOf(this);
    }

    @Override
    public String getDetails() {
        return "Product { Id = " + this.getId() + ", Name = " + this.getName() + ", Description = " + this.getDesc() + ", Price = " + this.getPrice() + ", Width = " + this.getWidth() + ", Length = " + this.getLength() + ", Type = " + this.isInstanceOf(this) + " }";
    }

    public String isInstanceOf(Product d) {
        String n = "";
        if (d instanceof Dimensional) {
            n = "D";
        } else {
            return Colors.ANSI_RED + "Not derived From this class";
        }
        return n;
    }

    public void inputScanner(Scanner in) throws Exceptions {

        while (true) {
            in = new Scanner(System.in);
            try {
                System.out.println("Enter id:");
                int id = in.nextInt();
                if (id > 0) {
                    this.setId(id);
                    break;
                } else {
                    System.out.println(this.ANSI_RED + "Id connot be zero" + this.ANSI_RESET);
                }

            } catch (Exception e) {
                System.out.println(this.ANSI_RED + "Id is of an integer type" + this.ANSI_RESET);
            }
        }

        in.nextLine();
        System.out.println("Enter Name:");
        String name = in.nextLine();
        this.setName(name);
        System.out.println("Enter Desc:");
        String desc = in.nextLine();
        this.setDesc(desc);

        while (true) {
            in = new Scanner(System.in);
            try {
                System.out.println("Enter Price:");
                float price = in.nextFloat();
                if (price > 0) {
                    this.setPrice(price);
                    break;
                } else {
                    System.out.println(this.ANSI_RED + "Invalid value, The price cannot be zero" + this.ANSI_RESET);
                }
            } catch (Exception e) {
                System.out.println(this.ANSI_RED + "Price is of an integer type" + this.ANSI_RESET);
            }
        }
        while (true) {
            in = new Scanner(System.in);
            try {
                System.out.println("Enter width:");
                float width = in.nextFloat();
                if (width > 0) {
                    this.setWidth(width);
                    break;
                } else {
                    System.out.println(this.ANSI_RED + "Invalid value, The width cannot be zero" + this.ANSI_RESET);
                }

            } catch (Exception e) {
                System.out.println(this.ANSI_RED + "width is of an integer type" + this.ANSI_RESET);
            }
        }

        while (true) {
            in = new Scanner(System.in);
            try {
                System.out.println("Enter length:");
                float length = in.nextFloat();
                if (length > 0) {
                    this.setLength(length);
                    break;
                } else {
                    System.out.println(this.ANSI_RED + "Invalid value, The length cannot be zero" + this.ANSI_RESET);
                }

            } catch (Exception e) {
                System.out.println(this.ANSI_RED + "length is of an integer type" + this.ANSI_RESET);
            }
        }

    }

    //show all items
    public static void disply(ArrayList<Product> p) {
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i) instanceof Dimensional) {
                Dimensional Dimensional = (Dimensional) p.get(i);
                System.out.println(Dimensional.getDetails());
            }

        }
    }

    public static void delete(ArrayList<Product> p, int id) {
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i) instanceof Dimensional) {
                Dimensional Dimensional = (Dimensional) p.get(i);
                if (Dimensional.getId() == id) {
                    System.out.println("removed (" + Dimensional.toString() + ")");
                    p.remove(i);

                }
            }
        }
    }

    public static void edit(ArrayList<Product> products, int id, Scanner in) throws Exceptions {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof Dimensional) {
                Dimensional Dimensional = (Dimensional) products.get(i);
                if (Dimensional.getId() == id) {
                    Dimensional d = new Dimensional();
                    System.out.println("You have chosen this product (" + Dimensional.toString() + ") for modification");
                    d.inputScanner(in);
                    System.out.println("This product (" + products.set(i, d) + ") after modification (" + products.get(i) + ")");

                }
            }
        }
    }
}
