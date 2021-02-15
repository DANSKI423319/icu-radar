package models;

import java.util.Date;

public class Patient {

    private String poid, firstName, lastName, machesterMobilityScore, admission;
    private Cpax cpax = new Cpax();
    private Mrc mrc = new Mrc();
    private Sofa sofa = new Sofa();

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">    
    public String getPoid() {
        return poid;
    }

    public void setPoid(String poid) {
        this.poid = poid;
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

    public String getMachesterMobilityScore() {
        return machesterMobilityScore;
    }

    public void setMachesterMobilityScore(String machesterMobilityScore) {
        this.machesterMobilityScore = machesterMobilityScore;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public Cpax getCpax() {
        return cpax;
    }

    public void setCpax(Cpax cpax) {
        this.cpax = cpax;
    }

    public Mrc getMrc() {
        return mrc;
    }

    public void setMrc(Mrc mrc) {
        this.mrc = mrc;
    }

    public Sofa getSofa() {
        return sofa;
    }

    public void setSofa(Sofa sofa) {
        this.sofa = sofa;
    }
    // </editor-fold> 

    public Patient(String poid, String firstName, String lastName, String machesterMobilityScore, String admission, Cpax cpax, Mrc mrc, Sofa sofa) {
        this.poid = poid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.machesterMobilityScore = machesterMobilityScore;
        this.admission = admission;
        this.cpax = cpax;
        this.mrc = mrc;
        this.sofa = sofa;
    }

    public Object[] getOverviewRow() {
        Object[] row = {
            this.poid,
            this.firstName,
            this.lastName,
            this.getCpax().getTotal(),
            this.getMrc().getTotal(),
            this.getSofa().getTotal(),
            this.getMachesterMobilityScore()
        };

        return row;
    }
    
}
