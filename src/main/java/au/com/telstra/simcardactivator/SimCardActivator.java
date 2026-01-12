package au.com.telstra.simcardactivator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SimCardActivator {

    private static final Logger log = LoggerFactory.getLogger(SimCardActivator.class);
    private static final SimCard simCard = new SimCard("11111", "john@example.com");


    public static void main(String[] args) {
        SpringApplication.run(SimCardActivator.class, args);
    }
    
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
      return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
      return args -> {
        CheckActivation check = restTemplate.postForObject("http://localhost:8444/actuate", simCard, CheckActivation.class);
        log.info(check.toString());
      };
    }
}
