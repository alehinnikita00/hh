package Model;

import java.sql.Date;

public class Blood {
    private int id;
    private Patient patient;
    private String barcode;
    private Date date;

    public Blood(int id, Patient patient, String barcode, Date date) {
        this.id = id;
        this.patient = patient;
        this.barcode = barcode;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getbarcode() {
        return barcode;
    }

    public void setbarcode(String barcode) {
        this.barcode = barcode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
