package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static helpers.properties.BaseProperties.PROPERTIES;

public class LoginPage extends BasePage{
    private static By getUserName() {return By.cssSelector(PROPERTIES.getProperty("userName"));}
    private static By getPassword() {
        return By.cssSelector(PROPERTIES.getProperty("password"));
    }
    private static By getLoginButton() {
        return By.cssSelector(PROPERTIES.getProperty("loginButton"));
    }
    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void authorization(String userName, String password){
        driver.findElement(getUserName()).sendKeys(userName);
        driver.findElement(getPassword()).sendKeys(password);
        driver.findElement(getLoginButton()).click();
    }
    public void waitTextProducts(){
        By textTitle = By.cssSelector("span.title");
        wait.until(ExpectedConditions.textToBe(textTitle, "Products"));
    }
}
