package database.select;

import java.util.Date;

public class ProjectPrice {
    private int projectId;
    private double price;

    public ProjectPrice(int projectId, double price) {
        this.projectId = projectId;
        this.price = price;
    }

    public int getProjectId() {
        return projectId;
    }

    public double getPrice() {
        return price;
    }
}
