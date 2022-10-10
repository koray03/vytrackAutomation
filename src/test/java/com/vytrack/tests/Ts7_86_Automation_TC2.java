package com.vytrack.tests;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Ts7_86_Automation_TC2 {
    WebDriver driver;

    @BeforeMethod

    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
    }

    @Test

    public void UsersTc2() {

        //Users login with valid credentials

        WebElement login = driver.findElement(By.id("prependedInput"));
        login.sendKeys("user38");

        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        WebElement loginBtn = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginBtn.click();

        //Users are on the homepage Click

        WebElement howToUseBar = driver.findElement(By.xpath("//*[@id=\"pinbar\"]/div[1]/div/a"));
        howToUseBar.click();

        //Verify Image Source

        WebElement imgSrc = driver.findElement(By.xpath("//img[@src='/bundles/oronavigation/images/pinbar-location.jpg']"));
        String actualSrc = imgSrc.getAttribute("src");
        System.out.println("Image source: " + actualSrc + " -verified!");

    }


    @AfterMethod

    public void tearDown() {
        driver.quit();
    }


}
