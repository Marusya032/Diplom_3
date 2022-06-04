import Client.StellarBurgersClient;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.RecoveryPasswordPage;
import PageObjects.RegistrationPage;
import User.User;
import com.codeborne.selenide.Driver;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static junit.framework.TestCase.assertTrue;

public class LoginUserTest {
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
        stellarBurgersClient.createNewUser(user);
    }

    @After
    public void tearDown() {
        webdriver().driver().close();
        if (authorization != null) {
            stellarBurgersClient.deleteUser(authorization);
        }
    }

    @Test
    @DisplayName("login from main page")
    public void loginFromMain() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLogin();
        assertTrue("Не найдена кнопка оформления заказа", mainPage.checkOrderButton());

        authorization = stellarBurgersClient.loginUser(user).extract().body().path("accessToken");
    }

    @Test
    @DisplayName("login from header")
    public void loginFromHeader() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccountHeader();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLogin();
        assertTrue("Не найдена кнопка оформления заказа", mainPage.checkOrderButton());

        authorization = stellarBurgersClient.loginUser(user).extract().body().path("accessToken");
    }

    @Test
    @DisplayName("login from registration button")
    public void loginFromRegistration() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationLink();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.clickLoginFromRegistration();
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLogin();
        assertTrue("Не найдена кнопка оформления заказа", mainPage.checkOrderButton());

        authorization = stellarBurgersClient.loginUser(user).extract().body().path("accessToken");
    }

    @Test
    @DisplayName("login from recovery password")
    public void loginFromRecoveryPassword() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRecoveryPasswordButton();
        RecoveryPasswordPage recoveryPasswordPage = page(RecoveryPasswordPage.class);
        recoveryPasswordPage.clickLoginFromRecoveryPassword();
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLogin();
        assertTrue("Не найдена кнопка оформления заказа", mainPage.checkOrderButton());

        authorization = stellarBurgersClient.loginUser(user).extract().body().path("accessToken");
    }
}
