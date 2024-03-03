package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class CheckoutYourInformationPage {
    private WebDriver driver;
    private By checkoutYourInformationPageTitle = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By errorMessageContainer = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]");
    private By errorMessage = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3");
    private By xButtonErrorMessage = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3/button");
    private By cancelButton = By.id("cancel");
    private By continueButton = By.id("continue");

    public CheckoutYourInformationPage(WebDriver driver){
        this.driver = driver;
    }
    public String checkoutYourInformationTitle(){
        return driver.findElement(checkoutYourInformationPageTitle).getText();
    }
    public void enterFirstName(String firstName){
        if(firstName.length() > 20){
            throw new IllegalArgumentException("Maximum number of characters must be lower than 20");
        }
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public String firstNameFieldFontSize(){
        return driver.findElement(firstNameField).getCssValue("font-size");
    }
    public String firstNameFieldFontFamily(){
        return driver.findElement(firstNameField).getCssValue("font-family");
    }
    public String firstNameBottomBorderColor(){
        Color firstNameBottomBorderColor = Color.fromString(driver.findElement(firstNameField).getCssValue("border-bottom-color"));
        return firstNameBottomBorderColor.asHex();
    }
    public void enterLastName(String lastName){
        if(lastName.length() > 20){
            throw new IllegalArgumentException("Maximum number of characters must be lower than 20");
        }
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public String lastNameFieldFontSize(){
        return driver.findElement(lastNameField).getCssValue("font-size");
    }
    public String lastNameFieldFontFamily(){
        return driver.findElement(lastNameField).getCssValue("font-family");
    }
    public String lastNameBottomBorderColor(){
        Color lastNameBottomBorderColor = Color.fromString(driver.findElement(lastNameField).getCssValue("border-bottom-color"));
        return lastNameBottomBorderColor.asHex();
    }
    public void enterZipCode(String zipCode){
        String specialCharacters = "!@#$%^&*(){}[]?><";
        if(zipCode.contains(specialCharacters))
            throw new IllegalArgumentException("Zip Code must not contain special characters");
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }
    public String zipCodeFieldFontSize(){
        return driver.findElement(zipCodeField).getCssValue("font-size");
    }
    public String zipCodeFieldFontFamily(){
        return driver.findElement(zipCodeField).getCssValue("font-family");
    }
    public String zipCodeBorderBottomColor(){
        Color zipCodeBorderBottomColor = Color.fromString(driver.findElement(zipCodeField).getCssValue("border-bottom-color"));
        return zipCodeBorderBottomColor.asHex();
    }
    public String errorMessage(){
        return driver.findElement(errorMessage).getText();
    }
    public void xButtonErrorMessage(){
        driver.findElement(xButtonErrorMessage).click();
    }
    public boolean errorMsgDisplayed(){
        try {
            driver.findElement(errorMessage).isDisplayed();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
    public String errorMessageContainerColor(){
        Color errorMessageContainerColor = Color.fromString(driver.findElement(errorMessageContainer).getCssValue("background-color"));
        return errorMessageContainerColor.asHex();
    }
    public void clickCancelButton(){
        driver.findElement(cancelButton).click();
    }
    public String cancelButtonFontSize(){
        return driver.findElement(cancelButton).getCssValue("font-size");
    }
    public String cancelButtonFontFamily(){
        return driver.findElement(cancelButton).getCssValue("font-family");
    }
    public String cancelButtonColor(){
        Color cancelButtonColor = Color.fromString(driver.findElement(cancelButton).getCssValue("background-color"));
        return cancelButtonColor.asHex();
    }
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
    public String continueButtonFontSize(){
        return driver.findElement(continueButton).getCssValue("font-size");
    }
    public String continueButtonFontFamily(){
        return driver.findElement(zipCodeField).getCssValue("font-family");
    }
    public String continueButtonColor(){
        Color continueButtonColor = Color.fromString(driver.findElement(continueButton).getCssValue("background-color"));
        return continueButtonColor.asHex();
    }

}
