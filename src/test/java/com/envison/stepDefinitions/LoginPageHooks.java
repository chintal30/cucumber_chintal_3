package com.envison.stepDefinitions;

import com.envison.pageObjects.LoginPage;
import com.envison.utility.BrowserFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginPageHooks{
    LoginPage lp=new LoginPage(BrowserFactory.openBrowser());
    @Given("user enters {string} as user id")
    public void user_enters_as_user_id(String string) {
        lp.enterUserName(string);
    }
    @Given("user enters {string} as password")
    public void user_enters_as_password(String string) {
        lp.enterPassword(string);
    }
    @When("user click on login button")
    public void user_click_on_login_button() {
        lp.clickLoginButton();
    }
    @Then("User  should see the home page title as {string}")
    public void user_should_see_the_home_page_title_as(String string) {
        String actualTitle=lp.getPageTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle,string);
    }
    @Then("User should see the error message as {string}")
    public void user_should_see_the_error_message_as(String string) {
        String errorMsg=lp.getInvalidLoginErrorMessage();
        Assert.assertEquals(errorMsg,string);
    }
}
