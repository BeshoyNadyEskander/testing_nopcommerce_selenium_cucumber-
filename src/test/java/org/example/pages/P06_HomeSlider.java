package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P06_HomeSlider {

    public P06_HomeSlider(){

        PageFactory.initElements(Hooks.driver ,this);
    }

    public List<WebElement> list_of_sliders()
    {

        return Hooks.driver.findElements(By.xpath("//div[@id=\"nivo-slider\"]/a[@href]"));
    }


    // get text of Nokia lumia from details product page
    @FindBy(xpath = "//h1[contains(text(),'Nokia Lumia 1020')]")
    public WebElement text_of_first_product;


}
