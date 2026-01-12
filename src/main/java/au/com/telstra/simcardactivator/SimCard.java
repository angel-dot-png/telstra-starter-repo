package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
// public record SimCard(String iccid, String customerEmail) { }
public class SimCard{
    @JsonProperty("iccid")
    private final String iccid;
    @JsonProperty("customerEmail")
    private final String customerEmail;

    public SimCard(String temp_iccid, String temp_customerEmail) {
        this.iccid = temp_iccid;
        this.customerEmail = temp_customerEmail;
    }

    @Override
    public String toString() {
        return "SimCard={" + "iccid=" + iccid + ", customerEmail=" + customerEmail + "}";
    }
}