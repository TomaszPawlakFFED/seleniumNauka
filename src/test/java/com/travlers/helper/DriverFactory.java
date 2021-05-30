package com.travlers.helper;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class DriverFactory {

    private static  WebDriver driverInstance;
    private static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();

    public static WebDriver getDriver(DriverType driverType) throws IOException, NoSuchDriverElementException {

        if(driverInstance == null){
            getSpecificDriver(driverType);
//            File driverExe = new File("/Users/tomaszpawlak/IdeaProjects/tutorialselenium/src/main/resources/executables/Drivers/chromedriver-4");
//            ChromeDriverService driverService = new ChromeDriverService.Builder()
//                    .usingDriverExecutable(driverExe)
//                    .usingAnyFreePort().build();
            System.out.println(" Zmienna zostanie zainicjalizowana");
//            String driverPath = "/Users/tomaszpawlak/IdeaProjects/tutorialselenium/src/main/resources/executables/Drivers/chromedriver-4";
//            System.setProperty("webdriver.chrome.driver", driverPath);
            Dimension dimension = new Dimension(1200, 600);


            driverInstance.manage().window().maximize();
        }
        return driverInstance;

    }

    public static WebDriver chooseDriver() throws IOException, NoSuchDriverElementException {
        String isRemoteDriverValue = ConfigurationProperties.getProperties().getProperty("isRemoteDriver");
            if(Boolean.getBoolean(isRemoteDriverValue)){
                System.out.println("______________1_____________");
                return DriverFactory.getDriver(DriverType.CHROME);
            } else {
                System.out.println("______________2_____________");
                File chromeExe = new File("/Users/tomaszpawlak/Downloads/chromedriver-4");
                System.setProperty("webdriver.chrome.driver","/Users/tomaszpawlak/Downloads/chromedriver-4");

                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setPlatform(Platform.MAC);
                capabilities.setBrowserName("chrome");
//
//            capabilities.setBrowserName("chrome");
//            capabilities.setPlatform(Platform.MAC);

                localDriver.set(new RemoteWebDriver(new URL("http://192.168.0.105:1234/wd/hub"), capabilities));
//            ChromeDriverService chromeService = new ChromeDriverService.Builder()
//                    .usingDriverExecutable(chromeExe)
//                    .usingAnyFreePort().build();
//            localDriver.set(new ChromeDriver(chromeService));
                localDriver.get().manage().window().maximize();


            }
            return  localDriver.get();

    }

    private static void getSpecificDriver(DriverType driverType) throws IOException, NoSuchDriverElementException {

        switch (driverType){
            case FIREFOX:
                File geckoExe = new File("/Users/tomaszpawlak/IdeaProjects/tutorialselenium/src/main/resources/executables/Drivers/geckodriver-2");
                GeckoDriverService geckoService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(geckoExe)
                        .usingAnyFreePort().build();
                driverInstance = new FirefoxDriver(geckoService);
            break;

            case CHROME:
                File chromeExe = new File("/Users/tomaszpawlak/IdeaProjects/tutorialselenium/src/main/resources/executables/Drivers/chromedriver-4");
                ChromeDriverService chromeService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(chromeExe)
                        .usingAnyFreePort().build();
                driverInstance = new ChromeDriver(chromeService);
            break;

            case IE:
                System.out.println("Brak IE driver");
            break;

            default:
                System.out.println("Brak dostępnych driverów");
                throw new NoSuchDriverElementException();
        }
    }

    public static void resetDriver() {
        driverInstance = null;
        localDriver = null;
    }
}
