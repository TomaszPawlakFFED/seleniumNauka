package com.travlers.helper;

import com.travlers.helper.DriverFactory;
import com.travlers.helper.SeleniumHelper;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.logging.Logger;

public class TestListner implements ITestListener {

    Logger log = Logger.getLogger("Test");

    @Override
    public void onTestStart(ITestResult iTestResult){
        log.info("\"On test start\"");
        System.out.println("TEST");
    }

    @Override
    public  void onTestFailure(ITestResult iTestResult){
        try {
            SeleniumHelper.takeScreenshot(DriverFactory.getDriver(DriverType.CHROME));
        } catch (IOException | NoSuchDriverElementException e) {
            e.printStackTrace();
        }
    }
}
