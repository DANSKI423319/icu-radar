package models;

/**
 *
 * @author Daniel
 */
public class Sofa {

    private String creatine, bilirubin, platelets, pulmonaryFunction, gcs,
            noradrenaline, total;

    private String[] items = {
        "Creatine",
        "Bilirubin",
        "Platelets",
        "Pulmonary Function",
        "GCS",
        "Noradrenaline"
    };

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getCreatine() {
        return creatine;
    }

    public void setCreatine(String creatine) {
        this.creatine = creatine;
    }

    public String getBilirubin() {
        return bilirubin;
    }

    public void setBilirubin(String bilirubin) {
        this.bilirubin = bilirubin;
    }

    public String getPlatelets() {
        return platelets;
    }

    public void setPlatelets(String platelets) {
        this.platelets = platelets;
    }

    public String getPulmonaryFunction() {
        return pulmonaryFunction;
    }

    public void setPulmonaryFunction(String pulmonaryFunction) {
        this.pulmonaryFunction = pulmonaryFunction;
    }

    public String getGcs() {
        return gcs;
    }

    public void setGcs(String gcs) {
        this.gcs = gcs;
    }

    public String getNoradrenaline() {
        return noradrenaline;
    }

    public void setNoradrenaline(String noradrenaline) {
        this.noradrenaline = noradrenaline;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }   
    // </editor-fold>

    public Sofa(String creatine, String bilirubin, String platelets, String pulmonaryFunction, String gcs, String noradrenaline, String total) {
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

    public String[] getScores() {
        String[] array = {
            this.creatine,
            this.bilirubin,
            this.platelets,
            this.pulmonaryFunction,
            this.gcs,
            this.noradrenaline
        };

        return array;
    }

    public String[] getScoresStrings() {
        String[] array = {
            String.valueOf(this.creatine),
            String.valueOf(this.bilirubin),
            String.valueOf(this.platelets),
            String.valueOf(this.pulmonaryFunction),
            String.valueOf(this.gcs),
            String.valueOf(this.noradrenaline)
        };

        return array;
    }

    public String[] getAll() {
        String[] array = {
            this.creatine,
            this.bilirubin,
            this.platelets,
            this.pulmonaryFunction,
            this.gcs,
            this.noradrenaline,
            this.total
        };

        return array;
    }

    /*
    public int checkTotal() {
        int total = this.creatine
        + this.bilirubin + this.platelets + this.pulmonaryFunction
        + this.gcs + this.noradrenaline;

        return total;
    }
     */
}
