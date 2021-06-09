package Model;

public class Insurance {
    private String inn;
    private String name;
    private String bik;
    private String rs;
    private String country;
    private String address;

    public Insurance(String inn, String name, String bik, String rs, String country, String address) {
        this.inn = inn;
        this.name = name;
        this.bik = bik;
        this.rs = rs;
        this.country = country;
        this.address = address;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBik() {
        return bik;
    }

    public void setBik(String bik) {
        this.bik = bik;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
