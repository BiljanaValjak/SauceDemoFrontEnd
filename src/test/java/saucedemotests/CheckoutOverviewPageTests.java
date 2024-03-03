package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.*;

public class CheckoutOverviewPageTests {

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
    }

    @Test
    public void checkoutOverviewPageTitleTest(){
        checkoutOverviewPage.checkOutOverviewTitleDisplayed();
        assertEquals("Checkout: Overview", checkoutOverviewPage.checkOutOverviewTitleDisplayed());
    }

    @Test
    public void quantityLabelDisplayedTest(){
        checkoutOverviewPage.quantityLabelDisplayed();
        assertTrue(checkoutOverviewPage.quantityLabelDisplayed());
    }

    @Test
    public void descriptionLabelDisplayedTest(){
        checkoutOverviewPage.descriptionLabelDisplayed();
        assertTrue(checkoutOverviewPage.descriptionLabelDisplayed());
    }

    @Test
    public void selectedItemReview(){
        assertTrue( checkoutOverviewPage.selectedItemReview());
    }

    @Test
    public void checkoutOverviewItemReview(){
        assertEquals("1", checkoutOverviewPage.selectedItemQuantity());
        assertEquals("Sauce Labs Fleece Jacket", checkoutOverviewPage.firstItemInYourCartTitle());
        assertEquals("It's not every day that you come across a midweight quarter-zip fleece jacket " +
                "capable of handling everything from a relaxing day outdoors to a busy day at the office."
                , checkoutOverviewPage.firstItemInYourCartDescription());
        assertEquals("$49.99", checkoutOverviewPage.firstItemInYourCartPrice());
    }

    @Test
    public void firstItemReviewUserInterfaceTest(){
        assertEquals("20px", checkoutOverviewPage.firstItemInYourCartTitleFontSize());
        assertEquals("\"DM Mono\", sans-serif", checkoutOverviewPage.firstItemInYourCartTitleFontFamily());
        assertEquals("#18583a", checkoutOverviewPage.firstItemInYourCartTitleColor());

        assertEquals("14px", checkoutOverviewPage.firstItemInYourCartDescriptionFontSize());
        assertEquals("\"DM Sans\", sans-serif", checkoutOverviewPage.firstItemInYourCartDescriptionFontFamily());
        assertEquals("#132322", checkoutOverviewPage.firstItemInYourCartDescriptionColor());

        assertEquals("20px", checkoutOverviewPage.firstItemInYourCartPriceFontSize());
        assertEquals("\"DM Mono\", sans-serif", checkoutOverviewPage.firstItemInYourCartPriceFontFamily());
        assertEquals("#132322", checkoutOverviewPage.firstItemInYourCartPriceColor());
    }

    @Test
    public void yourCartCountBadgeTest(){
        assertTrue(checkoutOverviewPage.yourCartItemsCountBadge());
        assertEquals("1", checkoutOverviewPage.yourCartCountIcon());
        assertEquals("#e2231a", checkoutOverviewPage.yourCartCountItemBadgeColor());
    }

    @Test
    public void paymentInformationTest(){
        assertEquals("Payment Information", checkoutOverviewPage.paymentInformationLabel());
        assertEquals("18px", checkoutOverviewPage.paymentInformationFontSize());
        assertEquals("\"DM Mono\", sans-serif", checkoutOverviewPage.paymentInformationFontFamily());
    }

    @Test
    public void cardInformationTest(){
        assertEquals("SauceCard #31337", checkoutOverviewPage.cardInformationLabel());
        assertEquals("14px", checkoutOverviewPage.cardInformationFontSize());
        assertEquals("\"DM Sans\", sans-serif", checkoutOverviewPage.cardInformationFontFamily());
    }

    @Test
    public void shippingInformationLabelTest(){
        assertEquals("Shipping Information", checkoutOverviewPage.shippingInformationLabel());
        assertEquals("18px", checkoutOverviewPage.shippingInformationFontSize());
        assertEquals("\"DM Mono\", sans-serif", checkoutOverviewPage.shippingInformationFontFamily());
    }

    @Test
    public void deliveryMethodTest(){
        assertEquals("Free Pony Express Delivery!", checkoutOverviewPage.deliveryMethodLabel());
        assertEquals("14px", checkoutOverviewPage.deliveryMethodFontSize());
        assertEquals("\"DM Sans\", sans-serif", checkoutOverviewPage.deliveryMethodFontFamily());
    }

    @Test
    public void priceTotalLabelTest(){
        assertEquals("Price Total", checkoutOverviewPage.priceTotalLabel());
        assertEquals("18px", checkoutOverviewPage.priceTotalFontSize());
        assertEquals("\"DM Mono\", sans-serif", checkoutOverviewPage.priceTotalFontFamily());
    }

    @Test
    public void itemTotalLabelTest(){
        assertEquals("Item total: $49.99", checkoutOverviewPage.itemTotalPriceLabel());
        assertEquals("14px", checkoutOverviewPage.itemTotalPriceFontSize());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", checkoutOverviewPage.itemTotalPriceFontFamily());
    }

    @Test
    public void taxLabelTest(){
        assertEquals("Tax: $4.00", checkoutOverviewPage.taxTotalLabel());
        assertEquals("14px", checkoutOverviewPage.taxTotalFontSize());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", checkoutOverviewPage.taxTotalFontFamily());
    }

    @Test
    public void totalLabelTest(){
        assertEquals("Total: $53.99", checkoutOverviewPage.totalLabel());
        assertEquals("18px", checkoutOverviewPage.totalLabelFontSize());
        assertEquals("\"DM Mono\", sans-serif", checkoutOverviewPage.totalLabelFontFamily());
    }

    @Test
    public void cancelButtonTest(){
        assertEquals("#ffffff", checkoutOverviewPage.cancelButtonColor());
        checkoutOverviewPage.clickCancelButton();
        productsPage.productsPageTitleDisplayed();
        assertEquals("Products", productsPage.productsPageTitleDisplayed());
    }

    @Test
    public void finishButtonTest(){
        assertEquals("16px", checkoutOverviewPage.finishButtonFontSize());
        assertEquals("\"DM Sans\", sans-serif", checkoutOverviewPage.finishButtonFontFamily());
        assertEquals("#3ddc91", checkoutOverviewPage.finishButtonColor());
        checkoutOverviewPage.clickFinishButton();

        checkoutCompletePage.checkoutCompletePageTitle();
        assertEquals("Checkout: Complete!", checkoutCompletePage.checkoutCompletePageTitle());
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
