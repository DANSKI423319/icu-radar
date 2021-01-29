package models;

public class Sofa {

    private int creatine, bilirubin, platelets, pulmonaryFunction, gcs,
            noradrenaline, total;

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Sofa(int creatine, int bilirubin, int platelets, int pulmonaryFunction, int gcs, int noradrenaline, int total) {
        this.creatine = creatine;
        this.bilirubin = bilirubin;
        this.platelets = platelets;
        this.pulmonaryFunction = pulmonaryFunction;
        this.gcs = gcs;
        this.noradrenaline = noradrenaline;
        this.total = total;
    }

    public Sofa() {
    }

    public int[] getScores() {
        int[] array = {
            this.creatine,
            this.bilirubin,
            this.platelets,
            this.pulmonaryFunction,
            this.gcs,
            this.noradrenaline
        };

        return array;
    }

}
