import Client.StellarBurgersClient;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.RegistrationPage;
import User.User;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static junit.framework.TestCase.assertTrue;

public class RegistrationUserTest {
    User user;
    StellarBurgersClient stellarBurgersClient;
    String authorization;
    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);

        user = User.getRandom();
        stellarBurgersClient = new StellarBurgersClient();
    }

    @After
    public void tearDown() {
        webdriver().driver().close();
        if (authorization != null) {
            stellarBurgersClient.deleteUser(authorization);
        }
}

    @Test
    @DisplayName("success registration")
    public void successRegistration() {
        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationLink();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.fillName(user.getName());
        registrationPage.fillEmail(user.getEmail());
        registrationPage.fillPassword(user.getPassword());
        registrationPage.clickRegistrationButton();
        open(LoginPage.URL_OPEN);
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLogin();
        assertTrue("Не найдена кнопка оформления заказа", mainPage.checkOrderButton());

        authorization = stellarBurgersClient.loginUser(user).extract().body().path("accessToken");

    }

    @Test
    @DisplayName("registration with incorrect password")
    public void registrationWithIncorrectPassword() {
        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationLink();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.fillName(user.getName());
        registrationPage.fillEmail(user.getEmail());
        registrationPage.fillPassword("111");
        registrationPage.clickRegistrationButton();

        assertTrue("Не найдено собщение об ошибке пароля", registrationPage.messageIncorrectPassword() );
    }
}
