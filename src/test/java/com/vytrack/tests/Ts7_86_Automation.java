package com.vytrack.tests;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Ts7_86_Automation {
   WebDriver driver;

   @BeforeMethod

    public void setUp(){
       driver = WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get("https://qa2.vytrack.com/user/login");


   }

@Test

    public void Truckdriver(){
    WebElement login = driver.findElement(By.id("prependedInput"));
    //login.sendKeys("user38");
    login.sendKeys("user43");
    WebElement password = driver.findElement(By.id("prependedInput2"));
    password.sendKeys("UserUser123");
    WebElement loginBtn = driver.findElement(By.xpath("//button[@id='_submit']"));
    loginBtn.click();

    WebElement howToUseBar = driver.findElement(By.xpath("//*[@id=\"pinbar\"]/div[1]/div/a"));
    howToUseBar.click();
    WebElement howToUseBarText = driver.findElement(By.xpath("//h3[.='How To Use Pinbar']"));
    String actualText = howToUseBarText.getText();
    String expectedText = "How To Use Pinbar";
    Assert.assertEquals(actualText, expectedText);

    WebElement pinIconText = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/p[1]"));
    String actualText2 = pinIconText.getText();
    String expectedText2 = "Use the pin icon on the right top corner of the page to create fast access link in the pinbar.";
    Assert.assertEquals(actualText2, expectedText2);

}


}




