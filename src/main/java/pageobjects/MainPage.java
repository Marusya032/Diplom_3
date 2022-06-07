package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    public static final String URL_OPEN = "https://stellarburgers.nomoreparties.site/";

    // кнопка Войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginAccount;

    // кнопка Личный кабинет
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement loginAccountHeader;

    // кнопка "Оформить заказ"
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    // кнопка Конструктор
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    //  иконка Лого
    @FindBy(how = How.CSS,  using = "header>nav>div>a")
    private SelenideElement logoIcon;

    public LoginPage clickLoginAccount(){
        loginAccount.click();
        return page(LoginPage.class);
    }

    public LoginPage clickLoginAccountHeader(){
        loginAccountHeader.click();
        return page(LoginPage.class);
    }

    public void clickCreateOrderButton(){
        createOrderButton.click();
    }

    public boolean checkOrderButton() {
    return createOrderButton.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed();
    }

    public void clickConstructorButton(){
        constructorButton.click();
    }

    public void clickLogoButton(){
        logoIcon.click();
    }
}

