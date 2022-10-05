package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver = null;

    @Before
    public void openBrrowser() {
        //1- bridge
        //System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files\\\\chromedriver.exe");
        // another method
        WebDriverManager.chromedriver().setup();

        //2- create object from webdriver
        driver = new ChromeDriver();

        //3-cofigurations

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //navigate

        driver.navigate().to("https://demo.nopcommerce.com/");
    }
        @After
                public void QuitDriver() throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }



    }





