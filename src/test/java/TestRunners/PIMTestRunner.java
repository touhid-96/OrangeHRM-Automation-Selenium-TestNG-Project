package TestRunners;

import Config.EmployeeModel;
import Config.Setup;
import Pages.LoginPage;
import Pages.PIMPage;
import Utils.Utils;
import Utils.PasswordGenerator;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class PIMTestRunner extends Setup {
    PIMPage pimPage;

    @BeforeTest
    public void login() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.doLogin("Admin", "admin123");
    }

    @Test(priority = 1, description = "Admin cannot create employee with less than 7 character password")
    public void createEmployeeWithShortPass() throws InterruptedException {
        pimPage = new PIMPage(webDriver);

        //get info
        String firstName = Utils.getFakerInfo().get("firstName").toString();
        String lastName = Utils.getFakerInfo().get("lastName").toString();
        String username = Utils.getFakerInfo().get("username").toString();
        String password = PasswordGenerator.generatePassword(6);

        //employee creation
        pimPage.createEmployeeFail(
                firstName,
                lastName,
                username,
                password
        );

        //assertion-1
        WebElement warningElement = webDriver.findElements(By.className("oxd-input-group__message")).get(0);

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(warningElement));

        Assert.assertTrue(warningElement.getText().contains("Should have at least 7 characters"));
    }

    @Test(priority = 2, description = "Admin can create new employee")
    public void createEmployee() throws InterruptedException, IOException, ParseException {
        pimPage = new PIMPage(webDriver);

        //get info
        String firstName = Utils.getFakerInfo().get("firstName").toString();
        String lastName = Utils.getFakerInfo().get("lastName").toString();
        String username = Utils.getFakerInfo().get("username").toString();
        String password = PasswordGenerator.generatePassword(8);

        //employee creation
        pimPage.createEmployee(
                firstName,
                lastName,
                username,
                password
        );

        //assertion-1
        WebElement headerElement = webDriver.findElement(By.xpath("//h6[text()=\"Personal Details\"]"));
        WebElement empIDElement = webDriver.findElements(By.className("oxd-input")).get(4);
        //WebElement empIDElement = webDriver.findElements(By.xpath("//input[contains(@class,'oxd-input')]")).get(4);


        //waiter
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(headerElement));
        wait.until(ExpectedConditions.visibilityOf(empIDElement));


        String txtActual = headerElement.getText();
        Assert.assertEquals(txtActual, "Personal Details");

        //save employee data
        String empId = empIDElement.getAttribute("value");
        System.out.println("-----------------------------------------------------"+empId);
        EmployeeModel empModel = new EmployeeModel();
        empModel.setFirstName(firstName);
        empModel.setLastName(lastName);
        empModel.setUsername(username);
        empModel.setPassword(password);
        empModel.setEmpID(empId);

        Utils.saveEmployee(empModel);
    }
}
