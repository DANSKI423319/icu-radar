package models;

/**
 *
 * @author Daniel
 */
public class Cpax {

    private String respiratory, cough, bedRolling, supineEdge, dynamicSitting,
            balance, sitToStand, bedToChair, stepping, grip, total;

    private String[] items = {
        "Respiratory",
        "Cough",
        "Bed Rolling",
        "Supine Edge",
        "Dynamic Sitting",
        "Balance",
        "Sit to Stand",
        "Bed to Chair",
        "Stepping",
        "Grip Strength"
    };

    public String getTotal() {
        return total;
    }

    public String[] getItems() {
        return items;
    }

    public Cpax(String respiratory, String cough, String bedRolling, String supineEdge, String dynamicSitting, String balance, String sitToStand, String bedToChair, String stepping, String grip, String total) {
        this.respiratory = respiratory;
        this.cough = cough;
        this.bedRolling = bedRolling;
        this.supineEdge = supineEdge;
        this.dynamicSitting = dynamicSitting;
        this.balance = balance;
        this.sitToStand = sitToStand;
        this.bedToChair = bedToChair;
        this.stepping = stepping;
        this.grip = grip;
        this.total = total;
    }

    public Cpax() {
    }

    public String[] getScores() {
        String[] array = {
            this.respiratory,
            this.cough,
            this.bedRolling,
            this.supineEdge,
            this.dynamicSitting,
            this.balance,
            this.sitToStand,
            this.bedToChair,
            this.stepping,
            this.grip
        };

        return array;
    }

}
