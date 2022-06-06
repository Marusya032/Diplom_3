package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.time.Duration;

public class ConstructorPage {

    public static final String URL_OPEN = "https://stellarburgers.nomoreparties.site/";

    // название раздела Соберите бургер
    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private SelenideElement makeBurger;

    // кнопка Булки
    @FindBy(how = How.CSS, using = "div:nth-child(2) > div:nth-child(1).noselect")
    private SelenideElement bunButton;

    // название раздела Булки
    @FindBy(how = How.CSS, using = "div.BurgerIngredients_ingredients__menuContainer__Xu3Mo > ul:nth-child(2)")
    private SelenideElement bunSection;

    // кнопка Соусы
    @FindBy(how = How.CSS, using = "div:nth-child(2) > div:nth-child(2).noselect")
    private SelenideElement sauceButton;

    // название раздела Соусы
    @FindBy(how = How.CSS, using = "div.BurgerIngredients_ingredients__menuContainer__Xu3Mo > ul:nth-child(4)")
    private SelenideElement sauceSection;

    // кнопка Начинки
    @FindBy(how = How.CSS, using = "div:nth-child(2) > div:nth-child(3).noselect")
    private SelenideElement mainButton;

    // название раздела Начинки
    @FindBy(how = How.CSS, using = "div.BurgerIngredients_ingredients__menuContainer__Xu3Mo > ul:nth-child(6)")
    private SelenideElement mainSection;

    public boolean checkMakeBurgerPage(){
        return makeBurger.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed();
    }

    public void clickBunButton(){
        bunButton.click();
    }

    public void clickSauceButton(){
        sauceButton.click();
    }

    public void clickMainButton(){
        mainButton.click();
    }

    public boolean checkBunSection(){
        return bunSection.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed();
    }

    public boolean checkSauceSection(){
        return sauceSection.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed();
    }

    public boolean checkMainSection(){
        return mainSection.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed();
    }
}
