package com.travlers.testsTestng;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GoogleSeleniumTest extends BaseSeleniumTest {


        @Test
        public void googleOpenTest() {
            driver.get("https://www.google.com");
            WebElement searchInput = driver.findElement(By.name("q"));


//            //Action prawy przycisk myszy
//            Actions action = new Actions(driver);
//            action.contextClick().build().perform();
//
//            //Hover
//            Actions actionHover = new Actions(driver);
//            actionHover.moveToElement(driver.findElement(By.id("navbar_tutorials"))).build().perform();
//
//
//
//
//            //Klikania Javą
//            JavascriptExecutor executor = (JavascriptExecutor) driver;
//            executor.executeScript("alert('Hello World')");
//            executor.executeScript("arguments[0].click():", searchInput);


//            searchInput.sendKeys("Selenium");
//            searchInput.sendKeys(Keys.ENTER);
//            WebElement seleniumPageLink = driver.findElement(By.linkText("Selenium - Web Browser Automation"));
//            seleniumPageLink.click();
//
//            String expectedTitle = "Selenium - Web Browser Automation";
//            System.out.println(driver.getTitle());
//
//            Assert.assertEquals(driver.getTitle(), expectedTitle);
//            Assert.assertNotEquals("Test1", "Test2");
//            assertTrue(expectedTitle.equals(driver.getTitle()));
//            assertTrue(driver.getTitle().equals("Zła nazwa"), "Tyuły nie są równe");
        }
}
