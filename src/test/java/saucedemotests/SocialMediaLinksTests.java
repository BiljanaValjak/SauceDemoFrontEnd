package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;
import pages.SocialMediaLinks;

import static org.junit.Assert.assertEquals;

public class SocialMediaLinksTests {

    private WebDriver driver;
    private ProductsPage productsPage;
    private LoginPage loginPage;
    private SocialMediaLinks socialMediaLinks;


    @Before
    public void invokeBrowserTest(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        socialMediaLinks = new SocialMediaLinks(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.backpackTitleClick();
    }

    @Test
    public void socialMediaLinksTest(){
        assertEquals("Twitter", socialMediaLinks.getAllSocialMediaLinks().get(0).getText());
        assertEquals("Facebook", socialMediaLinks.getAllSocialMediaLinks().get(1).getText());
        assertEquals("LinkedIn", socialMediaLinks.getAllSocialMediaLinks().get(2).getText());
    }

    @Test
    public void twitterLinkTest(){
        socialMediaLinks.twitterLink();
    }

    @Test
    public void facebookLinkTest(){
        socialMediaLinks.facebookLink();
    }

    @Test
    public void linkedInTest(){
        socialMediaLinks.linkedInLink();
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
