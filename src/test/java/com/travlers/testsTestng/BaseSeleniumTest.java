package com.travlers.testsTestng;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.travlers.helper.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

public abstract  class BaseSeleniumTest {

    public WebDriver driver;
    ExtentReporter extentReporter;
    ExtentReports extent;

    @BeforeClass
    public void beforeClass(){
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("test.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @BeforeTest
    public void setUpReporter(){
        extentReporter = new ExtentSparkReporter("index.html");
        extent = new ExtentReports();
        extent.attachReporter((ExtentObserver) extentReporter);
    }

    @BeforeMethod
    public void setUp() throws IOException, NoSuchDriverElementException {
     //   String driverPath = "/Users/tomaszpawlak/IdeaProjects/tutorialselenium/src/main/resources/executables/Drivers/chromedriver-4";
      //  System.setProperty("webdriver.chrome.driver", driverPath);
   //     Dimension dimension = new Dimension(1200, 600);
      //  driver = DriverFactory.getDriver(DriverType.CHROME);
        System.out.println("setup class");
        if(driver == null) {
            driver = DriverFactory.chooseDriver();
        } else {
            driver = DriverFactory.chooseDriver();
        }


    }

    @AfterMethod
    public void tearDown() {
        System.out.println("tear down class");
        driver.quit();
        driver = null;
    }

    @AfterTest
    public void tearDownReporter(){
        extent.flush();
    }

    protected Media getScreenshot() throws IOException {
        return MediaEntityBuilder.createScreenCaptureFromPath(SeleniumHelper.takeScreenshot(driver)).build();
    }
}
