package Model;

public class Social {
    private String Number;
    private String type;
    private Insurance insurance;

    public String getNumber() {
        return Number;
    }

    public String getType() {
        return type;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public Social(String number, String type, Insurance insurance) {
        Number = number;
        this.type = type;
        this.insurance = insurance;
    }
}
