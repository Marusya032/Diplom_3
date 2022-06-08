//package pageobjects;
//
//import com.codeborne.selenide.SelenideElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
//
//import static com.codeborne.selenide.Selenide.open;
//import static com.codeborne.selenide.Selenide.page;
//
//
//public class RegistrationPage {
//
//    public static final String URL_OPEN = "https://stellarburgers.nomoreparties.site/register";
//
//    // кнопка Войти
//    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
//    private SelenideElement loginButton;
//
//    // поле Имя
//    @FindBy(how = How.CSS, using = "fieldset:nth-child(1) > div > div > input")
//    private SelenideElement nameField;
//
//    // поле Email
//    @FindBy(how = How.CSS, using = "fieldset:nth-child(2) > div > div > input")
//    private SelenideElement emailField;
//
//    // поле Пароль
//    @FindBy(how = How.CSS, using = "fieldset:nth-child(3) > div > div > input")
//    private SelenideElement passwordField;
//
//    // кнопка Зарегистрироваться
//    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
//    private SelenideElement registrationButton;
//
//    // сообщение Некорректный пароль
//    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
//    private SelenideElement incorrectPassword  ;
//
//    public LoginPage clickLoginFromRegistration(){
//        loginButton.click();
//        return page(LoginPage.class);
//    }
//
//    public RegistrationPage fillName(String name){
//        nameField.setValue(name);
//        return this;
//    }
//
//    public RegistrationPage fillEmail(String email){
//        emailField.setValue(email);
//        return this;
//    }
//
//    public RegistrationPage fillPassword(String password){
//        passwordField.setValue(password);
//        return this;
//    }
//
//    public LoginPage clickRegistrationButton(){
//        registrationButton.click();
//        return page(LoginPage.class);
//    }
//
//    public boolean messageIncorrectPassword(){
//
//        return incorrectPassword.isDisplayed();
//    }
//
//}


package pageobjects;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.*;

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

    public LoginPage clickLoginFromRegistration(){
        loginButton.click();
        return page(LoginPage.class);
    }

    public RegistrationPage fillName(String name){
        nameField.setValue(name);
        return this;
    }

    public RegistrationPage fillEmail(String email){
        emailField.setValue(email);
        return this;
    }

    public RegistrationPage fillPassword(String password){
        passwordField.setValue(password);
        return this;
    }

    public LoginPage clickRegistrationButton(){
        registrationButton.click();
        sleep(100);
        return page(LoginPage.class);
    }

    public RegistrationPage clickRegistrationButtonWithIncorrectData(){
        registrationButton.click();
        return page(RegistrationPage.class);
    }

    public boolean messageIncorrectPassword(){
        return incorrectPassword.isDisplayed();
    }

}
