package PageObjects;

import User.User;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.open;


public class RegistrationPage {

    public static final String URL_OPEN = "https://stellarburgers.nomoreparties.site/register";

    // кнопка Войти
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginButton;

    // поле Имя
    @FindBy(how = How.CSS, using = "fieldset:nth-child(1) > div > div > input")
    private SelenideElement nameField;

    // поле Email
    @FindBy(how = How.CSS, using = "fieldset:nth-child(2) > div > div > input")
    private SelenideElement emailField;

    // поле Пароль
    @FindBy(how = How.CSS, using = "fieldset:nth-child(3) > div > div > input")
    private SelenideElement passwordField;

    // кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    // сообщение Некорректный пароль
    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    private SelenideElement incorrectPassword  ;

    public void clickLoginFromRegistration(){
        loginButton.click();
    }

    public void fillName(String name){
        nameField.setValue(name);

    }

    public void fillEmail(String email){
        emailField.setValue(email);

    }

    public void fillPassword(String password){
        passwordField.setValue(password);

    }

    public void clickRegistrationButton(){
        registrationButton.click();
    }

    public boolean messageIncorrectPassword(){

        return incorrectPassword.isDisplayed();
    }

}
