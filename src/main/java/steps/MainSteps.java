/**
 * @author Andrey Strelnikov
 * First AutoTest
 */

package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps{

    @Step("Выбран пунк меню {0}")
    public void stepSelectMainMenu(String menuItem){
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu(menuItem);
    }

    @Step("Выбран пунк меню {0}]")
    public void stepSelectSubMenu(String menuItem){
        MainPage mainPage = new MainPage(driver);
        mainPage.waitVisibilityOfelement();
        mainPage.selectSubMenu(menuItem);
    }
}
