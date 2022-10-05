@smoke
Feature: F02_Login | users could use login functionality to use their accounts

  Scenario: user could login with valid email and password

  Given user go to login page
  When user enter valid email and password "123456789"
  And user click on login button
  Then verify user login successfully


  Scenario: user could not login with invalid data

    Given user go to login page
    When enter invalid email "sss@exam.com" and password "wrong"
    And user click on login button
    Then verify user could not  login