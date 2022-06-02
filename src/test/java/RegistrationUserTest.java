import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.RegistrationPage;
import User.User;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static junit.framework.TestCase.assertTrue;

public class RegistrationUserTest {


    @Test
    @DisplayName("success registration")
    public void successRegistration() {
        User user ;
        user = User.getRandom();


        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccount();

        LoginPage loginPage = open(LoginPage.URL_OPEN, LoginPage.class);
        loginPage.clickRegistrationLink();

        RegistrationPage registrationPage = open(RegistrationPage.URL_OPEN, RegistrationPage.class);

        registrationPage.fillName(user.getName());
        registrationPage.fillEmail(user.getEmail());
        registrationPage.fillPassword(user.getPassword());
        registrationPage.clickRegistrationButton();

        open(LoginPage.URL_OPEN);
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLoginAccount();
        assertTrue(mainPage.checkOrderButton());

    }

    @Test
    @DisplayName("registration with incorrect password")
    public void registrationWithIncorrectPassword() {
        User user ;

        user = User.getRandom();

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccount();

        LoginPage loginPage = open(LoginPage.URL_OPEN, LoginPage.class);
        loginPage.clickRegistrationLink();

        RegistrationPage registrationPage = open(RegistrationPage.URL_OPEN, RegistrationPage.class);

        registrationPage.fillName(user.getName());
        registrationPage.fillEmail(user.getEmail());
        registrationPage.fillPassword("111");
        registrationPage.clickRegistrationButton();

        assertTrue(registrationPage.isMessageIncorrectPassword() );

    }
}
