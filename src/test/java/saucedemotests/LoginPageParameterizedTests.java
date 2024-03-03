package saucedemotests;

import org.junit.After;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;

public class LoginPageParameterizedTests {

    private WebDriver driver;
    private LoginPage loginPage;


    @ParameterizedTest
    @ValueSource(strings = {"wrong username", "standard_user"})
    public void errorMsgInvalidUsernameAndPasswordTest(String username) {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword("wrong password");
        loginPage.clickLoginButton();
        assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.errorMessageDisplayed());
    }

}
