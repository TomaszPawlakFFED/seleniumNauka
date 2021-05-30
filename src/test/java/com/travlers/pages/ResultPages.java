package com.travlers.pages;

import com.travlers.helper.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ResultPages {

    @FindBy(xpath = "//table[@class='bgwhite table table-striped']")
    private WebElement table;

    private SeleniumHelper helper;

    private WebDriver driver;


    public ResultPages(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
     //   this.driver = driver;
    }

    public List<String> getHotelNames() throws InterruptedException {
        List<String> hotelNames = new ArrayList<>();
        helper.waitForElementToBeDisplayes(table);
        helper.waitForListOfWebElements(table.findElements(By.xpath(".//h4//b")));
        Thread.sleep(2000);
        List<WebElement> hotelNamesWebElements = table.findElements(By.xpath("//h4//b"));
        for(WebElement element : hotelNamesWebElements){
            System.out.println(element.getText());
            hotelNames.add(element.getText());
        }
        return  hotelNames;
    }

    public List<String> getHotelPrices(){
        List<String> prices = new ArrayList<>();
        helper.waitForListOfWebElements(table.findElements(By.xpath("//div[contains(@class,'price_tab')]//b")));
        List<WebElement> hotelPrices = table.findElements(By.xpath("//div[contains(@class,'price_tab')]//b"));
        for(WebElement element : hotelPrices){
            System.out.println(element.getText());
            prices.add(element.getText());
        }
        //    List<String> prices = hotelPrices.stream().map(element -> element.getText()).collect(Collectors.toList());
        return prices;
    }
}
