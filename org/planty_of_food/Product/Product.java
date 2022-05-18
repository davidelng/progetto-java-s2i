package org.planty_of_food.Product;

import java.util.ArrayList;
import java.io.FileWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;

public class Product {

    private ArrayList<ProductModel> data;

    public Product() {
        this.data = ProductService.readProducts();
    }

    public ArrayList<ProductModel> getProducts() {
        return this.data;
    }

    public void showProducts() {
        System.out.println("ID | InsertDate | Name           | Brand | Price | Available");
        System.out.println("-------------------------------------------------------------");
        data.forEach(d -> System.out.println(d.toString()));
    }

    public void printProductsFile() {

        ArrayList<String> availableProducts = new ArrayList<String>();
        data.forEach(d -> {
            if (d.getAvailable()) {
                availableProducts.add(d.toStringCompleted());
            }
        });

        FileWriter csvWriter;

        try {
            String fileName = new SimpleDateFormat("'products_'dd_MM_yyyy'.csv'").format(new Date());
            csvWriter = new FileWriter(fileName);

            csvWriter.append("id");
            csvWriter.append(";");
            csvWriter.append("Name");
            csvWriter.append(";");
            csvWriter.append("Insert Date");
            csvWriter.append(";");
            csvWriter.append("Price");
            csvWriter.append(";");
            csvWriter.append("Brand");
            csvWriter.append("\n");

            for (String row : availableProducts) {
                csvWriter.append(row);
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();

            System.out.println("\nNew file " + fileName + " created\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
