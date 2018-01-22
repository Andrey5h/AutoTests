package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SPpage extends BasePage {

    @FindBy (xpath = "//a//img[contains(@src,'banner-zashita-traveler')]")

    public WebElement sendButton;


    public SPpage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void switchWindows(){
        for (String winHandle : driver.getWindowHandles()) {

            driver.switchTo().window(winHandle);
        }
    }
    public void waitElementToBeClickable(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//*[contains(text(),\"Минимальная\")]")))).click();
    }

    public void clickButton(){
        driver.findElement(By.xpath("//SPAN[@ng-click='save()'][text()='Оформить']")).click();
    }

}