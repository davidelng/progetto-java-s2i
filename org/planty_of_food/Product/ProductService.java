package org.planty_of_food.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;
import java.util.ArrayList;

public class ProductService {

    public static ArrayList<ProductModel> readProducts() {

        ArrayList<ProductModel> productData = new ArrayList<ProductModel>();

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("prodotti.csv"));

            String row = csvReader.readLine();

            while ((row = csvReader.readLine()) != null) {
                if (!(Pattern.matches("^[;]+", row))) {
                    String[] data = row.split(";");
                    ProductModel product = new ProductModel(
                            Integer.parseInt(data[0]), // ID prodotto
                            data[1], // nome
                            data[2], // data di inserimento
                            data[3], // prezzo
                            data[4], // marca
                            data[5]); // disponibilità
                    productData.add(product);
                }
            }

            csvReader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return productData;
    }

}
