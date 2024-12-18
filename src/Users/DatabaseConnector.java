package Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    // Step 1: Create a private static instance of the class
    private static DatabaseConnector instance;

    // Step 2: Private constructor to prevent instantiation from other classes
    private DatabaseConnector() {
        // private constructor
    }

    // Step 3: Public method to provide access to the instance
    public static DatabaseConnector getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnector.class) {
                if (instance == null) {
                    instance = new DatabaseConnector();
                }
            }
        }
        return instance;
    }

    // Method to connect to the database
    public static Connection connect() throws ClassNotFoundException {
        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Database connection details
            String url = "jdbc:oracle:thin:@localhost:1521:XE";  // Ensure this is correct (SID or Service Name)
            String username = "YASMINA";  // Ensure the username is correct (case-sensitive)
            String password = "yasmina";  // Ensure the password is correct

            // Establish the connection
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            // Print full exception details for debugging
            e.printStackTrace();
            return null;
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        try {
            // Step 4: Get the Singleton instance of DatabaseConnector
            DatabaseConnector dbConnector = DatabaseConnector.getInstance();
            Connection connection = dbConnector.connect();

            if (connection != null) {
                System.out.println("Connected to the database successfully!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Oracle JDBC Driver not found.");
        }
    }
}
