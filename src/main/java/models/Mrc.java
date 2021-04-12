package models;

/**
 *
 * @author Daniel
 */
public class Mrc {

    private String shoulderAbductionRight_11036, shoulderAbductionRight_11074;
    private String shoulderAbductionLeft_11073, shoulderAbductionLeft_11035;

    private String elbowFlexionRight_11030, elbowFlexionRight_11068;
    private String elbowFlexionLeft_11029, elbowFlexionLeft_11067;

    private String wristExtensionRight_11038, wristExtensionRight_11077;
    private String wristExtensionLeft_11037, wristExtensionLeft_11076;

    private String hipFlexionRight_11070, hipFlexionRight_11032;
    private String hipFlexionLeft_11069, hipFlexionLeft_11031;

    private String kneeExtensionRight_11072, kneeExtensionRight_11034;
    private String kneeExtensionLeft_11071, kneeExtensionLeft_11033;

    private String ankleDorsiflexionLeft_11027, ankleDorsiflexionLeft_11065;
    private String ankleDorsiflexionRight_11066, ankleDorsiflexionRight_11028;

    private String total;

    private String[] items = {
        "(R) Shoulder Abduction 11036",
        "(R) Shoulder Abduction 11074",
        "(L) Shoulder Abduction 11073",
        "(L) Shoulder Abduction 11935",
        "(R) Elbow Flexion 11030",
        "(R) Elbow Flexion 11068",
        "(L) Elbow Flexion 11029",
        "(L) Elbow Flexion 11067",
        "(R) Wrist Extension 11038",
        "(R) Wrist Extension 11077",
        "(L) Wrist Extension 11037",
        "(L) Wrist Extension 11076",
        "(R) Hip Flexion 11070",
        "(R) Hip Flexion 11032",
        "(L) Hip Flexion 11069",
        "(L) Hip Flexion 11031",
        "(R) Knee Extension 11072",
        "(R) Knee Extension 11034",
        "(L) Knee Extension 11071",
        "(L) Knee Extension 11033",
        "(L) Ankle Dorsi Flexion 11027",
        "(L) Ankle Dorsi Flexion 11065",
        "(R) Ankle Dorsi Flexion 11066",
        "(R) Ankle Dorsi Flexion 11028"
    };

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getShoulderAbductionRight_11036() {
        return shoulderAbductionRight_11036;
    }

    public void setShoulderAbductionRight_11036(String shoulderAbductionRight_11036) {
        this.shoulderAbductionRight_11036 = shoulderAbductionRight_11036;
    }

    public String getShoulderAbductionRight_11074() {
        return shoulderAbductionRight_11074;
    }

    public void setShoulderAbductionRight_11074(String shoulderAbductionRight_11074) {
        this.shoulderAbductionRight_11074 = shoulderAbductionRight_11074;
    }

    public String getShoulderAbductionLeft_11073() {
        return shoulderAbductionLeft_11073;
    }

    public void setShoulderAbductionLeft_11073(String shoulderAbductionLeft_11073) {
        this.shoulderAbductionLeft_11073 = shoulderAbductionLeft_11073;
    }

    public String getShoulderAbductionLeft_11035() {
        return shoulderAbductionLeft_11035;
    }

    public void setShoulderAbductionLeft_11035(String shoulderAbductionLeft_11035) {
        this.shoulderAbductionLeft_11035 = shoulderAbductionLeft_11035;
    }

    public String getElbowFlexionRight_11030() {
        return elbowFlexionRight_11030;
    }

    public void setElbowFlexionRight_11030(String elbowFlexionRight_11030) {
        this.elbowFlexionRight_11030 = elbowFlexionRight_11030;
    }

    public String getElbowFlexionRight_11068() {
        return elbowFlexionRight_11068;
    }

    public void setElbowFlexionRight_11068(String elbowFlexionRight_11068) {
        this.elbowFlexionRight_11068 = elbowFlexionRight_11068;
    }

    public String getElbowFlexionLeft_11029() {
        return elbowFlexionLeft_11029;
    }

    public void setElbowFlexionLeft_11029(String elbowFlexionLeft_11029) {
        this.elbowFlexionLeft_11029 = elbowFlexionLeft_11029;
    }

    public String getElbowFlexionLeft_11067() {
        return elbowFlexionLeft_11067;
    }

    public void setElbowFlexionLeft_11067(String elbowFlexionLeft_11067) {
        this.elbowFlexionLeft_11067 = elbowFlexionLeft_11067;
    }

    public String getWristExtensionRight_11038() {
        return wristExtensionRight_11038;
    }

    public void setWristExtensionRight_11038(String wristExtensionRight_11038) {
        this.wristExtensionRight_11038 = wristExtensionRight_11038;
    }

    public String getWristExtensionRight_11077() {
        return wristExtensionRight_11077;
    }

    public void setWristExtensionRight_11077(String wristExtensionRight_11077) {
        this.wristExtensionRight_11077 = wristExtensionRight_11077;
    }

    public String getWristExtensionLeft_11037() {
        return wristExtensionLeft_11037;
    }

    public void setWristExtensionLeft_11037(String wristExtensionLeft_11037) {
        this.wristExtensionLeft_11037 = wristExtensionLeft_11037;
    }

    public String getWristExtensionLeft_11076() {
        return wristExtensionLeft_11076;
    }

    public void setWristExtensionLeft_11076(String wristExtensionLeft_11076) {
        this.wristExtensionLeft_11076 = wristExtensionLeft_11076;
    }

    public String getHipFlexionRight_11070() {
        return hipFlexionRight_11070;
    }

    public void setHipFlexionRight_11070(String hipFlexionRight_11070) {
        this.hipFlexionRight_11070 = hipFlexionRight_11070;
    }

    public String getHipFlexionRight_11032() {
        return hipFlexionRight_11032;
    }

    public void setHipFlexionRight_11032(String hipFlexionRight_11032) {
        this.hipFlexionRight_11032 = hipFlexionRight_11032;
    }

    public String getHipFlexionLeft_11069() {
        return hipFlexionLeft_11069;
    }

    public void setHipFlexionLeft_11069(String hipFlexionLeft_11069) {
        this.hipFlexionLeft_11069 = hipFlexionLeft_11069;
    }

    public String getHipFlexionLeft_11031() {
        return hipFlexionLeft_11031;
    }

    public void setHipFlexionLeft_11031(String hipFlexionLeft_11031) {
        this.hipFlexionLeft_11031 = hipFlexionLeft_11031;
    }

    public String getKneeExtensionRight_11072() {
        return kneeExtensionRight_11072;
    }

    public void setKneeExtensionRight_11072(String kneeExtensionRight_11072) {
        this.kneeExtensionRight_11072 = kneeExtensionRight_11072;
    }

    public String getKneeExtensionRight_11034() {
        return kneeExtensionRight_11034;
    }

    public void setKneeExtensionRight_11034(String kneeExtensionRight_11034) {
        this.kneeExtensionRight_11034 = kneeExtensionRight_11034;
    }

    public String getKneeExtensionLeft_11071() {
        return kneeExtensionLeft_11071;
    }

    public void setKneeExtensionLeft_11071(String kneeExtensionLeft_11071) {
        this.kneeExtensionLeft_11071 = kneeExtensionLeft_11071;
    }

    public String getKneeExtensionLeft_11033() {
        return kneeExtensionLeft_11033;
    }

    public void setKneeExtensionLeft_11033(String kneeExtensionLeft_11033) {
        this.kneeExtensionLeft_11033 = kneeExtensionLeft_11033;
    }

    public String getAnkleDorsiflexionLeft_11027() {
        return ankleDorsiflexionLeft_11027;
    }

    public void setAnkleDorsiflexionLeft_11027(String ankleDorsiflexionLeft_11027) {
        this.ankleDorsiflexionLeft_11027 = ankleDorsiflexionLeft_11027;
    }

    public String getAnkleDorsiflexionLeft_11065() {
        return ankleDorsiflexionLeft_11065;
    }

    public void setAnkleDorsiflexionLeft_11065(String ankleDorsiflexionLeft_11065) {
        this.ankleDorsiflexionLeft_11065 = ankleDorsiflexionLeft_11065;
    }

    public String getAnkleDorsiflexionRight_11066() {
        return ankleDorsiflexionRight_11066;
    }

    public void setAnkleDorsiflexionRight_11066(String ankleDorsiflexionRight_11066) {
        this.ankleDorsiflexionRight_11066 = ankleDorsiflexionRight_11066;
    }

    public String getAnkleDorsiflexionRight_11028() {
        return ankleDorsiflexionRight_11028;
    }

    public void setAnkleDorsiflexionRight_11028(String ankleDorsiflexionRight_11028) {
        this.ankleDorsiflexionRight_11028 = ankleDorsiflexionRight_11028;
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
    
    public Mrc(String shoulderAbductionRight_11036, String shoulderAbductionRight_11074, String shoulderAbductionLeft_11073, String shoulderAbductionLeft_11035, String elbowFlexionRight_11030, String elbowFlexionRight_11068, String elbowFlexionLeft_11029, String elbowFlexionLeft_11067, String wristExtensionRight_11038, String wristExtensionRight_11077, String wristExtensionLeft_11037, String wristExtensionLeft_11076, String hipFlexionRight_11070, String hipFlexionRight_11032, String hipFlexionLeft_11069, String hipFlexionLeft_11031, String kneeExtensionRight_11072, String kneeExtensionRight_11034, String kneeExtensionLeft_11071, String kneeExtensionLeft_11033, String ankleDorsiflexionLeft_11027, String ankleDorsiflexionLeft_11065, String ankleDorsiflexionRight_11066, String ankleDorsiflexionRight_11028, String total) {
        this.shoulderAbductionRight_11036 = shoulderAbductionRight_11036;
        this.shoulderAbductionRight_11074 = shoulderAbductionRight_11074;
        this.shoulderAbductionLeft_11073 = shoulderAbductionLeft_11073;
        this.shoulderAbductionLeft_11035 = shoulderAbductionLeft_11035;
        this.elbowFlexionRight_11030 = elbowFlexionRight_11030;
        this.elbowFlexionRight_11068 = elbowFlexionRight_11068;
        this.elbowFlexionLeft_11029 = elbowFlexionLeft_11029;
        this.elbowFlexionLeft_11067 = elbowFlexionLeft_11067;
        this.wristExtensionRight_11038 = wristExtensionRight_11038;
        this.wristExtensionRight_11077 = wristExtensionRight_11077;
        this.wristExtensionLeft_11037 = wristExtensionLeft_11037;
        this.wristExtensionLeft_11076 = wristExtensionLeft_11076;
        this.hipFlexionRight_11070 = hipFlexionRight_11070;
        this.hipFlexionRight_11032 = hipFlexionRight_11032;
        this.hipFlexionLeft_11069 = hipFlexionLeft_11069;
        this.hipFlexionLeft_11031 = hipFlexionLeft_11031;
        this.kneeExtensionRight_11072 = kneeExtensionRight_11072;
        this.kneeExtensionRight_11034 = kneeExtensionRight_11034;
        this.kneeExtensionLeft_11071 = kneeExtensionLeft_11071;
        this.kneeExtensionLeft_11033 = kneeExtensionLeft_11033;
        this.ankleDorsiflexionLeft_11027 = ankleDorsiflexionLeft_11027;
        this.ankleDorsiflexionLeft_11065 = ankleDorsiflexionLeft_11065;
        this.ankleDorsiflexionRight_11066 = ankleDorsiflexionRight_11066;
        this.ankleDorsiflexionRight_11028 = ankleDorsiflexionRight_11028;
        this.total = total;
    }

    public Mrc() {
    }

    public String[] getScores() {
        String[] array = {
            this.shoulderAbductionRight_11036,
            this.shoulderAbductionRight_11074,
            this.shoulderAbductionLeft_11073,
            this.shoulderAbductionLeft_11035,
            this.elbowFlexionRight_11030,
            this.elbowFlexionRight_11068,
            this.elbowFlexionLeft_11029,
            this.elbowFlexionLeft_11067,
            this.wristExtensionRight_11038,
            this.wristExtensionRight_11077,
            this.wristExtensionLeft_11037,
            this.wristExtensionLeft_11076,
            this.hipFlexionRight_11070,
            this.hipFlexionRight_11032,
            this.hipFlexionLeft_11069,
            this.hipFlexionLeft_11031,
            this.kneeExtensionRight_11072,
            this.kneeExtensionRight_11034,
            this.kneeExtensionLeft_11071,
            this.kneeExtensionLeft_11033,
            this.ankleDorsiflexionLeft_11027,
            this.ankleDorsiflexionLeft_11065,
            this.ankleDorsiflexionRight_11066,
            this.ankleDorsiflexionRight_11028
        };

        return array;
    }

    public String[] getScoresStrings() {
        String[] array = {
            String.valueOf(this.shoulderAbductionRight_11036),
            String.valueOf(this.shoulderAbductionRight_11074),
            String.valueOf(this.shoulderAbductionLeft_11073),
            String.valueOf(this.shoulderAbductionLeft_11035),
            String.valueOf(this.elbowFlexionRight_11030),
            String.valueOf(this.elbowFlexionRight_11068),
            String.valueOf(this.elbowFlexionLeft_11029),
            String.valueOf(this.elbowFlexionLeft_11067),
            String.valueOf(this.wristExtensionRight_11038),
            String.valueOf(this.wristExtensionRight_11077),
            String.valueOf(this.wristExtensionLeft_11037),
            String.valueOf(this.wristExtensionLeft_11076),
            String.valueOf(this.hipFlexionRight_11070),
            String.valueOf(this.hipFlexionRight_11032),
            String.valueOf(this.hipFlexionLeft_11069),
            String.valueOf(this.hipFlexionLeft_11031),
            String.valueOf(this.kneeExtensionRight_11072),
            String.valueOf(this.kneeExtensionRight_11034),
            String.valueOf(this.kneeExtensionLeft_11071),
            String.valueOf(this.kneeExtensionLeft_11033),
            String.valueOf(this.ankleDorsiflexionLeft_11027),
            String.valueOf(this.ankleDorsiflexionLeft_11065),
            String.valueOf(this.ankleDorsiflexionRight_11066),
            String.valueOf(this.ankleDorsiflexionRight_11028)
        };

        return array;
    }

    public String[] getAll() {
        String[] array = {
            this.shoulderAbductionRight_11036,
            this.shoulderAbductionRight_11074,
            this.shoulderAbductionLeft_11073,
            this.shoulderAbductionLeft_11035,
            this.elbowFlexionRight_11030,
            this.elbowFlexionRight_11068,
            this.elbowFlexionLeft_11029,
            this.elbowFlexionLeft_11067,
            this.wristExtensionRight_11038,
            this.wristExtensionRight_11077,
            this.wristExtensionLeft_11037,
            this.wristExtensionLeft_11076,
            this.hipFlexionRight_11070,
            this.hipFlexionRight_11032,
            this.hipFlexionLeft_11069,
            this.hipFlexionLeft_11031,
            this.kneeExtensionRight_11072,
            this.kneeExtensionRight_11034,
            this.kneeExtensionLeft_11071,
            this.kneeExtensionLeft_11033,
            this.ankleDorsiflexionLeft_11027,
            this.ankleDorsiflexionLeft_11065,
            this.ankleDorsiflexionRight_11066,
            this.ankleDorsiflexionRight_11028,
            this.total
        };

        return array;
    }

    /*
    public int checkTotal() {
        int total = this.shoulderAbductionRight_11036
        + this.shoulderAbductionRight_11074 
        + this.shoulderAbductionLeft_11073 
        + this.shoulderAbductionLeft_11035
        + this.elbowFlexionRight_11030 
        + this.elbowFlexionRight_11068
        + this.elbowFlexionLeft_11029
        + this.elbowFlexionLeft_11067
        + this.wristExtensionRight_11038 
        + this.wristExtensionRight_11077
        + this.wristExtensionLeft_11037 
        + this.wristExtensionLeft_11076
        + this.hipFlexionRight_11070
        + this.hipFlexionRight_11032 
        + this.hipFlexionLeft_11069 
        + this.hipFlexionLeft_11031
        + this.kneeExtensionRight_11072
        + this.kneeExtensionRight_11034
        + this.kneeExtensionLeft_11071
        + this.kneeExtensionLeft_11033
        + this.ankleDorsiflexionLeft_11027
        + this.ankleDorsiflexionLeft_11065
        + this.ankleDorsiflexionRight_11066 
        + this.ankleDorsiflexionRight_11028;

        return 1;
    }
     */
}
