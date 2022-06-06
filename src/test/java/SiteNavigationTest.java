import Client.StellarBurgersClient;
import PageObjects.ConstructorPage;
import PageObjects.ProfilePage;
import User.User;
import PageObjects.LoginPage;
import PageObjects.MainPage;
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

public class SiteNavigationTest {
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

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLogin();
        mainPage.clickLoginAccountHeader();
        ProfilePage profilePage = page(ProfilePage.class);

        assertTrue("Не открыта страница личного кабинета", profilePage.checkProfilePage());
    }

    @Test
    @DisplayName("go to personal account without authorization")
    public void goToPersonalAccountWithoutAuthorization() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccountHeader();
        LoginPage loginPage = page(LoginPage.class);

        assertTrue("Не открыта страница для входа", loginPage.checkHeaderLogin());
    }

    @Test
    @DisplayName("transition from personal account to constructor by the constructor button")
    public void transitionFromPersonalAccountToConstructorByConstructorButton() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLogin();
        mainPage.clickLoginAccountHeader();
        mainPage.clickConstructorButton();
        ConstructorPage constructorPage = page(ConstructorPage.class);

        assertTrue("Не открыта страница конструктора", constructorPage.checkMakeBurgerPage());
    }

    @Test
    @DisplayName("transition from personal account to constructor by logo")
    public void transitionFromPersonalAccountToConstructorByLogo() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLogin();
        mainPage.clickLoginAccountHeader();
        mainPage.clickLogoButton();
        ConstructorPage constructorPage = page(ConstructorPage.class);

        assertTrue("Не открыта страница конструктора", constructorPage.checkMakeBurgerPage());
    }

    @Test
    @DisplayName("logout profile")
    public void logoutProfile() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLogin();
        mainPage.clickLoginAccountHeader();
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickExitButton();

        assertTrue("Не открыта страница конструктора", loginPage.checkHeaderLogin());
    }


    @Test
    @DisplayName("go to the bun section ")
    public void goToTheBunSection() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccountHeader();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLogin();
        ConstructorPage constructorPage = page(ConstructorPage.class);
        constructorPage.clickMainButton();
        constructorPage.clickBunButton();
        assertTrue("Не открылся раздел с булками", constructorPage.checkBunSection());
    }

    @Test
    @DisplayName("go to the main section ")
    public void goToTheMainSection() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccountHeader();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLogin();
        ConstructorPage constructorPage = page(ConstructorPage.class);
        constructorPage.clickSauceButton();

        assertTrue("Не открылся раздел с соусами", constructorPage.checkSauceSection());
    }

    @Test
    @DisplayName("go to the sauce section ")
    public void goToTheSauceSection() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class);
        mainPage.clickLoginAccountHeader();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillEmail(user.getEmail());
        loginPage.fillPassword(user.getPassword());
        loginPage.clickLogin();
        ConstructorPage constructorPage = page(ConstructorPage.class);
        constructorPage.clickMainButton();

        assertTrue("Не открылся раздел с начинками", constructorPage.checkMainSection());
    }
}
