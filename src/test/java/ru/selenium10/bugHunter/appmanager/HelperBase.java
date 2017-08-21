package ru.selenium10.bugHunter.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.Properties;

public class HelperBase {

    protected WebDriver wd;
    protected Properties properties;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
        properties = new Properties();
    }

    public String extract (String propFilePath, String propName) throws IOException {
        try (FileReader fr = new FileReader(new File (propFilePath)))
        {
            properties.load(fr);
        }
        return properties.getProperty(propName);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (! existingText.equals(text)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
