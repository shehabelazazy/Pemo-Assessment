package Pages;

import Utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvoicePagePO extends BasePage {
    String invoice = "//span[text()='@Sta']//ancestor::tr/td[2]/div/div/span[text()='@Nam']//ancestor::tr";
    By uploadInvoiceButton = By.id("NymCardInvoices-uploadInvoices-1");
    By uploadButton = By.id("NymCardInvoices-uploadInvoice-1");
    By chooseFileButton = By.xpath("//button[text()='Choose files']");
    String actionButton = "//span[text()='@Var']//ancestor::tr/td[last()]";
    By rejectButton = By.xpath("//*[text()='Reject']");
    By rejectedReason = By.name("reason");
    By rejectInvoiceButton = By.xpath("//button[text()='Reject invoice']");
    By toastMessage = By.xpath("//*[contains(@class,'Toastify__toast-body')]/div[2]");
    By countAll = By.xpath("//button[text()='All']/p");
    By numberFooter = By.xpath("//*[@id='drawer-container']/div/div[4]/div[2]/p[1]");
    By countRows = By.xpath("//table/tbody/tr");

    public InvoicePagePO(WebDriver driver) {
        super(driver);
    }

}
