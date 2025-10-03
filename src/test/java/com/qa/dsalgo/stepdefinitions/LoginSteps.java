package com.qa.dsalgo.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CommonUtils;


public class LoginSteps {
	private WebDriver driver;
	Background background;
	LoginPage loginpage;
	
	public LoginSteps() {
		driver = Hooks.getDriver();
		background = new Background(driver);
		loginpage = new LoginPage(driver);
	}
	
	@Given("The user is on the home page of the portal")
	public void the_User_Is_On_The_Home_Page_Of_The_Portal() {
		driver.get(CommonUtils.HOME_URL);
	}
	
	@Then("The user lands on the DS Algo Home portal with success message {string}")
	public void the_user_lands_on_the_ds_algo_home_portal_with_success_message(String message) {
		String expectedMessage = "You are logged in";
		String actualMessage = loginpage.getSuccessMessage(); 
		Assert.assertEquals(actualMessage, expectedMessage, "Success message mismatch!");
	}
	
	@When("The user clicks login button after entering valid values from {string}")
	public void the_user_clicks_login_button_after_entering_valid_values_from_Sheet(String SheetName) {
		loginpage.clickLoginLink();
	    loginpage.validateLogin(SheetName);
	}

	@Given("The user is on the Login page of the portal")
	public void The_user_is_on_the_Login_page_of_the_portal() {
		driver.get(CommonUtils.LOGIN_URL);
	}
	
	@When("The user enters invalid username and password in the textboxes")
	   public void The_user_enters_invalid_username_and_password_in_the_textboxes(io.cucumber.datatable.DataTable dataTable) {
		loginpage.clickLoginLink();
		loginpage.validateLogin(dataTable);
	}
	
	@Then ("The user should see an error message")
	public void The_user_should_see_an_error_message(){
		driver.quit();
	}
	
	@When("The user clicks on the Signin link on home page")
	public void the_user_clicks_on_the_signin_link_on_home_page() {
		loginpage.clickLoginLink();
	}
	
	@Then("The user sees {string} label on the top left corner of the {string} page")
	public void theUserSeesLabelOnTheTopLeftCornerOfThePage(String expectedLabel, String pageName) {
		String actualLabel = loginpage.getNumpyNinjaLinkText();
        Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
    }
	
	@Then("The user sees the {string} dropdown box on the top left corner of the {string} page")
	public void theUserSeesTheDropdownBoxOnTheTopLeftCornerOfThePage(String expectedLabel, String pageName) {
		String actualLabel = loginpage.getDataStructureDropdownText();
        Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
	}
	
	@Then("The user sees the {string} link on the top right corner of the {string} page")
	public void theUserSeesTheLinkOnTheTopRightCornerOfThePage(String expectedLabel, String pageName) {
		String actualLabel = loginpage.getRegisterLinkText();
        Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
	}
	
	@Then("The user sees {string} link on  the top right most corner of the Login page")
	public void The_user_sees_link_on_the_top_right_most_corner_of_the_Login_page (String expectedLabel) {
    String actualLabel = loginpage. getSigninLinkText();
        Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
	}

	@Then("The user is able to sign out with message {string}")
	public void theUserIsAbleToSignOutWithMessage(String string) {
		loginpage.logout();
		String expectedMessage = "Logged out successfully";
		String actualMessage = loginpage.getLogoutMessage(); 
		Assert.assertEquals(actualMessage, expectedMessage, "Success message mismatch!");
	}
	
}

