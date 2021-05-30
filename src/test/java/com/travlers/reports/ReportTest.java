package com.travlers.reports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportTest {
    public static void main(String[] args) {
        ExtentReporter extentReporter = new ExtentSparkReporter("index.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter((ExtentObserver) extentReporter);

        ExtentTest test = extent.createTest("First Test");
        test.log(Status.INFO, "First step");
        test.pass("Test passed");
        String path = "/Users/tomaszpawlak/IdeaProjects/tutorialselenium/src/main/resources/executables/Drivers";
        test.pass("Description", MediaEntityBuilder.createScreenCaptureFromPath(path).build());

        extent.flush();
    }
}