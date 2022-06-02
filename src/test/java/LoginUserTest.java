import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.RecoveryPasswordPage;
import PageObjects.RegistrationPage;
import groovy.util.logging.Log4j;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static junit.framework.TestCase.assertTrue;

public class LoginUserTest {

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @Test
    @DisplayName("login from main page")
    public void loginFromMain() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccount();
        LoginPage loginPage = open(LoginPage.URL_OPEN, LoginPage.class);
        loginPage.fillEmail("timokhina_marya@mail.ru");
        loginPage.fillPassword("11111111");
        loginPage.clickLoginAccount();
        assertTrue(mainPage.checkOrderButton());

    }

    @Test
    @DisplayName("login from header")
    public void loginFromHeader() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccountHeader();
        LoginPage loginPage = open(LoginPage.URL_OPEN, LoginPage.class);
        loginPage.fillEmail("timokhina_marya@mail.ru");
        loginPage.fillPassword("11111111");
        loginPage.clickLoginAccount();
        assertTrue(mainPage.checkOrderButton());

    }

    @Test
    @DisplayName("login from registration button")
    public void loginFromRegistration() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccount();

        LoginPage loginPage = open(LoginPage.URL_OPEN, LoginPage.class);
        loginPage.clickRegistrationLink();

        RegistrationPage registrationPage = open(RegistrationPage.URL_OPEN, RegistrationPage.class);
        registrationPage.clickLoginFromRegistration();

        loginPage.fillEmail("timokhina_marya@mail.ru");
        loginPage.fillPassword("11111111");
        loginPage.clickLoginAccount();
        assertTrue(mainPage.checkOrderButton());

    }

    @Test
    @DisplayName("login from recovery password")
    public void loginFromRecoveryPassword() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccount();

        LoginPage loginPage = open(LoginPage.URL_OPEN, LoginPage.class);
        loginPage.clickRecoveryPasswordButton();

        RecoveryPasswordPage recoveryPasswordPage = open(RecoveryPasswordPage.URL_OPEN, RecoveryPasswordPage.class);
        recoveryPasswordPage.clickLoginFromRecoveryPassword();

        loginPage.fillEmail("timokhina_marya@mail.ru");
        loginPage.fillPassword("11111111");
        loginPage.clickLoginAccount();
        assertTrue(mainPage.checkOrderButton());

    }

}
