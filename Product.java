package market;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Product implements Colors {

    private int id;
    private String name;
    private String desc;
    private float price;
    
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }
    public abstract float calcPay();

    public static void msg() {
        System.out.println("1- Show All Products\n"
                + "2- Add Product\n"
                + "3- Delete Product\n"
                + "4- Edit Product\n"
                + "5- Calculate Total Price\n"
                + "6- Save data to file\n"
                + "7- Exit\n"
                + "Enter your choice:");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public abstract String getDetails();
}
