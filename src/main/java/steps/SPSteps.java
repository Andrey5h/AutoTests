package steps;

import pages.SPpage;
import ru.yandex.qatools.allure.annotations.Step;

public class SPSteps extends BaseSteps {

    @Step("Выполнено нажатие на кнопку - оформить онлайн")
    public void stepSendAppButton(){
        new SPpage(driver).sendButton.click();
    }
}
