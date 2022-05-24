package org.planty_of_food.Sale;

public class SaleModel {
    private int saleID;
    private int productID;
    private int userID;

    public SaleModel(
            int saleID,
            int productID,
            int userID) {
        this.saleID = saleID;
        this.productID = productID;
        this.userID = userID;
    }

    public int getSaleID() {
        return this.saleID;
    }

    public int getUserID() {
        return this.userID;
    }

    public int getProductID() {
        return this.productID;
    }

    @Override
    public String toString() {
        return this.saleID + " - "
                + this.userID + ", "
                + this.productID;
    }
}
