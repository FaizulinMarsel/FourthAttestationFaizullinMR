package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.properties.BaseProperties.PROPERTIES;

public class CartPage extends BasePage{
    private static By getCheckoutButton(){return By.cssSelector(PROPERTIES.getProperty("checkout"));}
    public CartPage(WebDriver driver){
        super(driver);
    }
    @Step("Подтверждаем товары в корзине")
    public void checkout() {
        driver.findElement(getCheckoutButton()).click();
    }

}
