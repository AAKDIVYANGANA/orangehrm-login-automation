package tests;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExtentManager;
import utils.ScreenshotUtils;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    static ExtentReports extent;
    ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentManager.getInstance(); // Initialize the Extent Report using our Utility class
    }

    @BeforeMethod
    public void initPage() {
        // Create an instance of LoginPage before each test
        loginPage = new LoginPage(driver);
    }

    // Test Case 01: Valid Login
    @Test(priority = 1, description = "Valid credentials should redirect to Dashboard")
    public void testValidLogin() {
        test = extent.createTest("TC01 - Valid Login");
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isDashboardVisible(),
                "Dashboard not visible after valid login");
        test.pass("Valid login successful - Dashboard visible");
    }

    // Test Case 02: Wrong Password
    @Test(priority = 2, description = "Invalid password should show error message")
    public void testInvalidPassword() {
        test = extent.createTest("TC02 - Invalid Password");
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("wrong123");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
        test.pass("Error message correctly displayed for invalid password.");
    }

    // Test Case 03: Wrong Username
    @Test(priority = 3, description = "Invalid username should show error message")
    public void testInvalidUsername() {
        test = extent.createTest("TC03 - Invalid Username");
        loginPage.enterUsername("WrongUser");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
        test.pass("Error message correctly displayed for invalid username.");
    }

    // Test Case 04: Empty Fields
    @Test(priority = 4, description = "Login with empty fields to check validation")
    public void testEmptyFields() {
        test = extent.createTest("TC04 - Empty Fields");
        loginPage.clickLogin();

        String errorMsg = loginPage.getErrorMessage();
        Assert.assertNotNull(errorMsg, "Error message should not be null");

        test.pass("Empty fields validation successful.");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Capture screenshot only if the test fails
        if (result.getStatus() == ITestResult.FAILURE) {
            String path = ScreenshotUtils.captureScreenshot(driver, result.getName());
            test.fail("Test Case Failed: " + result.getThrowable(),
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        }
    }

    @AfterSuite
    public void tearDownReport() {
        // Save the report
        extent.flush();
    }
}
