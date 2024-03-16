package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SocialMediaLinks {

    private final WebDriver driver;
    private final By twitterLink = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a");
    private final By facebookLink = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a");
    private final By linkedInLink = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a");


    public SocialMediaLinks(WebDriver driver){
        this.driver = driver;
    }

    public String getAllSocialMediaLinks() {
        WebElement socialMediaLinks = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul"));
        socialMediaLinks.findElements(By.tagName("a"));
        return socialMediaLinks.getText();
    }

    public void twitterLink(){
        driver.findElement(twitterLink).click();
    }

    public String getHrefFromTwitterLink(){
        WebElement element = driver.findElement(twitterLink);
        return element.getAttribute("href");
    }

    public void facebookLink(){
        driver.findElement(facebookLink).click();
    }

    public String getHrefFromFacebookLink(){
        WebElement element = driver.findElement(facebookLink);
        return element.getAttribute("href");
    }

    public void linkedInLink(){
        driver.findElement(linkedInLink).click();
    }

    public String getHrefFromLinkedInLink(){
        WebElement element = driver.findElement(linkedInLink);
        return element.getAttribute("href");
    }

}
