package com.travlers.testsTestng;

import com.aventstack.extentreports.ExtentTest;
import com.travlers.helper.ExcelHelper;
import com.travlers.helper.TestListner;
import com.travlers.pages.HomePage;
import com.travlers.pages.ResultPages;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Listeners(TestListner.class)
public class SearchHotelTest extends BaseSeleniumTest {

    @Test(dataProvider = "getData")
    public void  searchHotelTest(String city, String checkInData, String checkOutDate,String fHotel, String fPrice, String sHotel, String sPrice, String tHotel, String tPrice) throws IOException, InterruptedException {
        driver.get("http://www.kurs-selenium.pl/demo/");
        ExtentTest test = extent.createTest("SearchHotelTest");

        test.info("Wejście do HomePage");
        HomePage homePage = new HomePage(driver)
                .setCityName(city)
                .setDateRange(checkInData, checkOutDate)
                .openTravellersModal()
                .addAdultCount()
                .addChild()
                .performSearch();

        String infoTest = "Wejście do ResultPage dla miasta %s";
        test.info(String.format(infoTest, city), getScreenshot());
        ResultPages resultPages = new ResultPages(driver);

        test.info("Przed asercją", getScreenshot());
        List<String> hotelNames = resultPages.getHotelNames();
        Assert.assertEquals(fHotel, hotelNames.get(0));
        Assert.assertEquals(sHotel, hotelNames.get(1));
        Assert.assertEquals(tHotel, hotelNames.get(2));

        List<String> prices = resultPages.getHotelPrices();
        Assert.assertEquals(prices.get(0), fPrice);
        Assert.assertEquals(prices.get(1), sPrice);
        Assert.assertEquals(prices.get(2), tPrice);



    }



    @DataProvider
    public  Object[][] getData() throws IOException {
        Object[][] data = null;
        data = ExcelHelper.newReadExcelFile(new File("/Users/tomaszpawlak/IdeaProjects/tutorialselenium/src/main/resources/DaneNew.xlsx"));
        return data;
    }


}
