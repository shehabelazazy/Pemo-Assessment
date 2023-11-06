package StepDefinition;

import Pages.NavigationMenuLogic;
import Utilities.BaseTest;
import io.cucumber.java.en.Then;

public class NavigationMenu {

    NavigationMenuLogic nav = new NavigationMenuLogic(BaseTest.getDriver());

    @Then("Navigate to invoice page")
    public void navigateToInvoicePage() {
        nav.navigateToInvoicePage();

    }

    @Then("Navigate to archive page")
    public void navigateToArchivePage() {
        nav.navigateToArchivePage();
    }


}
