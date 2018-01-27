package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps{

    @Step("Выбиран пунк меню")
    public void stepSelectMainMenu(String menuItem){
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu(menuItem);
    }

    @Step("Выбиран пунк меню Страхование путешественников")
    public void stepSelectSubMenu(String menuItem){
        MainPage mainPage = new MainPage(driver);
        mainPage.selectSubMenu(menuItem);
    }
}
