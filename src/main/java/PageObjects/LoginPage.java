package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;
    By email = By.xpath("//*[@placeholder='Email address']");
    By password = By.xpath("//*[@placeholder='Password']");
    By signBtn = By.xpath("//*[@type='submit']");

    public LoginPage(WebDriver driver) {this.driver=driver; }
    public WebElement enterEmail() { return driver.findElement(email);}

    public WebElement enterPassword(){return driver.findElement(password);}

    public WebElement clickSignButton() {return driver.findElement(signBtn);}



}
