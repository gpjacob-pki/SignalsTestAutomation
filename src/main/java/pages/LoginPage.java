package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ConfigReader;

import java.util.ArrayList;
import java.util.Properties;


public class LoginPage {

    private WebDriver driver;

    private By emailId = By.xpath("//input[@name='username']");
    private By passWord = By.xpath("//input[@name='password']");
    private By loginBtn = By.xpath("//button[@class='uk-button uk-button-primary']");
    private By dashboardBtn = By.xpath("//i[@class='icon icon-dashboard icon-lg']");
    private By loginError   = By.xpath("//p[@class='error']");
    private By accessDenied = By.xpath("//span[text()='Access Denied']");
    private By dismissBtn   = By.xpath("//button[text()='Dismiss']");

    private ConfigReader configReader;
    Properties prop;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getURL(String env){
        configReader = new ConfigReader();
        prop = configReader.init_prop();

        if(prop.getProperty("runOn").equalsIgnoreCase("jenkins")){
            return (System.getProperty("environment"));
        }
        else if(prop.getProperty("runOn").equalsIgnoreCase("local")) {
            if (env.equalsIgnoreCase("training")) {
                return (prop.getProperty("trainingURL"));
            } else if (env.equalsIgnoreCase("Staging")) {
                return (prop.getProperty("stagingURL"));
            } else if (env.equalsIgnoreCase("Production")) {
                return (prop.getProperty("prodURL"));
            } else if (env.equalsIgnoreCase("Original")) {
                return (prop.getProperty("originalURL"));
            } else if (env.equalsIgnoreCase("Sandbox sub URL")) {
                return (prop.getProperty("SubURL"));
            }
        }
        return "Enter proper Environment";
    }
    public void enterUserName(String userGroup) {

        configReader = new ConfigReader();
        prop = configReader.init_prop();

        if(prop.getProperty("runOn").equalsIgnoreCase("jenkins")){
            driver.findElement(emailId).sendKeys(System.getProperty("username"));
        }
        else if(prop.getProperty("runOn").equalsIgnoreCase("local")) {
            if (userGroup.equalsIgnoreCase("user1")) {
                driver.findElement(emailId).sendKeys(prop.getProperty("username1"));
            } else if (userGroup.equalsIgnoreCase("Power")) {
                driver.findElement(emailId).sendKeys(prop.getProperty("powerUser"));
            } else if (userGroup.equalsIgnoreCase("Standard")) {
                driver.findElement(emailId).sendKeys(prop.getProperty("standardUser"));
            } else if (userGroup.equalsIgnoreCase("CPS")) {
                driver.findElement(emailId).sendKeys(prop.getProperty("CPSUser"));
            } else if (userGroup.equalsIgnoreCase("Custom")) {
                driver.findElement(emailId).sendKeys(prop.getProperty("customUser"));
            } else if (userGroup.equalsIgnoreCase("Wrong")) {
                driver.findElement(emailId).sendKeys(prop.getProperty("WrongUser"));
            }
        }
    }

    public void enterPassword(String userGroup) {

        configReader = new ConfigReader();
        prop = configReader.init_prop();

        if(prop.getProperty("runOn").equalsIgnoreCase("jenkins")){
            driver.findElement(emailId).sendKeys(System.getProperty("password"));
        }
        else if(prop.getProperty("runOn").equalsIgnoreCase("local")) {
            if (userGroup.equalsIgnoreCase("user1")) {
                driver.findElement(passWord).sendKeys(prop.getProperty("user1Pswd"));
            } else if (userGroup.equalsIgnoreCase("Power")) {
                driver.findElement(passWord).sendKeys(prop.getProperty("password"));
            } else if (userGroup.equalsIgnoreCase("Standard")) {
                driver.findElement(passWord).sendKeys(prop.getProperty("password"));
            } else if (userGroup.equalsIgnoreCase("CPS")) {
                driver.findElement(passWord).sendKeys(prop.getProperty("password"));
            } else if (userGroup.equalsIgnoreCase("Custom")) {
                driver.findElement(passWord).sendKeys(prop.getProperty("custompassword"));
            } else if (userGroup.equalsIgnoreCase("Wrong")) {
                driver.findElement(passWord).sendKeys(prop.getProperty("WrongPassword"));
            }
        }
    }

    public void clickOnLogin() throws InterruptedException {

        driver.findElement(loginBtn).click();
        Thread.sleep(5000);
        if(driver.findElements(dismissBtn).size()>0){
            driver.findElement(dismissBtn).click();
        }
    }

    public boolean verifyDashboard() {

        boolean verifyDashboard = driver.findElement(dashboardBtn).isDisplayed();
        return verifyDashboard;
    }

    public void verifyDashboardwrongly() {

        String verifyText = driver.findElement(dashboardBtn).getText();
        Assert.assertTrue(verifyText.equalsIgnoreCase("Failure"));
    }

    public boolean verifyloginerror(){

        boolean flag = driver.findElement(loginError).isDisplayed();
        return flag;
    }

    public boolean verifyloginpage() {

        boolean flag = driver.findElement(emailId).isDisplayed();
        return flag;

    }

    public boolean verifyAccessDeniedPage() {

        boolean flag = driver.findElement(accessDenied).isDisplayed();
        return flag;

    }



    public void switchtab(){

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

    }


}
