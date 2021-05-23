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

    public String getTotal() {
        return total;
    }

    public String[] getItems() {
        return items;
    }

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

}
