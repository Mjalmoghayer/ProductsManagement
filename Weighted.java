package market;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Weighted extends Product {

    private float weight;

    @Override
    public float calcPay() {
        return this.weight * this.getPrice();
    }

    /**
     * @return the weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     * @throws market.Exceptions
     */
    public void setWeight(float weight) throws Exceptions {
        try {
            if (weight > 0) {
                this.weight = weight;
            } else {
                throw new Exceptions("Invalid value, The weight cannot be zero") {
                };
            }
        } catch (Exceptions e) {
            System.out.println(this.ANSI_RED + e.getMessage() + this.ANSI_RESET);
        }
    }

    @Override
    public String toString() {
        return this.getId() + "," + this.getName() + "," + this.getDesc() + "," + this.getPrice() + "," + this.getWeight() + "," + this.isInstanceOf(this);
    }

    @Override
    public String getDetails() {
        return "Product { Id = " + this.getId() + ", Name = " + this.getName() + ", Description = " + this.getDesc() + ", Price = " + this.getPrice() + ", Weight = " + this.getWeight() + ", Type = " + this.isInstanceOf(this) + " }";

    }

    public String isInstanceOf(Product w) {
        String n = "";
        if (w instanceof Weighted) {
            n = "W";
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

                System.out.println("Enter weight:");
                float weight = in.nextFloat();
                if (weight > 0) {
                    this.setWeight(weight);
                    break;
                } else {
                    System.out.println(this.ANSI_RED + "Invalid value, The weight cannot be zero" + this.ANSI_RESET);
                }

            } catch (Exception e) {
                System.out.println(this.ANSI_RED + "weight is of an integer type" + this.ANSI_RESET);
            }
        }

    }

    public static void delete(ArrayList<Product> p, int id) {
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i) instanceof Weighted) {
                Weighted Weighted = (Weighted) p.get(i);
                if (Weighted.getId() == id) {
                    System.out.println("removed (" + Weighted.toString() + ")");
                    p.remove(i);
                }
            }
        }
    }

    public static void disply(ArrayList<Product> p) {
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i) instanceof Weighted) {
                Weighted Weighted = (Weighted) p.get(i);
                System.out.println(Weighted.getDetails());
            }

        }
    }

    public static void edit(ArrayList<Product> products, int id, Scanner in) throws Exceptions {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof Weighted) {
                Weighted Weighted = (Weighted) products.get(i);
                if (Weighted.getId() == id) {
                    Weighted d = new Weighted();
                    System.out.println("You have chosen this product (" + Weighted.toString() + ") for modification");
                    d.inputScanner(in);
                    System.out.println("This product (" + products.set(i, d) + ") after modification (" + products.get(i) + ")");

                }
            }
        }
    }
}
