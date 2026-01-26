@Cucumber
Feature: Check iccid status
    Checks whther the sim card is active or not.

    Scenario: Good simcard to activate 
        Given good simcard
        When request is sent to activate
        Then activate simcard and record state to database

    Scenario: Bad simcard to activate 
        Given bad simcard
        When request is sent to activate
        Then fail to activate and record state to database