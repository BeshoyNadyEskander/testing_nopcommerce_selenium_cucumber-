package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P02_Home {


    // class for locators of login - currency - follow us
   public P02_Home ()
   {
       PageFactory.initElements(Hooks.driver ,this);
   }
    public WebElement register_button()
    {
        WebElement register_but = Hooks.driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
        return register_but;
    }

    public WebElement click_logout_button()
    {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/logout\"]"));
    }

    public WebElement click_login_button()
    {
        WebElement open_login = Hooks.driver.findElement(By.cssSelector("a[class=\"ico-login\"]"));
        return open_login;
    }

    public WebElement enter_Email()
    {
        WebElement Email = Hooks.driver.findElement(By.cssSelector("input[class=\"email\"]"));
        return Email;
    }
    public WebElement enter_password()
    {
        WebElement password = Hooks.driver.findElement(By.cssSelector("input[id=\"Password\"]"));
        return password;
    }

    public WebElement clickOn_login()
    {
       return Hooks.driver.findElement(By.className("login-button"));

    }

    public WebElement welcome_message()
    {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"topic-block-title\"] h2"));
    }

    public WebElement my_account_button()
    {
        return Hooks.driver.findElement(By.cssSelector("a[class=\"ico-account\"]"));
    }

    public WebElement enter_invalid_email()
    {
        WebElement invalidEmail = Hooks.driver.findElement(By.cssSelector("input[class=\"email\"]"));

        return invalidEmail;
    }
    public WebElement enter_invalid_password()
    {
        WebElement invalidPassword = Hooks.driver.findElement(By.cssSelector("input[id=\"Password\"]"));

        return invalidPassword;
    }
    public WebElement errorMessageInvalidLogin()
    {
       WebElement error_message = Hooks.driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
       return error_message;
    }

    @FindBy(id="customerCurrency")
    public WebElement currency;

   @FindBy(css = "span[class=\"price actual-price\"]")
   public List<WebElement> currency_symbol;

    /*public List<WebElement> currency_sym()
    {
        List<WebElement> currency_symbol = Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));

        return  currency_symbol;
    }*/


    // follow us
    //1- facebook button in nop commerce

    @FindBy(css = "li[class=\"facebook\"]")
    public WebElement facebook_button;

    //1-2 sign facebook in faceboook link
    @FindBy(xpath = "//a[@aria-label=\"Facebook\"]")
    public WebElement symbol_sign_of_facebook;

    @FindBy(css = "h1[class=\"jxuftiz4 jwegzro5 hl4rid49 icdlwmnq\"]")
    public WebElement text_name_page_displayed;

    //2-1 click on twitter
    @FindBy(css ="li[class=\"twitter\"]")
    public WebElement twitter_button;

    @FindBy(css ="a[aria-label=\"Twitter\"]")
    public WebElement symbol_sign_twitter;

    // 3- click on rss
    @FindBy(css ="li[class=\"rss\"]")
    public WebElement press_on_rss;

    //4- click on youtube

    @FindBy(css ="li[class=\"youtube\"]")
    public WebElement press_on_youtube;

    @FindBy(css ="ytd-topbar-logo-renderer[id=\"logo\"] a[title=\"YouTube Home\"] div[class=\"style-scope ytd-topbar-logo-renderer\"]")
    public WebElement icon_youtube;

    @FindBy(css = "div[id=\"subscribe-button\"] tp-yt-paper-button[aria-label=\"Subscribe\"]")
    public WebElement icon_subscriber;
}
