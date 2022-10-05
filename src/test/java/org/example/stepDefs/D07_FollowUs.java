package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_Home;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

public class D07_FollowUs {

  P02_Home home = new P02_Home();
  WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
  SoftAssert soft = new SoftAssert();
  String url;
  boolean status;


  @Given("user can scroll down page to reach follow us buttons")
  public void scroller_down_page() throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
    js.executeScript("window.scrollBy(0,2500)");
    Thread.sleep(2000);

  }

  @When("user can click on facebook sign to open facebook link")
  public void userCanClickOnFacebookSignToOpenFacebookLink() {
    wait.until(ExpectedConditions.elementToBeClickable(home.facebook_button)).click();

  }


  @Then("verify that page of nopcommerce in facebook is opened")
  public void verifyThatPageOfNopcommerceInFacebookIsOpened() throws InterruptedException {

// move driver to new tab
    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
    Hooks.driver.switchTo().window(tabs.get(1));


    // Assertions url is "https://www.facebook.com/nopCommerce"
    wait.until(ExpectedConditions.urlToBe("https://web.facebook.com/nopCommerce?_rdc=1&_rdr"));
     url = Hooks.driver.getCurrentUrl();

/* Error >>> waiting for url to be "https://www.facebook.com/nopCommerce". Current url: "https://web.facebook.com/nopCommerce?_rdc=1&_rdr
    soft.assertEquals(url ,"https://www.facebook.com/nopCommerce");*/

    soft.assertTrue(url.contains("https://web.facebook.com/nopCommerce"));

// symbol of facebook is displayed
     status = wait.until(ExpectedConditions.elementToBeClickable(home.symbol_sign_of_facebook)).isDisplayed();
    soft.assertTrue(status);

    // assert that name of page is displayed
    String text_page = home.text_name_page_displayed.getText();
    soft.assertEquals(text_page, "NopCommerce");

    soft.assertAll();

    // close new window
    Thread.sleep(3000);
    Hooks.driver.close();
    Hooks.driver.switchTo().window(tabs.get(0));

  }


  @When("user can click on twitter sign to open twitter link")
  public void userCanClickOnTwitterSignToOpenTwitterLink()
  {
  wait.until(ExpectedConditions.elementToBeClickable(home.twitter_button)).click();

  }

  @Then("verify that page of nopcommerce in twitter is opened")
  public void verifyThatPageOfNopcommerceInTwitterIsOpened() throws InterruptedException {
    // move driver to new tab
    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
    Hooks.driver.switchTo().window(tabs.get(1));

    // assert url is
    wait.until(ExpectedConditions.urlToBe("https://twitter.com/nopCommerce"));
     url = Hooks.driver.getCurrentUrl();
    soft.assertEquals(url,"https://twitter.com/nopCommerce");

    // assert is symbol of twitter is displayed
     status = home.symbol_sign_twitter.isDisplayed();
    soft.assertTrue(status);
       soft.assertAll();

    Thread.sleep(2000);

    //close window
    Hooks.driver.close();
    Hooks.driver.switchTo().window(tabs.get(0));

  }

  @When("user can click on rss sign to open rss link")
  public void userCanClickOnRssSignToOpenRssLink()
  {
     wait.until(ExpectedConditions.elementToBeClickable(home.press_on_rss)).click();
  }

  @Then("verify that page of nopcommerce in rss is opened")
  public void verifyThatPageOfNopcommerceInRssIsOpened()
  {
  /*  wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
    Hooks.driver.switchTo().window(tabs.get(1));*/

    //assert that url is https://demo.nopcommerce.com/new-online-store-is-open

     url = Hooks.driver.getCurrentUrl();
    Assert.assertTrue(url.contains("/new-online-store-is-open"));

  }


  @When("user can click on youtube sign to open youtube link")
  public void userCanClickOnYoutubeSignToOpenYoutubeLink()
  {
    wait.until(ExpectedConditions.elementToBeClickable(home.press_on_youtube)).click();
  }

  @Then("verify that page of nopcommerce in youtube is opened")
  public void verifyThatPageOfNopcommerceInYoutubeIsOpened() throws InterruptedException {
    // move driver to new tab
    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
    Hooks.driver.switchTo().window(tabs.get(1));

    // assert that url is https://www.youtube.com/user/nopCommerce
    wait.until(ExpectedConditions.urlToBe("https://www.youtube.com/user/nopCommerce"));
     url = Hooks.driver.getCurrentUrl();
    soft.assertEquals(url,"https://www.youtube.com/user/nopCommerce");

    // assert that icon of youtube is displayed
     status = home.icon_youtube.isDisplayed();
    soft.assertTrue(status);

    // asert that icon of subscriber is displayed
    soft.assertTrue(home.icon_subscriber.isDisplayed());
    soft.assertAll();

    wait.until(ExpectedConditions.elementToBeClickable(home.icon_subscriber)).click();

    //close tab
    Thread.sleep(2000);
    Hooks.driver.close();
    Hooks.driver.switchTo().window(tabs.get(0));

  }
}

