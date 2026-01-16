package au.com.telstra.simcardactivator.foundation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
// public record SimCard(String iccid, String customerEmail) { }
public class SimCard{
    @JsonProperty("iccid")
    private String iccid;
    @JsonProperty("customerEmail")
    private String customerEmail;
    @JsonProperty("active")
    private boolean active;

    public SimCard(String temp_iccid, String temp_customerEmail, boolean active) {
        this.iccid = temp_iccid;
        this.customerEmail = temp_customerEmail;
        this.active = active;
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