package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;


public class MainPage {

    public static final String URL_OPEN = "https://stellarburgers.nomoreparties.site/";

    // кнопка Войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginAccount;

//    // кнопка Личный кабинет
//    @FindBy(how = How.CSS, using = "div>header>nav>a>p")
//    private SelenideElement loginAccountHeader;

    // кнопка Личный кабинет
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement loginAccountHeader;

//    //локатор кнопки "Оформить заказ"
//    @FindBy(how = How.CSS, using = "section.BurgerConstructor_basket__29Cd7.mt-25>div>button")
//    private SelenideElement createOrderButton;

    //локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    // кнопка Конструктор
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    //  иконка Лого
    @FindBy(how = How.CSS, using = "how = How.CSS, using = \"header>nav>div>a\"")
    private SelenideElement logoIcon;

    public void clickLoginAccount(){
        loginAccount.click();

    }

    public void clickLoginAccountHeader(){
        loginAccountHeader.click();

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

//
//    public LoginPage clickToLoginMainPage() {
//        this.loginAccount.click();
//        return Selenide.page(LoginPage.class);
//    }
//
//    public LoginPage clickToLoginFromHeader() {
//        this.loginAccountHeader.click();
//        return Selenide.page(LoginPage.class);
//    }
//
//    public ProfilePage clickToLoginFromHeaderAfterLogin() {
//        this.loginToAccountFromHeader.click();
//        return Selenide.page(ProfilePage.class);
//    }
//
//
    public void waitForLoadAfterLogin() {
        createOrderButton.shouldBe(Condition.visible, Duration.ofSeconds(8));
   }
}
