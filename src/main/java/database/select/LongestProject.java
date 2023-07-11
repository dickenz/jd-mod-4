package database.select;

public class LongestProject {

    private int projectId;
    private int monthCount;

    public LongestProject(int projectId, int monthCount) {
        this.projectId = projectId;
        this.monthCount = monthCount;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getMonthCount() {
        return monthCount;
    }
}
