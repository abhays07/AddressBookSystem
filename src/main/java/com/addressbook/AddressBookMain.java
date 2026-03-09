package com.addressbook;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {

		System.out.println("Welcome to Address Book Program");

		HashMap<String, AddressBook> addressBookMap = new HashMap<>();

		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("\n1. Create New Address Book");
			System.out.println("2. Select Address Book");
			System.out.println("3. Search Person by City");
			System.out.println("4. Search Person by State");
			System.out.println("5. Exit");

			System.out.print("Enter Choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {

			case 1:

				System.out.print("Enter Address Book Name: ");
				String name = scanner.nextLine();

				addressBookMap.put(name, new AddressBook());

				System.out.println("Address Book Created Successfully");

				break;

			case 2:

				System.out.print("Enter Address Book Name: ");
				String bookName = scanner.nextLine();

				AddressBook addressBook = addressBookMap.get(bookName);

				if (addressBook == null) {
					System.out.println("Address Book Not Found");
					break;
				}

				boolean running = true;

				while (running) {

					System.out.println("\n1 Add Contact");
					System.out.println("2 Edit Contact");
					System.out.println("3 Delete Contact");
					System.out.println("4 Display Contacts");
					System.out.println("5 Back");

					System.out.print("Enter Choice: ");

					int option = scanner.nextInt();
					scanner.nextLine();

					switch (option) {

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

				break;

			case 3:
				System.out.print("Enter City to Search: ");
				String city = scanner.nextLine();

				addressBookMap.forEach((names, addressbook) -> {
					addressbook.searchPersonByCity(city);
				});

				break;
				
			case 4:

			    System.out.print("Enter State to Search: ");
			    String state = scanner.nextLine();

			    addressBookMap.forEach((names, addressbook) -> {
			        addressbook.searchPersonByState(state);
			    });

			    break;
		

			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}