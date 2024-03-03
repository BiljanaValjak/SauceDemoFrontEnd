package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.*;

public class CheckoutCompletePageTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformation;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;


    @Before
    public void invokeBrowserTest() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        checkoutYourInformation = new CheckoutYourInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLoginButton();
        productsPage.clickAddToCartButtonJacket();
        productsPage.clickYourCartIcon();
        yourCartPage.checkoutButton();

        checkoutYourInformation.enterFirstName("Biljana");
        checkoutYourInformation.enterLastName("Valjak");
        checkoutYourInformation.enterZipCode("1000");
        checkoutYourInformation.clickContinueButton();
        checkoutOverviewPage.clickFinishButton();
    }

    @Test
    public void checkOutCompletePageTitleTest(){
        checkoutCompletePage.checkoutCompletePageTitle();
        assertEquals("Checkout: Complete!", checkoutCompletePage.checkoutCompletePageTitle());
    }

    @Test
    public void yourCartIconTest(){
        checkoutCompletePage.yourCartCountIcon();
        assertTrue(checkoutCompletePage.yourCartCountIcon());
    }

    @Test
    public void clickYourCartIconTest(){
        checkoutCompletePage.clickYourCartIcon();
        yourCartPage.yourCartPageDisplayed();
        assertEquals("Your Cart", yourCartPage.yourCartPageDisplayed());
    }

    @Test
    public void headerDisplayedTest(){
        checkoutCompletePage.headerDisplayed();
        assertEquals("Thank you for your order!", checkoutCompletePage.headerDisplayed());
        assertEquals("24px", checkoutCompletePage.headerFontSize());
        assertEquals("\"DM Mono\", sans-serif", checkoutCompletePage.headerFontFamily());
        assertEquals("#132322", checkoutCompletePage.headerColor());
    }

    @Test
    public void textMessageDisplayedTest(){
        checkoutCompletePage.textMessageDisplayed();
        assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", checkoutCompletePage.textMessageDisplayed());
        assertEquals("14px", checkoutCompletePage.textMessageFontSize());
        assertEquals("\"DM Sans\", sans-serif", checkoutCompletePage.textMessageFontFamily());
        assertEquals("#132322", checkoutCompletePage.textMessageColor());
    }

    @Test
    public void backHomeButtonTest(){
        checkoutCompletePage.backHomeButton();
        assertEquals("Back Home", checkoutCompletePage.backHomeButton());
        assertEquals("16px", checkoutCompletePage.backHomeButtonFontSize());
        assertEquals("\"DM Sans\", sans-serif", checkoutCompletePage.backHomeButtonFontFamily());
        assertEquals("#132322", checkoutCompletePage.backHomeButtonColor());

        checkoutCompletePage.clickBackHomeButton();
        productsPage.productsPageTitleDisplayed();
        assertEquals("Products", productsPage.productsPageTitleDisplayed());
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
