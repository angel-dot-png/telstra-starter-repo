package au.com.telstra.simcardactivator.foundation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import au.com.telstra.simcardactivator.record.SimCardRecord;

@JsonIgnoreProperties(ignoreUnknown = true)
// public record SimCard(String iccid, String customerEmail) { }
public class SimCard{
    private String iccid;
    private String customerEmail;
    private boolean active;

    public SimCard() {
    }

    public SimCard(String temp_iccid, String temp_customerEmail, boolean active) {
        this.iccid = temp_iccid;
        this.customerEmail = temp_customerEmail;
        this.active = active;
    }

    public SimCard(SimCardRecord simCardRecord) {
        this.iccid = simCardRecord.getIccid();
        this.customerEmail = simCardRecord.getCustomerEmail();
        this.active = simCardRecord.getActive();
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    @Override
    public String toString() {
        return "SimCard={" + "iccid=" + iccid + ", customerEmail=" + customerEmail + ", active=" + active + "}";
    }
}