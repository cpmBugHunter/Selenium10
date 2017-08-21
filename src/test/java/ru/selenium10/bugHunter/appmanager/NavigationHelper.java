package ru.selenium10.bugHunter.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

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

    public void page(String urlPart) throws IOException {
        String baseUrl = extract("src/test/resources/local.properties", "web.baseUrl");
        wd.get(String.format("%s%s", baseUrl, urlPart));
    }
}
