package com.travlers.helper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;

public class SeleniumHelper {

    private WebDriver driver;

    public  SeleniumHelper(WebDriver driver){
        this.driver = driver;
    }

    public void waitForElementToBeDisplayes(By locator){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))
            .pollingEvery(Duration.ofMillis(1000))
            .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeDisplayes(WebElement element){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForListOfWebElements(List<WebElement> elementList){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
        wait.until(driver1 -> elementList.size()>0);
    }

    public static String takeScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshitFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile  = new File("src/main/resources/" + LocalTime.now().getNano() + ".png");
        Files.copy(screenshitFile.toPath(), destinationFile.toPath());
        return  destinationFile.getName();
    }

}
