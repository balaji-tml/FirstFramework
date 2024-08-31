package com.bit.CucumberPOMSeries.hooks;

import com.bit.CucumberPOMSeries.factory.DriverFactory;
import com.bit.CucumberPOMSeries.utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

//public class Hooks {
//
//    private static WebDriver driver;
//    private DriverFactory driverFactory ;
//    private ConfigReader configReader;
//    Properties prop;
//
//    Logger log;
//
//    String  browser;
//    String path;
//
//    @Before(order = 0)
//    public void getProperty()
//    {
//        path=System.getProperty("user.dir"+"/src/test/resources/config/config.properties");
//        log = LogManager.getLogger(Hooks.class);
//        configReader = new ConfigReader();
//        prop = configReader.init_properties(path);
//        log.error("Config file is loaded!");
//
//    }
//
//    @Before(order = 1)
//    public void launchBrowser()
//    {
//        browser = prop.getProperty("browser");
//        driverFactory = new DriverFactory();
//        driver = driverFactory.init_driver(browser);
//        log.error("Browser: "+browser+" is open!");
//    }
//
//    @After(order = 0)
//    public void quitBrowser()
//    {
//        driver.quit();
//        log.error("Browser: "+browser+" is closed!");
//    }
//
//    @After(order = 1)
//    public void tearDown(Scenario scenario)
//    {
//        String screenshotName = scenario.getName().replaceAll(" ","_");
//        byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//        scenario.attach(sourcePath,"img/png",screenshotName);
//
////        log.error("Browser: "+browser+" is closed!");
//    }
//}
public class Hooks {

//    private static WebDriver driver;
    private WebDriver driver;
    private DriverFactory driverFactory ;
    private ConfigReader configReader;
    Properties prop;

    Logger log;

    String  browser;
    String path;

    @Before(order = 0)
    public void getProperty()
    {
        path=System.getProperty("user.dir"+"/src/test/resources/config/config.properties");
        log = LogManager.getLogger(Hooks.class);
        configReader = new ConfigReader();
        prop = configReader.init_properties(path);
        log.error("Config file is loaded!");

    }

    @Before(order = 1)
    public void launchBrowser()
    {
        browser = prop.getProperty("browser");
        driverFactory = DriverFactory.getInstance();
        DriverFactory.setDriver(browser);
        driver = DriverFactory.getDriver(); //Added this step to resolve "this.driver" is null in (Hooks.java:109)
        log.error("Browser: "+browser+" is open!");
    }

    @After(order = 0)
    public void quitBrowser()
    {
        driver.quit();
        log.error("Browser: "+browser+" is closed!");
    }

    @After(order = 1)
    public void tearDown(Scenario scenario)
    {
        String screenshotName = scenario.getName().replaceAll(" ","_");
        byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcePath,"img/png",screenshotName);
        log.error("Browser: "+browser+" is closed!");
    }
}