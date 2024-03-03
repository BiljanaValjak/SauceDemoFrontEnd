package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class CheckoutOverviewPage {

    private WebDriver driver;
    private By checkoutOverviewPageTitleDisplayed = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private By descriptionLabel = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[2]");
    private By quantityLabel = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[1]");
    private By selectedItemDisplay = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]");
    private By selectedItemQuantity = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[1]");
    private By yourCartItemsCountBadge = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    private By firstItemTitleInYourCart = By.xpath("//*[@id=\"item_5_title_link\"]/div");
    private By firstItemDescriptionInYourCart = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[1]");
    private By firstItemPriceInYourCart = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private By paymentInformationLabel = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[1]");
    private By cardnNumber = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[2]");
    private By shippingInformationLabel = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[3]");
    private By deliveryMethod = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[4]");
    private By priceTotalLabel = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5]");
    private By itemTotalPrice = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]");
    private By taxTotal = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");
    private By totalLabel = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]");
    private By cancelButton = By.id("cancel");
    private By finishButton = By.id("finish");


    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String checkOutOverviewTitleDisplayed() {
        return driver.findElement(checkoutOverviewPageTitleDisplayed).getText();
    }

    public boolean descriptionLabelDisplayed() {
        return driver.findElement(descriptionLabel).isDisplayed();
    }

    public boolean quantityLabelDisplayed() {
        return driver.findElement(quantityLabel).isDisplayed();
    }

    public boolean selectedItemReview(){
        return driver.findElement(selectedItemDisplay).isDisplayed();
    }

    public String selectedItemQuantity() {
        return driver.findElement(selectedItemQuantity).getText();
    }

    public boolean yourCartItemsCountBadge() {
           return driver.findElement(yourCartItemsCountBadge).isDisplayed();
    }

    public String yourCartCountIcon(){
        return driver.findElement(yourCartItemsCountBadge).getText();
    }

    public String yourCartCountItemBadgeColor(){
        Color badgeColor = Color.fromString(driver.findElement(yourCartItemsCountBadge).getCssValue("background-color"));
        return badgeColor.asHex();
    }

    public String firstItemInYourCartTitle(){
        return driver.findElement(firstItemTitleInYourCart).getText();
    }

    public String firstItemInYourCartTitleFontSize(){
        return driver.findElement(firstItemTitleInYourCart).getCssValue("font-size");
    }

    public String firstItemInYourCartTitleFontFamily(){
        return driver.findElement(firstItemTitleInYourCart).getCssValue("font-family");
    }

    public String firstItemInYourCartTitleColor(){
        Color finishButtonColor = Color.fromString(driver.findElement(firstItemTitleInYourCart).getCssValue("color"));
        return finishButtonColor.asHex();
    }

    public String firstItemInYourCartDescription(){
        return driver.findElement(firstItemDescriptionInYourCart).getText();
    }

    public String firstItemInYourCartDescriptionFontSize(){
        return driver.findElement(firstItemDescriptionInYourCart).getCssValue("font-size");
    }

    public String firstItemInYourCartDescriptionFontFamily(){
        return driver.findElement(firstItemDescriptionInYourCart).getCssValue("font-family");
    }

    public String firstItemInYourCartDescriptionColor(){
        Color finishButtonColor = Color.fromString(driver.findElement(firstItemDescriptionInYourCart).getCssValue("color"));
        return finishButtonColor.asHex();
    }

    public String firstItemInYourCartPrice(){
        return driver.findElement(firstItemPriceInYourCart).getText();
    }

    public String firstItemInYourCartPriceFontSize(){
        return driver.findElement(firstItemPriceInYourCart).getCssValue("font-size");
    }

    public String firstItemInYourCartPriceFontFamily(){
        return driver.findElement(firstItemPriceInYourCart).getCssValue("font-family");
    }

    public String firstItemInYourCartPriceColor(){
        Color finishButtonColor = Color.fromString(driver.findElement(firstItemPriceInYourCart).getCssValue("color"));
        return finishButtonColor.asHex();
    }

    public void clickCancelButton(){
        driver.findElement(cancelButton).click();
    }

    public String cancelButtonColor(){
        Color cancelButtonColor = Color.fromString(driver.findElement(cancelButton).getCssValue("background-color"));
        return cancelButtonColor.asHex();
    }

    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }

    public String finishButtonFontSize(){
        return driver.findElement(finishButton).getCssValue("font-size");
    }

    public String finishButtonFontFamily(){
        return driver.findElement(finishButton).getCssValue("font-family");
    }

    public String finishButtonColor(){
        Color finishButtonColor = Color.fromString(driver.findElement(finishButton).getCssValue("background-color"));
        return finishButtonColor.asHex();
    }

    public String paymentInformationLabel(){
        return driver.findElement(paymentInformationLabel).getText();
    }

    public String paymentInformationFontSize(){
        return driver.findElement(paymentInformationLabel).getCssValue("font-size");
    }

    public String paymentInformationFontFamily(){
        return driver.findElement(paymentInformationLabel).getCssValue("font-family");
    }

    public String cardInformationLabel(){
        return driver.findElement(cardnNumber).getText();
    }

    public String cardInformationFontSize(){
        return driver.findElement(cardnNumber).getCssValue("font-size");
    }

    public String cardInformationFontFamily(){
        return driver.findElement(cardnNumber).getCssValue("font-family");
    }

    public String shippingInformationLabel(){
        return driver.findElement(shippingInformationLabel).getText();
    }

    public String shippingInformationFontSize(){
        return driver.findElement(shippingInformationLabel).getCssValue("font-size");
    }

    public String shippingInformationFontFamily(){
        return driver.findElement(shippingInformationLabel).getCssValue("font-family");
    }

    public String deliveryMethodLabel(){
        return driver.findElement(deliveryMethod).getText();
    }

    public String deliveryMethodFontSize(){
        return driver.findElement(deliveryMethod).getCssValue("font-size");
    }

    public String deliveryMethodFontFamily(){
        return driver.findElement(deliveryMethod).getCssValue("font-family");
    }

    public String priceTotalLabel(){
        return driver.findElement(priceTotalLabel).getText();
    }

    public String priceTotalFontSize(){
        return driver.findElement(priceTotalLabel).getCssValue("font-size");
    }

    public String priceTotalFontFamily(){
        return driver.findElement(priceTotalLabel).getCssValue("font-family");
    }

    public String itemTotalPriceLabel(){
        return driver.findElement(itemTotalPrice).getText();
    }

    public String itemTotalPriceFontSize(){
        return driver.findElement(itemTotalPrice).getCssValue("font-size");
    }

    public String itemTotalPriceFontFamily(){
        return driver.findElement(itemTotalPrice).getCssValue("font-family");
    }

    public String taxTotalLabel(){
        return driver.findElement(taxTotal).getText();
    }

    public String taxTotalFontSize(){
        return driver.findElement(taxTotal).getCssValue("font-size");
    }

    public String taxTotalFontFamily(){
        return driver.findElement(taxTotal).getCssValue("font-family");
    }

    public String totalLabel(){
        return driver.findElement(totalLabel).getText();
    }

    public String totalLabelFontSize(){
        return driver.findElement(totalLabel).getCssValue("font-size");
    }

    public String totalLabelFontFamily(){
        return driver.findElement(totalLabel).getCssValue("font-family");
    }

}