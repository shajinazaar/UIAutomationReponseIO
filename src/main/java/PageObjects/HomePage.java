package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;
    public By SettingBtn = By.xpath("//a[7]//div[2]//div[1]//div[1]//i[1]");

    public HomePage(WebDriver driver) {this.driver=driver; }

    public WebElement clickSettingBtn() { return driver.findElement(SettingBtn);}

}
