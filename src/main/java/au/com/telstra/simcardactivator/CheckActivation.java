package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
// public record CheckActivation(boolean success) { }

public class CheckActivation {
    private boolean success;
    
    public CheckActivation(){
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean bool) {
        this.success = bool;
    }

    @Override
    public String toString() {
        return "success=" + success;
    }
}