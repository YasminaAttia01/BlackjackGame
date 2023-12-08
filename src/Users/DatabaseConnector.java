/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    public static Connection connect() throws ClassNotFoundException {
        try {
             Class.forName("oracle.jdbc.OracleDriver");
            // Replace with your database connection details
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String username = "system";
            String password = "123456789";

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

