package org.planty_of_food;

public class Application {

    static String header = "***********************************************************************\n"
            + "*  ____  _             _            ___   __   _____               _  *\n"
            + "* |  _ \\| | __ _ _ __ | |_ _   _   / _ \\ / _| |  ___|__   ___   __| | *\n"
            + "* | |_) | |/ _` | '_ \\| __| | | | | | | | |_  | |_ / _ \\ / _ \\ / _` | *\n"
            + "* |  __/| | (_| | | | | |_| |_| | | |_| |  _| |  _| (_) | (_) | (_| | *\n"
            + "* |_|   |_|\\__,_|_| |_|\\__|\\__, |  \\___/|_|   |_|  \\___/ \\___/ \\__,_| *\n"
            + "*                          |___/                                      *\n"
            + "*                                                                     *\n"
            + "***********************************************************************";

    public static void main(String[] args) {

        // Mostriamo l'header in ASCII all'avvio
        System.out.println(header);
        // Inizializziamo il controller che gestirà l'input dell'utente
        Controller controller = new Controller();
        controller.start();

    }
}
