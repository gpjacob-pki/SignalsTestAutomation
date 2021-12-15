package com.signals.stepDefeniiton;

import com.driver.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import pages.DashboardPage;
import pages.LoginPage;

import java.io.IOException;

public class LoginTest {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private DashboardPage dashboardPage = new DashboardPage(DriverFactory.getDriver());

    @When("User open the signals notebook {string} URL")
    public void user_open_the_signals_notebook_url(String string) {

        String url = loginPage.getURL(string);
        DriverFactory.getDriver().get(url);
    }



    @When("User enters the username as {string}")
    public void user_enters_the_username_as(String string) {

      loginPage.enterUserName(string);

    }

    @When("User enters the password as {string}")
    public void user_enters_the_password_as(String string) {

        loginPage.enterPassword(string);
    }

    @Then("User logs into the signals notebook")
    public void loginToNotebook() throws InterruptedException {

        loginPage.clickOnLogin();

    }


    @And("User enters the username and password from datasheet")
    public void userEntersTheUsernameAndPasswordFromEmail() throws IOException, InvalidFormatException {

        loginPage.usernameAndPswdFromEmail();
    }


    @And("User enters the {string} and {string} from email")
    public void userEntersTheAndFromEmail(String arg0, String arg1) throws IOException, InvalidFormatException {

        loginPage.usernameAndPswdFromEmail();
    }

    @Then("User verifies the dashboard page in the Signals notebook")
    public void userVerifiesTheDashboardPageInTheSignalsNotebook() {

             loginPage.verifyDashboard();
    }

    @Then("User logs out of the application")
    public void userLogsOutOfTheApplication() {

        dashboardPage.logout();
    }
}