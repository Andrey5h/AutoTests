/**
 * @author Andrey Strelnikov
 * First AutoTest
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends BasePage{



    @FindBy (xpath = "//div[contains(@class,'bp-area header-container')]")
    WebElement mainMenu;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectMainMenu(String menuItem){
        mainMenu.findElement(By.xpath(".//span[contains(text(),'"+menuItem+"')]")).click();

    }
    public void selectSubMenu(String menuItem){
        mainMenu.findElement(By.xpath(".//a[contains(text(),'"+menuItem+"')]")).click();
    }

    public void waitVisibilityOfelement(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//div[contains(@class,'bp-area header-container')]//a[contains(text(),'Страхование путешественников')]"))));
    }
}
