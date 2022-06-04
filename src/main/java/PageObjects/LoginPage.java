package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class LoginPage {

    public static final String URL_OPEN = "https://stellarburgers.nomoreparties.site/login";

    // Поле Email
    @FindBy(how = How.CSS, using = "fieldset:nth-child(1) > div > div > input")
    private SelenideElement emailField;

    // Поле Пароль
    @FindBy(how = How.CSS, using = "fieldset:nth-child(2) > div > div > input")
    private SelenideElement passwordField;

    // кнопка Войти
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;

    // кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement registrationLink;

    // кнопка Восстановить пароль
    @FindBy(how = How.XPATH, using = ".//a[text()='Восстановить пароль']")
    private SelenideElement recoveryPasswordButton;

    // заголовок раздела Вход
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement headerLogin;

    public String fillName(String name){
        emailField.setValue(name);
        return name;
    }

    public String fillEmail(String email){
        emailField.setValue(email);
        return email;
    }

    public String fillPassword(String password){
       passwordField.setValue(password);
        return password;
    }

    public void clickLogin(){
        loginButton.click();
            }

    public void clickRegistrationLink(){
        registrationLink.click();
    }

    public void clickRecoveryPasswordButton(){
        recoveryPasswordButton.click();
    }

    public boolean checkHeaderLogin() {
        return headerLogin.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed();
    }
}
