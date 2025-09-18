package com.qa.dsalgo.stepdefinitions;

import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.RegisterPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;
import utilities.CommonUtils;
import utilities.ExcelReader;

public class RegistrationSteps {
	private WebDriver driver;
	RegisterPage registerpage;
	Background background;
	private static final Logger logger = LogManager.getLogger(RegistrationSteps.class);

	public RegistrationSteps() {
		driver = Hooks.getDriver();
		background = new Background(driver);
		registerpage = new RegisterPage(driver);
	}

	@Given("The user is on the DSAlgo portal")
	public void the_user_is_on_the_ds_algo_portal() {
		//background.launchUrl();
		driver.get(CommonUtils.APP_URL);
	}

	@When("The user clicks {string} button on welcome page")
	public void the_user_clicks(String string) {
		background.ClickGetStarted();
	}

	@Then("The user lands on the home page of DSAlgo portal")
	public void the_user_lands_on_the_home_page_of_ds_algo_portal() {
		logger.info("user lands on algo portal home page");
		background.verifyHomePageIsDisplayed();
	}


	@When("The user clicks on the Register link on home page")
	public void the_user_clicks_on_the_register_link_on_home_page() {
		registerpage.clickRegisterLink();
	}

	@Then("The user lands on Register page")
	public void the_user_lands_on_register_page() {
		String expectedTitle = "Registration";
		String actualTitle = registerpage.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}

	@Given("The user is on the register page of the portal")
	public void the_user_is_on_the_register_page_of_the_portal() {
		driver.get("https://dsportalapp.herokuapp.com/register");
	}

	@When("The user enters {string} in username text box on register page")
	public void the_user_enters_in_username_text_box_on_register_page(String username) {
		registerpage.enterUsername(username);
	}

	@When("The user enters {string} in password text box on register page")
	public void the_user_enters_in_password_text_box_on_register_page(String password) {
		registerpage.enterPassword(password);
	}

	@When("The user enters {string} in confirm password text box on register page")
	public void the_user_enters_in_confirm_password_text_box_on_register_page(String confirmpassword) {
		registerpage.enterConfirmPassword(confirmpassword);

	}

	@When("The user clicks the Register button")
	public void the_user_clicks_the_register_button() {
		registerpage.submitForm();
	}

	@When("The user submits the registration form with mismatched passwords:")
	public void the_user_submits_the_registration_form_with_mismatched_passwords(
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> users = dataTable.asMaps(String.class, String.class); // are taking data from
																						// datatable in feature file
																						// then putting it in map then
																						// we are taking from map and
																						// then putting into form
		for (Map<String, String> user : users) {
			String username = user.get("username");
			String password = user.get("password");
			String confirmpassword = user.get("confirmpassword");
			registerpage.enterUsername(username);
			registerpage.enterPassword(password);
			registerpage.enterConfirmPassword(confirmpassword);
			registerpage.submitForm();
		}
	}

	@Then("The user sees {string} error message")
	public void the_user_sees_error_message(String expectedMessage) {
		String actualMessage = registerpage.getMismatchMessage();
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}

	@Then("The user sees {string} on the Register page")
	public void the_user_sees_on_the_register_page(String string) {
	}

	@When("The user clicks Register button after entering valid values from {string}")
	public void the_user_clicks_register_button_after_entering_valid_values_from(String string) {
		String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/testdata.xlsx";
		Map<String, String> testData = ExcelReader.readData(filePath, string);
		String username = testData.get("username");// getting input from datasheet
		String password = testData.get("password");
		String confirmedPassword = testData.get("confirmpassword");
		ScenarioContext.set("registeredUsername", username);
		registerpage.enterUsername(username);
		registerpage.enterPassword(password);
		registerpage.enterConfirmPassword(confirmedPassword);
		registerpage.submitForm();
	}

	@Then("The user lands on the DSAlgo Home portal with Success Message {string}")
	public void the_user_lands_on_the_ds_algo_home_portal_with_success_message(String expectedMessage) {
		String actualMessage = registerpage.getSuccessMessage();
		String registeredUsername = ScenarioContext.get("registeredUsername").toString();
		expectedMessage = expectedMessage.replace("<username>", registeredUsername);
		Assert.assertEquals(actualMessage, expectedMessage, "Success message mismatch!");
	}

	@When("The user clicks {string} button without entering username and entering valid password")
	public void the_user_clicks_button_without_entering_username_and_entering_valid_password(String string) {

	}

	@Then("The error message {string} should be displayed")
	public void the_error_message_should_be_displayed(String string, io.cucumber.datatable.DataTable dataTable) {

	}

	@When("The user clicks Register button after entering {string} values in passwordtext box and valid username")
	public void the_user_clicks_register_button_after_entering_values_in_passwordtext_box_and_valid_username(
			String string) {

	}


	 

}
