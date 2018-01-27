package steps;

import pages.SendAppPage;
import ru.yandex.qatools.allure.annotations.Step;

public class SendAppSteps extends BaseSteps {

    @Step("Поле  заполняется значениями")
    public void stepFillField(){
        new SendAppPage(driver).checkFields();
    }
}
