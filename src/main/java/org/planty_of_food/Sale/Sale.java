package org.planty_of_food.Sale;

import java.util.ArrayList;

public class Sale {

    private ArrayList<SaleModel> data;

    public Sale() {
        this.data = SaleService.readSales();
    }

    public void showSales() {
        System.out.println("ID | User | Product");
        System.out.println("--------------------");
        data.forEach(d -> System.out.println(d.toString()));
    }

    public ArrayList<SaleModel> getSales() {
        return this.data;
    }

}
