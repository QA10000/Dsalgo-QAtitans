package com.qa.dsalgo.stepdefinitions;

import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.DataStructurePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class DataStructureSteps {

	Background background;
	private WebDriver driver;
	DataStructurePage dataStructurePage;
	private static final Logger logger = LogManager.getLogger(DataStructureSteps.class);

	public DataStructureSteps() {
		driver = Hooks.getDriver();
		background = new Background(driver);
		dataStructurePage = new DataStructurePage(driver);
	}

	@Then("The user lands on Time Complexity page")
	public void the_user_lands_on_time_complexity_page() {
		dataStructurePage.timeComplexityPage();
		Assert.assertTrue(dataStructurePage.timeComplexityLabelDisplayed(), "Time Complexity header not visible!");
	}

	@When("The user clicks the Get Started button under Data Structures introduction panel")
	public void the_user_clicks_get_started_under_data_structures_intro() {
		dataStructurePage.clickDataStructuresGetStarted();
	}

	@Then("The user lands on Data Structures introduction page")
	public void the_user_lands_on_data_structures_intro_page() {
		Assert.assertTrue(dataStructurePage.dsLabelDisplayed(), "Intro page not visible!");
	}

	@Given("The user is on  Data Structure page") // 1
	public void the_user_is_on_data_structure_page() {
		dataStructurePage.clickDataStructuresGetStarted();
		Assert.assertEquals(dataStructurePage.getTitle(), "Data Structures-Introduction", "Not on Array page!");
	}

	
     @When("The user clicks the Time-Complexity link under Data Structures introduction panel")
	  public void the_user_clicks_time_complexity_link() {
	 dataStructurePage.clickTimeComplexity(); }
	 

	@When("The user clicks {string} link on Data structure page") // 2
	public void the_user_clicks_link_on_data_structure_page(String string) {
		dataStructurePage.clickTimeComplexity();
	}

	@When("run invalid code by clicking run button after entering {string} in try  on Data Structure module") // 3
	public void run_invalid_code_by_clicking_run_button_after_entering_in_try_on_data_structure_module(String code) {
		dataStructurePage.codeEditorSendKeys(code);
		dataStructurePage.clickRunBtn();
	}

	@Then("The user should see alert with  error message {string} on Data Structure page") // 4
	public void the_user_should_see_alert_with_error_message_on_data_structure_page(String expectedMessage) {
		String actualMessage = dataStructurePage.getAlertMessageAndAccept();
		logger.info("Verifying that the user sees error message");
		Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch!");

	}

	@When("The user clicks {string} button in Time Complexity page")
	public void the_user_clicks_button_in_time_complexity_page(String page) {
		dataStructurePage.clickTryHere();
	}

	@When("The user clicks the Try here>>> button at the bottom of the Time Complexity page")
	public void the_user_clicks_the_try_here_button_at_the_bottom_of_the_time_complexity_page() {
		dataStructurePage.clickTryHere();

	}

	@When("The user clicks {string} link on Datastructure page")
	public void the_user_clicks_link(String optionOnDataStructurePage) // clicking options on array page
	{
		dataStructurePage.clickSection(optionOnDataStructurePage);
	}

	@Then("The user lands on Try Editor page")
	public void the_user_lands_on_try_editor_page() {
		Assert.assertTrue(dataStructurePage.codeTextAreaDisplayed(), "Try Editor page not visible!");
	}

	@When("The user enters valid python code {string}")
	public void the_user_enters_valid_python_code(String pcode) throws InterruptedException {
		dataStructurePage.getPythonCode(pcode);
	}

	@Then("The user should be presented with the run result")
	public void the_user_should_be_presented_with_the_run_result() {
		dataStructurePage.getPythonCodeExcMsg();
		Assert.assertTrue(dataStructurePage.codeExecutionDisplayed(), "Execution result not visible!");
	}

	@When("The user enter invalid python code in tryEditor {string}")
	public void the_user_enters_invalid_python_code(String code) throws TimeoutException, InterruptedException {
		dataStructurePage.invalidPythonCode(code);
	}

	@Then("The user should be presented an alert with the {string}")
	public void the_user_should_be_presented_an_alert_with(String expectedAlert) {
		String actualAlert = dataStructurePage.getAlertMessageAndAccept();
		Assert.assertEquals(actualAlert.trim(), expectedAlert.trim(), "Alert mismatch!");
	}

	@Then("The user sees {string} label on top-left corner of {string} page")
	public void the_user_sees_label_on_top_left(String expected, String page) {
		String actual = dataStructurePage.getNumpyNinjaLinkText();
		Assert.assertEquals(actual, expected, "Top-left label mismatch!");
	}

	@Then("The user sees the {string} drop-down box on the top-left corner of the {string} page")
	public void the_user_sees_dropdown_on_top_left(String expected, String page) {
		String actual = dataStructurePage.getDataStructureLblText();
		Assert.assertEquals(actual, expected, "Dropdown mismatch!");
	}

	@Then("The user sees {string} link on the top-right corner of the Data Structure page")
	public void the_user_sees_sign_out_link(String expected) {
		String actual = dataStructurePage.getSignOutLinkText();
		Assert.assertEquals(actual, expected, "Top-right link mismatch!");
	}

	@Then("The user sees {string} link on the top-right corner of Data Structure page")
	public void the_user_sees_username_link(String expectedUsername) {
		String actualUsername = dataStructurePage.getUsernameLblText();
		Assert.assertEquals(actualUsername, expectedUsername, "Username mismatch!");
	}
}
