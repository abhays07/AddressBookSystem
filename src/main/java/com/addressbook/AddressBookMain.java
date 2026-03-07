package com.addressbook;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\n1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addressBook.addContact();
                    break;

                case 2:
                    addressBook.editContact();
                    break;

                case 3:
                    addressBook.deleteContact();
                    break;

                case 4:
                    addressBook.displayContacts();
                    break;

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}