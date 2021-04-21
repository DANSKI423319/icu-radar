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

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getRespiratory() {
        return respiratory;
    }

    public void setRespiratory(String respiratory) {
        this.respiratory = respiratory;
    }

    public String getCough() {
        return cough;
    }

    public void setCough(String cough) {
        this.cough = cough;
    }

    public String getBedRolling() {
        return bedRolling;
    }

    public void setBedRolling(String bedRolling) {
        this.bedRolling = bedRolling;
    }

    public String getSupineEdge() {
        return supineEdge;
    }

    public void setSupineEdge(String supineEdge) {
        this.supineEdge = supineEdge;
    }

    public String getDynamicSitting() {
        return dynamicSitting;
    }

    public void setDynamicSitting(String dynamicSitting) {
        this.dynamicSitting = dynamicSitting;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getSitToStand() {
        return sitToStand;
    }

    public void setSitToStand(String sitToStand) {
        this.sitToStand = sitToStand;
    }

    public String getBedToChair() {
        return bedToChair;
    }

    public void setBedToChair(String bedToChair) {
        this.bedToChair = bedToChair;
    }

    public String getStepping() {
        return stepping;
    }

    public void setStepping(String stepping) {
        this.stepping = stepping;
    }

    public String getGrip() {
        return grip;
    }

    public void setGrip(String grip) {
        this.grip = grip;
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

    public String[] getScoresStrings() {
        String[] array = {
            String.valueOf(this.respiratory),
            String.valueOf(this.cough),
            String.valueOf(this.bedRolling),
            String.valueOf(this.supineEdge),
            String.valueOf(this.dynamicSitting),
            String.valueOf(this.balance),
            String.valueOf(this.sitToStand),
            String.valueOf(this.bedToChair),
            String.valueOf(this.stepping),
            String.valueOf(this.grip)
        };

        return array;
    }

    public String[] getAll() {
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
            this.grip,
            this.total
        };

        return array;
    }

    /*
    public int checkTotal() {
        String total = this.respiratory + this.cough + this.bedRolling
            + this.supineEdge + this.dynamicSitting + this.balance
            + this.sitToStand + this.bedToChair + this.stepping
            + this.grip;

        return total;
    }
     */
}
