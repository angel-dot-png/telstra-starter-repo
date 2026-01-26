package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import au.com.telstra.simcardactivator.foundation.CheckActivation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;
    private String iccid;
    private CheckActivation check;
    
    @Given("active ICCID to verify")
    public void active_iccid_to_verify() {
        iccid = "1255789453849037777";
    }
    @When("check active iccid")
    public void check_active_iccid(){
        check = restTemplate.postForObject("http://localhost:8444/actuate", iccid, CheckActivation.class);
    }
    @Then("return true")
    public void return_true() {
        assertThat(check.getSuccess()).isEqualTo(true);
    }

    @Given("inactive ICCID to verify")
    public void inactive_iccid_to_verify() {
        iccid = "8944500102198304826";
    }
    @When("check inactive iccid")
    public void check_inactive_iccid(){
        check = restTemplate.postForObject("http://localhost:8444/actuate", iccid, CheckActivation.class);
    }
    @Then("return false")
    public void return_false() {
        assertThat(check.getSuccess()).isEqualTo(false);
    }

}