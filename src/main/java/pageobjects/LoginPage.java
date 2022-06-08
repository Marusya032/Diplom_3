package pageobjects;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.page;

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

    public LoginPage fillEmail(String email){
        emailField.shouldBe(Condition.visible, Duration.ofSeconds(28));
        this.emailField.setValue(email);
        return this;
    }

    public LoginPage fillPassword(String password){
        emailField.shouldBe(Condition.visible, Duration.ofSeconds(8));
        this.passwordField.setValue(password);
        return this;
    }

    public MainPage clickLogin(){
        loginButton.click();
        return page(MainPage.class);
    }

    public boolean checkLoginButton() {
        return loginButton.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed();
    }

    public RegistrationPage clickRegistrationLink(){
        registrationLink.click();
        return page(RegistrationPage.class);
    }

    public RecoveryPasswordPage clickRecoveryPasswordButton(){
        recoveryPasswordButton.click();
        return page(RecoveryPasswordPage.class);
    }

    public boolean checkHeaderLogin() {
        return headerLogin.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed();
    }
}
