package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingPage {

    WebDriver driver;
    public By UsersBtn = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/a[2]/div[1]/div[1]/span[1]");
    public By AddUserBtn = By.xpath("//div[@class='dls-shrink dls-me-12']//span[@class='dls-txt-button dls-inline-flex dls-items-center'][normalize-space()='Add User']");
    By EnterEmail = By.xpath("//*[@placeholder='Email Address']");
    By AddBtn = By.xpath("//*[@class='dls-txt-button dls-inline-flex dls-items-center' and text()='Add']");

    By AdvancedRestrictionsBtn = By.xpath("//*[@class='text-subtitle-2 highlight-toggle-text-on-hover' and text()='Advanced Restrictions']");

    By CheckRestrictDataExport = By.xpath("//div[@class='v-selection-control__input']/input[@value='restrict_data_export']");
    By CheckRestrictContactDeletion = By.xpath("//div[@class='v-selection-control__input']/input[@value='restrict_contact_deletion']");

    public By UserAddedMessage = By.xpath("//span[@class='dls-text-text-primary dls-txt-body' and normalize-space(text())='User has been invited to workspace']");

    public By invitationAlreadySentMessage = By.xpath("//span[@class='dls-text-text-primary dls-txt-body' and normalize-space(text())='Invitation has already been sent and is not accepted.']");
    public SettingPage(WebDriver driver) {this.driver=driver; }

    public WebElement clickUsersBtn() { return driver.findElement(UsersBtn);}

    public WebElement clickAddUserBtn() {return driver.findElement(AddUserBtn);}

    public WebElement enterEmail() {return driver.findElement(EnterEmail);}

    public WebElement clickAdvancedRestriction() {return driver.findElement(AdvancedRestrictionsBtn);}

    public WebElement clickRestrictDataExport() {return driver.findElement(CheckRestrictDataExport);}
    public WebElement clickRestrictContactDeletion() {return driver.findElement(CheckRestrictContactDeletion);}
    public WebElement clickAddBtn() {return driver.findElement(AddBtn);}

    public WebElement userAddedMessagePopup() {return driver.findElement(UserAddedMessage);}

    public WebElement invitationAlreadySentMessagePopup() {return driver.findElement(invitationAlreadySentMessage);}

}
