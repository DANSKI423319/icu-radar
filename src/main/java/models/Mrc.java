package models;

/**
 *
 * @author Daniel
 */
public class Mrc {

    private String shoulderAbductionRight_1, shoulderAbductionRight_2;
    private String shoulderAbductionLeft_1, shoulderAbductionLeft_2;

    private String elbowFlexionRight_1, elbowFlexionRight_2;
    private String elbowFlexionLeft_1, elbowFlexionLeft_2;

    private String wristExtensionRight_1, wristExtensionRight_2;
    private String wristExtensionLeft_1, wristExtensionLeft_2;

    private String hipFlexionRight_1, hipFlexionRight_2;
    private String hipFlexionLeft_1, hipFlexionLeft_2;

    private String kneeExtensionRight_1, kneeExtensionRight_2;
    private String kneeExtensionLeft_1, kneeExtensionLeft_2;

    private String ankleDorsiflexionLeft_1, ankleDorsiflexionLeft_2;
    private String ankleDorsiflexionRight_1, ankleDorsiflexionRight_2;

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

    public String getTotal() {
        return total;
    }

    public String[] getItems() {
        return items;
    }
    
    public Mrc(String shoulderAbductionRight_1, String shoulderAbductionRight_2, String shoulderAbductionLeft_1, String shoulderAbductionLeft_2, String elbowFlexionRight_1, String elbowFlexionRight_2, String elbowFlexionLeft_1, String elbowFlexionLeft_2, String wristExtensionRight_1, String wristExtensionRight_2, String wristExtensionLeft_1, String wristExtensionLeft_2, String hipFlexionRight_1, String hipFlexionRight_2, String hipFlexionLeft_1, String hipFlexionLeft_2, String kneeExtensionRight_1, String kneeExtensionRight_2, String kneeExtensionLeft_1, String kneeExtensionLeft_2, String ankleDorsiflexionLeft_1, String ankleDorsiflexionLeft_2, String ankleDorsiflexionRight_1, String ankleDorsiflexionRight_2, String total) {
        this.shoulderAbductionRight_1 = shoulderAbductionRight_1;
        this.shoulderAbductionRight_2 = shoulderAbductionRight_2;
        this.shoulderAbductionLeft_1 = shoulderAbductionLeft_1;
        this.shoulderAbductionLeft_2 = shoulderAbductionLeft_2;
        this.elbowFlexionRight_1 = elbowFlexionRight_1;
        this.elbowFlexionRight_2 = elbowFlexionRight_2;
        this.elbowFlexionLeft_1 = elbowFlexionLeft_1;
        this.elbowFlexionLeft_2 = elbowFlexionLeft_2;
        this.wristExtensionRight_1 = wristExtensionRight_1;
        this.wristExtensionRight_2 = wristExtensionRight_2;
        this.wristExtensionLeft_1 = wristExtensionLeft_1;
        this.wristExtensionLeft_2 = wristExtensionLeft_2;
        this.hipFlexionRight_1 = hipFlexionRight_1;
        this.hipFlexionRight_2 = hipFlexionRight_2;
        this.hipFlexionLeft_1 = hipFlexionLeft_1;
        this.hipFlexionLeft_2 = hipFlexionLeft_2;
        this.kneeExtensionRight_1 = kneeExtensionRight_1;
        this.kneeExtensionRight_2 = kneeExtensionRight_2;
        this.kneeExtensionLeft_1 = kneeExtensionLeft_1;
        this.kneeExtensionLeft_2 = kneeExtensionLeft_2;
        this.ankleDorsiflexionLeft_1 = ankleDorsiflexionLeft_1;
        this.ankleDorsiflexionLeft_2 = ankleDorsiflexionLeft_2;
        this.ankleDorsiflexionRight_1 = ankleDorsiflexionRight_1;
        this.ankleDorsiflexionRight_2 = ankleDorsiflexionRight_2;
        this.total = total;
    }

    public Mrc() {
    }

    public String[] getScores() {
        String[] array = {
            this.shoulderAbductionRight_1,
            this.shoulderAbductionRight_2,
            this.shoulderAbductionLeft_1,
            this.shoulderAbductionLeft_2,
            this.elbowFlexionRight_1,
            this.elbowFlexionRight_2,
            this.elbowFlexionLeft_1,
            this.elbowFlexionLeft_2,
            this.wristExtensionRight_1,
            this.wristExtensionRight_2,
            this.wristExtensionLeft_1,
            this.wristExtensionLeft_2,
            this.hipFlexionRight_1,
            this.hipFlexionRight_2,
            this.hipFlexionLeft_1,
            this.hipFlexionLeft_2,
            this.kneeExtensionRight_1,
            this.kneeExtensionRight_2,
            this.kneeExtensionLeft_1,
            this.kneeExtensionLeft_2,
            this.ankleDorsiflexionLeft_1,
            this.ankleDorsiflexionLeft_2,
            this.ankleDorsiflexionRight_1,
            this.ankleDorsiflexionRight_2
        };

        return array;
    }
    
}
