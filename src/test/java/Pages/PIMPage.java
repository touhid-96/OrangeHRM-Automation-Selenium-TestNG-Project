package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMPage {
    @FindBy(className = "oxd-main-menu-item")
    List<WebElement> menuItems;

    @FindBy(className = "oxd-button")
    List<WebElement> buttons;

    @FindBy(name = "firstName")
    WebElement txtfirstName;

    @FindBy(name = "lastName")
    WebElement txtlastName;

    @FindBy(className = "oxd-switch-input")
    WebElement toggleButton;

    @FindBy(className = "oxd-input")
    List<WebElement> txtFields;

    public PIMPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void createEmployee(String firstName, String lastName, String username, String password) throws InterruptedException {
        menuItems.get(1).click();   //click PIM menu
        Thread.sleep(2000);
        buttons.get(2).click();     //click Add button
        Thread.sleep(2000);

        txtfirstName.sendKeys(firstName);
        txtlastName.sendKeys(lastName);

        toggleButton.click();

        txtFields.get(5).sendKeys(username);
        txtFields.get(6).sendKeys(password);
        txtFields.get(7).sendKeys(password);    //confirm password

        buttons.get(1).click();     //submit button
    }

    public void createEmployeeFail(String firstName, String lastName, String username, String password) throws InterruptedException {
        menuItems.get(1).click();   //click PIM menu
        Thread.sleep(2000);
        buttons.get(2).click();     //click Add button
        Thread.sleep(2000);

        txtfirstName.sendKeys(firstName);
        txtlastName.sendKeys(lastName);

        toggleButton.click();

        txtFields.get(5).sendKeys(username);
        txtFields.get(6).sendKeys(password);
        txtFields.get(7).sendKeys(password);    //confirm password

        //buttons.get(1).click();     //cancel button
    }
}
