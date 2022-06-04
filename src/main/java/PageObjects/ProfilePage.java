package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class ProfilePage {

    public static final String URL_OPEN = "https://stellarburgers.nomoreparties.site/account/profile";

    // кнопка Профиль
    @FindBy(how = How.XPATH, using = ".//a[text()='Профиль']")
    private SelenideElement profilePage;

    // кнопка Выход
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement exitButton;

    public void clickExitButton(){
        exitButton.click();
    }

    public boolean checkProfilePage(){
        return profilePage.shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public boolean checkExitButton(){
        return exitButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }
}
