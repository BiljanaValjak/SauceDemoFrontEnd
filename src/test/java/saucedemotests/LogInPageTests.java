package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.Assert.*;


public class LogInPageTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;


    @Before
    public void invokeBrowserTest(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void loginPageTitleTest(){
        loginPage.loginPageTitleDisplayed();
    }

    @Test
    public void successfulLoginTest(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.productsPageTitleDisplayed();
        assertEquals("Products", productsPage.productsPageTitleDisplayed());
    }

    @Test
    public void unsuccessfulLoginLockedOutUser(){
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        loginPage.errorMessageDisplayed();
        assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.errorMessageDisplayed());
    }

    @Test
    public void unsuccessfulLoginEmptyUsernameAndPassword(){
        loginPage.clickLoginButton();
        loginPage.errorMessageDisplayed();
        assertEquals("Epic sadface: Username is required", loginPage.errorMessageDisplayed());
    }

    @Test
    public void unsuccessfulLoginEmptyUsername(){
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        loginPage.errorMessageDisplayed();
        assertEquals("Epic sadface: Username is required", loginPage.errorMessageDisplayed());
    }

    @Test
    public void unsuccessfulLoginEmptyPassword(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        loginPage.errorMessageDisplayed();
        assertEquals("Epic sadface: Password is required", loginPage.errorMessageDisplayed());
    }

    @Test
    public void xButtonErrorMsgTest(){
        loginPage.clickLoginButton();
        loginPage.xButtonErrorMessage();
        assertFalse(loginPage.errorMsgDisplayed());
    }

    @Test
    public void loginFormInitialStateUserInterfaceTest(){
        assertEquals("14px", loginPage.usernameFieldFontSize());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", loginPage.usernameFieldFontFamily());

        assertEquals("14px", loginPage.passwordFieldFontSize());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", loginPage.passwordFieldFontFamily());

        assertEquals("16px", loginPage.loginButtonFontSize());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", loginPage.loginButtonFontFamily());
        assertEquals("#3ddc91", loginPage.loginButtonColor());
    }

    @Test
    public void loginFormErrorStateUserInterfaceTest(){;
        loginPage.clickLoginButton();
        assertEquals("#e2231a", loginPage.usernameFieldBorderBottomColor());
        assertEquals("#e2231a", loginPage.passwordFieldBorderBottomColor());
        assertEquals("#e2231a",loginPage.errorMessageContainerColor());
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
