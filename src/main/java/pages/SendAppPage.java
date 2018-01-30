package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class SendAppPage extends BasePage {

    @FindBy(name = "insured0_surname")
    public
    WebElement insured_surname;

    @FindBy(name = "insured0_name")
    public
    WebElement insured_name;

    @FindBy(name = "insured0_birthDate")
    public
    WebElement insured_birthDate;

    @FindBy(name = "surname")
    public
    WebElement surname;

    @FindBy(name = "middlename")
    public
    WebElement middlename;

    @FindBy(name = "name")
    public
    WebElement name;

    @FindBy(name = "birthDate")
    public
    WebElement birthDate;

    @FindBy (xpath = "//SPAN[@ng-click='save()'][text()='Продолжить']")
    public WebElement sendButton;

    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия":
                fillField(surname, value);
                break;
            case  "Имя":
                fillField(name, value);
                break;
            case  "Отчество":
                fillField(middlename, value);
                break;
            case  "Фамилия2":
                fillField(insured_surname, value);
                break;
            case  "Имя2":
                fillField(insured_name, value);
                break;
            case  "Дата рождения":
                fillField(insured_birthDate, value);
                break;
            case  "Дата рождения2":
                fillField(birthDate, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }
    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Фамилия":
                return surname.getAttribute("value");
            case  "Имя":
                return name.getAttribute("value");
            case  "Отчество":
                return middlename.getAttribute("value");
            case  "Фамилия2":
                return insured_surname.getAttribute("value");
            case  "Имя2":
                return insured_name.getAttribute("value");
            case  "Дата рождения":
                return insured_birthDate.getAttribute("value");
            case  "Дата рождения2":
                return birthDate.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }



    @FindBy (xpath = "//DIV[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")
    public WebElement checkMessageError;


}