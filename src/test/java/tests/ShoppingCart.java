package tests;

import helpers.BrowserSetting;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCart {
    CheckoutPage checkoutPage;
    InformationClientPage informationClientPage;
    ProductsPage productsPage;
    LoginPage loginPage;
    MainPage mainPage;
    CartPage cartPage;
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = BrowserSetting.createChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        productsPage = new ProductsPage(driver);
        informationClientPage = new InformationClientPage(driver);
        checkoutPage = new CheckoutPage(driver);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @ParameterizedTest
    @MethodSource("helpers.LoginData#loginDetails")
    @DisplayName("Проверка итоговой суммы")
    @Description ("Добавляем три товара в корзину и сравниваем их сумму + налог с итоговой суммой корзины " +
                    "под разными пользователями")
    public void compareTotalSumAndSumProductsWithTax(String userName, String password) {
        mainPage.open();
        step("Авторизуемся", () -> {
            loginPage.authorization(userName, password);
            loginPage.waitTextProducts();
        });
        productsPage.addProductCart();
        cartPage.checkout();
        informationClientPage.addTestClient();
        checkoutPage.findTotalPrice();
        checkoutPage.clickFinishButton();
        assertEquals(checkoutPage.getTotalPriceWithTax(), checkoutPage.getExpectedPrice());
    }

}
