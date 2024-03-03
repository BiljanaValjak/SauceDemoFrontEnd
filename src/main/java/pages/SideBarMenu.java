package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SideBarMenu {

    private WebDriver driver;
    private By openMenuButton = By.id("react-burger-menu-btn");
    private By allItemsLink = By.id("inventory_sidebar_link");
    private By aboutLink = By.id("about_sidebar_link");
    private By logoutLink = By.id("logout_sidebar_link");
    private By resetAppStateLink = By.id("reset_sidebar_link");
    private By closeMenuButton = By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]/div[2]/div");


    public SideBarMenu(WebDriver driver){
        this.driver = driver;
    }

    public void clickMenuButton() {
        driver.findElement(openMenuButton).click();
    }

    public List<WebElement> getAllLinksSideBarMenu() {
        WebElement menuContainer = driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]/div[1]"));
        return menuContainer.findElements(By.tagName("a"));
    }

    public String allLinksSideBarMenu(int linkNum){
        WebElement menuContainer = driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]/div[1]"));
        List<WebElement> options = menuContainer.findElements(By.tagName("a"));
        return options.get(linkNum).getText();
    }

    public void allItemsSideBarLink() {
         driver.findElement(allItemsLink).getText();
         driver.findElement(allItemsLink).click();
    }

    public void aboutSideBarLink() {
        driver.findElement(aboutLink).getText();
        driver.findElement(aboutLink).click();
    }

    public void logoutSideBarLink() {
        driver.findElement(logoutLink).getText();
        driver.findElement(logoutLink).click();
    }

    public void resetAppStateSideBarLink() {
        driver.findElement(resetAppStateLink).getText();
        driver.findElement(resetAppStateLink).click();
    }

    public void clickCloseMenuButton() {
        driver.findElement(closeMenuButton).click();
    }

}
