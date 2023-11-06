package Pages;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class NavigationMenuLogic extends NavigationMenuPO {
    public NavigationMenuLogic(WebDriver driver) {
        super(driver);
    }


    public void navigateToInvoicePage() {
        waitForExpectedElement(invoiceButton, Duration.ofSeconds(30));
        waitForElementToBeClickable(invoiceButton, Duration.ofSeconds(30));



    }

    public void navigateToArchivePage() {
        waitForExpectedElement(archiveButton, Duration.ofSeconds(30));
        waitForElementToBeClickable(archiveButton, Duration.ofSeconds(30));

    }
}
