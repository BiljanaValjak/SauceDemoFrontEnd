package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class YourCartPage {

    private WebDriver driver;
    private By yourCartPageDisplayed = By.className("title");
    private By descriptionLabel = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[2]");
    private By quantityLabel = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[1]");
    private By selectedItemQuantity = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]");
    private By yourCartItemsCountBadge = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    private By firstItemTitleInYourCart = By.xpath("//*[@id=\"item_5_title_link\"]/div");
    private By firstItemDescriptionInYourCart = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]");
    private By firstItemPriceInYourCart = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private By firstItemRemoveButton = By.id("remove-sauce-labs-fleece-jacket");
    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");


    public YourCartPage(WebDriver driver){
        this.driver = driver;
    }

    public String yourCartPageDisplayed(){
        return driver.findElement(yourCartPageDisplayed).getText();
    }

    public boolean descriptionLabelDisplayed(){
        return driver.findElement(descriptionLabel).isDisplayed();
    }

    public boolean quantityLabelDisplayed(){
        return driver.findElement(quantityLabel).isDisplayed();
    }

    public String selectedItemQuantity(){
        return driver.findElement(selectedItemQuantity).getText();
    }

    public boolean yourCartItemsCountBadge(){
        try{
            driver.findElement(yourCartItemsCountBadge).isDisplayed();
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

    public String firstItemInYourCartTitle(){
        return driver.findElement(firstItemTitleInYourCart).getText();
    }

    public String firstItemInYourCartDescription(){
        return driver.findElement(firstItemDescriptionInYourCart).getText();
    }

    public String firstItemInYourCartPrice(){
        return driver.findElement(firstItemPriceInYourCart).getText();
    }

    public String removeButtonFirstItemInYourCart(){
        return driver.findElement(firstItemRemoveButton).getText();
    }

    public void clickRemoveButtonFirstItem(){
        driver.findElement(firstItemRemoveButton).click();
    }

    public void continueShoppingButton(){
        driver.findElement(continueShoppingButton).click();
    }

    public void checkoutButton(){
        driver.findElement(checkoutButton).click();
    }

}
