package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_Home;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_Login {

    P02_Home home = new P02_Home();

    @Given("user go to login page")
    public void open_login_page()
    {
      home.click_login_button().click();
    }

    @When("user enter valid email and password {string}")
    public void userEnterValidEmailAndPassword( String arg1) throws InterruptedException {
        home.enter_Email().sendKeys(configuration.get("email"));
        System.out.println("random email ... " + configuration.get("email"));
        home.enter_password().sendKeys(arg1);
        Thread.sleep(2000);
    }

    @And("user click on login button")
    public void userClickOnLoginButton()
    {
        home.clickOn_login().click();

    }

    @Then("verify user login successfully")
    public void verifyUserLoginSuccessfully()
    {

        SoftAssert soft = new SoftAssert();

        // validate that log_out button is displayed
        boolean status = home.click_logout_button().isDisplayed();
        soft.assertTrue(status);

        //validate that my_account button is displayed
        status = home.my_account_button().isDisplayed();
        soft.assertEquals(status,true);


       // ensure that url is https://demo.nopcommerce.com/
        String url = "https://demo.nopcommerce.com/";
        soft.assertEquals(Hooks.driver.getCurrentUrl(),url);

        //ensure that message "Welcome to our store " is displayed

        boolean message = home.welcome_message().isDisplayed();
        soft.assertTrue(message);

        soft.assertAll();
        
    }

    @When("enter invalid email {string} and password {string}")
    public void enterInvalidEmailAndPassword(String arg0 , String arg1) throws InterruptedException {
        home.enter_invalid_email().sendKeys(arg0);
        home.enter_invalid_password().sendKeys(arg1);
        Thread.sleep(1000);

    }

    @Then("verify user could not  login")
    public void verifyUserCouldNotLogin()
    {
        SoftAssert soft =new SoftAssert();

        // verify that error message is dispalyed
         String error_message = home.errorMessageInvalidLogin().getText();
         soft.assertTrue(error_message.contains("Login was unsuccessful. Please correct the errors and try again.\n" +
                 "No customer account found"));

       // verify that color of error message is red color
         String color =home.errorMessageInvalidLogin().getCssValue("color");
         String Hex_color = Color.fromString(color).asHex();
         soft.assertEquals(Hex_color,"#e4434b");

          // verify that url is contained "https://demo.nopcommerce.com/login?returnUrl=%2F"
        String url = Hooks.driver.getCurrentUrl();
        soft.assertTrue(url.contains("/login"));
         soft.assertAll();

    }


}
