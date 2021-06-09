package Model;

public class User {
    private int id;
    private String login;
    private String password;
    private String first_name;
    private String last_name;
    private String ip;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(int id, String login, String password, String ip) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.ip = ip;
    }

    public User(int id, String login, String password, String first_name, String last_name, String ip) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.ip = ip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
