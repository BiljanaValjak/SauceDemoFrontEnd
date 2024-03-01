package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage {
    private WebDriver driver;
    private By checkoutYourInformationPageTitle = By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    public CheckoutYourInformationPage(WebDriver driver){
        this.driver = driver;
    }
    public String checkoutYourInformationTitle(){
        return driver.findElement(checkoutYourInformationPageTitle).getText();
    }
}
