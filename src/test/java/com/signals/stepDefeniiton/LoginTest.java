package com.signals.stepDefeniiton;

import com.driver.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import pages.LoginPage;

import java.io.IOException;

public class LoginTest {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

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


    @And("User enters the username and password from email")
    public void userEntersTheUsernameAndPasswordFromEmail() throws IOException, InvalidFormatException {

        loginPage.usernameAndPswdFromEmail();
    }


}