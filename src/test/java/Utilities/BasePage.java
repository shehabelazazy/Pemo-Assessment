package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static void waitForExpectedElement(By by, Duration waitTimeInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), waitTimeInSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException");
        }
    }

    public static void waitForElementToBeClickable(By by, Duration waitTimeInSeconds) {
        try {
            Actions action = new Actions(BaseTest.getDriver());
            WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), waitTimeInSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
            action.moveToElement(element).click().perform();
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            System.out.println("NoSuchElementException");
            Actions action = new Actions(BaseTest.getDriver());
            WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), waitTimeInSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
            action.moveToElement(element).click().perform();


        }

    }


}
