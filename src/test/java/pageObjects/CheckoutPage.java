package pageObjects;

import helpers.testData.InputTestData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.properties.BaseProperties.PROPERTIES;

public class CheckoutPage extends BasePage{
    private double totalPrice = InputTestData.getStartedTotalPrice();
    private double taxPrice;
    private double totalPriceWithTax;
    private double expectedPrice;
    private static By getFinishButton(){return By.cssSelector(PROPERTIES.getProperty("finishButton"));}
    private static String getListAllElements(){return PROPERTIES.getProperty("listAllElements");}
    private static String getTaxSum(){return  PROPERTIES.getProperty("taxSum");}
    private static String getTotalSum(){return PROPERTIES.getProperty("totalSum");}
    private static String getTextTaxSum(){return PROPERTIES.getProperty("textTaxSum");}
    private static String getTextTotalSum(){return PROPERTIES.getProperty("textTotalSum");}
    private static String getSymbol$(){return PROPERTIES.getProperty("symbol$");}
    public CheckoutPage(WebDriver driver){
        super(driver);
    }
    @Step("Поиск итоговой суммы")
    public void findTotalPrice(){
        List<WebElement> allElements = driver.findElements(By.cssSelector(getListAllElements()));
        for (WebElement elements : allElements) {
            double price = Double.parseDouble(elements.getText().replace(getSymbol$(), ""));
            totalPrice += price;
        }
        WebElement taxSumFindElement = driver.findElement(By.cssSelector(getTaxSum()));
        taxPrice = Double.parseDouble(taxSumFindElement.getText().replace(getTextTaxSum(), ""));
        totalPriceWithTax = totalPrice + taxPrice;
        WebElement sum = driver.findElement(By.cssSelector(getTotalSum()));
        expectedPrice = Double.parseDouble(sum.getText().replace(getTextTotalSum(), ""));
    }
    @Step("Завершаем тест")
    public void clickFinishButton(){
        driver.findElement(getFinishButton()).click();
    }

    public double getTotalPriceWithTax() {
        return totalPriceWithTax;
    }

    public double getExpectedPrice() {
        return expectedPrice;
    }
}
