package com.addressbook;

import java.util.*;

public class AddressBook {
	ArrayList<ContactPerson> contactList = new ArrayList<>();
	
	Map<String, List<ContactPerson>> cityPersonMap = new HashMap<>();
	Map<String, List<ContactPerson>> statePersonMap = new HashMap<>();
	
	Scanner scanner = new Scanner(System.in);

	public void addContact() {

		ContactPerson person = new ContactPerson();

		System.out.print("Enter First Name: ");
		person.firstName = scanner.nextLine();

		System.out.print("Enter Last Name: ");
		person.lastName = scanner.nextLine();
		
		boolean duplicate = contactList.stream()
	            .anyMatch(p -> p.firstName.equalsIgnoreCase(person.firstName) &&
	                           p.lastName.equalsIgnoreCase(person.lastName));

	    if (duplicate) {
	        System.out.println("Duplicate Contact Found. Cannot Add.");
	        return;
	    }

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
		
		cityPersonMap.computeIfAbsent(person.city, k -> new ArrayList<>()).add(person);
		statePersonMap.computeIfAbsent(person.state, k -> new ArrayList<>()).add(person);
		
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
	
	public void searchPersonByCity(String city) {
		contactList.stream().filter(person -> person.city.equalsIgnoreCase(city)).forEach(person -> System.out.println(person.firstName + " "+person.lastName+" - "+ person.city));
	}
	
	public void searchPersonByState(String state) {

	    contactList.stream()
	            .filter(person -> person.state.equalsIgnoreCase(state))
	            .forEach(person ->
	                    System.out.println(person.firstName + " " + person.lastName + " - " + person.state));
	}
	
	
	public void viewPersonsByCity(String city) {

	    List<ContactPerson> persons = cityPersonMap.get(city);

	    if (persons != null) {
	        persons.forEach(person ->
	                System.out.println(person.firstName + " " + person.lastName));
	    } else {
	        System.out.println("No contacts found in this city.");
	    }
	}
	
	public void viewPersonsByState(String state) {

	    List<ContactPerson> persons = statePersonMap.get(state);

	    if (persons != null) {
	        persons.forEach(person ->
	                System.out.println(person.firstName + " " + person.lastName));
	    } else {
	        System.out.println("No contacts found in this state.");
	    }
	}
	
	public void countContactsByCity() {

	    cityPersonMap.forEach((city, persons) -> {
	        System.out.println(city + " : " + persons.size() + " contacts");
	    });
	}
	
	public void countContactsByState() {

	    statePersonMap.forEach((state, persons) -> {
	        System.out.println(state + " : " + persons.size() + " contacts");
	    });
	}
	
	public void sortContactsByName() {

	    contactList.stream()
	            .sorted((p1, p2) -> p1.firstName.compareToIgnoreCase(p2.firstName))
	            .forEach(System.out::println);
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
