package database;

import database.select.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseQueryService queryService = new DatabaseQueryService();

        List<MaxProjectCountClient> maxProjectsClients = queryService.findMaxProjectsClient();
        for (MaxProjectCountClient client : maxProjectsClients) {
            System.out.println("Client Name: " + client.getName());
            System.out.println("Project Count: " + client.getProjectCount());
        }

        System.out.println("\n");

        List<LongestProject> longestProjects = queryService.findLongestProject();
        for (LongestProject project : longestProjects) {
            System.out.println("Project ID: " + project.getProjectId());
            System.out.println("Month Count: " + project.getMonthCount());
        }

        System.out.println("\n");


        List<MaxSalaryWorker> maxSalaryWorkers = queryService.findMaxSalaryWorker();
        for (MaxSalaryWorker worker : maxSalaryWorkers) {
            System.out.println("Worker Name: " + worker.getName());
            System.out.println("Salary: " + worker.getSalary());
        }

        System.out.println("\n");

        List<Worker> youngestAndEldestWorkers = queryService.findYoungestAndEldestWorkers();
        for (Worker worker : youngestAndEldestWorkers) {
            System.out.println("Worker Type: " + worker.getType());
            System.out.println("Worker Name: " + worker.getName());
            System.out.println("Birthday: " + worker.getBirthday());
        }

        System.out.println("\n");

        List<ProjectPrice> projectPrices = queryService.printProjectPrices();
        for (ProjectPrice projectPrice : projectPrices) {
            System.out.println("Project ID: " + projectPrice.getProjectId());
            System.out.println("Price: " + projectPrice.getPrice());
        }

    }

}