package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    //Setup Method: Runs before every test case
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
    }

    // Test Case 01: Positive Login Test
    @Test(priority = 1, description = "Valid credentials should redirect to Dashboard")
    public void testValidLogin() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isDashboardVisible(),
                "Dashboard not visible after valid login");
        System.out.println("✅ TC01 - Valid Login: PASSED");
    }

    // Test Case 02: Negative Login Test (Wrong Password)
    @Test(priority = 2, description = "Invalid password should show error message")
    public void testInvalidPassword() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Invalid credentials",
                "Error message mismatch");
        System.out.println("✅ TC02 - Invalid Password: PASSED");
    }

    // Test Case 03: Negative Login Test (Wrong Username)
    @Test(priority = 3, description = "Invalid username should show error message")
    public void testInvalidUsername() {
        loginPage.enterUsername("WrongUser");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Invalid credentials",
                "Error message mismatch");
        System.out.println("✅ TC03 - Invalid Username: PASSED");
    }

    // Test Case 04: Validation Test (Empty Fields)
    @Test(priority = 4, description = "Empty fields should show required validation")
    public void testEmptyFields() {
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isRequiredErrorVisible(),
                "Required error not shown for empty fields");
        System.out.println("✅ TC04 - Empty Fields: PASSED");
    }

    // Runs after every test case
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}