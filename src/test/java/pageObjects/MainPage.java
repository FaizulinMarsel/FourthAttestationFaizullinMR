package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static helpers.properties.BaseProperties.PROPERTIES;

public class MainPage extends BasePage{
    private static String getUrl() {
        return PROPERTIES.getProperty("URL");
    }

    public MainPage(WebDriver driver){
        super(driver);
    }
    @Step("Открываем главную страницу")
    public void open(){
        driver.get(getUrl());
    }
}
