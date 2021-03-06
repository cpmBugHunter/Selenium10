package ru.selenium10.bugHunter.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private final Properties properties;
    WebDriver wd;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private String browser;
    private AdminHelper addminHelper;
    private ShopHelper shopHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }


    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        try (FileReader fr = new FileReader(new File(String.format("src/test/resources/%s.properties", target))))
        {
            properties.load(fr);
        }

        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        }
        else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        }
        else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
    }

    public void stop() {
        wd.quit();
    }
    
    public AdminHelper admin() {
        return addminHelper;
    }
    
    public ShopHelper shop() {
        return shopHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public SessionHelper session() {
        return sessionHelper;
    }
}
