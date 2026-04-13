package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports getInstance() {

        ExtentSparkReporter reporter =
                new ExtentSparkReporter("target/ExtentReport.html");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        return extent;
    }
}
