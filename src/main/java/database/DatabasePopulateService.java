package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class DatabasePopulateService {

    public static void main(String[] args) {
        String sqlFilePath = "sql/populate_db.sql";

        try (Connection conn = Database.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath))) {

            StringBuilder queryBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                queryBuilder.append(line);

                if (line.trim().endsWith(";")) {
                    String query = queryBuilder.toString();
                    stmt.execute(query);

                    queryBuilder.setLength(0);
                }
            }

            System.out.println("Tables fielded successfully.");

        } catch (IOException e) {
            System.err.println("File reading error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Request execution error: " + e.getMessage());
        }

    }

}
