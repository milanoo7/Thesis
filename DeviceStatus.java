public class DeviceStatus {
    private boolean isOn;
    private boolean isconfigured;
    private boolean isconfigured12;
    private boolean isconfigured13;
    private boolean isconfigured21;
    private boolean isconfigured23;

    public boolean isIsconfigured31() {
        return isconfigured31;
    }

    public void setIsconfigured31(boolean isconfigured31) {
        this.isconfigured31 = isconfigured31;
    }

    public boolean isIsconfigured32() {
        return isconfigured32;
    }

    public void setIsconfigured32(boolean isconfigured32) {
        this.isconfigured32 = isconfigured32;
    }

    private boolean isconfigured31;
    private boolean isconfigured32;
    private String interacted;
    private boolean device1;

    public boolean isIsconfigured12() {
        return isconfigured12;
    }

    public void setIsconfigured12(boolean isconfigured12) {
        this.isconfigured12 = isconfigured12;
    }

    public boolean isIsconfigured13() {
        return isconfigured13;
    }

    public void setIsconfigured13(boolean isconfigured13) {
        this.isconfigured13 = isconfigured13;
    }

    public boolean isIsconfigured21() {
        return isconfigured21;
    }

    public void setIsconfigured21(boolean isconfigured21) {
        this.isconfigured21 = isconfigured21;
    }

    public boolean isIsconfigured23() {
        return isconfigured23;
    }

    public void setIsconfigured23(boolean isconfigured23) {
        this.isconfigured23 = isconfigured23;
    }

    private boolean device2;
    private boolean device3;

    public boolean isDevice2() {
        return device2;
    }

    public void setDevice2(boolean device2) {
        this.device2 = device2;
    }

    public boolean isDevice3() {
        return device3;
    }

    public void setDevice3(boolean device3) {
        this.device3 = device3;
    }

    public DeviceStatus() {}

    public DeviceStatus(boolean isOn, boolean isconfigured) {
        this.isOn = isOn;
        this.isconfigured = isconfigured;
    }

    public boolean isDevice1() {
        return device1;
    }

    public void setDevice1(boolean device1) {
        this.device1 = device1;
    }

    public boolean isOn() {
        return isOn;
    }

    public String isInteracted() {
        return interacted;
    }

    public void setInteracted(String interacted) {
        this.interacted = interacted;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
    public boolean getOn() {
        return isOn;
    }

    public boolean isIsconfigured() {
        return isconfigured;
    }

    public void setIsconfigured(boolean isconfigured) {
        this.isconfigured = isconfigured;
    }
    public boolean getIsconfigured() {
        return isconfigured;
    }
}
