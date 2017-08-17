package ru.selenium10.bugHunter.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void homePage() {
        if(isElementPresent((By.xpath("//*[@title=\"Home\"]")))) {
            return;
        } else {
            click(By.xpath("//*[@title=\"Home\"]"));
        }
    }

    public void url(String uri){

    }
}
