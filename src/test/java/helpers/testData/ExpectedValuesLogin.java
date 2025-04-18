package helpers.testData;

import helpers.properties.BaseProperties;
import org.openqa.selenium.By;

public class ExpectedValuesLogin extends BaseProperties {
    public static By getErrorTextAuth(){return By.cssSelector(PROPERTIES.getProperty("errorTextButton"));}
    public static By getProducts(){return By.cssSelector(PROPERTIES.getProperty("products"));}
}
