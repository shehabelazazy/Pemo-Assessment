package Pages;

import Utilities.BaseTest;
import io.cucumber.messages.internal.com.google.gson.Gson;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.RequestId;
import org.openqa.selenium.devtools.v85.network.model.Response;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

public class InvoicePageLogic extends InvoicePagePO {
    public static String FILE_PATH = "D:\\eclipse_projects\\Automation_Framework\\files\\Shehab Invoice.pdf";
    public static String INVOICES_API = "https://api.pemo.io/invoices/v2/invoices?statuses=uploading,review_pending,pending_approval,payment_pending,failed&page=1&limit=30";


    WebDriverWait wait = new WebDriverWait(driver, 10);

    public InvoicePageLogic(WebDriver driver) {
        super(driver);
    }


    public void searchInvoice(String invoiceName, String status) {
        String tmp;
        waitForExpectedElement(uploadInvoiceButton, Duration.ofSeconds(30));
        tmp = invoice.replace("@Nam", invoiceName);
        tmp = tmp.replace("@Sta", status);

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tmp)));
            System.out.println("element found");
        } catch (TimeoutException e) {

            System.out.println("Element not found within the specified timeout.");
            uploadInvoice();
            waitForExpectedElement(By.xpath(tmp), Duration.ofSeconds(180));
        }


    }


    public void uploadInvoice() {
        waitForExpectedElement(uploadInvoiceButton, Duration.ofSeconds(30));
        driver.findElement(uploadInvoiceButton).click();
        waitForExpectedElement(chooseFileButton, Duration.ofSeconds(30));
        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);
        fileInput.sendKeys(FILE_PATH);
        waitForExpectedElement(uploadButton, Duration.ofSeconds(30));
        waitForElementToBeClickable(uploadButton, Duration.ofSeconds(30));
    }


    public void clickOnAction(String invoiceName) {
        String tmp;
        tmp = actionButton.replace("@Var", invoiceName);
        waitForExpectedElement(By.xpath(tmp), Duration.ofSeconds(30));
        waitForElementToBeClickable(By.xpath(tmp), Duration.ofSeconds(30));

    }

    public void clickOnReject() {
        waitForExpectedElement(rejectButton, Duration.ofSeconds(30));
        driver.findElement(rejectButton).click();
    }

    public void setRejectReason(String message) {
        waitForExpectedElement(rejectedReason, Duration.ofSeconds(30));
        driver.findElement(rejectedReason).sendKeys(message);


    }

    public void clickOnRejectInvoiceButton() {
        waitForExpectedElement(rejectInvoiceButton, Duration.ofSeconds(30));
        waitForElementToBeClickable(rejectInvoiceButton, Duration.ofSeconds(30));


    }


    public void validateToastMessageDisplayed(String message) {
        waitForExpectedElement(toastMessage, Duration.ofSeconds(30));
        Assert.assertEquals(message, driver.findElement(toastMessage).getText());
    }

    public void validateInvoiceDisappeared(String invoiceName, String status) {
        boolean isInvoiceRecordPresent;
        driver.navigate().refresh();
        String tmp;
        waitForExpectedElement(uploadInvoiceButton, Duration.ofSeconds(30));
        tmp = invoice.replace("@Nam", invoiceName);
        tmp = tmp.replace("@Sta", status);
        try {
            WebElement invoiceRecord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tmp)));
            isInvoiceRecordPresent = true;

        } catch (TimeoutException e) {

            isInvoiceRecordPresent = false;
        }
        Assert.assertFalse(isInvoiceRecordPresent);




    }

    public CompletableFuture<Integer> captureAllNetworksApis()  {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        DevTools devTools = BaseTest.getDriver().getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        final RequestId[] requestId = new RequestId[1];
        devTools.addListener(Network.responseReceived(), responseConsumer -> {
            Response res = responseConsumer.getResponse();
            requestId[0] = responseConsumer.getRequestId();

            if (res.getUrl().equals(INVOICES_API)) {
                System.out.println("Entered Loop");
                String responseBody = devTools.send(Network.getResponseBody(requestId[0])).getBody();
                System.out.println(responseBody);
                int total = new Gson().fromJson(responseBody, InvoicesDTO.class).getTotal();
                future.complete(total);
            }
        });

        return future;
    }


    public void validateAllValuesMatched() throws InterruptedException {
        driver.navigate().refresh();
        AtomicReference<Integer> total = new AtomicReference<>();
        CompletableFuture<Integer> resultFuture = captureAllNetworksApis();
        resultFuture.thenAccept(totalCount -> {
            System.out.println("Total count: " + totalCount);
            total.set(totalCount);
        });
        waitForExpectedElement(countAll, Duration.ofSeconds(30));
        waitForExpectedElement(numberFooter, Duration.ofSeconds(30));
        waitForExpectedElement(countRows, Duration.ofSeconds(30));
        String numbersAll = driver.findElement(countAll).getText();
        List<WebElement> numRows = driver.findElements(countRows);
        String numFoot = driver.findElement(numberFooter).getText().split("\\D+")[1];
        System.out.println("shehab");
        System.out.println();
        Assert.assertTrue(
                Integer.parseInt(numbersAll) == numRows.size() &&
                        numRows.size() == total.get() &&
                        total.get() == Integer.parseInt(numFoot)
        );


    }
}
