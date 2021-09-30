package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;

    private By addNewBtn              = By.xpath("//span[text()='Add New']");
    private By addNewNotebook         = By.xpath("//a[@id='new-journal']");
    private By addNewExp              = By.xpath("//a[@id='new-experiment']");
    private By expIcon                = By.xpath("//a[@id='experiments']");
    private By profile                = By.xpath("//button[@id='profile-dropdown']");
    private By signOut                = By.xpath("//a[@id='logout']");
    private By sytmConfig             = By.xpath("//a[text()='System Configuration']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addNewExperiment(){

        driver.findElement(addNewBtn).click();
        driver.findElement(addNewExp).click();

    }

    public void addNewNotebook(){

        driver.findElement(addNewBtn).click();
        driver.findElement(addNewNotebook).click();

    }


    public void selectExperiementicon(){

        driver.findElement(expIcon).click();
    }

    public void logout(){

        driver.findElement(profile).click();
        driver.findElement(signOut).click();
    }

    public void selectSystmConfig(){

        driver.findElement(profile).click();
        driver.findElement(sytmConfig).click();
    }



}
