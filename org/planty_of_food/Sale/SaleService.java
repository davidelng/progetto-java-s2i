package org.planty_of_food.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Scanner;

import org.planty_of_food.User.UserModel;
import org.planty_of_food.Product.ProductModel;

public class SaleService {

    // Metodo per mostrare la lista degli ordini
    public static ArrayList<SaleModel> readSales() {

        ArrayList<SaleModel> saleData = new ArrayList<SaleModel>();

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("vendite.csv"));

            String row = csvReader.readLine();

            while ((row = csvReader.readLine()) != null) {
                if (!(Pattern.matches("^[;]+", row))) {
                    String[] data = row.split(";");
                    SaleModel sale = new SaleModel(
                            Integer.parseInt(data[0]), // ID ordine
                            Integer.parseInt(data[1]), // ID prodotto
                            Integer.parseInt(data[2]) // ID utente
                    );
                    saleData.add(sale);
                }
            }

            csvReader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return saleData;
    }

    // Metodo per fare un nuovo ordine
    public static void makeNewOrder(
            ArrayList<UserModel> users,
            ArrayList<ProductModel> products,
            ArrayList<SaleModel> sales,
            Scanner scanner) {

        System.out.println("\nYou'll need your user ID and a product ID to make an order");

        System.out.println("\nPlease enter your ID:");
        System.out.print("\n> ");
        int userID = scanner.nextInt();
        for (UserModel user : users) {
            if (user.getUserID() == userID) {
                break;
            } else {
                System.out.println("No such user");
                return;
            }
        }

        System.out.println("\nPlease enter the desired product ID:");
        System.out.print("\n> ");
        int productID = Integer.parseInt(scanner.next());
        for (ProductModel product : products) {
            if (product.getID() == productID) {
                product.setAvailable(false);
                break;
            } else {
                System.out.println("No such product");
                return;
            }
        }

        // genera nuovo ID
        SaleModel lastSale = sales.get(sales.size() - 1);
        int newOrderID = lastSale.getSaleID() + 1;

        // inserisci l'ordine
        SaleModel newOrder = new SaleModel(newOrderID, productID, userID);
        sales.add(newOrder);
        System.out.println("New order placed: " + newOrderID + " " + productID + " " + userID);
    }

    // Metodo per restituire un acquisto
    public static void returnSale(ArrayList<SaleModel> data, Scanner scanner) {
        try {
            int inputId = 0;
            System.out.println("\nPlease enter the ID of the order you wish to return (Enter 0 to cancel):");
            System.out.print("> ");
            inputId = scanner.nextInt();
            if (inputId == 0)
                return;
            for (int i = 0; i <= data.size(); i++) {
                SaleModel sale = data.get(i);
                if (inputId == sale.getSaleID()) {
                    data.remove(inputId - 1);
                    System.out.println("Order returned!");
                    break;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No order corresponding to that ID!");
        }
    }

}
