package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import java.util.List;

public class SideBarMenu {

    private WebDriver driver;
    Actions actions;
    private By openMenuButton = By.id("react-burger-menu-btn");
    private By allItemsLink = By.id("inventory_sidebar_link");
    private By aboutLink = By.id("about_sidebar_link");
    private By logoutLink = By.id("logout_sidebar_link");
    private By resetAppStateLink = By.id("reset_sidebar_link");
    private By closeMenuButton = By.id("react-burger-cross-btn");


    public SideBarMenu(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void clickMenuButton() {
        driver.findElement(openMenuButton).click();
    }

    public String allLinksSideBarMenu(int linkNum){
        WebElement menuContainer = driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]/div[1]"));
        List<WebElement> options = menuContainer.findElements(By.tagName("a"));
        return options.get(linkNum).getText();
    }

    public String allItemsSideBarLink() {
        return driver.findElement(allItemsLink).getText();
    }

    public void allItemsLinkHover(){
        WebElement element = driver.findElement(allItemsLink);
        actions.moveToElement(element).perform();
    }

    public String allItemsLinkColorSwitch(){
        Color titleColor = Color.fromString(driver.findElement(allItemsLink).getCssValue("color"));
        return titleColor.asHex();
    }

    public void clickAllItemsSideBarLink() {
        driver.findElement(allItemsLink).click();
    }

    public String aboutSideBarLink() {
        return driver.findElement(aboutLink).getText();
    }

    public void aboutLinkHover(){
        WebElement element = driver.findElement(aboutLink);
        actions.moveToElement(element).perform();
    }

    public String aboutLinkColorSwitch(){
        Color titleColor = Color.fromString(driver.findElement(aboutLink).getCssValue("color"));
        return titleColor.asHex();
    }

    public String getHrefFromAboutLink(){
        WebElement element = driver.findElement(By.xpath("//*[@id=\"about_sidebar_link\"]"));
        return element.getAttribute("href");
    }

    public void clickAboutSideBarLink(){
        driver.findElement(aboutLink).click();
    }

    public String logoutSideBarLink() {
        return driver.findElement(logoutLink).getText();
    }

    public void logoutLinkHover(){
        WebElement element = driver.findElement(logoutLink);
        actions.moveToElement(element).perform();
    }

    public String logoutLinkColorSwitch(){
        Color titleColor = Color.fromString(driver.findElement(logoutLink).getCssValue("color"));
        return titleColor.asHex();
    }

    public void clickLogoutSideBarLink() {
        driver.findElement(logoutLink).click();
    }

    public String resetAppStateSideBarLink() {
       return driver.findElement(resetAppStateLink).getText();
    }

    public void restAppStateHover(){
        WebElement element = driver.findElement(resetAppStateLink);
        actions.moveToElement(element).perform();
    }

    public String resetAppStateLinkColorSwitch(){
        Color titleColor = Color.fromString(driver.findElement(resetAppStateLink).getCssValue("color"));
        return titleColor.asHex();
    }

    public void clickResetAppStateSideBarLink() {
        driver.findElement(resetAppStateLink).click();
    }

    public void clickCloseMenuButton() {
        driver.findElement(closeMenuButton).click();
    }

}
