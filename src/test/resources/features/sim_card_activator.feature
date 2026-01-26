@Cucumber
Feature: Check iccid status
    Checks whther the sim card is active or not.

    Scenario: Active iccid 
        Given active ICCID to verify
        When check active iccid
        Then return true

    Scenario: Inactive iccid 
        Given inactive ICCID to verify
        When check inactive iccid
        Then return false