package Pages;

import com.sun.source.tree.AssertTree;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

public class ArchivePageLogic extends ArchivePO {
    WebDriverWait wait = new WebDriverWait(driver, 10);

    public ArchivePageLogic(WebDriver driver) {
        super(driver);
    }

    public void navigateTORejectedTab() {
        waitForExpectedElement(rejectedButton, Duration.ofSeconds(30));
        waitForElementToBeClickable(rejectedButton, Duration.ofSeconds(30));

    }

    public void ValidateInvoiceDisplayedWithStatusRejected(String invoiceName, String status) {
        String tmp = null;
        navigateTORejectedTab();
        tmp = invoice.replace("@Nam", invoiceName);
        tmp = tmp.replace("@Sta", status);
        boolean isDisplayed = false;

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tmp)));
            System.out.println("element found");
            isDisplayed = true;
        } catch (TimeoutException e) {

            System.out.println("Element not found within the specified timeout.");
            isDisplayed = false;
        }

        Assert.assertTrue(isDisplayed);
    }

    public String getNumberOfRows() {
        waitForExpectedElement(nextButton, Duration.ofSeconds(30));
        WebElement element = driver.findElement(nextButton);
        boolean buttonClickable = true;
        String totalCount = null;
        List<WebElement> list = driver.findElements(countRows);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while (buttonClickable) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                System.out.println("Element is clickable.");
                driver.findElement(nextButton).click();
                Thread.sleep(2000);
                waitForExpectedElement(actionButton, Duration.ofSeconds(30));
                driver.findElement(actionButton).click();
                navigateTORejectedTab();
                waitForExpectedElement(countRows, Duration.ofSeconds(30));
                list.addAll(driver.findElements(countRows));

            } catch (org.openqa.selenium.TimeoutException e) {
                System.out.println("Element is not clickable.");
                totalCount = String.valueOf(list.size());
                break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        driver.navigate().refresh();
        return totalCount;

    }


    public void navigateToPaid() {
        waitForExpectedElement(paidButton, Duration.ofSeconds(30));
        waitForElementToBeClickable(paidButton, Duration.ofSeconds(30));
    }

   public void CheckSubmittedByEqualUsername(String name )
   {
       waitForExpectedElement(username, Duration.ofSeconds(30));
       String usernameValue=driver.findElement(username).getText();
       submittedBy=submittedBy.replace("@Sub",usernameValue);
       submittedBy=submittedBy.replace("@Nam",name);
       waitForExpectedElement(By.xpath(submittedBy), Duration.ofSeconds(30));
       Assert.assertTrue(driver.findElement(By.xpath(submittedBy)).isDisplayed());
   }


  public void openInvoice(String name,String status)
  {
      driver.navigate().refresh();
      String tmp = null;
      navigateTORejectedTab();
      tmp = invoice.replace("@Nam", name);
      tmp = tmp.replace("@Sta", status);
      waitForElementToBeClickable(By.xpath(tmp), Duration.ofSeconds(30));

  }

  public void validateAllMatched()
  {
      waitForExpectedElement(countAll, Duration.ofSeconds(30));
      waitForExpectedElement(numberFooter, Duration.ofSeconds(30));
      String numbersAll = driver.findElement(countAll).getText();
      String numFoot = driver.findElement(numberFooter).getText().split("\\D+")[1];
      int numOfRows= Integer.parseInt(getNumberOfRows());
      System.out.println("shehab");
      System.out.println(numOfRows);
      System.out.println(numbersAll);
      System.out.println(numFoot);


      Assert.assertTrue(
              Integer.parseInt(numbersAll) == numOfRows &&
                      numOfRows == Integer.parseInt(numFoot)
      );
      driver.navigate().refresh();

  }


}


