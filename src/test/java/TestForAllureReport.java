/**
 * @author Andrey Strelnikov
 * First AutoTest
 */

import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.MainSteps;
import steps.SPSteps;
import steps.SendAppSteps;
import java.util.HashMap;

public class TestForAllureReport extends BaseSteps {

    @Test
    @Title("Страхование путешественников")
    public void testTravelInsurance() throws InterruptedException {
        driver.get(baseUrl);
        MainSteps mainSteps = new MainSteps();
        SPSteps spSteps = new SPSteps();
        SendAppSteps sendAppSteps = new SendAppSteps();

        HashMap<String, String> testDate = new HashMap<>();
        testDate.put("Фамилия", "Иванов");
        testDate.put("Имя", "Иван");
        testDate.put("Отчество", "Иванович");
        testDate.put("Фамилия2", "Ivanov");
        testDate.put("Имя2", "Ivan");
        testDate.put("Дата рождения", "01.01.1990");
        testDate.put("Дата рождения2", "01.01.1990");

        mainSteps.stepSelectMainMenu("Застраховать себя");
        mainSteps.stepSelectSubMenu("Страхование путешественников");

        spSteps.checkText();
        spSteps.stepSendAppButton();
        spSteps.switchWindow();
        spSteps.clickMinSum();
        spSteps.clickButtonNext();
        sendAppSteps.stepFillFields(testDate);
        sendAppSteps.stepCheckFields();
        sendAppSteps.stepClickButton();
        sendAppSteps.stepCheckError();
    }
}
