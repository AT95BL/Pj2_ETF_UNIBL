package org.example;

import java.sql.*;

public class Main {
    // Database credentials and URL
    private static final String URL = "jdbc:mysql://localhost:3306/test2";
    private static final String USER = "root";
    private static final String PASS = "StrongPassword123!"; // Replace with your password

    public static void main(String[] args) {
        // 1. Establish the connection
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("Connected to test2 database successfully!");

            // 2. Prepare an INSERT statement
            String sql = "INSERT INTO fakultet (NazivFakulteta, AdresaFakulteta) VALUES (?, ?)";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, "ETF");
                pstmt.setString(2, "Patriotske lige 9");

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new university was inserted successfully!");
                }
            }

            // 3. Select and Print data
            String selectSql = "SELECT * FROM fakultet";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectSql);

            System.out.println("\n--- List of Faculties ---");
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("NazivFakulteta") +
                        " | Address: " + rs.getString("AdresaFakulteta"));
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}
