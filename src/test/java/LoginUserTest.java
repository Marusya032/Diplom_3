import client.StellarBurgersClient;
import pageobjects.MainPage;
import user.User;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.codeborne.selenide.Selenide.open;
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
    @DisplayName("login from main page")
    public void loginFromMain() {
        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class)
                .clickLoginAccount()
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLogin();
        assertTrue("Не найдена кнопка оформления заказа", mainPage.checkOrderButton());
    }

    @Test
    @DisplayName("login from header")
    public void loginFromHeader() {
        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class)
                .clickLoginAccountHeader()
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLogin();
        assertTrue("Не найдена кнопка оформления заказа", mainPage.checkOrderButton());
    }

    @Test
    @DisplayName("login from registration button")
    public void loginFromRegistration() {
        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class)
                .clickLoginAccount()
                .clickRegistrationLink()
                .clickLoginFromRegistration()
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLogin();
        assertTrue("Не найдена кнопка оформления заказа", mainPage.checkOrderButton());
    }

    @Test
    @DisplayName("login from recovery password")
    public void loginFromRecoveryPassword() {
        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class)
                .clickLoginAccount()
                .clickRecoveryPasswordButton()
                .clickLoginFromRecoveryPassword()
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLogin();
        assertTrue("Не найдена кнопка оформления заказа", mainPage.checkOrderButton());
    }
}
