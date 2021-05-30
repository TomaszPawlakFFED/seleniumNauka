import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class FirstSeleniumTest {

    @Test
    public void googleOpenTest() {
        String driverPath = "/Users/tomaszpawlak/IdeaProjects/tutorialselenium/src/main/resources/executables/Drivers/chromedriver-4";
        System.setProperty("webdriver.chrome.driver", driverPath);
        Dimension dimension = new Dimension(1200, 600);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/tomaszpawlak/IdeaProjects/tutorialselenium/src/main/resources/Test.html");
        driver.findElement(By.id("newPage")).click();
        WebElement firstNameInupt = driver.findElement(By.id("clickOnMe"));
        firstNameInupt.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();




        //Sprawdzenie czy lement jest widoczny
        WebElement topSecretElement = driver.findElement(By.className("topSecret"));
        if(topSecretElement.isDisplayed()){
            System.out.println("Element jest widoczny");
            System.out.println(topSecretElement.getText());
        } else {
            System.out.println("Element nie jest widoczny");
            System.out.println(topSecretElement.getText());
        }

        //Sprawdzenie czy checkbox jest zaznaczony
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if (checkbox.isSelected()) {
            System.out.println("Checkbox jest zazanczony");
            checkbox.click();
            System.out.println("Checkbox został odznacozny");
        } else {
            System.out.println("Checkbox nie jest zaznaczony");
            System.out.println(topSecretElement.getAttribute("textContent"));
        }



        //Sprawdzenie czy element isEnabled()
        WebElement firstNameInput = driver.findElement(By.name("fname"));
        if(firstNameInput.isEnabled()){
            System.out.println("Element nie jest zablokowany");
            firstNameInput.sendKeys("Tomasz");
        } else {
            System.out.println("element jest zablokowany");
        }

        // Pobieranie rozmiaru obrazka
        WebElement smileImg = driver.findElement(By.id("smileImage"));
        System.out.println(smileImg.getSize().getHeight());



        //Odczytanie niewidocznego tekstu
        WebElement paragraph = driver.findElement(By.className("topSecret"));
        System.out.println("Mój text to " + paragraph.getAttribute("textContent"));

        // Zaznaczenie chceckoboxa
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox2.click();
        checkbox2.click();

        // Zaznaczenie radiobuttona
        WebElement radioButton = driver.findElement(By.xpath("//input[@value='male']"));
        radioButton.click();

        //

        WebElement firstNameInput2 = driver.findElement(By.name("fname"));
        firstNameInput2.sendKeys("Bartek");
        firstNameInput2.clear();
        firstNameInput2.sendKeys("Tomek");

        // get nie znajdzie inputa
        System.out.println(firstNameInput.getText());

        // do pobrania wartości trzeba wziąc getAtrribiute
        System.out.println(firstNameInput.getAttribute("value"));

        Select carSelect = new Select(driver.findElement(By.tagName("select")));
        carSelect.selectByValue("audi");
        carSelect.selectByIndex(0);

        WebElement label = driver.findElement(By.tagName("label"));
        System.out.println("wartość labela " + label.getText());

        //get attribiute

        WebElement w3SchoolLink = driver.findElement(By.linkText("Visit W3Schools.com!"));
     //   WebElement googleLink = driver.findElement(By.partialLinkText("Weird"));
        WebElement topSecretParagraph = driver.findElement(By.className("topSecret"));
        WebElement firstInput = driver.findElement(By.tagName("input"));
        WebElement firstLink = driver.findElement(By.tagName("a"));

        WebElement clickOnMeButton = driver.findElement(By.cssSelector("#clickOnMe"));
        WebElement links = driver.findElement(By.cssSelector("a"));
        WebElement topSecretCss = driver.findElement(By.cssSelector(".topSecret"));
        WebElement tdFirstChild = driver.findElement(By.cssSelector("td:first-child"));
        WebElement clickOnMeXpathButton = driver.findElement(By.xpath("/html/body/button"));
        WebElement clickOnMeXpathButton2 = driver.findElement(By.xpath("//button"));
        WebElement linkXpath = driver.findElement(By.xpath("//a"));
        WebElement topSecretXpath = driver.findElement(By.xpath("//p[@class='topSecret']"));
        WebElement topSecretXpath2 = driver.findElement(By.xpath("//*[@class='topSecret']"));
        WebElement linkText = driver.findElement(By.xpath("//a[text()='Visit W3Schools.com!']"));

        WebElement firstLinkTag = driver.findElement(By.tagName("a"));
        List<WebElement> linkss = driver.findElements(By.tagName("a"));




        //Xpath trening
        // /students/student/imie
        // //imie
        // //students//imie
        // //imie[test()='John']
        // //kierunek[text()='Geologia']
        // //nazwisko[@lang='en']
        // //nazwisko[@class='red']
        // //a
        // //*[text()='Kowalski']
        //driver.close();
        //driver.quit();

        WebElement newPageButton = driver.findElement(By.id("newPage"));
        String currentWindowName = driver.getWindowHandle();
        newPageButton.click();
        switchNewWindow(driver, currentWindowName);
        System.out.println("Obecny URL to " + driver.getCurrentUrl());
        driver.switchTo().window(currentWindowName);
        driver.findElement(By.name("username")).sendKeys(" Mouser");
    }

    private void switchNewWindow(WebDriver driver, String currentWindowName) {
        System.out.println("Wartość dla obecnego okna to " + currentWindowName);
        Set<String> windows = Collections.singleton(driver.getWindowHandle());
        System.out.println("Ilość okien przeglądarki " + windows.size());
        for (String window : windows){
            if(!window.equals(currentWindowName)) {
                driver.switchTo().window(window);
            }
        }

    }
    // Sprawdzenie czy element istnieje na stronie


    // Metoda nr 1
    public boolean checkIfElementExist(By locator, WebDriver driver){
        if(driver.findElements(locator).size()>0){
            System.out.println("Element istnieje na stronie");
            return true;
        }
        System.out.println("Brak elementu na stronie");
        return false;
    }

    // Metoda nr 2
    public void checkIfElementExist(WebDriver driver, By locator){
        try {

        } catch (NoSuchElementException exc){
            System.out.println("Element nie istnieje");
        }
    }
}
