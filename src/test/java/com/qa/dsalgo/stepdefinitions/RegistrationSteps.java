package com.qa.dsalgo.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.dsalgo.base.DriverScripts;
import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.RegisterPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;
import utilities.ScenarioContext;

import com.qa.dsalgo.pages.RegisterPage;

public class RegistrationSteps extends DriverScripts {

	Background background;
    private static final Logger logger = LogManager.getLogger(RegistrationSteps.class);


	@Given("The user is on the DSAlgo portal")
	public void the_user_is_on_the_ds_algo_portal() {
		initializeApplication();// Initialize the page object with the current driver
		background = new Background(driver); // driver must not be null
	}

	@When("The user clicks {string}")
		public void the_user_clicks(String string) {
	background = new Background(driver); // driver must not be null
	background.ClickGetStarted();
}
	@Then("user logs in")
	public void user_logs_in() {
   background = new Background(driver); // driver must not be null
   background.userLoggedin();
	}
		    
		
	@Then("The user lands on the home page of DSAlgo portal")
	public void the_user_lands_on_the_home_page_of_ds_algo_portal() {
		logger.info("user lands on algo portal home page" );
		RegisterPage registerpage = new RegisterPage(driver);
		String expectedTitle = "NumpyNinja";
		String actualTitle = registerpage.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}

	@Given("The user is on the home page of the portal")
	public void the_user_is_on_the_home_page_of_the_portal() {
		driver.get("https://dsportalapp.herokuapp.com/home");

	}

	@When("The user clicks on the Register link on home page")
	public void the_user_clicks_on_the_register_link_on_home_page() {
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.clickRegisterLink();
	}

	@Then("The user lands on Register page")
	public void the_user_lands_on_register_page() {
    RegisterPage registerpage = new RegisterPage(driver);
		String expectedTitle = "Registration";
		String actualTitle = registerpage.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}

	/*
	 * @Then("The user sees {string} label on the top left corner of the {string} page"
	 * ) //public void the_user_sees_label_on_the_top_left_corner_of_the_page(String
	 * string, String string2) {
	 * 
	 * 
	 * //}
	 * 
	 * //@
	 * Then("The user sees the data structures select box on the top left corner of the {string} page"
	 * ) //public void
	 * the_user_sees_the_data_structures_select_box_on_the_top_left_corner_of_the_page
	 * (String string) {
	 * 
	 * }
	 * 
	 * //@
	 * Then("The user sees {string} link on  the top right corner of the  Register page"
	 * ) /*public void
	 * the_user_sees_link_on_the_top_right_corner_of_the_register_page(String
	 * string) {
	 * 
	 * 
	 * }
	 * 
	 * // @Then("The user sees {string} label on Regiser pagepage") public void
	 * the_user_sees_label_on_regiser_pagepage(String string) {
	 * 
	 * }
	 * 
	 * //@Then("The user sees {string} label on Register page") public void
	 * the_user_sees_label_on_register_page(String string) {
	 * 
	 * }
	 * 
	 * @Then("The user sees {string} on the Register page") public void
	 * the_user_sees_on_the_register_page(String string) {
	 * 
	 * 
	 * }
	 */

	@Given("The user is on the register page of the portal")
	public void the_user_is_on_the_register_page_of_the_portal() {
		driver.get("https://dsportalapp.herokuapp.com/register");
	}
	/*
	 * //@When("The user clicks {string} button without entering username") public
	 * void the_user_clicks_button_without_entering_username(String string) {
	 * 
	 * }
	 * 
	 * //@Then("The error message {string} should be displayed") public void
	 * the_error_message_should_be_displayed(String string) {
	 * 
	 * }
	 * 
	 * // @When("The user clicks Register button after entering {string} values in username text box and valid password"
	 * ) public void
	 * the_user_clicks_register_button_after_entering_values_in_username_text_box_and_valid_password
	 * (String string) {
	 * 
	 * }
	 * 
	 * //@
	 * When("The user clicks Register button after entering {string} values in password text box and valid username"
	 * ) public void
	 * the_user_clicks_register_button_after_entering_values_in_password_text_box_and_valid_username
	 * (String string) {
	 * 
	 * }
	 * 
	 * //@
	 * When("The user clicks Register button after entering {string} values in passwordtext box and valid username"
	 * ) public void
	 * the_user_clicks_register_button_after_entering_values_in_passwordtext_box_and_valid_username
	 * (String string) {
	 * 
	 * }
	 * 
	 * /*@
	 * When("The user clicks Register button after entering a username with spacebar characters other than digits and @\\/.\\/+\\/-\\/_"
	 * ) public void
	 * the_user_clicks_register_button_after_entering_a_username_with_spacebar_characters_other_than_digits_and
	 * () { .cucumber.java.PendingException(); }
	 */

	/*
	 * @Then("The user should see an error message reading {string}") public void
	 * the_user_should_see_an_error_message_reading(String string) {
	 * 
	 * }
	 * 
	 * @Given("The user clicks Register button after entering a username with spacebar characters other than digits and @\\/.\\/+\\/-\\/_"
	 * ) public void
	 * the_user_clicks_register_button_after_entering_a_username_with_spacebar_characters_other_than_digits_and
	 * () {
	 * 
	 * }
	 * 
	 * @When("The user clicks Register button after entering {string} values in password text box and valid username and {string} value in confirm password text box"
	 * ) public void
	 * the_user_clicks_register_button_after_entering_values_in_password_text_box_and_valid_username_and_value_in_confirm_password_text_box
	 * (String string, String string2) {
	 * 
	 * }
	 * 
	 * @Then("The user sees {string}") public void the_user_sees(String string) {
	 * 
	 * }
	 * 
	 * @Then("The user sees {string} message on the Register page") public void
	 * the_user_sees_message_on_the_register_page(String string) {
	 * 
	 * }
	 * 
	 * @When("The user enters admin in username text box and password in password textbox"
	 * ) public void
	 * the_user_enters_admin_in_username_text_box_and_password_in_password_textbox()
	 * {
	 * 
	 * }
	 * 
	 * @Then("The user should see a message suggesting to enter a strong username and password"
	 * ) public void
	 * the_user_should_see_a_message_suggesting_to_enter_a_strong_username_and_password
	 * () {
	 * 
	 * }
	 */

	@When("The user enters {string} in username text box on register page")
	public void the_user_enters_in_username_text_box_on_register_page(String username) {
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterUsername(username);
	}

	@When("The user enters {string} in password text box on register page")
	public void the_user_enters_in_password_text_box_on_register_page(String password) {
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterPassword(password);
	}

	@When("The user enters {string} in confirm password text box on register page")
	public void the_user_enters_in_confirm_password_text_box_on_register_page(String confirmpassword) {
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterConfirmPassword(confirmpassword);
		;
	}

	@When("The user clicks the Register button")
	public void the_user_clicks_the_register_button() {
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.submitForm();
	}


	@When("The user submits the registration form with mismatched passwords:")
	public void the_user_submits_the_registration_form_with_mismatched_passwords(
			io.cucumber.datatable.DataTable dataTable) {
		RegisterPage registerpage = new RegisterPage(driver);
		List<Map<String, String>> users = dataTable.asMaps(String.class, String.class); // we are taking data from
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
		RegisterPage registerpage = new RegisterPage(driver);

		String actualMessage = registerpage.getMismatchMessage();
// expectedMessage = "password mismatch:The two password fields didn’t match.";
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}

	@Then("The user sees {string} on the Register page")
	public void the_user_sees_on_the_register_page(String string) {

	}
	
	@When("The user clicks Register button after entering valid values from {string}")
	public void the_user_clicks_register_button_after_entering_valid_values_from(String string) {
	
	    RegisterPage registerpage = new RegisterPage(driver);

	    String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/testdata.xlsx";
	    Map<String, String> testData = ExcelReader.readData(filePath, string);
	    String username =testData.get("username");// getting input from datasheet
	    String password =testData.get("password");
	    String confirmedPassword = testData.get("confirmpassword");
	    ScenarioContext.set("registeredUsername", username);
	    registerpage.enterUsername(username);
	    registerpage.enterPassword(password);
	    registerpage.enterConfirmPassword(confirmedPassword);
	    registerpage.submitForm();
	}
	

	@Then("The user lands on the DSAlgo Home portal with Success Message {string}")
	public void the_user_lands_on_the_ds_algo_home_portal_with_success_message(String expectedMessage) {
		RegisterPage registerpage = new RegisterPage(driver);
	   // String expectedMessage = "New Account Created. You are logged in as qatitans16";
		String actualMessage = registerpage.getSuccessMessage(); 
	    String registeredUsername = ScenarioContext.get("registeredUsername").toString();
	    expectedMessage = expectedMessage.replace("<username>", registeredUsername);
	    Assert.assertEquals(actualMessage, expectedMessage, "Success message mismatch!");
	}

	//@When("The user clicks {string}")
	//public void the_user_clicks(String string) {
	    
	//}

	@When("The user clicks {string} button without entering username and entering valid password")
	public void the_user_clicks_button_without_entering_username_and_entering_valid_password(String string) {
	   
	}

	@Then("The error message {string} should be displayed")
	public void the_error_message_should_be_displayed(String string, io.cucumber.datatable.DataTable dataTable) {
	   
	}

	@When("The user clicks Register button after entering {string} values in passwordtext box and valid username")
	public void the_user_clicks_register_button_after_entering_values_in_passwordtext_box_and_valid_username(String string) {
	    
	}


}
