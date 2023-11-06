package StepDefinition;

import Pages.LoginPageLogic;
import Utilities.BaseTest;
import io.cucumber.java.en.Given;

public class Login {

    LoginPageLogic lo = new LoginPageLogic(BaseTest.getDriver());


    @Given("Login using credentials {string} {string}")
    public void loginUsingCredentials() {
        lo.loginWithCredentials();
    }


    @Given("Login to the Application")
    public void loginToTheApplication() {
        lo.loginWithCredentials();
    }
}
