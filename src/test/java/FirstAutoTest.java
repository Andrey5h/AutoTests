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

public class FirstAutoTest {
    private WebDriver driver;


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");

        driver = new ChromeDriver();
        System.out.println("Step 1: Переходим на сайте Сбербанка http://www.sberbank.ru/ru/person - Ок");
        driver.get("http://www.sberbank.ru/ru/person");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void firstTest() throws InterruptedException {
        System.out.println("Step 2: Нажать на – Застраховать себя и имущество - Ок");
        driver.findElement(By.xpath("//*[@id='main']/div/div/table/tbody/tr/td/div/div/div/div/div/div[1]/div[1]/div[4]/div/div/div/ul/li[5]/a/span")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath(".//*[@id='main']/div/div/table/tbody/tr/td/div/div/div/div/div/div[1]/div[1]/div[4]/div/div/div/ul/li[5]/div/div/div[2]/div/a"))));

        System.out.println("Step 3: Выбираем – Страхование путешественников - Ок");
        driver.findElement(By.xpath(".//*[@id='main']/div/div/table/tbody/tr/td/div/div/div/div/div/div[1]/div[1]/div[4]/div/div/div/ul/li[5]/div/div/div[2]/div/a")).click();
        Thread.sleep(1000);
        System.out.println("Step 4: Проверяем наличие на странице заголовка – Страхование путешественников - Ок");
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='sbrf-rich-outer']")).getText().contains("Страхование путешественников"));
        Thread.sleep(1000);
        System.out.println("Step 5: Нажать на – Оформить Онлайн - Ок");
        driver.findElement(By.cssSelector("img[src='/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53']")).click();
        Thread.sleep(1000);

        for (String winHamdle : driver.getWindowHandles()) {

            driver.switchTo().window(winHamdle);
        }
        Thread.sleep(3000);
        driver.get("https://online.sberbankins.ru/store/vzr/index.html#/viewCalc");
        Thread.sleep(3000);
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
        driver.findElement(By.name("insured0_birthDate")).sendKeys("01.01.1990");
        Thread.sleep(1000);
        driver.findElement(By.name("surname")).sendKeys("Иванов");
        Thread.sleep(1000);
        driver.findElement(By.name("middlename")).sendKeys("Иванович");
        Thread.sleep(1000);
        driver.findElement(By.name("name")).sendKeys("Иван");
        Thread.sleep(1000);
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

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
