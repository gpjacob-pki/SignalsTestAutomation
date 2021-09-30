package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigningPage {

    private WebDriver driver;

    private By signAndCloseBtn          = By.xpath("//button[@id='CLOSE']");
    private By signAndAddReviwBtn       = By.xpath("//button[@id='SIGN_AND_ADD_REVIEWERS']");
    private By signAndKeepOpenBtn       = By.xpath("//button[@id='SIGN']");
    private By signingComment           = By.xpath("//textarea[@placeholder='Type comment…']");
    private By signingChkBox            = By.xpath("//label[@class='btn-checkbox']");
    private By signCloseConfirm         = By.xpath("//button[@id='action' and text()='Sign and Close']");
    private By signOpenConfirm          = By.xpath("//button[@id='action' and text()='Sign and Keep Open']");
    private By addReviewerTxtBox        = By.xpath("//input[@id='qa-add-reviewers']");

    public SigningPage(WebDriver driver){
        this.driver = driver;
    }

    public void signingExperiment(String signingType){

        if(signingType.equalsIgnoreCase("signandclose")){

            driver.findElement(signAndCloseBtn).click();
            driver.findElement(signingComment).sendKeys("Signing and closing the experiment for automation testing");
            driver.findElement(signingChkBox).click();
            driver.findElement(signCloseConfirm).click();
        }

        else if(signingType.equalsIgnoreCase("signandaddreviweres")){

            driver.findElement(signAndAddReviwBtn).click();
            driver.findElement(addReviewerTxtBox).sendKeys("");
            driver.findElement(signingComment).sendKeys("Added as reviewer for automation testing");
            driver.findElement(signingChkBox).click();

        }

        else if(signingType.equalsIgnoreCase("signandkeepopen")){

            driver.findElement(signAndKeepOpenBtn).click();
            driver.findElement(signingComment).sendKeys(" Signing and keeping as open experiment for automation testing");
            driver.findElement(signingChkBox).click();
            driver.findElement(signOpenConfirm).click();

        }
    }

    public void verifySigningMsg(){

        driver.getPageSource();
    }
}
