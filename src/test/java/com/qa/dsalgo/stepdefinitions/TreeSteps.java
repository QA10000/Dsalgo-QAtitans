package com.qa.dsalgo.stepdefinitions;

import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.RegisterPage;
import com.qa.dsalgo.pages.TreePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TreeSteps {
	private WebDriver driver;
	TreePage treepage;
	Background background;
	private static final Logger logger = LogManager.getLogger(TreeSteps.class);

	public TreeSteps() {
		driver = Hooks.getDriver();
		background = new Background(driver);
		treepage = new TreePage(driver);
	}

	@When("user clicks {string} button in tree Panel") // scenario 1, step 1
	public void user_clicks_button_in_tree_panel(String string) {
		treepage.clickTreeStrtBtn();

	}

	@Then("The user lands on the {string} page") // scenario 1/step 2
	public void the_user_lands_on_the_tree_page(String expectedTitle) {
		String actualTitle = driver.getTitle();
		logger.info("Verifying that the user lands on the page");
		Assert.assertEquals(actualTitle, expectedTitle, "User did not land on the expected page");
	}

	@Given("The user is on Tree Data Structure")
	public void the_user_is_on_tree_data_structure() {
		treepage.clickTreeStrtBtn();
		Assert.assertEquals(treepage.getTreePageTitle(), "Tree", "Not on Tree page!");
	}

	@When("The user clicks {string} link on the tree page")
	public void the_user_clicks_link_on_the_tree_page(String optionOnTree) {
		treepage.clickTreeOptiions(optionOnTree);

	}

	@When("The user clicks {string} button")
	public void the_user_clicks_button(String string) {
		treepage.clickTryMeButton();
	}

	@And("run invalid code by clicking run button after entering {string} in try editor for tree module")
	public void run_invalid_code_by_clicking_run_button_after_entering_in_try_editor(String code) {
		treepage.codeEditorSendKeys(code);
		treepage.clickRunBtn();
	}

	@Then("The user should see alert with  error message {string} on Tree module page")
	public void the_user_should_see_alert_with_error_message_on_tree_module_page(String expectedMessage) {
		String actualMessage = treepage.getAlertMessageAndAccept();
		logger.info("Verifying that the user sees error message");
		Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch!");
	}

	@When("The user clicks {string} link on tree page")
	public void the_user_clicks_link_on_tree_page(String optionOnTree) {
		treepage.clickTreeOptiions(optionOnTree);
		;
	}

	@When("The user clicks {string} button on tree page")
	public void the_user_clicks_button_on_tree_page(String string) {
		treepage.clickTryMeButton();
	}

	@Then("The user should see the correct output")
	public void the_user_should_see_the_correct_output() {
		treepage.outputDisplayed();

	}

	@Then("The user sees {string} link on the top right most corner of the {string} page module")
	public void the_user_sees_link_on_the_top_right_most_corner_of_the_page_module(String labelnumpai,
			String treepage) {
	}

	@Then("The user sees {string} link on the top left most corner of the {string} page module")
	public void the_user_sees_link_on_the_top_left_most_corner_of_the_page_module(String expectedLabel, String module) {
		String actualLabel = treepage.getNumpyNinjaLinkTextTreePg();
	    logger.info("Verifying that the user sees NumpaiNinja logo");
		Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");

	}

	@Then("The user sees {string} label on the top left corner of the {string} page for tree module")
	public void the_user_sees_label_on_the_top_left_corner_of_the_page_tree_module(String expectedLabel,
			String module) {
		String actualLabel = treepage.getDataStructureLblText();
		Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
	}

	@Then("The user sees {string} link on the top right most corner of the {string} page for tree module")
	public void the_user_sees_link_on_the_top_right_most_corner_of_the_page_for_tree_module(String expectedLabel,
			String module) {
		String actualLabel = treepage.getSignoutLblText();
	    logger.info("Verifying that the user sees Signout Link on Tree page");
		Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
	}

	@Then("The user sees {string} label on the top right corner of the {string} page for tree module")
	public void the_user_sees_label_on_the_top_right_corner_of_the_page_for_tree_module(String expectedLabel,
			String module) {
		String actualLabel = treepage.getUsernameLblText();
	    logger.info("Verifying that the user sees username Lable on Tree page");
		Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
	}

}
