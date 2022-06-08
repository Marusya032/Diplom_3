//import client.StellarBurgersClient;
//import pageobjects.ConstructorPage;
//import pageobjects.ProfilePage;
//import user.User;
//import pageobjects.LoginPage;
//import pageobjects.MainPage;
//import io.qameta.allure.junit4.DisplayName;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.chrome.ChromeDriver;
//import static com.codeborne.selenide.Selenide.open;
//import static com.codeborne.selenide.Selenide.page;
//import static com.codeborne.selenide.Selenide.webdriver;
//import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
//import static junit.framework.TestCase.assertTrue;
//import static org.junit.Assert.assertEquals;
//
//public class SiteNavigationTest {
//    User user;
//    StellarBurgersClient stellarBurgersClient;
//    String authorization;
//    ChromeDriver driver;
//
//    @Before
//    public void setUp(){
//    //    System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
//    //    driver = new ChromeDriver();
//    //    setWebDriver(driver);
//
//        user = User.getRandom();
//        stellarBurgersClient = new StellarBurgersClient();
//        authorization = stellarBurgersClient.createNewUser(user).extract().body().path("accessToken");
//    }
//
//    @After
//    public void tearDown() {
//        webdriver().driver().close();
//        if (authorization != null) {
//            stellarBurgersClient.deleteUser(authorization);
//        }
//    }
//
//    @Test
//    @DisplayName("go to personal account with authorization")
//    public void goToPersonalAccountWithAuthorization() {
//
//        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
//        mainPage.clickLoginAccount();
//        LoginPage loginPage = page(LoginPage.class);
//        loginPage.fillEmail(user.getEmail());
//        loginPage.fillPassword(user.getPassword());
//        loginPage.clickLogin();
//        mainPage.clickLoginAccountHeader();
//        ProfilePage profilePage = page(ProfilePage.class);
//
//        assertTrue("Не открыта страница личного кабинета", profilePage.checkProfilePage());
//    }
//
//    @Test
//    @DisplayName("go to personal account without authorization")
//    public void goToPersonalAccountWithoutAuthorization() {
//
//        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
//        mainPage.clickLoginAccountHeader();
//        LoginPage loginPage = page(LoginPage.class);
//
//        assertTrue("Не открыта страница для входа", loginPage.checkHeaderLogin());
//    }
//
//    @Test
//    @DisplayName("transition from personal account to constructor by the constructor button")
//    public void transitionFromPersonalAccountToConstructorByConstructorButton() {
//
//        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
//        mainPage.clickLoginAccount();
//        LoginPage loginPage = page(LoginPage.class);
//        loginPage.fillEmail(user.getEmail());
//        loginPage.fillPassword(user.getPassword());
//        loginPage.clickLogin();
//        mainPage.clickLoginAccountHeader();
//        mainPage.clickConstructorButton();
//        ConstructorPage constructorPage = page(ConstructorPage.class);
//
//        assertTrue("Не открыта страница конструктора", constructorPage.checkMakeBurgerPage());
//    }
//
//    @Test
//    @DisplayName("transition from personal account to constructor by logo")
//    public void transitionFromPersonalAccountToConstructorByLogo() {
//
//        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
//        mainPage.clickLoginAccount();
//        LoginPage loginPage = page(LoginPage.class);
//        loginPage.fillEmail(user.getEmail());
//        loginPage.fillPassword(user.getPassword());
//        loginPage.clickLogin();
//        mainPage.clickLoginAccountHeader();
//        mainPage.clickLogoButton();
//        ConstructorPage constructorPage = page(ConstructorPage.class);
//
//        assertTrue("Не открыта страница конструктора", constructorPage.checkMakeBurgerPage());
//    }
//
//    @Test
//    @DisplayName("logout profile")
//    public void logoutProfile() {
//
//        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
//        mainPage.clickLoginAccount();
//        LoginPage loginPage = page(LoginPage.class);
//        loginPage.fillEmail(user.getEmail());
//        loginPage.fillPassword(user.getPassword());
//        loginPage.clickLogin();
//        mainPage.clickLoginAccountHeader();
//        ProfilePage profilePage = page(ProfilePage.class);
//        profilePage.clickExitButton();
//
//        assertTrue("Не открыта страница конструктора", loginPage.checkHeaderLogin());
//    }
//
//
//    @Test
//    @DisplayName("go to the bun section ")
//    public void goToTheBunSection() {
//
//        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
//        mainPage.clickLoginAccountHeader();
//        LoginPage loginPage = page(LoginPage.class);
//        loginPage.fillEmail(user.getEmail());
//        loginPage.fillPassword(user.getPassword());
//        loginPage.clickLogin();
//        ConstructorPage constructorPage = page(ConstructorPage.class);
//        constructorPage.clickMainButton();
//        constructorPage.clickBunButton();
//        assertEquals("Не открылся раздел с булками", "Булки", constructorPage.getTextClickedButton());
//    }
//
//    @Test
//    @DisplayName("go to the main section ")
//    public void goToTheMainSection() {
//
//        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
//        mainPage.clickLoginAccountHeader();
//        LoginPage loginPage = page(LoginPage.class);
//        loginPage.fillEmail(user.getEmail());
//        loginPage.fillPassword(user.getPassword());
//        loginPage.clickLogin();
//        ConstructorPage constructorPage = page(ConstructorPage.class);
//        constructorPage.clickMainButton();
//        assertEquals("Не открылся раздел с начинками", "Начинки", constructorPage.getTextClickedButton());
//       }
//
//    @Test
//    @DisplayName("go to the sauce section ")
//    public void goToTheSauceSection() {
//
//        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
//        mainPage.clickLoginAccountHeader();
//        LoginPage loginPage = page(LoginPage.class);
//        loginPage.fillEmail(user.getEmail());
//        loginPage.fillPassword(user.getPassword());
//        loginPage.clickLogin();
//        ConstructorPage constructorPage = page(ConstructorPage.class);
//        constructorPage.clickSauceButton();
//        assertEquals("Не открылся раздел с соусами", "Соусы", constructorPage.getTextClickedButton());
//    }
//}

import client.StellarBurgersClient;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.ProfilePage;
import user.User;
import pageobjects.LoginPage;
import pageobjects.MainPage;
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
import static org.junit.Assert.assertEquals;

public class SiteNavigationTest {
    User user;
    StellarBurgersClient stellarBurgersClient;
    String authorization;
    ChromeDriver driver;

    @Before
    public void setUp(){
//        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
//        driver = new ChromeDriver();
//        setWebDriver(driver);

        user = User.getRandom();
        stellarBurgersClient = new StellarBurgersClient();
        authorization = stellarBurgersClient.createNewUser(user).extract().body().path("accessToken");
    }

    @After
    public void tearDown() {
        webdriver().driver().close();
        if (authorization != null) {
            stellarBurgersClient.deleteUser(authorization);
        }
    }

    @Test
    @DisplayName("go to personal account with authorization")
    public void goToPersonalAccountWithAuthorization() {
        ProfilePage profilePage = open(MainPage.URL_OPEN, MainPage.class)
                .clickLoginAccount()
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLogin()
                .clickLoginHeaderAfterLogin();
        assertTrue("Не открыта страница личного кабинета", profilePage.checkProfilePage());
    }

    @Test
    @DisplayName("go to personal account without authorization")
    public void goToPersonalAccountWithoutAuthorization() {
        LoginPage loginPage = open(MainPage.URL_OPEN, MainPage.class)
                .clickLoginHeaderWithoutLogin();
        assertTrue("Не открыта страница для входа", loginPage.checkHeaderLogin());
    }

    @Test
    @DisplayName("transition from personal account to constructor by the constructor button")
    public void transitionFromPersonalAccountToConstructorByConstructorButton() {
        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class)
                .clickLoginAccount()
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLogin()
                .clickConstructorButton();
        assertTrue("Не открыта страница конструктора", mainPage.checkMakeBurgerPage());
    }

    @Test
    @DisplayName("transition from personal account to constructor by logo")
    public void transitionFromPersonalAccountToConstructorByLogo() {
        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class)
                .clickLoginAccount()
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLogin()
                .clickLogoButton();
        assertTrue("Не открыта страница конструктора", mainPage.checkMakeBurgerPage());
    }

    @Test
    @DisplayName("logout profile")
    public void logoutProfile() {
        LoginPage loginPage = open(MainPage.URL_OPEN, MainPage.class)
                .clickLoginAccount()
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLogin()
                .clickLoginHeaderAfterLogin()
                .clickExitButton();
        assertTrue("Не открыта страница конструктора", loginPage.checkHeaderLogin());
    }

    @Test
    @DisplayName("go to the bun section ")
    public void goToTheBunSection() {
        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class)
                .clickLoginAccountHeader()
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLogin()
                .clickMainButton()
                .clickBunButton();
        assertEquals("Не открылся раздел с булками", "Булки", mainPage.getTextClickedButton());
    }

    @Test
    @DisplayName("go to the main section ")
    public void goToTheMainSection() {
        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class)
                .clickLoginAccountHeader()
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLogin()
                .clickMainButton();
        assertEquals("Не открылся раздел с начинками", "Начинки", mainPage.getTextClickedButton());
    }

    @Test
    @DisplayName("go to the sauce section ")
    public void goToTheSauceSection() {
        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class)
                .clickLoginAccountHeader()
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLogin()
                .clickSauceButton();
        assertEquals("Не открылся раздел с соусами", "Соусы", mainPage.getTextClickedButton());
    }
}
