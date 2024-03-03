package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.*;

public class YourCartPageTests {
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
    }
    @Test
    public void yourCartPageTitleDisplayed(){
        productsPage.clickYourCartIcon();
        yourCartPage.yourCartPageDisplayed();
        assertEquals("Your Cart", yourCartPage.yourCartPageDisplayed());
    }
    @Test
    public void quantityLabelDisplayedTest(){
        productsPage.clickYourCartIcon();
        yourCartPage.quantityLabelDisplayed();
        assertTrue(yourCartPage.quantityLabelDisplayed());
    }
    @Test
    public void descriptionLabelDisplayedTest(){
        productsPage.clickYourCartIcon();
        yourCartPage.descriptionLabelDisplayed();
        assertTrue(yourCartPage.descriptionLabelDisplayed());
    }
    @Test
    public void addFirstItemToCartAndRemoveItTest(){
      productsPage.clickAddToCartButtonJacket();
      productsPage.clickYourCartIcon();
      assertEquals("1", yourCartPage.selectedItemQuantity());

      assertEquals("Sauce Labs Fleece Jacket", yourCartPage.firstItemInYourCartTitle());
      assertEquals("It's not every day that you come across a midweight quarter-zip fleece jacket " +
                "capable of handling everything from a relaxing day outdoors to a busy day at the office.", yourCartPage.firstItemInYourCartDescription());
      assertEquals("$49.99", yourCartPage.firstItemInYourCartPrice());
      assertEquals("Remove", yourCartPage.removeButtonFirstItemInYourCart());
      assertTrue(yourCartPage.yourCartItemsCountBadge());

      yourCartPage.clickRemoveButtonFirstItem();
      assertFalse(yourCartPage.yourCartItemsCountBadge());
    }
    @Test
    public void clickContinueShoppingTest(){
        productsPage.clickYourCartIcon();
        yourCartPage.continueShoppingButton();
        productsPage.productsPageTitleDisplayed();
        assertEquals("Products", productsPage.productsPageTitleDisplayed());
    }
    @Test
    public void clickCheckoutYourInformationTest(){
        productsPage.clickYourCartIcon();
        yourCartPage.checkoutButton();
        checkoutYourInformation.checkoutYourInformationTitle();
        assertEquals("Checkout: Your Information", checkoutYourInformation.checkoutYourInformationTitle());
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }

}
