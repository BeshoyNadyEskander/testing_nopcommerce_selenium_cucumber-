package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_Search;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D04_search
{

    P04_Search search = new P04_Search();


   @Given("user could go to field of search")
   public void search_label()
   {
       search.search_field().click();


    }

    @When("user could search with valid product {string}")
    public void userCouldSearchWithValidProduct(String arg0)
    {
        System.out.println(arg0);
        search.search_field().sendKeys(arg0.toLowerCase(), Keys.ENTER);

    }

    @Then("verify that the user could find a product relative for result {string}")
    public void verifyThatTheUserCouldFindAProductRelativeForResult(String name)
    {
        int count = search.productResult.size();
        for (int i = 0; i < count ; i++)
        {
            String productName = search.productResult.get(i).getText();
            Assert.assertTrue(productName.toLowerCase().contains(name.toLowerCase()));


        }
    }

    @When("user could search with valid sku {string}")
    public void userCouldSearchWithValidSku(String arg0)
    {
        search.search_field().sendKeys(arg0);
        search.search_button.click();

    }

    @Then("verify that user could find product relative for sku of result {string}")
    public void verifyThatUserCouldFindProductRelativeForSkuOfResult(String sku)
    {
        int count = search.skuProduct.size();
        SoftAssert soft = new SoftAssert();
        for (int i = 0; i < count; i++)
        {
            String productname = search.skuProduct.get(i).getText();
            soft.assertTrue(productname.contains(sku));

        }

    }

    @And("click on picture of product to navigate details for product")
    public void clickOnPictureOfProductToNavigateDetailsForProduct()
    {
        WebDriverWait wait =new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
       wait.until(ExpectedConditions.elementToBeClickable(search.click_picture_product)).click();
        //search.click_picture_product.click();
    }


    @And("verify that main sku relative for sku for searching product {string}")
    public void verifyThatMainSkuRelativeForSkuForSearchingProduct(String sku)
    {
        String product = search.sarialNumProduct.getText();
        Assert.assertEquals(product.toUpperCase() , sku.toUpperCase());
    }
}
