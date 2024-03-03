package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.*;

public class CheckoutYourInformationPageTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformation;
    private CheckoutOverviewPage checkoutOverviewPage;

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
    @Test
    public void successfulInputTest(){
        checkoutYourInformation.enterFirstName("Biljana");
        checkoutYourInformation.enterLastName("Valjak");
        checkoutYourInformation.enterZipCode("1000");
        checkoutYourInformation.clickContinueButton();
        checkoutOverviewPage.checkOutOverviewTitleDisplayed();
        assertEquals("Checkout: Overview", checkoutOverviewPage.checkOutOverviewTitleDisplayed());
    }
    @Test
    public void unsuccessfulInputEmptyFieldsTest(){
        checkoutYourInformation.clickContinueButton();
        assertEquals("Error: First Name is required", checkoutYourInformation.errorMessage());
    }
    @Test
    public void unsuccessfulInputFirstNameEmptyFieldTest(){
        checkoutYourInformation.enterLastName("Valjak");
        checkoutYourInformation.enterZipCode("1000");
        checkoutYourInformation.clickContinueButton();
        assertEquals("Error: First Name is required", checkoutYourInformation.errorMessage());
    }
    @Test
    public void unsuccessfulInputLastEmptyFieldTest(){
        checkoutYourInformation.enterFirstName("Biljana");
        checkoutYourInformation.enterZipCode("1000");
        checkoutYourInformation.clickContinueButton();
        assertEquals("Error: Last Name is required", checkoutYourInformation.errorMessage());
    }
    @Test
    public void unsuccessfulInputZipCodeFieldTest(){
        checkoutYourInformation.enterFirstName("Biljana");
        checkoutYourInformation.enterLastName("Valjak");
        checkoutYourInformation.clickContinueButton();
        assertEquals("Error: Postal Code is required", checkoutYourInformation.errorMessage());
    }
    @Test
    public void xButtonErrorMessage(){
        checkoutYourInformation.enterFirstName("Biljana");
        checkoutYourInformation.clickContinueButton();
        checkoutYourInformation.xButtonErrorMessage();
        checkoutYourInformation.errorMsgDisplayed();
        assertFalse(checkoutYourInformation.errorMsgDisplayed());
    }
    @Test
    public void yourInformationInitialStateUserInterfaceTest(){
        assertEquals("14px", checkoutYourInformation.firstNameFieldFontSize());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", checkoutYourInformation.firstNameFieldFontFamily());

        assertEquals("14px", checkoutYourInformation.lastNameFieldFontSize());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", checkoutYourInformation.lastNameFieldFontFamily());

        assertEquals("14px", checkoutYourInformation.zipCodeFieldFontSize());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", checkoutYourInformation.zipCodeFieldFontFamily());
    }
    @Test
    public void yourInformationErrorStateUserInterfaceTest(){;
        checkoutYourInformation.clickContinueButton();
        assertEquals("#e2231a", checkoutYourInformation.firstNameBottomBorderColor());
        assertEquals("#e2231a", checkoutYourInformation.lastNameBottomBorderColor());
        assertEquals("#e2231a", checkoutYourInformation.zipCodeBorderBottomColor());
        assertEquals("#e2231a",checkoutYourInformation.errorMessageContainerColor());
    }
    @Test
    public void continueButton(){
        assertEquals("16px", checkoutYourInformation.continueButtonFontSize());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", checkoutYourInformation.continueButtonFontFamily());
        assertEquals("#3ddc91", checkoutYourInformation.continueButtonColor());
    }
    @Test
    public void cancelButton(){
        assertEquals("16px", checkoutYourInformation.cancelButtonFontSize());
        assertEquals("\"DM Sans\", sans-serif", checkoutYourInformation.cancelButtonFontFamily());
        assertEquals("#ffffff", checkoutYourInformation.cancelButtonColor());
    }
    @Test
    public void clickCancelButton(){
        checkoutYourInformation.clickCancelButton();
        yourCartPage.yourCartPageDisplayed();
        assertEquals("Your Cart", yourCartPage.yourCartPageDisplayed());
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }
}
