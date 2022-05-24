package org.planty_of_food.Product;

public class ProductModel {
    private int productID;
    private String name;
    private String insertDate;
    private String price;
    private String brand;
    private Boolean available;

    public ProductModel(
            int productID,
            String name,
            String insertDate,
            String price,
            String brand,
            String available) {
        this.productID = productID;
        this.name = name;
        this.insertDate = insertDate;
        this.price = price.substring(0, 4);
        this.brand = brand;
        if (available.compareTo("SI") == 0) {
            this.available = true;
        } else {
            this.available = false;
        }
    }

    public int getID() {
        return this.productID;
    }

    public boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(boolean b) {
        this.available = b;
    }

    public String isAvailable() {
        if (available) {
            return "YES";
        } else {
            return "NO";
        }
    }

    @Override
    public String toString() {
        return this.productID + " - ["
                + this.insertDate + "] "
                + this.name + ", "
                + this.brand + " ("
                + this.price + ") ["
                + this.isAvailable() + "]";
    }

    public String toStringCompleted() {
        return this.productID + ";"
                + this.insertDate + ";"
                + this.name + ";"
                + this.brand + ";"
                + this.price + ";";
    }
}
