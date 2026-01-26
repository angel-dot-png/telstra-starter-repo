package au.com.telstra.simcardactivator.component;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.telstra.simcardactivator.foundation.CheckActivation;
import au.com.telstra.simcardactivator.foundation.SimCard;


@RestController
public class SimCardActivationRestController {

    private final SimCardActuationHandler simCardActuationHandler;
    private final DatabaseConduit databaseConduit;

    public SimCardActivationRestController(DatabaseConduit databaseConduit, SimCardActuationHandler simCardActuationHandler) {
        this.simCardActuationHandler = simCardActuationHandler;
        this.databaseConduit = databaseConduit;
    }

    @PostMapping(value = "/activate")
    public void handleActivationRequest(@RequestBody SimCard simCard) {
        CheckActivation actuationResult = simCardActuationHandler.actuate(simCard);
        databaseConduit.save(simCard, actuationResult);
    }

    @GetMapping(value = "/query")
    public SimCard handleActivationRequest(@RequestParam Long simCardId) {
        return databaseConduit.querySimCard(simCardId);
    }
}