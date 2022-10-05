@smoke
Feature: F01_Register | users could register accounts

  Scenario: new user could register account with valid data
    Given user could go to the registration page
    When user could select on Gender type
    And user enter the first name  and last name "nady"
    And user enter birthdate
     And user enter valid email
    And user enter valid password "123456789" and confirmation password "123456789"
    And user click on register button
    Then verify user register his account successfully

