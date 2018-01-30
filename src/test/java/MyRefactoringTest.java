/**
 * @author Andrey Strelnikov
 * First AutoTest
 */


import org.junit.Ignore;
import org.junit.Test;
import pages.MainPage;
import pages.SPpage;
import pages.SendAppPage;
import steps.BaseSteps;

import static org.junit.Assert.assertEquals;

public class MyRefactoringTest extends BaseSteps {

    @Test
    @Ignore
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

        assertEquals("Иванов", sendAppPage.surname.getAttribute( "value" ));
        assertEquals( "Иван", sendAppPage.name.getAttribute( "value" ) );
        assertEquals( "Иванович", sendAppPage.middlename.getAttribute( "value" ) );
        assertEquals( "Ivanov", sendAppPage.insured_surname.getAttribute( "value" ) );
        assertEquals( "Ivan", sendAppPage.insured_name.getAttribute( "value" ) );
        assertEquals( "01.01.1990", sendAppPage.insured_birthDate.getAttribute( "value" ) );
        assertEquals( "01.01.1990", sendAppPage.birthDate.getAttribute( "value" ) );

        sendAppPage.sendButton.click();
        assertEquals("Заполнены не все обязательные поля", sendAppPage.checkMessageError.getText());

    }

}
