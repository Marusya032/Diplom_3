import Client.StellarBurgersClient;
import Client.StellarBurgersRestClient;
import User.User;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static junit.framework.TestCase.assertTrue;

public class SiteNavigationTest {
    StellarBurgersClient stellarBurgersClient;
    User user;
    String authorization;

    @After
    public void tearDown() {
        webdriver().driver().close();
        if (authorization != null) {
            stellarBurgersClient.deleteUser(authorization);
        }
    }

    @Before
    public void setUp() {
        stellarBurgersClient = new StellarBurgersClient();
        user  = user.getRandom();
        authorization = stellarBurgersClient.createNewUser(user).extract().body().path("accessToken");

    }
    @Test
    @DisplayName("go to personal account with authorization")
    public void goToPersonalAccountWithAuthorization() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccount();
        LoginPage loginPage = open(LoginPage.URL_OPEN, LoginPage.class);
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLoginAccount();
        loginPage.clickLoginAccount();
        assertTrue(.checkOrderButton());

    }

    @Test
    @DisplayName("go to personal account without authorization")
    public void goToPersonalAccountWithoutAuthorization() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccountHeader();
        LoginPage loginPage = open(LoginPage.URL_OPEN, LoginPage.class);
        loginPage.fillEmail("timokhina_marya@mail.ru");
        loginPage.fillPassword("11111111");
        loginPage.clickLoginAccount();
        assertTrue(mainPage.checkOrderButton());

    }

    @Test
    @DisplayName("transition from personal account to constructor by the constructor button")
    public void transitionFromPersonalAccountToConstructorByConstructorButton() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccountHeader();
        LoginPage loginPage = open(LoginPage.URL_OPEN, LoginPage.class);
        loginPage.fillEmail("timokhina_marya@mail.ru");
        loginPage.fillPassword("11111111");
        loginPage.clickLoginAccount();
        assertTrue(mainPage.checkOrderButton());

    }

    @Test
    @DisplayName("transition from personal account to constructor by logo")
    public void transitionFromPersonalAccountToConstructorByLogo() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccountHeader();
        LoginPage loginPage = open(LoginPage.URL_OPEN, LoginPage.class);
        loginPage.fillEmail("timokhina_marya@mail.ru");
        loginPage.fillPassword("11111111");
        loginPage.clickLoginAccount();
        assertTrue(mainPage.checkOrderButton());

    }

    @Test
    @DisplayName("logout profile")
    public void logoutProfile() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccountHeader();
        LoginPage loginPage = open(LoginPage.URL_OPEN, LoginPage.class);
        loginPage.fillEmail("timokhina_marya@mail.ru");
        loginPage.fillPassword("11111111");
        loginPage.clickLoginAccount();
        assertTrue(mainPage.checkOrderButton());

    }


    @Test
    @DisplayName("go to the bun section ")
    public void goToTheBunSection() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccountHeader();
        LoginPage loginPage = open(LoginPage.URL_OPEN, LoginPage.class);
        loginPage.fillEmail("timokhina_marya@mail.ru");
        loginPage.fillPassword("11111111");
        loginPage.clickLoginAccount();
        assertTrue(mainPage.checkOrderButton());

    }

    @Test
    @DisplayName("go to the main section ")
    public void goToTheMainSection() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccountHeader();
        LoginPage loginPage = open(LoginPage.URL_OPEN, LoginPage.class);
        loginPage.fillEmail("timokhina_marya@mail.ru");
        loginPage.fillPassword("11111111");
        loginPage.clickLoginAccount();
        assertTrue(mainPage.checkOrderButton());

    }

    @Test
    @DisplayName("go to the sauce section ")
    public void goToTheSauceSection() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccountHeader();
        LoginPage loginPage = open(LoginPage.URL_OPEN, LoginPage.class);
        loginPage.fillEmail("timokhina_marya@mail.ru");
        loginPage.fillPassword("11111111");
        loginPage.clickLoginAccount();
        assertTrue(mainPage.checkOrderButton());

    }



}
