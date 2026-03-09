package com.addressbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressBookDBService {

	public void retrieveContacts() {

		String url = "jdbc:mysql://localhost:3306/addressbook_service";
		String username = "root";
		String password = "05052005";

		try {

			Connection connection = DriverManager.getConnection(url, username, password);

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts");

			while (resultSet.next()) {

				System.out.println(resultSet.getInt("id") + " " + resultSet.getString("first_name") + " "
						+ resultSet.getString("last_name") + " -> " + resultSet.getString("city"));
			}

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean updateContactCity(String name, String city) {

		String url = "jdbc:mysql://localhost:3306/addressbook_service";
		String username = "root";
		String password = "05052005";

		String updateQuery = "UPDATE contacts SET city = ? WHERE first_name = ?";

		try {

			Connection connection = DriverManager.getConnection(url, username, password);

			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

			preparedStatement.setString(1, city);
			preparedStatement.setString(2, name);

			int result = preparedStatement.executeUpdate();

			connection.close();

			return result > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public void retrieveContactsByDateRange(String startDate, String endDate) {

	    String url = "jdbc:mysql://localhost:3306/addressbook_service";
	    String username = "root";
	    String password = "05052005";

	    String query = "SELECT * FROM contacts WHERE date_added BETWEEN ? AND ?";

	    try {

	        Connection connection = DriverManager.getConnection(url, username, password);

	        PreparedStatement preparedStatement = connection.prepareStatement(query);

	        preparedStatement.setString(1, startDate);
	        preparedStatement.setString(2, endDate);

	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {

	            System.out.println(
	                    resultSet.getInt("id") + " " +
	                    resultSet.getString("first_name") + " " +
	                    resultSet.getString("last_name") + " " +
	                    resultSet.getDate("date_added")
	            );
	        }

	        connection.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}