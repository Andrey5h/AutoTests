import org.junit.Test;
import pages.MainPage;
import pages.SPpage;
import pages.SendAppPage;

public class MyRafactoringTest extends BaseTest {

    @Test
    public void newAutoTest() throws InterruptedException {
        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Застраховать себя");
        mainPage.waitVisibilityOfelement();
        mainPage.selectSubMenu("Страхование путешественников");
        Thread.sleep(1000);

        SPpage sPpage = new SPpage(driver);
        sPpage.sendButton.click();
        Thread.sleep(1000);
        sPpage.switchWindows();
        Thread.sleep(1000);
        sPpage.waitElementToBeClickable();
        Thread.sleep(1000);
        sPpage.clickButton();
        Thread.sleep(10000);

        SendAppPage sendAppPage = new SendAppPage(driver);

        sendAppPage.fillField("Фамилия", "Иванов");
        sendAppPage.fillField("Имя", "Иван");
        sendAppPage.fillField("Отчество", "Иванович");
        sendAppPage.fillField("Фамилия2", "Ivanov");
        sendAppPage.fillField("Имя2", "Ivan");
        sendAppPage.fillField("Дата рождения", "10.10.1989");
        sendAppPage.fillField("Дата рождения2", "10.10.1989");
        Thread.sleep(1000);
        sendAppPage.sendButton.click();
        Thread.sleep(10000);

    }

}
