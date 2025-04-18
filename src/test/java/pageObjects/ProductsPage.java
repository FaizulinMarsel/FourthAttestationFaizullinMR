package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.properties.BaseProperties.PROPERTIES;

public class ProductsPage extends BasePage{
    private static By getFirstElement() {return By.cssSelector(PROPERTIES.getProperty("firstElement"));}
    private static By getSecondElement() {return By.cssSelector(PROPERTIES.getProperty("secondElement"));}
    private static By getThirdElement() {return By.cssSelector(PROPERTIES.getProperty("thirdElement"));}
    private static By getCssSelectorShoppingCart(){return By.cssSelector(PROPERTIES.getProperty("shoppingCart"));}
    public ProductsPage(WebDriver driver){
        super(driver);
    }
    @Step("Добавляем продукты в корзину")
    public void addProductCart(){
        driver.findElement(getFirstElement()).click();
        driver.findElement(getSecondElement()).click();
        driver.findElement(getThirdElement()).click();
        driver.findElement(getCssSelectorShoppingCart()).click();
    }
}
