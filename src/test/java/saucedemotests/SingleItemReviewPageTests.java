package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SingleItemReviewPage;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.Assert.*;

public class SingleItemReviewPageTests {
    private WebDriver driver;
    private ProductsPage productsPage;
    private LoginPage loginPage;
    private SingleItemReviewPage singleItemReviewPage;

    @Before
    public void invokeBrowserTest(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        singleItemReviewPage = new SingleItemReviewPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.backpackTitleClick();
    }
    @Test
    public void inventoryItemPageDisplayedTest(){
        singleItemReviewPage.singleItemPageDisplayed();
        assertTrue(singleItemReviewPage.singleItemPageDisplayed());
    }
    @Test
    public void singleItemTitleDisplayedTest(){
        assertEquals("Sauce Labs Backpack", singleItemReviewPage.selectedItemTitleDisplayed());
        assertEquals("20px", singleItemReviewPage.selectedItemTitleFontSize());
        assertEquals("\"DM Mono\", sans-serif", singleItemReviewPage.selectedItemTitleFontFamily());
        assertEquals("#132322", singleItemReviewPage.selectedItemTitleColor());
    }
    @Test
    public void singleItemDescriptionDisplayedTest(){
        assertEquals("carry.allTheThings() with the sleek, " +
                "streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                singleItemReviewPage.selectedItemDescriptionDisplayed());
        assertEquals("14px", singleItemReviewPage.selectedItemDescriptionFontSize());
        assertEquals("\"DM Sans\", sans-serif", singleItemReviewPage.selectedItemDescriptionFontFamily());
        assertEquals("#132322", singleItemReviewPage.selectedItemDescriptionColor());
    }
    @Test
    public void singleItemPriceDisplayedTest(){
        assertEquals("$29.99", singleItemReviewPage.selectedItemPriceDisplayed());
        assertEquals("20px", singleItemReviewPage.selectedItemPriceFontSize());
        assertEquals("\"DM Mono\", sans-serif", singleItemReviewPage.selectedItemPriceFontFontFamily());
        assertEquals("#132322", singleItemReviewPage.selectedItemPriceColor());
    }
    @Test
    public void selectedItemAddToCartButtonTest(){
        assertEquals("16px", singleItemReviewPage.selectedItemAddToCartButtonFontSize());
        assertEquals("\"DM Sans\", sans-serif", singleItemReviewPage.selectedItemAddToCartButtonFontFamily());
        assertEquals("#132322", singleItemReviewPage.selectedItemAddToCartButtonColor());

        singleItemReviewPage.selectedItemAddToCartButton();
        assertTrue(singleItemReviewPage.yourCartBadge());
    }
    @Test
    public void selectedItemRemoveButtonTest(){
        singleItemReviewPage.selectedItemAddToCartButton();

        assertEquals("16px", singleItemReviewPage.selectedItemRemoveButtonFontSize());
        assertEquals("\"DM Sans\", sans-serif", singleItemReviewPage.selectedItemRemoveButtonFontFamily());
        assertEquals("#e2231a", singleItemReviewPage.selectedItemRemoveButtonColor());

        singleItemReviewPage.selectedItemRemoveButton();
        assertFalse(singleItemReviewPage.yourCartBadge());
    }
    @Test
    public void clickBacToProductsLinkTest(){
        singleItemReviewPage.clickBackToProductsLink();
        productsPage.productsPageTitleDisplayed();
        assertEquals("Products", productsPage.productsPageTitleDisplayed());
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }

}
