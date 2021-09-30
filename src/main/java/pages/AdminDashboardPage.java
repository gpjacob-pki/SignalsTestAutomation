package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPage {


        private WebDriver driver;

        private By usersBtn              = By.xpath("//a[@id='Users']");
        private By attributeBtn          = By.xpath("//a[@id='metadata']");
        private By systemObjBtn          = By.xpath("//a[@id='systemObject']");


        public AdminDashboardPage(WebDriver driver){
            this.driver = driver;
        }

        public void selectUsersTab(){

            driver.findElement(usersBtn).click();
        }

        public void selectAttributesTab(){

            driver.findElement(attributeBtn).click();

        }

        public void selectSystemObjectTab(){

            driver.findElement(systemObjBtn).click();
        }


}
