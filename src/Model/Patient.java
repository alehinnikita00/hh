package Model;

public class Patient{
    private String guid;
    private User user;
    private Social social;
    private String ein;
    private String pass_series;
    private String pass_number;
    private String email;
    private String phone;
    private String ua;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    public String getEin() {
        return ein;
    }

    public void setEin(String ein) {
        this.ein = ein;
    }

    public String getPass_series() {
        return pass_series;
    }

    public void setPass_series(String pass_series) {
        this.pass_series = pass_series;
    }

    public String getPass_number() {
        return pass_number;
    }

    public void setPass_number(String pass_number) {
        this.pass_number = pass_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public Patient(String guid, User user, Social social, String ein, String pass_series, String pass_number, String email, String phone, String ua) {
        this.guid = guid;
        this.user = user;
        this.social = social;
        this.ein = ein;
        this.pass_series = pass_series;
        this.pass_number = pass_number;
        this.email = email;
        this.phone = phone;
        this.ua = ua;
    }
}
