package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P07_Wishlist {

    public P07_Wishlist(){

        PageFactory.initElements(Hooks.driver ,this);
    }

    @FindBy (css = "div[class=\"item-grid\"] [class=\"product-item\"]")
    public List<WebElement> list_of_products;


    public WebElement wishList_buttons()
    {

       return Hooks.driver.findElement(By.xpath("//div[@class=\"product-item\"] [@data-productid=\"18\"]//div[@class=\"buttons\"]//button[@title=\"Add to wishlist\"]"));
    }

    @FindBy(css = "div[class=\"bar-notification success\"]")
    public WebElement success_message;

    @FindBy(css = "a[class=\"ico-wishlist\"]")
    public WebElement wishlist_button_on_tob;

    @FindBy(css = "td[class=\"quantity\"] [value]")
    public WebElement quantityOfProducts;
}
