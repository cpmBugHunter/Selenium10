package ru.selenium10.bugHunter.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopHelper extends HelperBase {

    public ShopHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        type(By.name("email"), username);
        type(By.name("password"), password);
        click(By.name("login"));
    }

    public void logout() {
        if (isElementPresent(By.xpath("//*[@title=\"Logout\"]"))) {
            click(By.xpath("//*[@title=\"Logout\"]"));
        } else return;
    }
}
