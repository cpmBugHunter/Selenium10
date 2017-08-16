package ru.selenium10.bugHunter.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.selenium10.bugHunter.appmanager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static final ApplicationManager appMngr = new ApplicationManager(
            System.getProperty("browser", BrowserType.CHROME));


    @BeforeSuite
    public void setUp(ITestContext context) throws Exception {
        appMngr.init();
        context.setAttribute("appMngr", appMngr);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        appMngr.stop();
    }

    @BeforeMethod(alwaysRun = true)
    public void logTestStart(Method m, Object[] p){
        logger.info("Test " + m.getName() + " with parameters " + Arrays.asList(p) + " started");
    }

    @AfterMethod
    public void logTestStop(Method m) {
        logger.info("Test " + m.getName() + " finished");
    }
}
