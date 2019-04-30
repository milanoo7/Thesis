import java.util.Date;

public class DeviceCertificate {
    private String issuer;
    private int serialNumber;
    private String signAlgo;
    private Date dateOfIssue;
    private boolean validity;

    public DeviceCertificate() {
    }

    public DeviceCertificate(String issuer, int serialNumber, String signAlgo, Date dateOfIssue, boolean validity) {
        this.issuer = issuer;
        this.serialNumber = serialNumber;
        this.signAlgo = signAlgo;
        this.dateOfIssue = dateOfIssue;
        this.validity = validity;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSignAlgo() {
        return signAlgo;
    }

    public void setSignAlgo(String signAlgo) {
        this.signAlgo = signAlgo;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public boolean getValidity() {
        return validity;
    }

    public void setValidity(boolean validity) {
        this.validity = validity;
    }


}

