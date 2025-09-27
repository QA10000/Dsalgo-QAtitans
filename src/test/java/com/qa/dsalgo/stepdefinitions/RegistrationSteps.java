package com.qa.dsalgo.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.RegisterPage;
import com.qa.dsalgo.pages.ScenarioContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CommonUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrationSteps {
	private WebDriver driver;
	ScenarioContext scenariocontext;
	RegisterPage registerpage;
	Background background;
	private static final Logger logger = LogManager.getLogger(RegistrationSteps.class);

	public RegistrationSteps(ScenarioContext scenariocontext) {
		this.driver = Hooks.getDriver();
		this.background = new Background(driver);
		this.scenariocontext = scenariocontext;
		this.registerpage = new RegisterPage(driver);
		this.registerpage.setScenarioContext(scenariocontext);
	}

	@Given("The user is on the DSAlgo portal")
	public void the_user_is_on_the_ds_algo_portal() {
		background.launchUrl();
	}

	@When("The user clicks {string} button on welcome page")
	public void the_user_clicks(String string) {
		background.ClickGetStarted();
	}

	@Then("The user lands on the home page of DSAlgo portal")
	public void the_user_lands_on_the_home_page_of_ds_algo_portal() {
		logger.info("user lands on home page");
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
		logger.info("Verifying that the user lands on the Registration page");
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}

	@Given("The user is on the register page of the portal")
	public void the_user_is_on_the_register_page_of_the_portal() {
		driver.get(CommonUtils.REGISTER_LINK);
		driver.get(CommonUtils.APP_URL);
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
	public void the_user_submits_the_registration_form_with_mismatched_passwords(DataTable dataTable) {
		registerpage.enterInvalidData(dataTable);
	}

	@Then("The user sees {string} error message")
	public void the_user_sees_error_message(String expectedMessage) {
		String actualMessage = registerpage.getMismatchMessage();
		logger.info("Verifying that the user sees error message");
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}

	@When("The user clicks Register button after entering valid values from {string}")
	public void the_user_clicks_register_button_after_entering_valid_values_from(String file) {
		registerpage.enterValidDatafrmSheet(file);
	}

	@Then("The user lands on the DSAlgo Home portal with Success Message {string}")
	public void the_user_lands_on_the_ds_algo_home_portal_with_success_message(String expectedMessage) {
		String actualMessage = registerpage.getSuccessMessage();
		System.out.println("Getting username from context: " + scenariocontext.get("registeredUsername")
				+ " | Context: " + scenariocontext.hashCode());
		Object usernameObj = scenariocontext.get("registeredUsername");
		if (usernameObj == null) {
			throw new RuntimeException("registeredUsername is null in ScenarioContext!");
		}

		String username = (String) usernameObj;

		expectedMessage = expectedMessage.replace("<username>", username);
		logger.info("Verifying that the user sees success message on home page");
		Assert.assertEquals(actualMessage, expectedMessage, "Success message mismatch!");
	}

	@Then("The user sees {string} label on the top left corner of the Register page")
	public void the_user_sees_label_on_the_top_left_corner_of_the_register_page(String expectedLabel) {
		String actualLabel = registerpage.getNumpyNinjaLinkText();
		logger.info("Verifying that the user sees NumpaiNinja logo");
		Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
	}

	@Then("The user sees {string} link on  the top right corner of the  Register page")
	public void the_user_sees_link_on_the_top_right_corner_of_the_register_page(String expectedLabel) {
		String actualLabel = registerpage.getRegisterLinkText();
		logger.info("Verifying that the user sees Register link");
		Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
	}

	@Then("The user sees {string} link on the top right most corner of the Register page")
	public void the_user_sees_link_on_the_top_right_most_corner_of_the_register_page(String expectedLabel) {
		String actualLabel = registerpage.getSigninLinkText();
		logger.info("Verifying that the user sees Signin Link");
		Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");

	}

	@Then("The user sees the {string} select box on the top left corner of the Register module page")
	public void the_user_sees_the_select_box_on_the_top_left_corner_of_the_register_module_page(String expectedLabel) {
		String actualLabel = registerpage.getDataStructureLblText();
		logger.info("Verifying that the user sees label for  Data Structure dropdown");
		Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
	}

}