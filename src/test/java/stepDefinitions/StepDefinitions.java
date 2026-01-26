package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

import au.com.telstra.simcardactivator.SimCardActivator;
import au.com.telstra.simcardactivator.foundation.SimCard;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class StepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;
    private SimCard simCard;
    
    @Given("good simcard")
    public void good_simcard() {
        simCard = new SimCard("1255789453849037777", "active@example.com", false);
    }
    @When("request is sent to activate")
    public void request_to_activate(){
        this.restTemplate.postForObject("http://localhost:8080/activate", simCard, String.class);
    }
    @Then("activate simcard and record state to database")
    public void activate_and_record() {
        simCard = this.restTemplate.getForObject("http://localhost:8080/query?simCardId={simCardId}", SimCard.class, 1);
        assertTrue(simCard.getActive());
    }
    @Given("bad simcard")
    public void bad_simcard() {
        simCard = new SimCard("8944500102198304826", "off@example.com", false);
    }
    @Then("fail to activate and record state to database")
    public void fail_and_record() {
        simCard = this.restTemplate.getForObject("http://localhost:8080/query?simCardId={simCardId}", SimCard.class, 2);
        assertFalse(simCard.getActive());
    }

}