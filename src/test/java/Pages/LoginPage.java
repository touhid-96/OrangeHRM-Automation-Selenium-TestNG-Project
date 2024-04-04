package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    @FindBy(name = "username")
    WebElement txtUsername;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(className = "oxd-button")
    WebElement btnLogin;

    @FindBy(className = "oxd-userdropdown-name")
    WebElement labelUsername;

    @FindBy(css = "[role=\"menuitem\"]")
    List<WebElement> dropDownUserMenu;

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void doLogin(String username, String password) {
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }

    public void doLogOut() {
        labelUsername.click();
        dropDownUserMenu.get(3).click();
    }
}
