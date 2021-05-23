package models;

/**
 *
 * @author Daniel
 */
public class Patient {

    private String poid, firstName, lastName, admission;
    private Cpax cpax = new Cpax();
    private Mrc mrc = new Mrc();
    private Sofa sofa = new Sofa();

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">    
    public String getPoid() {
        return poid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAdmission() {
        return admission;
    }

    public Cpax getCpax() {
        return cpax;
    }

    public Mrc getMrc() {
        return mrc;
    }

    public Sofa getSofa() {
        return sofa;
    }

    public Patient(String poid, String firstName, String lastName, String admission, Cpax cpax, Mrc mrc, Sofa sofa) {
        this.poid = poid;
        this.firstName = firstName;
        this.lastName = lastName;
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
        };

        return row;
    }
    
}
