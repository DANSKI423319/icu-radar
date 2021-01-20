package models;
import models.Model;

public class Patient {
    
    private String firstName;
    private String lastName;
    private String patientID;

    public Patient(String firstName, String lastName, String patientID) {       
        this.firstName = firstName;
        this.lastName = lastName;
        this.patientID = patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    
}
