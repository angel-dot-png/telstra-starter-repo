package au.com.telstra.simcardactivator.component;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.telstra.simcardactivator.Customer;
import au.com.telstra.simcardactivator.CustomerRepository;
import au.com.telstra.simcardactivator.foundation.CheckActivation;
import au.com.telstra.simcardactivator.foundation.SimCard;


@RestController
public class SimCardActivationRestController {

    private final SimCardActuationHandler simCardActuationHandler;
    private CustomerRepository repository;

    public SimCardActivationRestController(SimCardActuationHandler simCardActuationHandler) {
        this.simCardActuationHandler = simCardActuationHandler;
    }

    @PostMapping(value = "/activate")
    public void handleActivationRequest(@RequestBody SimCard simCard) {
        CheckActivation actuationResult = simCardActuationHandler.actuate(simCard);
        System.out.println(actuationResult.getSuccess());
    }

    @GetMapping("/get")
    public Customer getCustomer(@RequestParam long simCardId) {
        Customer customer = repository.findById(simCardId);
        System.out.println(customer.toString());
        return customer;
    }

}