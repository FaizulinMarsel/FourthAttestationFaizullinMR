package pageObjects;

import helpers.testData.InputTestData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.properties.BaseProperties.PROPERTIES;

public class InformationClientPage extends BasePage{
    private static By getFirstName(){return By.cssSelector(PROPERTIES.getProperty("firstName"));}
    private static By getLastName(){return By.cssSelector(PROPERTIES.getProperty("lastName"));}
    private static By getPostalCode(){return By.cssSelector(PROPERTIES.getProperty("postalCode"));}
    private static By getContinueButton(){return By.cssSelector(PROPERTIES.getProperty("continueButton"));}
    public InformationClientPage(WebDriver driver){
        super(driver);
    }
    @Step("Добавляем информацию о клиенте")
    public void addTestClient(){
        driver.findElement(getFirstName()).sendKeys(InputTestData.getTestFirstName());
        driver.findElement(getLastName()).sendKeys(InputTestData.getTestLastName());
        driver.findElement(getPostalCode()).sendKeys(InputTestData.getTestPostalCode());
        driver.findElement(getContinueButton()).click();
    }
}
