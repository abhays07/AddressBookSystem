package com.addressbook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AddressBookFileIO {

    public void writeContactsToFile(List<ContactPerson> contactList) {

        try {
            FileWriter writer = new FileWriter("addressbook.txt");

            for (ContactPerson person : contactList) {

                writer.write(person.firstName + "," +
                        person.lastName + "," +
                        person.address + "," +
                        person.city + "," +
                        person.state + "," +
                        person.zip + "," +
                        person.phoneNumber + "," +
                        person.email + "\n");
            }

            writer.close();

            System.out.println("Contacts Written Successfully To File");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void readContactsFromFile() {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("addressbook.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}