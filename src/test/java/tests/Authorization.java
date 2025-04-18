package tests;

import helpers.BrowserSetting;
import helpers.testData.ExpectedTextData;
import helpers.testData.InputTestData;
import helpers.testData.ExpectedValuesLogin;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Authorization {
    LoginPage loginPage;
    MainPage mainPage;
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = BrowserSetting.createChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Авторизация с незаблокированным пользователем")
    public void correctAuthorization() {
        mainPage.open();
        loginPage.authorization(InputTestData.getCorrectUserName(), InputTestData.getCorrectPassword());
        assertEquals(ExpectedTextData.getTextProducts(), driver.findElement(ExpectedValuesLogin.getProducts()).getText());
    }

    @Test
    @DisplayName("Авторизация с заблокированным пользователем")
    public void lockedUserAuthorization() {
        mainPage.open();
        loginPage.authorization(InputTestData.getLockedUserName(), InputTestData.getCorrectPassword());
        assertEquals(ExpectedTextData.getErrorTextAuth(), driver.findElement(ExpectedValuesLogin.getErrorTextAuth()).getText());
    }
}
