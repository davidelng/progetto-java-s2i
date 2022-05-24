package org.planty_of_food.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService {

    public static ArrayList<UserModel> readUsers() {

        ArrayList<UserModel> userData = new ArrayList<UserModel>();

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("./utenti.csv")); //

            String row = csvReader.readLine();

            while ((row = csvReader.readLine()) != null) {
                if (!(Pattern.matches("^[;]+", row))) {
                    String[] data = row.split(";");
                    UserModel product = new UserModel(
                            Integer.parseInt(data[0]), // ID utente
                            data[1], // Nome
                            data[2], // Cognome
                            data[3], // Data di nascita
                            data[4], // Indirizzo
                            data[5]); // ID Documento
                    userData.add(product);
                }
            }

            csvReader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return userData;
    }

    public static void addUser(ArrayList<UserModel> data, Scanner scanner) {

        String[] userData = new String[6];

        // controlliamo se l'utente esiste già
        boolean idIsAvailable = false;
        do {
            System.out.println("\nEnter new user ID:");
            System.out.print("> ");
            userData[0] = scanner.next();
            for (int i = 0; i < data.size(); i++) {
                UserModel user = data.get(i);
                if (user.getUserID() == (Integer.parseInt(userData[0]))) {
                    idIsAvailable = false;
                    System.out.println("This user ID already exists.\n");
                    break;
                } else {
                    idIsAvailable = true;
                }
            }

        } while (idIsAvailable == false);

        // raccogliamo info sull'utente da registrare
        System.out.println("\nEnter your first name:");
        System.out.print("> ");
        userData[1] = scanner.next();
        System.out.println("\nEnter your last name:");
        System.out.print("> ");
        userData[2] = scanner.next();
        System.out.println("\nEnter your date of birth (DD/MM/YY):");
        System.out.print("> ");
        userData[3] = scanner.next();
        System.out.println("\nEnter your address (Street, City):");
        System.out.print("> ");
        userData[4] = scanner.next();
        System.out.println("\nEnter your document ID:");
        System.out.print("> ");
        userData[5] = scanner.next();

        // creiamo il nuovo utente
        UserModel user = new UserModel(
                Integer.parseInt(userData[0]), // ID utente
                userData[1], // Nome
                userData[2], // Cognome
                userData[3], // Data di nascita
                userData[4], // Indirizzo
                userData[5]); // ID Documento

        // aggiungiamo il nuovo utente alla lista degli utenti
        data.add(user);

        System.out.println(
                "New user succesfully added: " + userData[1] + " " + userData[2] + " [ID: " + userData[0] + "]");
    }

}