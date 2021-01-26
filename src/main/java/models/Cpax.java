package models;

public class Cpax extends Patient {

    private int respiratory, cough, bedRolling, supineEdge, dynamicSitting,
            balance, sitToStand, bedToChair, stepping, grip;

    public Cpax(int respiratory, int cough, int bedRolling, int supineEdge, int dynamicSitting, int balance, int sitToStand, int bedToChair, int stepping, int grip, String firstName, String lastName, String patientID) {
        super(firstName, lastName, patientID);
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
    }

    public int getRespiratory() {
        return respiratory;
    }

    public void setRespiratory(int respiratory) {
        this.respiratory = respiratory;
    }

    public int getCough() {
        return cough;
    }

    public void setCough(int cough) {
        this.cough = cough;
    }

    public int getBedRolling() {
        return bedRolling;
    }

    public void setBedRolling(int bedRolling) {
        this.bedRolling = bedRolling;
    }

    public int getSupineEdge() {
        return supineEdge;
    }

    public void setSupineEdge(int supineEdge) {
        this.supineEdge = supineEdge;
    }

    public int getDynamicSitting() {
        return dynamicSitting;
    }

    public void setDynamicSitting(int dynamicSitting) {
        this.dynamicSitting = dynamicSitting;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getSitToStand() {
        return sitToStand;
    }

    public void setSitToStand(int sitToStand) {
        this.sitToStand = sitToStand;
    }

    public int getBedToChair() {
        return bedToChair;
    }

    public void setBedToChair(int bedToChair) {
        this.bedToChair = bedToChair;
    }

    public int getStepping() {
        return stepping;
    }

    public void setStepping(int stepping) {
        this.stepping = stepping;
    }

    public int getGrip() {
        return grip;
    }

    public void setGrip(int grip) {
        this.grip = grip;
    }
    
    
    
}
