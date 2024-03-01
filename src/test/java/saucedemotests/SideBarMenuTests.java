package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SideBarMenuTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private SideBarMenu sideBarMenu;

    @Before
    public void invokeBrowser(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        sideBarMenu = new SideBarMenu(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        sideBarMenu.clickMenuButton();
    }

    @Test
    public void allLinksSideBarMenuTest(){
        assertEquals("All Items", sideBarMenu.getAllLinksSideBarMenu().get(0).getText());
        assertEquals("About", sideBarMenu.getAllLinksSideBarMenu().get(1).getText());
        assertEquals("Logout", sideBarMenu.getAllLinksSideBarMenu().get(2).getText());
        assertEquals("Reset App State", sideBarMenu.getAllLinksSideBarMenu().get(3).getText());
    }

    @Test
    public void sideBarMenuAllItemsLinkTest(){
        assertEquals("All Items", sideBarMenu.allLinksSideBarMenu(0));
        sideBarMenu.allItemsSideBarLink();
    }

    @Test
    public void sideBarMenuAboutLinkTest(){
        assertEquals("About", sideBarMenu.allLinksSideBarMenu(1));
        sideBarMenu.aboutSideBarLink();
    }

    @Test
    public void sideBarMenuLogoutLinkTest(){
        assertEquals("Logout", sideBarMenu.allLinksSideBarMenu(2));
        sideBarMenu.logoutSideBarLink();

        loginPage.loginPageTitleDisplayed();
        assertTrue(loginPage.loginPageTitleDisplayed());
    }

    @Test
    public void sideBarMenuResetAppStateLinkTest(){
        assertEquals("Reset App State", sideBarMenu.allLinksSideBarMenu(3));

        productsPage.clickAddToCartButtonBackpack();
        productsPage.clickAddToCartButtonJacket();
        productsPage.yourCartSelectedItemsBadge();
        assertEquals("2", productsPage.yourCartSelectedItemsBadge());

        sideBarMenu.resetAppStateSideBarLink();
    }

    @Test
    public void sideBarMenuCloseButtonTest(){
        sideBarMenu.clickCloseMenuButton();
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
