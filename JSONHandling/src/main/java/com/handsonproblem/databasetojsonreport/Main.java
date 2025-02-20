package com.handsonproblem.databasetojsonreport;



import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/company_db"; // Database URL
        String username = "root";  // Your database username
        String password = "password";  // Your database password

        String query = "SELECT id, first_name, last_name, age, city FROM employees";  // SQL query to fetch data

        try {
            // Establish connection to the database
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Execute the query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // List to store records
            List<Map<String, Object>> records = new ArrayList<>();

            // Iterate through the result set
            while (resultSet.next()) {
                Map<String, Object> record = new HashMap<>();
                record.put("id", resultSet.getInt("id"));
                record.put("first_name", resultSet.getString("first_name"));
                record.put("last_name", resultSet.getString("last_name"));
                record.put("age", resultSet.getInt("age"));
                record.put("city", resultSet.getString("city"));
                records.add(record);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

            // Convert the records to JSON using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonReport = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(records);

            // Output the JSON report
            System.out.println("Generated JSON Report:");
            System.out.println(jsonReport);

        } catch (SQLException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
