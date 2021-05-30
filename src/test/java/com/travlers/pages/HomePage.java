package com.travlers.pages;

import com.travlers.helper.SeleniumHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchSpan;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement searchCityInput;

    @FindBy(name = "checkin")
    private WebElement checkInInput;

    @FindBy(name = "checkout")
    private WebElement checkOutput;

    @FindBy(id = "travellersInput")
    private WebElement travellersInput;

    @FindBy(id = "adultPlusBtn")
    private WebElement adultPlusBtn;

    @FindBy(id = "childPlusBtn")
    private WebElement childPlusBtn;

    @FindBy(xpath = "//button[text()=' Search']")
    private WebElement searchButton;



    @FindBy(xpath = "//div[@class='select2-result-label']")
    private WebElement selectResult;

    private SeleniumHelper helper;

    private WebDriver driver;


    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
   //     this.driver = driver;
    }

    public HomePage setCityName(String cityName)  {
        searchSpan.click();
        searchCityInput.sendKeys(cityName);
       //  By locatioLabel = By.xpath("//div[@class='select2-result-label']");
        helper.waitForElementToBeDisplayes(selectResult);
        searchCityInput.sendKeys(Keys.ENTER);
        return this;
    }

    public HomePage setDateRange(String checkInDate, String checkOutDate) {
        checkInInput.sendKeys(checkInDate);
        checkOutput.sendKeys(checkOutDate);
        checkOutput.click();
        return this;
    }

    public HomePage openTravellersModal() {
        travellersInput.click();
        helper.waitForElementToBeDisplayes(adultPlusBtn);
        return this;
    }

    public HomePage addAdultCount(){
        adultPlusBtn.click();
        return this;
    }

    public HomePage addChild(){
        childPlusBtn.click();
        return this;
    }

    public HomePage performSearch(){
        searchButton.click();
        return this;
    }





}

