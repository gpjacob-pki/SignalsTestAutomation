package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExperimentPage {

    private WebDriver driver;

    private By signingBtn          = By.xpath("//button[text()='Signing']");

    public ExperimentPage(WebDriver driver){
        this.driver = driver;
    }


    public void signBtnSelection(){

        driver.findElement(signingBtn).click();
        System.out.println("Signing completed");
    }


}
