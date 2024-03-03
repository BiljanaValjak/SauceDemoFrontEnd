package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class CheckoutCompletePage {

    private WebDriver driver;
    private By checkoutCompleteTitle = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private By completeHeader = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");
    private By completeTextMsg = By.xpath("//*[@id=\"checkout_complete_container\"]/div");
    private By backHomeButton = By.id("back-to-products");
    private By yourCartIcon = By.xpath("//*[@id=\"shopping_cart_container\"]/a");


    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String checkoutCompletePageTitle(){
        return driver.findElement(checkoutCompleteTitle).getText();
    }

    public String headerDisplayed(){
        return driver.findElement(completeHeader).getText();
    }

    public String headerFontSize(){
        return driver.findElement(completeHeader).getCssValue("font-size");
    }

    public String headerFontFamily(){
        return driver.findElement(completeHeader).getCssValue("font-family");
    }

    public String headerColor(){
        Color finishButtonColor = Color.fromString(driver.findElement(completeHeader).getCssValue("color"));
        return finishButtonColor.asHex();
    }

    public String textMessageDisplayed(){
        return driver.findElement(completeTextMsg).getText();
    }

    public String textMessageFontSize(){
        return driver.findElement(completeTextMsg).getCssValue("font-size");
    }

    public String textMessageFontFamily(){
        return driver.findElement(completeTextMsg).getCssValue("font-family");
    }

    public String textMessageColor(){
        Color finishButtonColor = Color.fromString(driver.findElement(completeTextMsg).getCssValue("color"));
        return finishButtonColor.asHex();
    }

    public boolean yourCartCountIcon(){
        try {
            driver.findElement(yourCartIcon).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickYourCartIcon(){
        driver.findElement(yourCartIcon).click();
    }

    public String backHomeButton(){
        return driver.findElement(backHomeButton).getText();
    }

    public String backHomeButtonFontSize(){
        return driver.findElement(backHomeButton).getCssValue("font-size");
    }

    public String backHomeButtonFontFamily(){
        return driver.findElement(backHomeButton).getCssValue("font-family");
    }

    public String backHomeButtonColor(){
        Color finishButtonColor = Color.fromString(driver.findElement(backHomeButton).getCssValue("color"));
        return finishButtonColor.asHex();
    }

    public void clickBackHomeButton(){
        driver.findElement(backHomeButton).click();
    }

}
