package com.addressbook;

import java.util.Scanner;

public class AddressBook {
	public void addContact() {
		Scanner scanner = new Scanner(System.in);
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

	        System.out.println("Contact Added Successfully");
	}
}
