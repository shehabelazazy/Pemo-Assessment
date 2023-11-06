package StepDefinition;

import Pages.ArchivePageLogic;
import Pages.InvoiceDetailsLogic;
import Utilities.BaseTest;
import io.cucumber.java.en.Then;

public class InvoiceDetails {

    InvoiceDetailsLogic invoiceDetails=new InvoiceDetailsLogic(BaseTest.getDriver());
    ArchivePageLogic archive = new ArchivePageLogic(BaseTest.getDriver());

    @Then("The entered {string} should be appearing")
    public void theEnteredShouldBeAppearing(String arg0) {
    }

    @Then("The entered {string} should be appearing  {string} {string}")
    public void theEnteredShouldBeAppearing(String arg0, String arg1, String arg2) {
        archive.openInvoice(arg1,arg2);
        invoiceDetails.validateRejectionMessageAppears(arg0);
    }
}
