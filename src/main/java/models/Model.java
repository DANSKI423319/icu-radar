package models;

public class Model {
    
    private String poid, firstName, lastName, machesterMobilityScore; 
    private Cpax patientCpax = new Cpax();
    private Mrc patientMrc = new Mrc();
    private Sofa patientSofa = new Sofa();

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

    public Mrc getPatientMrc() {
        return patientMrc;
    }

    public void setPatientMrc(Mrc patientMrc) {
        this.patientMrc = patientMrc;
    }

    public Cpax getPatientCpax() {
        return patientCpax;
    }

    public void setPatientCpax(Cpax patientCpax) {
        this.patientCpax = patientCpax;
    }

    public Sofa getPatientSofa() {
        return patientSofa;
    }

    public void setPatientSofa(Sofa patientSofa) {
        this.patientSofa = patientSofa;
    }

    public Model(String poid, String firstName, String lastName, String machesterMobilityScore, Cpax patientCpax, Mrc patientMrc, Sofa patientSofa) {
        this.poid = poid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.machesterMobilityScore = machesterMobilityScore;
        this.patientCpax = patientCpax;
        this.patientMrc = patientMrc;
        this.patientSofa = patientSofa;
    }
    
}
