package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage {

    private WebDriver driver;
    private By productsPageTitle = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private By inventoryList = By.id("inventory_container");
    private By firstItemTitleInFilterNameAtoZ = By.id("item_4_title_link");
    private By firstItemTitleInFilterNameZtoA = By.id("item_3_title_link");
    private By lowestPriceInPriceLowToHighFilter = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    private By highestPriceInPriceHighToLowFilter = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    private By backpackTitle = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private By clickBackpackAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By removeBackpackFromCartButton = By.id("remove-sauce-labs-backpack");
    private By yourCartIcon = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    private By addToCartButtonBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By addToCartButtonJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By yourCartItemsBadge = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String productsPageTitleDisplayed() {
        return driver.findElement(productsPageTitle).getText();
    }

    public String inventoryList() {
        return driver.findElement(inventoryList).getText();
    }

    public List<WebElement> allOptionsFromDropDown() {
        Select listDropDown = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        return listDropDown.getOptions();
    }

    public void selectOptionFromDropDown(int optionNum) {
        if (optionNum > 3) {
            throw new IndexOutOfBoundsException("The value of index must be lower than or equal to 3");
        }
        Select selectOption = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        selectOption.selectByIndex(optionNum);
    }

    public String getTextFromFilterDropDown(int index) {
        Select selectOption = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        return String.valueOf(selectOption.getOptions().get(index).getText());
    }

    public String firstItemTitleInNameAtoZFilter() {
        return driver.findElement(firstItemTitleInFilterNameAtoZ).getText();
    }

    public String firstItemTitleInNameZtoAFilter() {
        return driver.findElement(firstItemTitleInFilterNameZtoA).getText();
    }

    public String lowestPriceInPriceLowToHighFilter() {
        return driver.findElement(lowestPriceInPriceLowToHighFilter).getText();
    }

    public String highestPriceInPriceHighToLowFilter() {
        return driver.findElement(highestPriceInPriceHighToLowFilter).getText();
    }

    public void backpackTitleClick() {
        driver.findElement(backpackTitle).click();
    }

    public String backpackAddToCartButtonDisplayed() {
        return driver.findElement(clickBackpackAddToCartButton).getText();
    }

    public void clickAddToCartButtonBackpack() {
        driver.findElement(clickBackpackAddToCartButton).click();
    }

    public boolean removeBackpackButtonDisplayed() {
        return driver.findElement(removeBackpackFromCartButton).isDisplayed();
    }

    public void clickRemoveButtonBackpack() {
        driver.findElement(removeBackpackFromCartButton).click();
    }

    public boolean yourCartIconDisplayed() {
        return driver.findElement(yourCartIcon).isDisplayed();
    }

    public void clickYourCartIcon() {
        driver.findElement(yourCartIcon).click();
    }

    public void clickAddToCartButtonBikeLight() {
        driver.findElement(addToCartButtonBikeLight).click();
    }

    public void clickAddToCartButtonJacket() {
        driver.findElement(addToCartButtonJacket).click();
    }

    public String yourCartSelectedItemsBadge() {
        return driver.findElement(yourCartItemsBadge).getText();
    }

}


