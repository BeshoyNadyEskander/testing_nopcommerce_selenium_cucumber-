package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_Register {



    public WebElement Gender_type() {
        WebElement gender = Hooks.driver.findElement(By.className("male"));
        return gender;
    }

    public WebElement first_name() {
        WebElement firstName = Hooks.driver.findElement(By.id("FirstName"));
        return firstName;
    }

    public WebElement last_name() {
        WebElement lastName = Hooks.driver.findElement(By.id("LastName"));
        return lastName;
    }

 public WebElement dayList()
 {
     WebElement day_list= Hooks.driver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"] "));
     return day_list;
 }
    public WebElement monthList()
    {
        WebElement month_list= Hooks.driver.findElement(By.name("DateOfBirthMonth"));
        return month_list;
    }
    public WebElement yearList()
    {
        WebElement year_list= Hooks.driver.findElement(By.name("DateOfBirthYear"));
        return year_list;
    }

    public WebElement valid_Email()
    {
        WebElement email = Hooks.driver.findElement(By.cssSelector("input[type=\"email\"][id=\"Email\"]"));
        return email;
    }

    public WebElement password()
    {
        WebElement password_acc = Hooks.driver.findElement(By.cssSelector("input[type=\"password\"][id=\"Password\"]"));
        return password_acc;
    }
    public WebElement confirmation_password()
    {
        WebElement confirm_password = Hooks.driver.findElement(By.cssSelector("input[type=\"password\"][name=\"ConfirmPassword\"]"));
        return confirm_password;
    }
    public  WebElement signup()
    {
        return Hooks.driver.findElement(By.id("register-button"));

    }
    public  WebElement register_message()
    {
        WebElement registerMessage = Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]"));
        return registerMessage;
    }

    public WebElement click_continue_button()
    {
        return Hooks.driver.findElement(By.className("register-continue-button"));
    }

}
