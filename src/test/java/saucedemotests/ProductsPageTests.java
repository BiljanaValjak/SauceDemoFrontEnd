package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SingleItemReviewPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ProductsPageTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private SingleItemReviewPage singleItemReviewPage;
    private YourCartPage yourCartPage;


    @Before
    public void invokeBrowser(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        singleItemReviewPage = new SingleItemReviewPage(driver);
        yourCartPage = new YourCartPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @Test
    public void productsPageTitleDisplayedTest(){
        productsPage.productsPageTitleDisplayed();
        assertEquals("Products", productsPage.productsPageTitleDisplayed());
    }

    @Test
    public void inventoryListDisplayedTest(){
        productsPage.inventoryList();
        assertFalse(productsPage.inventoryList().isEmpty());
    }

    @Test
    public void allOptionsFromDropDownTest(){
        assertEquals("Name (A to Z)", productsPage.allOptionsFromDropDown().get(0).getText());
        assertEquals("Name (Z to A)", productsPage.allOptionsFromDropDown().get(1).getText());
        assertEquals("Price (low to high)", productsPage.allOptionsFromDropDown().get(2).getText());
        assertEquals("Price (high to low)", productsPage.allOptionsFromDropDown().get(3).getText());
    }

    @Test
    public void selectFirstItemFromNameAToZFilterTest(){
        productsPage.selectOptionFromDropDown(0);
        productsPage.inventoryList();

        assertEquals("Name (A to Z)", productsPage.getTextFromFilterDropDown(0));
        assertEquals("Sauce Labs Backpack", productsPage.firstItemTitleInNameAtoZFilter());
    }

    @Test
    public void selectFirstItemFromNameAZoAFilterTest(){
        productsPage.selectOptionFromDropDown(1);
        productsPage.inventoryList();

        assertEquals("Name (Z to A)", productsPage.getTextFromFilterDropDown(1));
        assertEquals("Test.allTheThings() T-Shirt (Red)", productsPage.firstItemTitleInNameZtoAFilter());
    }

    @Test
    public void selectLowestPriceInPriceLowToHighFilterTest(){
        productsPage.selectOptionFromDropDown(2);
        productsPage.inventoryList();

        assertEquals("Price (low to high)", productsPage.getTextFromFilterDropDown(2));
        assertEquals("$7.99", productsPage.lowestPriceInPriceLowToHighFilter());
    }

    @Test
    public void selectHighestPriceInPriceHighToLowFilterTest() {
        productsPage.selectOptionFromDropDown(3);
        productsPage.inventoryList();

        assertEquals("Price (high to low)", productsPage.getTextFromFilterDropDown(3));
        assertEquals("$49.99", productsPage.highestPriceInPriceHighToLowFilter());
    }

    @Test
    public void clickBackpackTitleTest(){
        productsPage.backpackTitleClick();
        singleItemReviewPage.singleItemPageDisplayed();
        assertTrue(singleItemReviewPage.singleItemPageDisplayed());
    }

    @Test
    public void backpackAddToCartButtonTest(){
        productsPage.backpackAddToCartButtonDisplayed();
        productsPage.clickAddToCartButtonBackpack();
        productsPage.removeBackpackButtonDisplayed();
        assertTrue(productsPage.removeBackpackButtonDisplayed());
    }

    @Test
    public void backpackRemoveButtonTest(){
        productsPage.clickAddToCartButtonBackpack();
        productsPage.clickRemoveButtonBackpack();
        productsPage.backpackAddToCartButtonDisplayed();
        assertEquals("Add to cart", productsPage.backpackAddToCartButtonDisplayed());
    }

    @Test
    public void yourCartIconTest(){
        productsPage.yourCartIconDisplayed();
        assertTrue(productsPage.yourCartIconDisplayed());

        productsPage.clickYourCartIcon();
        yourCartPage.yourCartPageDisplayed();
        assertEquals("Your Cart", yourCartPage.yourCartPageDisplayed());
    }

    @Test
    public void clickAddToCartOn3ItemsTest(){
        productsPage.clickAddToCartButtonBikeLight();
        productsPage.clickAddToCartButtonJacket();
        productsPage.clickAddToCartButtonBackpack();
        productsPage.yourCartSelectedItemsBadge();
        assertEquals("3", productsPage.yourCartSelectedItemsBadge());

        productsPage.clickRemoveButtonBackpack();
        productsPage.yourCartSelectedItemsBadge();
        assertEquals("2", productsPage.yourCartSelectedItemsBadge());
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
