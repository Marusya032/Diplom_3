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

    // название раздела Соберите бургер
    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private SelenideElement makeBurger;

    // кнопка Булки
    @FindBy(how = How.CSS, using = "div:nth-child(2) > div:nth-child(1).noselect")
    private SelenideElement bunButton;

    // кнопка Соусы
    @FindBy(how = How.CSS, using = "div:nth-child(2) > div:nth-child(2).noselect")
    private SelenideElement sauceButton;

    // кнопка Начинки
    @FindBy(how = How.CSS, using = "div:nth-child(2) > div:nth-child(3).noselect")
    private SelenideElement mainButton;

    // нажатая кнопка раздела в конструкторе
    @FindBy(how = How.CSS, using = ".tab_tab_type_current__2BEPc")
    private SelenideElement clickedButton;

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

    public MainPage clickConstructorButton(){
        constructorButton.click();
        return this;
    }

    public MainPage clickLogoButton(){
        logoIcon.click();
        return this;
    }

    public ProfilePage clickLoginHeaderAfterLogin(){
        loginAccountHeader.click();
        return page(ProfilePage.class);
    }

    public LoginPage clickLoginHeaderWithoutLogin(){
        loginAccountHeader.click();
        return page(LoginPage.class);
    }

    public boolean checkMakeBurgerPage(){
        return makeBurger.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed();
    }

    public MainPage clickBunButton(){
        bunButton.click();
        return this;
    }

    public MainPage clickSauceButton(){
        sauceButton.click();
        return this;
    }

    public MainPage clickMainButton(){
        mainButton.click();
        return this;
    }

    public String getTextClickedButton() {
        return clickedButton.getText();
    }
}

