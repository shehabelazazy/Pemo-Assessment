package StepDefinition;

import Pages.InvoicePageLogic;
import Utilities.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class Invoice {

    InvoicePageLogic invoice = new InvoicePageLogic(BaseTest.getDriver());


    @Then("Search for invoice with {string} {string}")
    public void searchForInvoiceWith(String arg0, String arg1) {
        invoice.searchInvoice(arg0, arg1);


    }

    @And("Click on Action button to an invoice has {string}")
    public void clickOnActionButtonToAnInvoiceHas(String arg0) {
        invoice.clickOnAction(arg0);

    }

    @And("Click on reject option")
    public void clickOnRejectOption() {
        invoice.clickOnReject();

    }



    @And("Click on reject invoice button")
    public void clickOnRejectInvoiceButton() {
        invoice.clickOnRejectInvoiceButton();
    }

    @Then("Validate toast message will appear to the user {string}")
    public void validateToastMessageWillAppearToTheUser(String arg0) {
        invoice.validateToastMessageDisplayed(arg0);
    }



    @Then("Number besides the All tab & Number in the Footer & Count of rows in the All tab & Total count fetched from API should be matched")
    public void numberBesidesTheAllTabNumberInTheFooterCountOfRowsInTheAllTabTotalCountFetchedFromAPIShouldBeMatched() throws InterruptedException {
        invoice.validateAllValuesMatched();
    }

    @Then("Enter {string} in the rejection reason field")
    public void enterInTheRejectionReasonField(String arg0) {
        invoice.setRejectReason(arg0);

    }

    @And("Invoice record should disappear from the All tab under the {string} {string}")
    public void invoiceRecordShouldDisappearFromTheAllTabUnderThe(String arg0, String arg1) {
        invoice.validateInvoiceDisappeared(arg0, arg1);

    }
}
