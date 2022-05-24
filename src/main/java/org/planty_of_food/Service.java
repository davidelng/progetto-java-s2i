package org.planty_of_food;

import org.planty_of_food.Product.Product;
import org.planty_of_food.User.User;
import org.planty_of_food.User.UserService;
import org.planty_of_food.Sale.Sale;
import org.planty_of_food.Sale.SaleService;
import java.util.Scanner;

public class Service {

    private static Service service;

    private Service() {
        products = new Product();
        users = new User();
        sales = new Sale();
    }

    public static Service getInstance() {
        if (service == null) {
            service = new Service();
        }
        return service;
    }

    protected Product products;
    protected User users;
    protected Sale sales;

    // Eseguiamo un'azione in base all'input ricevuto dal Controller
    public void getOutput(int input, Scanner scanner) {
        switch (input) {
            case 1:
                // Visualizza tutti i prodotti all'interno del sistema
                products.showProducts();
                break;
            case 2:
                // Compra un prodotto esistente
                SaleService.makeNewOrder(users.getUsers(), products.getProducts(), sales.getSales(), scanner);
                break;
            case 3:
                // Restituisci un prodotto
                sales.showSales();
                SaleService.returnSale(sales.getSales(), scanner);
                break;
            case 4:
                // Aggiungi nuovo utente
                UserService.addUser(users.getUsers(), scanner);
                break;
            case 5:
                // Esporta file con prodotti disponibili
                products.printProductsFile();
                break;
            default:
                break;
        }
    }
}
