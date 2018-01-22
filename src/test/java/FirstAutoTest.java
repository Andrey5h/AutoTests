/**
 * @author Andrey Strelnikov
 * First AutoTest
 */

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstAutoTest extends BaseTest {

    @Test
    @Ignore
    public void firstTest() throws InterruptedException {
        System.out.println("Step 1: Переходим на сайте Сбербанка http://www.sberbank.ru/ru/person - Ок");
        driver.get(baseUrl);
        System.out.println("Step 2: Нажать на – Застраховать себя и имущество - Ок");
        driver.findElement(By.xpath("//*[@id='main']/div/div/table/tbody/tr/td/div/div/div/div/div/div[1]/div[1]/div[4]/div/div/div/ul/li[5]/a/span")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//div[contains(@class,'bp-area header-container')]//a[contains(text(),'Страхование путешественников')]"))));

        System.out.println("Step 3: Выбираем – Страхование путешественников - Ок");
        driver.findElement(By.xpath("//div[contains(@class,'bp-area header-container')]//a[contains(text(),'Страхование путешественников')]")).click();
        Thread.sleep(1000);
        System.out.println("Step 4: Проверяем наличие на странице заголовка – Страхование путешественников - Ок");
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='sbrf-rich-outer']")).getText().contains("Страхование путешественников"));
        Thread.sleep(1000);
        System.out.println("Step 5: Нажать на – Оформить Онлайн - Ок");
        driver.findElement(By.xpath("//a//img[contains(@src,'banner-zashita-traveler')]")).click();
        Thread.sleep(1000);

        for (String winHandle : driver.getWindowHandles()) {

            driver.switchTo().window(winHandle);
        }
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(text(),\"Минимальная\")]")))).click();
        System.out.println("Step 6: На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная - Ок");

        driver.findElement(By.xpath("//div[text()='Минимальная']")).click();
        Thread.sleep(1000);
        System.out.println("Step 7: Нажать Оформить - Ок");
        driver.findElement(By.xpath("//SPAN[@ng-click='save()'][text()='Оформить']")).click();
        Thread.sleep(1000);

        System.out.println("Step 8: На вкладке Оформить заполнить поля - Ок");
        driver.findElement(By.name("insured0_surname")).sendKeys("Ivanov");
        Thread.sleep(1000);
        driver.findElement(By.name("insured0_name")).sendKeys("Ivan");
        Thread.sleep(1000);
        driver.findElement(By.name("insured0_birthDate")).click();
        driver.findElement(By.name("insured0_birthDate")).sendKeys("01.01.1990");
        Thread.sleep(1000);
        driver.findElement(By.name("surname")).sendKeys("Иванов");
        Thread.sleep(1000);
        driver.findElement(By.name("middlename")).sendKeys("Иванович");
        Thread.sleep(1000);
        driver.findElement(By.name("name")).sendKeys("Иван");
        Thread.sleep(1000);
        driver.findElement(By.name("birthDate")).click();
        driver.findElement(By.name("birthDate")).sendKeys("01.01.1990");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[class='b-radio-field-entity ng-pristine ng-untouched ng-valid']")).click();
        Thread.sleep(1000);

        System.out.println("Step 9: Проверить, что все поля заполнены правильно - Ок");
        assertEquals("Ivanov", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        assertEquals("Ivan", driver.findElement(By.name("insured0_name")).getAttribute("value"));
        assertEquals("01.01.1990", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
        assertEquals("Иванов", driver.findElement(By.name("surname")).getAttribute("value"));
        assertEquals("Иванович", driver.findElement(By.name("middlename")).getAttribute("value"));
        assertEquals("Иван", driver.findElement(By.name("name")).getAttribute("value"));
        assertEquals("01.01.1990", driver.findElement(By.name("birthDate")).getAttribute("value"));

        System.out.println("Step 10: Нажать продолжить - Ок");
        driver.findElement(By.xpath("//SPAN[@ng-click='save()'][text()='Продолжить']")).click();
        Thread.sleep(1000);
        System.out.println("Step 11: Проверить, что появилось сообщение - Заполнены не все обязательные поля - Ок");
        assertEquals("Заполнены не все обязательные поля", driver.findElement(By.xpath("//DIV[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")).getText());
        System.out.println("Тест успешно пройден!");
    }

}
