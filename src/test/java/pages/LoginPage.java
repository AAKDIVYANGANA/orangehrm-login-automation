package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By usernameField   = By.name("username");
    By passwordField   = By.name("password");
    By loginButton     = By.xpath("//button[@type='submit']");
    By errorMessage    = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");
    By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    By requiredError   = By.xpath("//span[contains(@class,'oxd-input-field-error-message')]");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Method to enter username after waiting for it to be visible
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method to click the login button
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    // Method to verify if the dashboard is visible after a successful login
    public boolean isDashboardVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));
            return driver.findElement(dashboardHeader).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Error message for wrong details
    public String getErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            return driver.findElement(errorMessage).getText();
        } catch (Exception e) {
            return "";
        }
    }

    // Method to verify if the 'Required' validation error is visible
    public boolean isRequiredErrorVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(requiredError));
            return driver.findElement(requiredError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}