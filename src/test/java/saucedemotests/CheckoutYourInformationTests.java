package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckoutYourInformationPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

import static org.junit.Assert.assertEquals;

public class CheckoutYourInformationTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformation;

    @Before
    public void invokeBrowserTest() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        checkoutYourInformation = new CheckoutYourInformationPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLoginButton();
        productsPage.clickAddToCartButtonJacket();
        productsPage.clickYourCartIcon();
        yourCartPage.checkoutButton();
    }

    @Test
    public void checkoutYourInformationPageDisplayedTest(){
        assertEquals("Checkout: Your Information", checkoutYourInformation.checkoutYourInformationTitle());
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
