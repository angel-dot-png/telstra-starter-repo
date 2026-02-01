package au.com.telstra.simcardactivator.foundation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class CheckActivation {
    private boolean success;
    
    public CheckActivation(){
        /* boilerplate */
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean bool) {
        this.success = bool;
    }

    @Override
    public String toString() {
        return "Sim Activation {success=" + success + "}";
    }
}