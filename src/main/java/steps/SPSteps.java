/**
 * @author Andrey Strelnikov
 * First AutoTest
 */

package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SPpage;
import ru.yandex.qatools.allure.annotations.Step;

public class SPSteps extends BaseSteps {

    @Step ("Выполнена проверка текстовки Страхование путешественников на странице SP")
    public void checkText (){
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='sbrf-rich-outer']")).getText().contains("Страхование путешественников"));
    }


    @Step("Выполнено нажатие на кнопку - оформить онлайн")
    public void stepSendAppButton() {
        new SPpage(driver).sendButton.click();
    }

    @Step("Выполнен переход на страницу выбора полиса")
    public void switchWindow() {
        for (String winHandle : driver.getWindowHandles()) {

            driver.switchTo().window(winHandle);
        }
    }
    @Step ("Выполнено нажатие на поле 'выберите сумму страховой защиты' - Минимальная")
    public void clickMinSum(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//*[contains(text(),\"Минимальная\")]")))).click();
    }

    @Step ("Выполнено нажатие на кнопку Продолжить")
    public void clickButtonNext(){
        driver.findElement(By.xpath("//SPAN[@ng-click='save()'][text()='Оформить']")).click();
    }

}
