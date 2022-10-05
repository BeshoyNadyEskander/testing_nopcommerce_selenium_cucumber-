package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_Home;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class D03_currency {
    P02_Home home = new P02_Home();

    @When("user select on euro currency")
    public void currency_button()
    {
        Select select = new Select(home.currency);
        select.selectByVisibleText("Euro");


    }

    @Then("verify that the changing of currency is displayed successfully")
    public void verifyThatTheChangingOfCurrencyIsDisplayedSuccessfully()
    {
        int count =home.currency_symbol.size();
        for(int i =0; i<count; i++)
        {
            String symbolcurrency = home.currency_symbol.get(i).getText();
            Assert.assertTrue(symbolcurrency.contains("€"));
        }

    }
}
