package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class SingleItemReviewPage {

    private WebDriver driver;
    private By inventoryItem = By.id("inventory_item_container");
    private By selectedItemTitle = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]");
    private By selectedItemDescription = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]");
    private By selectedItemPrice = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]");
    private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By removeButton = By.id("remove-sauce-labs-backpack");
    private By yourCartItemsBadge = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    private By backToProductsLink = By.id("back-to-products");


    public SingleItemReviewPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean singleItemPageDisplayed(){
        return driver.findElement(inventoryItem).isDisplayed();
    }

    public String selectedItemTitleDisplayed(){
        return driver.findElement(selectedItemTitle).getText();
    }

    public String selectedItemDescriptionDisplayed(){
        return driver.findElement(selectedItemDescription).getText();
    }

    public String selectedItemPriceDisplayed(){
        return driver.findElement(selectedItemPrice).getText();
    }

    public String selectedItemTitleFontSize(){
        return driver.findElement(selectedItemTitle).getCssValue("font-size");
    }

    public String selectedItemTitleFontFamily(){
        return driver.findElement(selectedItemTitle).getCssValue("font-family");
    }

    public String selectedItemTitleColor(){
        Color titleColor = Color.fromString(driver.findElement(selectedItemTitle).getCssValue("color"));
        return titleColor.asHex();
    }

    public String selectedItemDescriptionFontSize(){
        return driver.findElement(selectedItemDescription).getCssValue("font-size");
    }

    public String selectedItemDescriptionFontFamily(){
        return driver.findElement(selectedItemDescription).getCssValue("font-family");
    }

    public String selectedItemDescriptionColor(){
        Color titleColor = Color.fromString(driver.findElement(selectedItemDescription).getCssValue("color"));
        return titleColor.asHex();
    }

    public String selectedItemPriceFontSize(){
        return driver.findElement(selectedItemPrice).getCssValue("font-size");
    }

    public String selectedItemPriceFontFontFamily(){
        return driver.findElement(selectedItemPrice).getCssValue("font-family");
    }

    public String selectedItemPriceColor(){
        Color titleColor = Color.fromString(driver.findElement(selectedItemPrice).getCssValue("color"));
        return titleColor.asHex();
    }

    public String selectedItemAddToCartButtonFontSize(){
        return driver.findElement(addToCartButton).getCssValue("font-size");
    }

    public String selectedItemAddToCartButtonFontFamily(){
        return driver.findElement(addToCartButton).getCssValue("font-family");
    }

    public String selectedItemAddToCartButtonColor(){
        Color titleColor = Color.fromString(driver.findElement(addToCartButton).getCssValue("color"));
        return titleColor.asHex();
    }

    public void selectedItemAddToCartButton(){
         driver.findElement(addToCartButton).click();
    }

    public void selectedItemRemoveButton(){
        driver.findElement(removeButton).click();
    }

    public String selectedItemRemoveButtonFontSize(){
        return driver.findElement(removeButton).getCssValue("font-size");
    }

    public String selectedItemRemoveButtonFontFamily(){
        return driver.findElement(removeButton).getCssValue("font-family");
    }

    public String selectedItemRemoveButtonColor(){
        Color titleColor = Color.fromString(driver.findElement(removeButton).getCssValue("color"));
        return titleColor.asHex();
    }

    public boolean yourCartBadge(){
        try{
            driver.findElement(yourCartItemsBadge).isDisplayed();
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

    public void clickBackToProductsLink(){
        driver.findElement(backToProductsLink).click();
    }
}
