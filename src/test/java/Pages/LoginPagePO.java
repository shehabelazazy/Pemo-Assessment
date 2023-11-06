package Pages;

import Utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPagePO extends BasePage {


    protected By emailField = By.name("email");
    protected By passwordField = By.name("password");
    protected By submitButton = By.xpath("//button[@type='submit']");
    protected By invoiceButton = By.xpath("//p[text()='Invoices']//parent::button");

    public LoginPagePO(WebDriver driver) {
        super(driver);
    }


}
