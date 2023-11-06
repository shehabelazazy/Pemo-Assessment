package Pages;

import Utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationMenuPO extends BasePage {
    protected By invoiceButton = By.xpath("//p[text()='Invoices']//parent::button");
    protected By archiveButton = By.xpath("//p[text()='Archive']//parent::button");

    public NavigationMenuPO(WebDriver driver) {
        super(driver);
    }


}
