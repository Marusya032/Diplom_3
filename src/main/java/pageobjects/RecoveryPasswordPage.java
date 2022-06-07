package pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RecoveryPasswordPage {

    public static final String URL_OPEN = "https://stellarburgers.nomoreparties.site/forgot-password";

    // кнопка Войти
    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    private SelenideElement loginButtonRecoveryPassword;

    public LoginPage clickLoginFromRecoveryPassword(){
        loginButtonRecoveryPassword.click();
        return page(LoginPage.class);
    }
}
