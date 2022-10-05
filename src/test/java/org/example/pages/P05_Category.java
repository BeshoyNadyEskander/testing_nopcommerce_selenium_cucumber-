package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P05_Category {



    public P05_Category()
    {
        PageFactory.initElements(Hooks.driver , this);
    }


    // get locater of elements for main categories [7 category]
    @FindBy(xpath = "//ul[@class=\"top-menu notmobile\"]/li/a")
    public List<WebElement> main_category;

// get locator of elements for subCategories belong to main category and we need to identify main category about passing number of main category for example int randomsubcat
    // we need increase +1 because when generat random main catoegey for example (2) >> prefer to main category [Apparel] but when we are running [2] refer to [electronics]
    //so we need to increase 1
    public List<WebElement>subCategories(int  randomSubCatSt)
    {
        randomSubCatSt =randomSubCatSt +1;
         return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]//li["+randomSubCatSt+"]/ul[@class=\"sublist first-level\"]/li"));
    }


    //locator of page cateogry
    @FindBy(css = "div[class=\"page category-page\"]")
    public WebElement page_of_category;

    //locator of title
    @FindBy(css = "div[class=\"page-title\"]")
    public  WebElement title_of_category;




}
