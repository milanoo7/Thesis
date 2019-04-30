public class DeviceAttribute {
    private String name;
    private String desc;
    private int deviceID;
    private String firmVendor;
    private double firmNum;
    private String publicKey;
    private float hardwareVersion;
    private int serialNumber;
    private String macadd;


    public String getMacadd() {
        return macadd;
    }

    public void setMacadd(String macadd) {
        this.macadd = macadd;
    }

    public DeviceAttribute() {
        this.name = name;
        this.desc = desc;
        this.deviceID = deviceID;
        this.firmVendor = firmVendor;
        this.publicKey = publicKey;
        this.firmNum = firmNum;

        this.hardwareVersion = hardwareVersion;
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    public String getFirmVendor() {
        return firmVendor;
    }

    public void setFirmVendor(String firmVendor) {
        this.firmVendor = firmVendor;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public double getHardwareVersion() {
        return hardwareVersion;
    }

    public void setHardwareVersion(float hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
    public void setFirmNum(double firmNum) {
        this.firmNum = firmNum;
    }
    public double getFirmNum() { return firmNum;  }

}
