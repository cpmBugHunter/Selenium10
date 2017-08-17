package ru.selenium10.bugHunter.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
     public void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testInfrastructureSetProperly() {
        driver.get("https://www.google.ru/");
        WebElement q = driver.findElement(By.name("q"));
        q.sendKeys("webdriver");
        q.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.titleContains("webdriver"));
    }

    @AfterMethod
    public void tearDown(){
         driver.quit();
         driver = null;
    }
}
