package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;
import java.util.Random;

public class NewExperimentPage {

    private  WebDriver driver;

    private By expTemplate          = By.xpath("//input[@id='template-auto']");
    private By expDesc              = By.xpath("//input[@id='description-input']");
    private By expNotebook          = By.xpath("//input[@id='notebook-auto']");
    private By expNotebookSelct     = By.xpath("//a[@id='select-notebook-item-0']");
    private By templateClose        = By.xpath("//button[@class='close rbt-close']");
    private By expDate              = By.xpath("//div[@class='date-time-input']/div/input");
    private By expOrg               = By.xpath("");
    private By expSubmit            = By.xpath("//button[@id='create-btn']");
    private By expName              = By.xpath("//input[@id='name-input']");


    public NewExperimentPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterExpDescription(){

        driver.findElement(expDesc).sendKeys("Experiment created through Automation");

    }

    public void enterExpName(){

        Date d = new Date();
        Random random = new Random();
        int num = random.nextInt(90) + 10;
        String name = d.toString().replace(":","").replace(" ","");
        String expeName = "automationexperiment"+name+num;
        driver.findElement(expName).sendKeys(expeName);

    }

    public void enterTemplate(String template){

        //Checking whether any default value is present in the field
        String templateValue = driver.findElement(expTemplate).getAttribute("value");
        System.out.println("The value is"+templateValue);
        //Entering the value fetched from feature file to the field and navigating to another field to confirm
        if(!templateValue.isEmpty())
        {
            driver.findElement(templateClose).click();
            driver.findElement(expTemplate).sendKeys(template);
            driver.findElement(expNotebook).click();
        }

    }


    public void enterExpNotebook(String noteBookName){


        try {
            //Checking whether any default value is present in the field
            String notebookValue = driver.findElement(expNotebook).getAttribute("value");
            System.out.println("The value is" + notebookValue);
            //Entering the value fetched from feature file to the field and navigating to another field to confirm
            if (notebookValue.isEmpty()) {
                driver.findElement(expNotebook).sendKeys(noteBookName);
                driver.findElement(expNotebookSelct).click();
            }
        }catch (Exception e){
            System.out.println("Unable to enter the notebook value ");

        }

    }



    public void createNewExperiment(){

        driver.findElement(expSubmit).click();

    }
}
