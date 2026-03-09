package com.addressbook;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;

public class AddressBookJSONIO {

	public void writeContactsToJSON(List<ContactPerson> contactList) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try {

			FileWriter writer = new FileWriter("addressbook.json");

			gson.toJson(contactList, writer);

			writer.close();

			System.out.println("Contacts Written Successfully to JSON File");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readContactsFromJSON() {

		Gson gson = new Gson();

		try {

			FileReader reader = new FileReader("addressbook.json");

			Type listType = new TypeToken<List<ContactPerson>>() {
			}.getType();

			List<ContactPerson> contacts = gson.fromJson(reader, listType);

			contacts.forEach(System.out::println);

			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}