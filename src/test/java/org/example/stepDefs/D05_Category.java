package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P05_Category;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class D05_Category {

    P05_Category homeCategory = new P05_Category();
    String subcategoryText ;


    @When("user selects random category from main category")
    public void random_main_category()
    {
        // we find that the counting in list start from zero to sex >>>[0]= category computer  but this category inside dom page = 1
        // so we need increase +1 >> we will it in method for subCategory in home page

        // count for main category
        int count_main_category = homeCategory.main_category.size();


        // 1- generate random number from list zero to (number of category ) and click on it
        int randomCategory = new Random().nextInt(count_main_category );
        System.out.println(randomCategory);

        //2- hover on select random category about using class of Actions and pass parameter of driver inside object
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(homeCategory.main_category.get(randomCategory)).perform();



        // to select random subcategory if found
        // locate cub categories that belong to the main category
        if(!homeCategory.subCategories(randomCategory).isEmpty())
        {
            // count for main category consist of sub category
            int countSubCAt = homeCategory.subCategories(randomCategory).size();
             //  generate random from them
            int selectedsubCategory = new Random().nextInt(countSubCAt);

           // get text main category that is choosed random and get number of selectedSubCategory that generated random >>
            // and using [trim()]to remove any space from first or last text  to do not make failure in assertion
            this.subcategoryText = homeCategory.subCategories(randomCategory).get(selectedsubCategory).getText().trim();

            // do action to press on random category
            homeCategory.subCategories(randomCategory).get(selectedsubCategory).click();
           // Assert.assertEquals(subcategoryText.toLowerCase(),subcategoryText.toLowerCase());

        }
        else {

            //3- get text for main category :
             this.subcategoryText = homeCategory.main_category.get(randomCategory).getText().trim();
            homeCategory.main_category.get(randomCategory).click();
           // Assert.assertEquals(mainCategoryText.toLowerCase() ,mainCategoryText.toLowerCase());



        }

    }

    @Then("verify that page of category is displayed")
    public void verifyThatPageOfCategoryIsDisplayed()
    {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(homeCategory.page_of_category.isDisplayed());
        soft.assertAll();

    }

    @And("verify that the title of category belongs to the title of random category")
    public void verifyThatTheTitleOfCategoryBelongsToTheTitleOfRandomCategory()
    {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(homeCategory.title_of_category.getText().contains(this.subcategoryText));
        soft.assertAll();


    }
}
