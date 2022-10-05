package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P04_Search {

   public P04_Search()
   {
       PageFactory.initElements(Hooks.driver , this);
   }

   public WebElement search_field()
   {
       WebElement searchLabel = Hooks.driver.findElement(By.cssSelector("input[aria-label=\"Search store\"]"));
       return searchLabel;
   }

   // method for click button of search
    @FindBy(css = "button[class=\"button-1 search-box-button\"]")
    public WebElement search_button;

   // this method for search products result (name)
   @FindBy(css = "h2[class=\"product-title\"] a[href]")
    public List<WebElement>productResult;

   // method for searching products (sku) to verify sku relative name of product
    @FindBy(css = "h2[class=\"product-title\"] a")
    public List<WebElement> skuProduct;

    //method for clicking on picture of product
    @FindBy(css = "div[class=\"picture\"]")
    public WebElement click_picture_product;

    // method for locator sku product to verify sku searching
    @FindBy(css = "div[class=\"sku\"] span[class=\"value\"]")
    public WebElement sarialNumProduct;
}
