package Pages;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static Utilities.BaseTest.appPath;

public class LoginPageLogic extends LoginPagePO {


    public LoginPageLogic(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        waitForExpectedElement(emailField, Duration.ofSeconds(30));
        driver.findElement(emailField).sendKeys(email);

    }

    public void setPassword(String password) {
        waitForExpectedElement(passwordField, Duration.ofSeconds(30));
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        waitForExpectedElement(submitButton, Duration.ofSeconds(30));
        waitForElementToBeClickable(submitButton, Duration.ofSeconds(30));
    }

    public void loginWithCredentials() {
        Properties properties = new Properties();
        try (FileInputStream fileInput = new FileInputStream(appPath)) {
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setEmail(properties.getProperty("Email"));
        setPassword(properties.getProperty("Password"));
        clickSubmit();
    }


}
