package Pages;

import Utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvoiceDetailsPO extends BasePage {


    public InvoiceDetailsPO(WebDriver driver) {
        super(driver);

    }
    By auditTrailButton= By.id("NymCardInvoice-auditTrailTab-1");
    String message="//p[text()='@Var']";

}
