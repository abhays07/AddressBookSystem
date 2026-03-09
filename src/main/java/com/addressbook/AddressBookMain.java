package com.addressbook;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        // Service initializations
        AddressBookFileIO fileIO = new AddressBookFileIO();
        AddressBookCSVIO csvIO = new AddressBookCSVIO();
        AddressBookJSONIO jsonIO = new AddressBookJSONIO();
        AddressBookDBService dbService = new AddressBookDBService();
        
        // addressBookMap stores multiple address books by name
        HashMap<String, AddressBook> addressBookMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1.  Create New Address Book");
            System.out.println("2.  Select Address Book");
            System.out.println("3.  Search Person by City");
            System.out.println("4.  Search Person by State");
            System.out.println("5.  View Persons by City");
            System.out.println("6.  View Persons by State");
            System.out.println("7.  Count Contacts by City");
            System.out.println("8.  Count Contacts by State");
            System.out.println("9.  Sort Contacts by Name");
            System.out.println("10. Sort Contacts by City");
            System.out.println("11. Sort Contacts by State");
            System.out.println("12. Sort Contacts by Zip");
            System.out.println("13. Write Contacts to File");
            System.out.println("14. Read Contacts from File");
            System.out.println("15. Write Contacts to CSV");
            System.out.println("16. Read Contacts from CSV");
            System.out.println("17. Write Contacts to JSON");
            System.out.println("18. Read Contacts from JSON");
            System.out.println("19. Retrieve Contacts from Database");
            System.out.println("20. Update Contact City in Database");
            System.out.println("21 Retrieve Contacts by Date Range");
            System.out.println("22. Exit");

            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Logic Check: If choice is 21, break the loop
            if (choice == 22) {
                System.out.println("Exiting - Thank you for choosing AddressBook");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Address Book Name: ");
                    String bookTitle = scanner.nextLine();
                    addressBookMap.put(bookTitle, new AddressBook());
                    System.out.println("Address Book '" + bookTitle + "' Created.");
                    break;

                case 2:
                    System.out.print("Enter Address Book Name to Open: ");
                    String searchBook = scanner.nextLine();
                    AddressBook selectedBook = addressBookMap.get(searchBook);

                    if (selectedBook == null) {
                        System.out.println("Error: Address Book Not Found!");
                        break;
                    }

                    boolean running = true;
                    while (running) {
                        System.out.println("\n--- Managing: " + searchBook + " ---");
                        System.out.println("1. Add Contact | 2. Edit | 3. Delete | 4. Display | 5. Back");
                        System.out.print("Choice: ");
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
                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();
                    addressBookMap.forEach((k, v) -> v.searchPersonByCity(city));
                    break;

                case 4:
                    System.out.print("Enter State: ");
                    String state = scanner.nextLine();
                    addressBookMap.forEach((k, v) -> v.searchPersonByState(state));
                    break;

                case 5:
                    System.out.print("Enter City Name: ");
                    String cityName = scanner.nextLine();
                    addressBookMap.forEach((k, v) -> v.viewPersonsByCity(cityName));
                    break;

                case 6:
                    System.out.print("Enter State Name: ");
                    String stateName = scanner.nextLine();
                    addressBookMap.forEach((k, v) -> v.viewPersonsByState(stateName));
                    break;

                case 7:
                    addressBookMap.forEach((k, v) -> v.countContactsByCity());
                    break;

                case 8:
                    addressBookMap.forEach((k, v) -> v.countContactsByState());
                    break;

                case 9:
                    addressBookMap.forEach((k, v) -> v.sortContactsByName());
                    break;

                case 10:
                    addressBookMap.forEach((k, v) -> v.sortContactsByCity());
                    break;

                case 11:
                    addressBookMap.forEach((k, v) -> v.sortContactsByState());
                    break;

                case 12:
                    addressBookMap.forEach((k, v) -> v.sortContactsByZip());
                    break;

                case 13:
                    addressBookMap.forEach((name, ab) -> fileIO.writeContactsToFile(ab.getContacts()));
                    break;

                case 14:
                    fileIO.readContactsFromFile();
                    break;

                case 15:
                    addressBookMap.forEach((name, ab) -> csvIO.writeContactsToCSV(ab.getContacts()));
                    break;

                case 16:
                    csvIO.readContactsFromCSV();
                    break;

                case 17:
                    addressBookMap.forEach((name, ab) -> jsonIO.writeContactsToJSON(ab.getContacts()));
                    break;

                case 18:
                    jsonIO.readContactsFromJSON();
                    break;

                case 19:
                    dbService.retrieveContacts();
                    break;
                
                case 21:

                    System.out.print("Enter Start Date (YYYY-MM-DD): ");
                    String startDate = scanner.nextLine();

                    System.out.print("Enter End Date (YYYY-MM-DD): ");
                    String endDate = scanner.nextLine();

                    dbService.retrieveContactsByDateRange(startDate, endDate);

                    break;

                case 20:
                    System.out.print("Enter First Name: ");
                    String fName = scanner.nextLine();
                    System.out.print("Enter New City: ");
                    String newCity = scanner.nextLine();

                    boolean updated = dbService.updateContactCity(fName, newCity);

                    if (updated) {
                        // Also update in-memory map if the contact exists
                        addressBookMap.values().forEach(ab -> ab.updateContactCity(fName, newCity));
                        System.out.println("Database and Local Memory Updated Successfully");
                    } else {
                        System.out.println("Update Failed in Database");
                    }
                    break;

                case 21:

                    System.out.print("Enter Start Date (YYYY-MM-DD): ");
                    String startDate = scanner.nextLine();

                    System.out.print("Enter End Date (YYYY-MM-DD): ");
                    String endDate = scanner.nextLine();

                    dbService.retrieveContactsByDateRange(startDate, endDate);

                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
        scanner.close();
    }
}