package com.bit.CucumberPOMSeries.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
//public class DriverFactory {
//    public static WebDriver driver;
//    public static ThreadLocal<WebDriver> tlWebDriver = new ThreadLocal<>();
//
//    /*
//    *This method is used to initialize the threadlocal driver on the basis of given browser
//    * @param browser
//    *@return WebDriver
//    *
//     */
////    public static WebDriver init_driver(String browser)
//    public WebDriver init_driver(String browser)
//    {
//        System.out.println("Browser value is: "+browser);
//        if(browser.equals("chrome"))
//        {
//            WebDriverManager.chromedriver().setup();
//            tlWebDriver.set(new ChromeDriver());
//        }
//        else if(browser.equals("firefox"))
//        {
//            WebDriverManager.firefoxdriver().setup();
//            tlWebDriver.set(new FirefoxDriver());
//        }
//        else if(browser.equals("edge"))
//        {
//            WebDriverManager.edgedriver().setup();
//            tlWebDriver.set(new EdgeDriver());
//        }
//        else if(browser.equals("safari"))
//        {
//            tlWebDriver.set(new SafariDriver());
//        }
//        else {
//            System.out.println("Please pass the correct browser value: "+browser);
//        }
//        getDriver().manage().deleteAllCookies();
//        getDriver().manage().window().maximize();
//        return getDriver();
//
//    }
//
//    /*
//    *This is used to get the driver with ThreadLocal
//    *@return WebDriver
//     */
//    public static synchronized WebDriver getDriver()
//    {
//        return tlWebDriver.get();
//    }
//
//}

public class DriverFactory {
    private static DriverFactory instance = null;
    public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    private static String userDir = System.getProperty("user.dir");

    public static DriverFactory getInstance() {
        if ( instance == null ) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public static final void setDriver(String browser) {

        switch (browser) {

            case "firefox":
//                WebDriverManager.firefoxdriver().setup();
                System.setProperty("webdriver.gecko.driver", userDir + "/src/test/resources/executables/geckodriver.exe");
                webDriver.set(new FirefoxDriver());
                break;

            case "chrome":
//                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", userDir + "/src/test/resources/executables/chromedriver.exe");
                webDriver.set(new ChromeDriver());

                break;

            case "edge":

//                WebDriverManager.edgedriver().setup();
                System.setProperty("webdriver.edge.driver", userDir + "/src/test/resources/executables/msedgedriver.exe");
                webDriver.set(new EdgeDriver());
                break;

        }
//        getDriver().manage().timeouts().implicitlyWait(10, Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void tearDown() {
        getDriver().quit();
    }
}