package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P06_HomeSlider;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D06_homeSlider {

    P06_HomeSlider slider = new P06_HomeSlider();
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));


    @When("user could select from sliders is Nokia")
    public void the_first_slider_is_clickable()
    {

        int count_slider  = slider.list_of_sliders().size();
        slider.list_of_sliders().get(1).click();
        
    }

    @Then("verify that the details of first slider for Nokia Lumia is displayed")
    public void verifyThatTheDetailsOfFirstSliderForNokiaLumiaIsDisplayed()
    {
        //https://demo.nopcommerce.com/nokia-lumia-1020
        SoftAssert soft = new SoftAssert();
        wait.until(ExpectedConditions.urlToBe("https://demo.nopcommerce.com/nokia-lumia-1020"));
        String url = Hooks.driver.getCurrentUrl();
        System.out.println("url is >>>>" + url);
        soft.assertTrue(url.contains("/nokia-lumia-1020"));

        String product_name = slider.text_of_first_product.getText();
        soft.assertEquals(product_name ,"nokia-lumia-1020");
        soft.assertAll();



    }

    @When("user could select from sliders is Iphone")
    public void the_Second_slider_is_clickable()
    {

        int count_slider  = slider.list_of_sliders().size();
        slider.list_of_sliders().get(0).click();

    }




    @Then("verify that the details of Second slider for iPhone is displayed")
    public void verifyThatTheDetailsOfSecondSliderForIPhoneIsDisplayed()
    {
        //https://demo.nopcommerce.com/iphone-6
        SoftAssert soft = new SoftAssert();

        wait.until(ExpectedConditions.urlToBe("https://demo.nopcommerce.com/iphone-6"));
        String url = Hooks.driver.getCurrentUrl();
        System.out.println("url is >>>>" + url);
        soft.assertTrue(url.contains("/iphone-6"));
        soft.assertAll();

    }
}
