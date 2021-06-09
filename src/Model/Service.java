package Model;

public class Service {
    private int code;
    private String name;
    private double cost;
    private int time;
    private int timeOut;

    public Service(){}

    public Service(int code, String name, double cost) {
        this.code = code;
        this.name = name;
        this.cost = cost;
    }

    public Service(int code, String name, double cost, int time, int timeOut) {
        this.code = code;
        this.name = name;
        this.cost = cost;
        this.time = time;
        this.timeOut = timeOut;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }
}
