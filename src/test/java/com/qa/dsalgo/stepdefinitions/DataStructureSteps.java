package com.qa.dsalgo.stepdefinitions;

import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.DataStructurePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DataStructureSteps {
	Background background;
	private WebDriver driver;
	DataStructurePage dataStructurePage; 
	private static final Logger logger = LogManager.getLogger(DataStructureSteps.class);
	
	public DataStructureSteps(){
		driver = Hooks.getDriver();
		background = new Background(driver);
		dataStructurePage = new DataStructurePage(driver);
	}

	@Given("The user is on signon page of the DS-Algo page")
	public void the_user_is_on_signon_page_of_the_ds_algo_page() {
		dataStructurePage.Login();
	}

	@When("The user enter valid username {string} and password {string}")
	public void the_user_enter_valid_username_and_password(String uid, String pwd) {
		dataStructurePage.CorrectUsernameAndPassword(uid, pwd);
	}

	@Then("It should display {string}")
	public void it_should_display(String msg) {
		String getSuccessMessage = dataStructurePage.getLoginSuccessMessage();
		Assert.assertEquals(getSuccessMessage,msg);
	}

	@Given("The user is on the home page after successful login with username {string} and password {string} with message {string}")
	public void the_user_is_on_the_home_page_after_successful_login_with_username_password(String uid, String pwd, String msg) {
		dataStructurePage.Login();
		dataStructurePage.CorrectUsernameAndPassword(uid, pwd);
		String getSuccessMessage = dataStructurePage.getLoginSuccessMessage();
		Assert.assertEquals(getSuccessMessage,msg);
		dataStructurePage.homePage();
	}
	
	@When("The user clicks the Get Started button under Data Structures introduction panel")
	public void the_user_clicks_the_get_started_button_under_data_structures_introduction_panel() {
		dataStructurePage.clickDataStructuresGetStarted();
	}

	@Then("The user should be redirected to Data Structures introduction page")
	public void the_user_should_be_redirected_to_data_structures_introduction_page() {
		dataStructurePage.dataStructuresIntroPage();
		Assert.assertTrue(dataStructurePage.dsLabelDisplayed(), "Data Structure page header not visible!");
		logger.info("Then: The user lands on Data Structures introduction page");
	}
	
	@Then("The user lands on Data Structures introduction page")
	public void the_user_lands_on_data_structures_introduction_page() {
		dataStructurePage.dataStructuresIntroPage();
		Assert.assertTrue(dataStructurePage.dsLabelDisplayed(), "Data Structure page header not visible!");
		logger.info("Then: The user lands on Data Structures introduction page");
	}	
	
	@When("The user clicks the Time-Complexity link under Data Structures introduction panel")
	public void the_user_clicks_the_time_complexity_link_under_data_structures_introduction_panel() {
		dataStructurePage.clickTimeComplexity();
	}

	@Then("The user lands on Time Complexity page")
	public void the_user_should_be_redirected_to_time_complexity_page() {
		dataStructurePage.timeComplexityPage();
		Assert.assertTrue(dataStructurePage.timeComplexityLableDisplayed(), "Data Structure: Time Complexity page header not visible!");
	}

	@When("The user clicks the Try here>>> button at the bottom of the Time Complexity page")
	public void the_user_clicks_the_try_here_button_at_the_bottom_of_the_time_complexity_page() {
		dataStructurePage.clickTryHere();
		logger.info("When:The user clicks the Try here>>> button at the bottom of the Time Complexity page");		
	}

	@Then("The user lands on Try Editor page")
	public void the_user_lands_on_try_editor_page() throws InterruptedException {
		logger.info("Then:The user lands on Try Editor page");		
		dataStructurePage.clickTryHere();
		Assert.assertTrue(dataStructurePage.codeTextAreaDisplayed(), "Data Structure: Try Editor page header not visible!");		
	}
	
	@When("The user enter valid python code in tryEditor {string}")
	public void the_user_enter_valid_python_code_in_try_editor_print_hello_world(String pcode) {
		logger.info("Then:The user enter valid python code in tryEditor "+pcode);
		dataStructurePage.getPythonCode(pcode);
	}

	@Then("The user should be presented with the run result")
	public void the_user_should_be_presented_with_the_run_result() {
		logger.info("Then:The user should be presented with the run result");	
		try {
		dataStructurePage.getPythonCodeExcMsg();
		Assert.assertTrue(dataStructurePage.codeExectuionOPDisplayed(), "Data Structure: Try Editor Execution successful message not visible!");
		} catch (Exception ex){
			logger.error("Error "+ex);
		}
	}
	
	@When("The user enter invalid python code in tryEditor {string}")
	public void the_user_enter_invalid_python_code_in_try_editor(String pycode) {
		dataStructurePage.invalidPythonCode(pycode);
		logger.info("Then:The user enter invalid python code in tryEditor "+pycode);
	}
	
	@Then("The user sees {string} label on top-left corner of {string} page")
	public void the_user_sees_label_on_top_left_corner_of_page(String expectedLabel, String string2) {
		String actualLabel = dataStructurePage.getNumpyNinjaLinkText();
		logger.info("Verifying that the user sees NumpaiNinja label| actualLabel | "+actualLabel+ "| expectedLabel | "+expectedLabel);
		Assert.assertEquals(actualLabel, expectedLabel, "NumpyNinja Link Label mismatch!");
	}

	@Then("The user sees the {string} drop-down box on the top-left corner of the {string} page")
	public void the_user_sees_the_drop_down_box_on_the_top_left_corner_of_the_page(String expectedLabel, String string2) {
		String actualLabel = dataStructurePage.getDataStructureLblText();
		logger.info("Verifying that the user sees label for Data Structure dropdown");
		Assert.assertEquals(actualLabel, expectedLabel, "Drop down Label mismatch!");
	}

	@Then("The user sees {string} link on the top-right corner of the Data Structure page")
	public void the_user_sees_link_on_the_top_right_corner_of_the_data_structure_page(String expectedLabel) {
		String actualLabel = dataStructurePage.getSignOutLinkText();
		logger.info("Verifying that the user sees SignOut Link");
		Assert.assertEquals(actualLabel, expectedLabel, "Sign out Label mismatch!");
	}
	
	@Then("The user sees {string} link on the top-right corner of Data Structure page")
	public void the_user_sees_link_on_the_top_right_corner_of_data_structure_page(String username) throws InterruptedException {
		logger.info("Verifying that the user sees Registered User Name link | "+username);
		Assert.assertEquals(dataStructurePage.getUsernameLblText(), username, "User Name Label mismatch!");
	}
}