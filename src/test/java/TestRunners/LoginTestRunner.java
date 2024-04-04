package TestRunners;

import Config.Setup;
import Pages.LoginPage;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;

    @Test(priority = 1, description = "Admin cannot login with wrong credentials")
    public void loginWithWrongCreds() {
        loginPage = new LoginPage(webDriver);
        loginPage.doLogin("wrongUsername", "wrongPass");

        //assertion-1
        String txtActual = webDriver.findElement(By.className("oxd-alert-content-text")).getText();
        Assert.assertEquals(txtActual, "Invalid credentials");
    }

    @Test(priority = 2, description = "Admin can login with valid credentials")
    public void loginSuccess() throws IOException, ParseException {
        loginPage = new LoginPage(webDriver);

        if (System.getProperty("username")!=null && System.getProperty("password")!=null) {
            loginPage.doLogin(System.getProperty("username"), System.getProperty("password"));
        } else {
            loginPage.doLogin(Utils.getAdmin().get("username").toString(), Utils.getAdmin().get("password").toString());
        }

        //assertion-1
        Assert.assertTrue(webDriver.getCurrentUrl().contains("dashboard"));

        //assertion-2
        boolean isProfilePicExist = webDriver.findElement(By.className("oxd-userdropdown-img")).isDisplayed();
        Assert.assertTrue(isProfilePicExist);
    }

    @Test(priority = 3, description = "Admin can logout successfully")
    public void logOut() {
        loginPage = new LoginPage(webDriver);
        loginPage.doLogOut();

        //assertion-1
        String loginHeaderActual = webDriver.findElement(By.className("orangehrm-login-title")).getText();
        Assert.assertEquals(loginHeaderActual, "Login");
    }
}
