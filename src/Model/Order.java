package Model;

public class Order {
    private int id;
    private Blood blood;
    private Employee employee;
    private Service service;
    private String serviceStatus;
    private boolean status;
    private double result;
    private String analyzer;

    public Order(int id, Blood blood, Employee employee, Service service, String serviceStatus, boolean status, double result, String analyzer) {
        this.id = id;
        this.blood = blood;
        this.employee = employee;
        this.service = service;
        this.serviceStatus = serviceStatus;
        this.status = status;
        this.result = result;
        this.analyzer = analyzer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blood getBlood() {
        return blood;
    }

    public void setBlood(Blood blood) {
        this.blood = blood;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean getStatus(){
        return this.status;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getAnalyzer() {
        return analyzer;
    }

    public void setAnalyzer(String analyzer) {
        this.analyzer = analyzer;
    }
}
