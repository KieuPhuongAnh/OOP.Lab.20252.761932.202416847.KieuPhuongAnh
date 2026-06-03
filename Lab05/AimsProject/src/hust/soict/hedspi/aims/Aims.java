package hust.soict.hedspi.aims;

import java.util.Scanner;
import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.exception.PlayerException;

public class Aims {

    public static Store store = new Store();
    public static Cart cart = new Cart();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        DigitalVideoDisc dvd = new DigitalVideoDisc(
                1,
                "Test DVD",
                "Animation",
                "Director",
                0,          // length = 0
                19.95f);

        try {
            dvd.play();
        } catch (PlayerException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + e.getMessage(),
                    "Illegal DVD Length",
                    JOptionPane.ERROR_MESSAGE);

            e.printStackTrace();
        }
    }

    public static void showMenu() {
        System.out.println("\nAIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    public static void viewStore() {

        store.print();

        System.out.println("\nOptions:");
        System.out.println("1. See media details");
        System.out.println("2. Add media to cart");
        System.out.println("3. Play media");
        System.out.println("0. Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

        case 1:
            System.out.print("Enter media title: ");
            String title = scanner.nextLine();

            for (Media media : store.getItemsInStore()) {
                if (media.getTitle().equalsIgnoreCase(title)) {
                    System.out.println(media.toString());
                }
            }
            break;

        case 2:
            System.out.print("Enter media title: ");
            title = scanner.nextLine();

            for (Media media : store.getItemsInStore()) {
                if (media.getTitle().equalsIgnoreCase(title)) {
                    cart.addMedia(media);
                }
            }
            break;

        case 3:
            System.out.print("Enter media title: ");
            title = scanner.nextLine();

            for (Media media : store.getItemsInStore()) {

                if (media.getTitle().equalsIgnoreCase(title)
                        && media instanceof Playable) {

                	try {

                	    ((Playable) media).play();

                	} catch (PlayerException e) {

                	    System.out.println("===== PLAYER EXCEPTION =====");

                	    System.out.println("getMessage():");
                	    System.out.println(e.getMessage());

                	    System.out.println("\ntoString():");
                	    System.out.println(e.toString());

                	    System.out.println("\nprintStackTrace():");
                	    e.printStackTrace();

                	    JOptionPane.showMessageDialog(
                	            null,
                	            e.getMessage(),
                	            "Player Exception",
                	            JOptionPane.ERROR_MESSAGE);
                	}
                }
            }
            break;
        }
    }

    public static void updateStore() {

        System.out.println("\nOptions:");
        System.out.println("1. Add DVD");
        System.out.println("2. Add Book");
        System.out.println("3. Remove media");
        System.out.println("0. Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

        case 1:

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Category: ");
            String category = scanner.nextLine();

            System.out.print("Director: ");
            String director = scanner.nextLine();

            System.out.print("Length: ");
            int length = scanner.nextInt();

            System.out.print("Cost: ");
            float cost = scanner.nextFloat();

            DigitalVideoDisc dvd =
                    new DigitalVideoDisc(
                            id,
                            title,
                            category,
                            director,
                            length,
                            cost);

            store.addMedia(dvd);
            break;

        case 2:

            System.out.print("ID: ");
            id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Title: ");
            title = scanner.nextLine();

            System.out.print("Category: ");
            category = scanner.nextLine();

            System.out.print("Cost: ");
            cost = scanner.nextFloat();

            Book book =
                    new Book(
                            id,
                            title,
                            category,
                            cost);

            store.addMedia(book);
            break;

        case 3:

            System.out.print("Enter media title: ");
            title = scanner.nextLine();

            Media found = null;

            for (Media media : store.getItemsInStore()) {
                if (media.getTitle().equalsIgnoreCase(title)) {
                    found = media;
                    break;
                }
            }

            if (found != null) {
                store.removeMedia(found);
            }

            break;
        }
    }

    public static void seeCart() {

        cart.print();

        System.out.println("\nOptions:");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Title");
        System.out.println("3. Remove media");
        System.out.println("4. Play media");
        System.out.println("5. Place order");
        System.out.println("0. Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

        case 1:

            System.out.print("Enter ID: ");
            int id = scanner.nextInt();

            Media media = cart.searchById(id);

            if (media != null)
                System.out.println(media.toString());
            else
                System.out.println("Not found");

            break;

        case 2:

            System.out.print("Enter title: ");
            String title = scanner.nextLine();

            media = cart.searchByTitle(title);

            if (media != null)
                System.out.println(media.toString());
            else
                System.out.println("Not found");

            break;

        case 3:

            System.out.print("Enter title: ");
            title = scanner.nextLine();

            media = cart.searchByTitle(title);

            if (media != null)
                cart.removeMedia(media);

            break;

        case 4:

            System.out.print("Enter title: ");
            title = scanner.nextLine();

            media = cart.searchByTitle(title);

            if (media instanceof Playable) {

                try {

                    ((Playable) media).play();

                } catch (PlayerException e) {

                    System.out.println("===== PLAYER EXCEPTION =====");

                    System.out.println("getMessage():");
                    System.out.println(e.getMessage());

                    System.out.println("\ntoString():");
                    System.out.println(e.toString());

                    System.out.println("\nprintStackTrace():");
                    e.printStackTrace();

                    JOptionPane.showMessageDialog(
                            null,
                            e.getMessage(),
                            "Player Exception",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

            break;

        case 5:

            System.out.println("Order created!");
            break;
        }
    }
}