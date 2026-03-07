package com.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	ArrayList<ContactPerson> contactList = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);

	public void addContact() {

		ContactPerson person = new ContactPerson();

		System.out.print("Enter First Name: ");
		person.firstName = scanner.nextLine();

		System.out.print("Enter Last Name: ");
		person.lastName = scanner.nextLine();

		System.out.print("Enter Address: ");
		person.address = scanner.nextLine();

		System.out.print("Enter City: ");
		person.city = scanner.nextLine();

		System.out.print("Enter State: ");
		person.state = scanner.nextLine();

		System.out.print("Enter Zip: ");
		person.zip = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter Phone Number: ");
		person.phoneNumber = scanner.nextLine();

		System.out.print("Enter Email: ");
		person.email = scanner.nextLine();

		contactList.add(person);
		System.out.println("Contact Added Successfully");
	}

	public void editContact() {
		System.out.println("Enter First Name of Contact to Edit:  ");
		String name = scanner.nextLine();

		boolean found = false;

		for (ContactPerson person : contactList) {
			if (person.firstName.equalsIgnoreCase(name)) {
				System.out.print("Enter New Address: ");
				person.address = scanner.nextLine();

				System.out.print("Enter New City: ");
				person.city = scanner.nextLine();

				System.out.print("Enter New State: ");
				person.state = scanner.nextLine();

				System.out.print("Enter New Zip: ");
				person.zip = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter New Phone Number: ");
				person.phoneNumber = scanner.nextLine();

				System.out.print("Enter New Email: ");
				person.email = scanner.nextLine();

				System.out.println("Contact Updated Successfully");
				found = true;
				break;
			}

		}
		if (!found) {
			System.out.println("Contact Not Found");
		}
	}

	public void deleteContact() {
		System.out.println("Enter First Name of Contact to Delete: ");
		String name = scanner.nextLine();

		ContactPerson personToDelete = null;

		for (ContactPerson person : contactList) {

			if (person.firstName.equals(name)) {
				personToDelete = person;
				break;
			}
		}

		if (personToDelete != null) {
			contactList.remove(personToDelete);
			System.out.println("Contact Deleted Successfully");
		} else {
			System.out.println("Contact Not Found");
		}
	}
	
	 public void displayContacts() {

	        for (ContactPerson person : contactList) {

	            System.out.println("Name: " + person.firstName + " " + person.lastName);
	            System.out.println("Address: " + person.address);
	            System.out.println("City: " + person.city);
	            System.out.println("State: " + person.state);
	            System.out.println("Zip: " + person.zip);
	            System.out.println("Phone: " + person.phoneNumber);
	            System.out.println("Email: " + person.email);
	            System.out.println("-------------------------");
	        }
	    }
}
