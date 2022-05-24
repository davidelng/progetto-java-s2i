package org.planty_of_food;

import java.util.Scanner;

public class Controller {

    private Service service;

    // Inizializziamo il servizio nel costruttore del Controller
    public Controller() {
        this.service = Service.getInstance();
    }

    // Metodo principale che si occupa di catturare l'input dell'utente
    public void start() {

        Scanner scanner = new Scanner(System.in);
        int input = 0;

        // Loop principale
        do {
            printToConsole();

            input = scanner.nextInt();

            if (input < 0 || input > 5) {
                System.out.println("Invalid action, please try again\n");
                continue;
            }

            // Passiamo l'input al servizio che restituirà un output
            // Passiamo anche lo scanner per le ulteriori interazioni
            service.getOutput(input, scanner);

        } while (input != 0);

        scanner.close();
    }

    // Puliamo il codice inserendo le azioni possibili in un metodo a parte
    private void printToConsole() {
        System.out.println("\n***********************************************************************");
        System.out.println("What would you like to do?");
        System.out.println("1) View all the products");
        System.out.println("2) Buy an existing product");
        System.out.println("3) Return a product");
        System.out.println("4) Add new user");
        System.out.println("5) Export a list of available products");
        System.out.println("0) Quit\n");
        System.out.print("> "); // Prompt personalizzato per indicare all'utente la possibilità di digitare
    }
}
