package com.addressbook;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.opencsv.CSVReader;
import java.io.FileReader;

public class AddressBookCSVIO {

    public void writeContactsToCSV(List<ContactPerson> contactList) {

        try {

            CSVWriter writer = new CSVWriter(new FileWriter("addressbook.csv"));

            for (ContactPerson person : contactList) {

                String[] data = {
                        person.firstName,
                        person.lastName,
                        person.address,
                        person.city,
                        person.state,
                        String.valueOf(person.zip),
                        person.phoneNumber,
                        person.email
                };

                writer.writeNext(data);
            }

            writer.close();

            System.out.println("Contacts Written Successfully to CSV");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readContactsFromCSV() {

        try {

            CSVReader reader = new CSVReader(new FileReader("addressbook.csv"));

            String[] line;

            while ((line = reader.readNext()) != null) {

                for (String value : line) {
                    System.out.print(value + " ");
                }

                System.out.println();
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}