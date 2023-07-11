package database.select;

import java.util.Date;

public class Worker {
    private String type;
    private String name;
    private Date birthday;

    public Worker(String type, String name, Date birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

}
