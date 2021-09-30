package com.signals.stepDefeniiton;

import com.driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import pages.*;

import java.io.IOException;

public class ExpSigning {

    private DashboardPage dashboardPage = new DashboardPage(DriverFactory.getDriver());
    private NewExperimentPage newExperimentPage = new NewExperimentPage(DriverFactory.getDriver());
    private ExperimentPage experimentPage = new ExperimentPage(DriverFactory.getDriver());
    private SigningPage signingPage = new SigningPage(DriverFactory.getDriver());
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());


    @And("User selects on the add new experiment button")
    public void userSelectsOnTheAddNewExperimentButton() {

         dashboardPage.addNewExperiment();

    }


    @And("User selects the template as {string} for the creation of experiment")
    public void userSelectsTheTemplateAsForTheCreationOfExperiment(String arg0) {

        newExperimentPage.enterTemplate(arg0);
    }


    @And("User enters the description for the creation of new Experiment")
    public void userEntersTheDescriptionForTheCreationOfNewExperiment() {

        newExperimentPage.enterExpDescription();
    }

    @And("User selects the notebook as {string} for the creation of experiment")
    public void userSelectsTheNotebookAsForTheCreationOfExperiment(String arg0) {

        newExperimentPage.enterExpNotebook(arg0);
    }


    @And("User clicks on the creation of experiment")
    public void userClicksOnTheCreationOfExperiment() throws InterruptedException {

        newExperimentPage.createNewExperiment();
        Thread.sleep(5000);
    }

    @And("User enters the name for the new Experiment")
    public void userEntersTheNameForTheNewExperiment() {

        newExperimentPage.enterExpName();

    }

    @Then("User selects on the signing button")
    public void userSelectsOnTheSigningButton() throws InterruptedException {

        experimentPage.signBtnSelection();
        Thread.sleep(5000);
    }


    @Then("User completes the sign in process according to the {string}")
    public void userCompletesTheSignInProcessAccordingToThe(String arg0) throws InterruptedException {

        signingPage.signingExperiment(arg0);
        Thread.sleep(9000);

    }

    @And("User enters the credentials and logs in the application")
    public void userEntersTheCredentialsAndLogsInTheApplication() throws IOException, InvalidFormatException, InterruptedException {

        loginPage.usernameAndPswdFromEmail();
        loginPage.clickOnLogin();

    }

    @Then("User verifies the signing completion message")
    public void userVerifiesTheSigningCompletionMessage() {

        signingPage.verifySigningMsg();
    }
}
