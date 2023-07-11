package database;

import database.select.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;


public class DatabaseQueryService {

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlQuery = getSQLFromFile("sql/find_max_projects_client.sql");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int projectCount = resultSet.getInt("PROJECT_COUNT");
                result.add(new MaxProjectCountClient(name, projectCount));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    public List<LongestProject> findLongestProject() {
        List<LongestProject> result = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlQuery = getSQLFromFile("sql/find_longest_project.sql");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                int projectId = resultSet.getInt("ID");
                int monthCount = resultSet.getInt("MONTH_COUNT");
                result.add(new LongestProject(projectId, monthCount));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlQuery = getSQLFromFile("sql/find_max_salary_worker.sql");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                double salary = resultSet.getDouble("SALARY");
                result.add(new MaxSalaryWorker(name, salary));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Worker> findYoungestAndEldestWorkers() {
        List<Worker> result = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlQuery = getSQLFromFile("sql/find_youngest_eldest_workers.sql");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                String type = resultSet.getString("TYPE");
                String name = resultSet.getString("NAME");
                Date birthday = resultSet.getDate("BIRTHDAY");
                result.add(new Worker(type, name, birthday));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<ProjectPrice> printProjectPrices() {
        List<ProjectPrice> result = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlQuery = getSQLFromFile("sql/print_project_prices.sql");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                int projectId = resultSet.getInt("ID");
                double price = resultSet.getDouble("PRICE");
                result.add(new ProjectPrice(projectId, price));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    private String getSQLFromFile(String fileName) {
        String sqlQuery = "";

        try {
            Path filePath = Path.of(fileName);
            sqlQuery = Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sqlQuery;
    }

}