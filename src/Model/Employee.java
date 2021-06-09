package Model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class Employee{
    private int id;
    private String type;
    private Date lastEnter;
    private User user;

    private List<Service> services;

    public Employee(int id, String type, Date lastEnter, User user) {
        this.id = id;
        this.type = type;
        this.lastEnter = lastEnter;
        this.user = user;
    }

    public Employee(int id, String type, Date lastEnter, User user, List<Service> services) {
        this.id = id;
        this.type = type;
        this.lastEnter = lastEnter;
        this.user = user;
        this.services = services;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getLastEnter() {
        return lastEnter;
    }

    public void setLastEnter(Date lastEnter) {
        this.lastEnter = lastEnter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
