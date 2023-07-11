package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        try {
            Connection conn = Database.getInstance().getConnection();

            String filePath = "sql/init_db.sql";

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                StringBuilder queryBuilder = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    if (line.trim().isEmpty() || line.trim().startsWith("--")) {
                        continue;
                    }

                    queryBuilder.append(line);

                    if (line.trim().endsWith(";")) {
                        String query = queryBuilder.toString();

                        try (Statement statement = conn.createStatement()) {
                            statement.executeUpdate(query);
                        }

                        queryBuilder.setLength(0);
                    }
                }

                System.out.println("Database successfully initialized.");
            } catch (IOException e) {
                System.err.println("File reading error: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }

}
