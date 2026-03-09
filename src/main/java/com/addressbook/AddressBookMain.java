package com.addressbook;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        HashMap<String, AddressBook> addressBookMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create New Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Search Person by City");
            System.out.println("4. Search Person by State");
            System.out.println("5. View Persons by City");
            System.out.println("6. View Persons by State");
            System.out.println("7. Count Contacts by City");
            System.out.println("8. Count Contacts by State");
            System.out.println("9. Exit");

            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 7) {
                System.out.println("Exiting... Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Address Book Name: ");
                    String name = scanner.nextLine();
                    addressBookMap.put(name, new AddressBook());
                    System.out.println("Address Book '" + name + "' Created Successfully");
                    break;

                case 2:
                    System.out.print("Enter Address Book Name to Open: ");
                    String bookName = scanner.nextLine();
                    AddressBook selectedBook = addressBookMap.get(bookName);

                    if (selectedBook == null) {
                        System.out.println("Error: Address Book Not Found!");
                        break;
                    }

                    boolean running = true;
                    while (running) {
                        System.out.println("\n--- Managing: " + bookName + " ---");
                        System.out.println("1. Add Contact");
                        System.out.println("2. Edit Contact");
                        System.out.println("3. Delete Contact");
                        System.out.println("4. Display Contacts");
                        System.out.println("5. Back to Main Menu");

                        System.out.print("Enter Choice: ");
                        int option = scanner.nextInt();
                        scanner.nextLine();

                        switch (option) {
                            case 1 -> selectedBook.addContact();
                            case 2 -> selectedBook.editContact();
                            case 3 -> selectedBook.deleteContact();
                            case 4 -> selectedBook.displayContacts();
                            case 5 -> running = false;
                            default -> System.out.println("Invalid Choice");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter City to Search: ");
                    String searchCity = scanner.nextLine();
                    addressBookMap.forEach((n, book) -> book.searchPersonByCity(searchCity));
                    break;

                case 4:
                    System.out.print("Enter State to Search: ");
                    String searchState = scanner.nextLine();
                    addressBookMap.forEach((n, book) -> book.searchPersonByState(searchState));
                    break;

                case 5:
                    System.out.print("Enter City Name: ");
                    String cityName = scanner.nextLine();
                    // Used (n, a) to avoid variable name collisions
                    addressBookMap.forEach((n, a) -> a.viewPersonsByCity(cityName));
                    break;

                case 6:
                    System.out.print("Enter State Name: ");
                    String stateName = scanner.nextLine();
                    // Using unique parameter names (k, v) for the lambda
                    addressBookMap.forEach((k, v) -> v.viewPersonsByState(stateName));
                    break;
                
                case 7:

                    addressBookMap.forEach((x, y) -> {
                        y.countContactsByCity();
                    });

                    break;

                case 8:

                    addressBookMap.forEach((m, n) -> {
                        n.countContactsByState();
                    });

                    break;
                default:
                    System.out.println("Invalid Choice. Please try again.");
            }
        }
        scanner.close();
    }
}