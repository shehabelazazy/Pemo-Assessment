package Pages;

import Utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArchivePO extends BasePage {
    By rejectedButton = By.xpath("//button[text()='Rejected']");
        String invoice = "//span[text()='@Sta']//ancestor::tr/td[2]/div/div/span[text()='@Nam']//ancestor::tr";
    By countAll = By.xpath("//button[text()='Rejected']/p");
    By numberFooter = By.xpath("//*[@id='drawer-container']/div/div[4]/div[2]/p[1]");
    By countRows = By.xpath("//table/tbody/tr");
    By nextButton = By.xpath("//*[@id='drawer-container']/div/div[4]/div[2]/button[2]");
    By paidButton = By.xpath("//button[text()='Paid']");
    By actionButton = By.xpath("//span[text()='Rejected']//ancestor::tr/td[last()]");

    By username  =By.xpath("//*[@id='__next']/div[2]/div[2]/div[1]/div[2]/div[1]/div/p");

    String submittedBy="//p[text()='@Sub']//ancestor::tr/td[2]/div/div/span[text()='@Nam']//ancestor::tr";

    public ArchivePO(WebDriver driver) {
        super(driver);
    }
}
