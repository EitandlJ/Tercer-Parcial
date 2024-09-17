package stepDefinitions;

import pages.LoginPage;
import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonSteps
{
    @Given("I am in sauce demo web page")
    public void goSauceDemoWeb()
    {
        DriverManager.getDriver().driver.get("https://www.saucedemo.com/");
        DriverManager.getDriver().driver.manage().window().maximize();
    }
    LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
    @When("I set the user name text box with {string}")
    public void fillUsername(String userName)
    {
        loginPage.setUserNameTextBox(userName);
    }
    @And("I set the password text box with {string}")
    public void fillPassword(String password)
    {
        loginPage.setPasswordTextBox(password);
    }
    @And("I click on the login button")
    public void clickLogin()
    {
        loginPage.clickLogin();
    }

}
