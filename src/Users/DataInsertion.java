/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataInsertion {

    public static void insertData(String FISRTNAME, String LASTNAME) throws ClassNotFoundException {
        // Replace "your_database_name" with the actual name of your database
        // Replace "your_table_name" with the actual name of your table
        String insertQuery = "INSERT INTO USERBLACKJACK (FISRTNAME, LASTNAME) VALUES (?, ?)";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            // Set parameters
            preparedStatement.setString(1, FISRTNAME);
            preparedStatement.setString(2, LASTNAME);

            // Execute the query
            preparedStatement.executeUpdate();
            System.out.println("Data inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error inserting data: " + e.getMessage());
        }
    }

  
}

