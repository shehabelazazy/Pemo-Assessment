package StepDefinition;

import Pages.ArchivePageLogic;
import Utilities.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Archive {

    ArchivePageLogic archive = new ArchivePageLogic(BaseTest.getDriver());


    @And("Invoice {string} record should appear in the archive page under rejected tab in the First Row and Status should be {string}")
    public void invoiceRecordShouldAppearInTheArchivePageUnderRejectedTabInTheFirstRowAndStatusShouldBe(String arg0, String arg1) {

        archive.ValidateInvoiceDisplayedWithStatusRejected(arg0, arg1);
    }

    @Then("Number besides the Rejected tab and the Number in the Footer and number of Records should be matched")
    public void numberBesidesTheRejectedTabAndTheNumberInTheFooterAndNumberOfRecordsShouldBeMatched() {
        archive.validateAllMatched();
    }



    @And("Submitted by column should contains Uploader First Name + Last Name {string}")
    public void submittedByColumnShouldContainsUploaderFirstNameLastName(String arg0) {
        archive.CheckSubmittedByEqualUsername(arg0);
    }
}
