package models;

import static models.Main.sofas;

public class Sofa extends Patient {

    private int creatine, bilirubin, platelets, pulmonaryFunction, gcs,
            noradrenaline;

    public Sofa(int creatine, int bilirubin, int platelets, int pulmonaryFunction, int gcs, int noradrenaline, String firstName, String lastName, String patientID) {
        super(firstName, lastName, patientID);
        this.creatine = creatine;
        this.bilirubin = bilirubin;
        this.platelets = platelets;
        this.pulmonaryFunction = pulmonaryFunction;
        this.gcs = gcs;
        this.noradrenaline = noradrenaline;
    }

    public int getCreatine() {
        return creatine;
    }

    public void setCreatine(int creatine) {
        this.creatine = creatine;
    }

    public int getBilirubin() {
        return bilirubin;
    }

    public void setBilirubin(int bilirubin) {
        this.bilirubin = bilirubin;
    }

    public int getPlatelets() {
        return platelets;
    }

    public void setPlatelets(int platelets) {
        this.platelets = platelets;
    }

    public int getPulmonaryFunction() {
        return pulmonaryFunction;
    }

    public void setPulmonaryFunction(int pulmonaryFunction) {
        this.pulmonaryFunction = pulmonaryFunction;
    }

    public int getGcs() {
        return gcs;
    }

    public void setGcs(int gcs) {
        this.gcs = gcs;
    }

    public int getNoradrenaline() {
        return noradrenaline;
    }

    public void setNoradrenaline(int noradrenaline) {
        this.noradrenaline = noradrenaline;
    }

    public int getSofaTotal(int index) {
        int total = sofas.get(index).getCreatine() + sofas.get(index).getBilirubin() + sofas.get(index).getPlatelets()
                + sofas.get(index).getPulmonaryFunction() + sofas.get(index).getGcs() + sofas.get(index).getNoradrenaline();

        return total;
    }

}
