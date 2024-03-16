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
    private YourCartPage yourCartPage;
    private SideBarMenu sideBarMenu;


    @Before
    public void invokeBrowser(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        yourCartPage = new YourCartPage(driver);
        sideBarMenu = new SideBarMenu(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        sideBarMenu.clickMenuButton();
    }

    @Test
    public void allLinksSideBarMenuTest() throws InterruptedException {
        Thread.sleep(250);
        assertEquals("All Items", sideBarMenu.allLinksSideBarMenu(0));
        assertEquals("About", sideBarMenu.allLinksSideBarMenu(1));
        assertEquals("Logout", sideBarMenu.allLinksSideBarMenu(2));
        assertEquals("Reset App State", sideBarMenu.allLinksSideBarMenu(3));
    }

    @Test
    public void allItemsLinkHoverTest() throws InterruptedException {
        Thread.sleep(250);
        assertEquals("#18583a", sideBarMenu.allItemsLinkColorSwitch());
        sideBarMenu.allItemsLinkHover();
        sideBarMenu.allItemsLinkColorSwitch();
        assertEquals("#3ddc91", sideBarMenu.allItemsLinkColorSwitch());

    }

    @Test
    public void sideBarMenuAllItemsLinkTest() throws InterruptedException {
        productsPage.clickAddToCartButtonBackpack();
        productsPage.clickAddToCartButtonJacket();
        productsPage.clickYourCartIcon();

        sideBarMenu.clickMenuButton();
        Thread.sleep(250);
        sideBarMenu.allItemsSideBarLink();
        assertEquals("All Items", sideBarMenu.allItemsSideBarLink());
        sideBarMenu.clickAllItemsSideBarLink();

        productsPage.productsPageTitleDisplayed();
    }

    @Test
    public void sideBarMenuAboutLinkTest() throws InterruptedException {
        Thread.sleep(250);
        assertEquals("About", sideBarMenu.aboutSideBarLink());
        sideBarMenu.getHrefFromAboutLink();
    }

    @Test
    public void aboutLinkHoverColorTest() throws InterruptedException {
        Thread.sleep(250);
        assertEquals("#18583a", sideBarMenu.aboutLinkColorSwitch());
        sideBarMenu.aboutLinkHover();
        assertEquals("#3ddc91", sideBarMenu.aboutLinkColorSwitch());
        assertEquals("https://saucelabs.com/", sideBarMenu.getHrefFromAboutLink());
        sideBarMenu.clickAboutSideBarLink();
    }

    @Test
    public void sideBarMenuLogoutLinkTest() throws InterruptedException {
        Thread.sleep(250);
        assertEquals("Logout", sideBarMenu.logoutSideBarLink());
        sideBarMenu.clickLogoutSideBarLink();

        loginPage.loginPageTitleDisplayed();
        assertTrue(loginPage.loginPageTitleDisplayed());
    }

    @Test
    public void logoutLinkHoverColorTest() throws InterruptedException {
        Thread.sleep(250);
        assertEquals("#18583a", sideBarMenu.logoutLinkColorSwitch());
        sideBarMenu.logoutLinkHover();
        assertEquals("#3ddc91", sideBarMenu.logoutLinkColorSwitch());
    }

    @Test
    public void sideBarMenuResetAppStateLinkTest(){
        productsPage.clickAddToCartButtonBackpack();
        productsPage.clickAddToCartButtonJacket();
        productsPage.yourCartSelectedItemsBadge();
        assertEquals("2", productsPage.yourCartSelectedItemsBadge());

        sideBarMenu.resetAppStateSideBarLink();
        assertEquals("Reset App State", sideBarMenu.resetAppStateSideBarLink());
        sideBarMenu.clickResetAppStateSideBarLink();

        yourCartPage.yourCartItemsCountBadge();
    }

    @Test
    public void resetAppStateHoverColorTest() throws InterruptedException {
        Thread.sleep(250);
        assertEquals("#18583a", sideBarMenu.resetAppStateLinkColorSwitch());
        sideBarMenu.restAppStateHover();
        assertEquals("#3ddc91", sideBarMenu.resetAppStateLinkColorSwitch());
    }

    @Test
    public void sideBarMenuCloseButtonTest() throws InterruptedException {
        Thread.sleep(250);
        sideBarMenu.clickCloseMenuButton();
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
