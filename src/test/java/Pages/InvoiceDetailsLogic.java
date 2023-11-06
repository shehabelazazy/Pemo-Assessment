package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class InvoiceDetailsLogic extends InvoiceDetailsPO {
    public InvoiceDetailsLogic(WebDriver driver) {
        super(driver);
    }

    public void  validateRejectionMessageAppears(String mess)
    {
        waitForExpectedElement(auditTrailButton, Duration.ofSeconds(30));
        waitForElementToBeClickable(auditTrailButton, Duration.ofSeconds(30));
        message=message.replace("@Var",mess);
        waitForExpectedElement(By.xpath(message), Duration.ofSeconds(30));
        Assert.assertTrue(driver.findElement(By.xpath(message)).isDisplayed());
    }
}
