package au.com.telstra.simcardactivator.component;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import au.com.telstra.simcardactivator.foundation.CheckActivation;
import au.com.telstra.simcardactivator.foundation.SimCard;

@Component
public class SimCardActuationHandler {
    private final RestTemplate restTemplate;

    public SimCardActuationHandler(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public CheckActivation actuate(SimCard simCard) {
        return restTemplate.postForObject("http://localhost:8444/actuate", simCard, CheckActivation.class);
    }
}