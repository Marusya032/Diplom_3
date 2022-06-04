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


//    public  void registrationNewAccount(){
//      // UserData userData = new UserData();
//
//
//
//        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
//        mainPage.clickLoginAccount();
//
//        LoginPage loginPage = open(LoginPage.URL_OPEN, LoginPage.class);
//        loginPage.clickRegistrationLink();
//
//        RegistrationPage registrationPage = open(RegistrationPage.URL_OPEN, RegistrationPage.class);
//
//        registrationPage.fillName(user.getName());
//        registrationPage.fillEmail(user.getEmail());
//        registrationPage.fillPassword(user.getPassword());
//        registrationPage.clickRegistrationButton();


//    }

//    //локатор поля "Имя"
//    @FindBy(how = How.CSS, using = "fieldset:nth-child(1) > div > div > input")
//    private SelenideElement nameField;
//
//    //локатор поля "Email"
//    @FindBy(how = How.CSS, using = "fieldset:nth-child(2) > div > div > input")
//    private SelenideElement emailField;
//
//    //локатор поля "Пароль"
//    @FindBy(how = How.CSS, using = "fieldset:nth-child(3) > div > div > input")
//    private SelenideElement passwordField;
//
//    //локатор лейбла "Ошибка при вводе пароля"
//    @FindBy(how = How.CSS, using = "fieldset:nth-child(3) > div > p")
//    private SelenideElement passwordError;
//
//    //локатор кнопки "Зарегистрироваться"
//    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
//    private SelenideElement registrationButton;
//
//    //локатор кнопки "Войти"
//    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
//    private SelenideElement loginButton;
//
//    public RegistrationPage setNameRegPage(String name) {
//        this.nameField.sendKeys(name);
//        return this;
//    }
//
//    public RegistrationPage setEmailRegPage(String email) {
//        this.emailField.sendKeys(email);
//        return this;
//    }
//
//    public RegistrationPage setPasswordRegPage(String password) {
//        this.passwordField.sendKeys(password);
//        return this;
//    }
//
//        public LoginPage clickAccept() {
//        this.registrationButton.click();
//        return Selenide.page(LoginPage.class);
//    }
//
//    public LoginPage clickLoginRegPage() {
//        this.loginButton.click();
//        return Selenide.page(LoginPage.class);
//    }
//
//    public void registrationNewAccount(String email, String password) {
//        LoginPage loginPage = Selenide.open(RegistrationPage.URL_OPEN, RegistrationPage.class)
//                .setNameRegPage("Name")
//                .setEmailRegPage(email)
//                .setPasswordRegPage(password)
//                .clickAccept();
//    }
}
