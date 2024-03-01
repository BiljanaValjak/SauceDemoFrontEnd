package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class LoginPage {

    private WebDriver driver;
    private By loginPageTitle = By.className("login_logo");
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    private By xButtonErrorMsg = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/button");
    private By errorMessageContainer = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean loginPageTitleDisplayed(){
        return driver.findElement(loginPageTitle).isDisplayed();
    }
    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public boolean errorMsgDisplayed(){
        try {
            driver.findElement(errorMessage).isDisplayed();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
    public String errorMessageDisplayed(){
        return driver.findElement(errorMessage).getText();
    }
    public void xButtonErrorMessage(){
        driver.findElement(xButtonErrorMsg).click();
    }
    public String usernameFieldFontSize(){
        return driver.findElement(usernameField).getCssValue("font-size");
    }
    public String usernameFieldFontFamily(){
        return driver.findElement(usernameField).getCssValue("font-family");
    }
    public String usernameBorderBottomColor(){
        Color loginButtonBackgroundColour = Color.fromString(driver.findElement(usernameField).getCssValue("border-bottom-color"));
        return loginButtonBackgroundColour.asHex();
    }
    public String passwordFieldFontSize(){
        return driver.findElement(passwordField).getCssValue("font-size");
    }
    public String passwordFieldFontFamily(){
        return driver.findElement(passwordField).getCssValue("font-family");
    }
    public String passwordBorderBottomColor(){
        Color loginButtonBackgroundColour = Color.fromString(driver.findElement(passwordField).getCssValue("border-bottom-color"));
        return loginButtonBackgroundColour.asHex();
    }
    public String loginButtonFontSize(){
        return driver.findElement(loginButton).getCssValue("font-size");
    }
    public String loginButtonFontFamily(){
        return driver.findElement(loginButton).getCssValue("font-family");
    }
    public String loginButtonColor(){
        Color loginButtonBackgroundColour = Color.fromString(driver.findElement(loginButton).getCssValue("background-color"));
        return loginButtonBackgroundColour.asHex();
    }
    public String errorMessageContainerColor(){
        Color loginButtonBackgroundColour = Color.fromString(driver.findElement(errorMessageContainer).getCssValue("background-color"));
        return loginButtonBackgroundColour.asHex();
    }

}
