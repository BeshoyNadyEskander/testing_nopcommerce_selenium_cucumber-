package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P07_Wishlist;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Random;

public class D08_Wishlist {

    P07_Wishlist home_Wishlist = new P07_Wishlist();
    WebDriverWait wait = new WebDriverWait(Hooks.driver , Duration.ofSeconds(10));


    @Given("user could scroller down until gets the list of products")
    public void scrollDown() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(2000);
    }

    @When("user could press on wishlist button where it exists below the product")
    public void userCouldPressOnWishlistButtonWhereItExistsBelowTheProduct() throws InterruptedException {

        // generate hover and then click
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(home_Wishlist.wishList_buttons()).perform();

        Thread.sleep(2000);
       wait.until(ExpectedConditions.elementToBeClickable(home_Wishlist.wishList_buttons())).click();
        Thread.sleep(2000);


    }

    @Then("verify that the successful message appears after pressing on the button")
    public void verifyThatTheSuccessfulMessageAppearsAfterPressingOnTheButton()
    {
        SoftAssert soft =new SoftAssert();
       boolean status_message= wait.until(ExpectedConditions.visibilityOf(home_Wishlist.success_message)).isDisplayed();
       soft.assertTrue(status_message);

       String back_ground_color = home_Wishlist.success_message.getCssValue("background-color");
       String colorHx = Color.fromString(back_ground_color).asHex();
       soft.assertEquals(colorHx,"#4bb07a");

       soft.assertAll();

    }


    @And("user scroller up  wishlist where exist on Tab on the top of the page that ensure the message dissapear")
    public void userScrollerUpWishlistWhereExistOnTabOnTheTopOfThePageThatEnsureTheMessageDissapear()  {
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("window.scrollBy(0,-1500)");

        wait.until(ExpectedConditions.invisibilityOf(home_Wishlist.success_message));
        wait.until(ExpectedConditions.elementToBeClickable(home_Wishlist.wishlist_button_on_tob)).click();

    }

    @Then("verify that the quantity of wishlist bigger than zero")
    public void verifyThatTheQuantityOfWishlistBiggerThanZero()
    {
      String num_qut =  home_Wishlist.quantityOfProducts.getAttribute("value");

      // convert string to integer
      int numQut_integer = Integer.parseInt(num_qut);


        Assert.assertTrue(numQut_integer>0);
    }
}
