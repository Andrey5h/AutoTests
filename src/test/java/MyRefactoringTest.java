import org.junit.Test;
import pages.MainPage;
import pages.SPpage;
import pages.SendAppPage;

public class MyRefactoringTest extends BaseTest {

    @Test
    public void newAutoTest() throws InterruptedException {
        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Застраховать себя");
        mainPage.waitVisibilityOfelement();
        mainPage.selectSubMenu("Страхование путешественников");

        SPpage sPpage = new SPpage(driver);
        sPpage.checkTitle();
        sPpage.sendButton.click();
        sPpage.switchWindows();
        sPpage.waitElementToBeClickable();
        sPpage.clickButton();

        SendAppPage sendAppPage = new SendAppPage(driver);

        sendAppPage.fillField("Фамилия", "Иванов");
        sendAppPage.fillField("Имя", "Иван");
        sendAppPage.fillField("Отчество", "Иванович");
        sendAppPage.fillField("Фамилия2", "Ivanov");
        sendAppPage.fillField("Имя2", "Ivan");
        sendAppPage.fillField("Дата рождения", "01.01.1990");
        sendAppPage.fillField("Дата рождения2", "01.01.1990");
        sendAppPage.checkFields();
        sendAppPage.sendButton.click();
        sendAppPage.checkError();

    }

}
