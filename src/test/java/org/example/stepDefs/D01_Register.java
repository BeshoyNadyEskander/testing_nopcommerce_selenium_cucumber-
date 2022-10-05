package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.example.pages.P02_Home;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class D01_Register {

    P01_Register register = new P01_Register();
    P02_Home home = new P02_Home();

    @Given("user could go to the registration page")
    public void open_register_page()
    {
        home.register_button().click();

    }

    @When("user could select on Gender type")
    public void userCouldSelectOnGender()
    {
        register.Gender_type().click();

    }
       // attention that string inside annotation is small {string} if you want to pass paramters to access on it from feature file
    @And("user enter the first name  and last name {string}")
    public void userEnterTheFirstNameAndLastName(String arg1)  {

        Faker fake = new Faker();
        String firstname = fake.name().firstName();
        // enter first name
        register.first_name().sendKeys(firstname);
        configuration.set("name",firstname);
        // enter last name
        register.last_name().sendKeys(arg1);


    }

    @And("user enter birthdate")
    public void userEnterBirthdate()  {
        Select select = new Select(register.dayList());
        select.selectByValue("15");

        select = new Select(register.monthList());
        select.selectByVisibleText("February");

        select = new Select(register.yearList());
        select.selectByValue("1990");
        ;


    }

    @And("user enter valid email")
    public void userEnterValidEmail()  {
        // generate random email from class Faker in dependency javafaker
        Faker fake = new Faker();
        String rondomEmail = fake.internet().safeEmailAddress();
        register.valid_Email().sendKeys(rondomEmail);
        configuration.set("email",rondomEmail);
    }

    @And("user enter valid password {string} and confirmation password {string}")
    public void userEnterValidPasswordAndConfirmationPassword(String arg0 , String arg1)  {
        register.password().sendKeys(arg0);
        register.confirmation_password().sendKeys(arg1);


    }

    @And("user click on register button")
    public void userClickOnRegisterButton() throws InterruptedException
    {
        register.signup().click();

       Thread.sleep(2000);
    }

    @Then("verify user register his account successfully")
    public void verfiyUserRegisterHisAccountSuccessfully()
    {
        //1- verify register of message "" is displayed
        SoftAssert soft = new SoftAssert();
        boolean message_successfully = register.register_message().isDisplayed();
        soft.assertTrue(message_successfully);

        //2- verify the color of letters is green  rgba(76, 177, 124, 1)
        String color = register.register_message().getCssValue("color");
        soft.assertEquals(color,"rgba(76, 177, 124, 1)");

        // hex color
        String Hex_color = Color.fromString(color).asHex();
        soft.assertEquals(Hex_color,"#4cb17c");

        // verify user could enter continue button to go to home page abut url "https://demo.nopcommerce.com/"
        register.click_continue_button().click();
        String url = "https://demo.nopcommerce.com/";
        soft.assertEquals(url,"https://demo.nopcommerce.com/");

        // click on logout button to return home page
        home.click_logout_button().click();

        soft.assertAll();
    }
}
