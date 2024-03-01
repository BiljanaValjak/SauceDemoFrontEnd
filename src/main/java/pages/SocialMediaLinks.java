package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SocialMediaLinks {
    private final WebDriver driver;
    private final By twitterLink = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a");
    private final By facebookLink = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a");
    private final By linkedInLink = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a");

    public SocialMediaLinks(WebDriver driver){
        this.driver = driver;
    }
    public List<WebElement> getAllSocialMediaLinks() {
        WebElement socialMediaLinks = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul"));
        return socialMediaLinks.findElements(By.tagName("a"));
    }
    public void twitterLink(){
        driver.findElement(twitterLink).click();
    }
    public void facebookLink(){
        driver.findElement(facebookLink).click();
    }
    public void linkedInLink(){
        driver.findElement(linkedInLink).click();
    }

}
