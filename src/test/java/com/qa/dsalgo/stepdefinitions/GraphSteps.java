package com.qa.dsalgo.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.dsalgo.base.DriverScripts;
import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.GraphPage;
import com.qa.dsalgo.pages.LinkedListPage;
import com.qa.dsalgo.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GraphSteps {
	private WebDriver driver;
	GraphPage graphpage;
	Background background;
	
	public GraphSteps() {
		driver = Hooks.getDriver();
		background = new Background(driver);
		graphpage = new GraphPage(driver);
	}

	@When("user clicks {string} button in graph Panel") // scenario 1, step 1
	public void user_clicks_button_in_Graph_panel(String string) {
		graphpage.clickGraphStrtBtn();
	}
	
	@Then("The user lands on the {string} page") // scenario 1/step 2
	public void the_user_lands_on_the_Graph_page(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "User did not land on the expected page");
	}
	
	@Given("The user is on Tree Data Structure")
	public void the_user_is_on_tree_data_structure() {
		graphpage.clickGraphStrtBtn();
		Assert.assertEquals(graphpage.getGraphPageTitle(), "Graph", "Not on Graph page!");
	}
	

	
	@When("The user clicks {string} link on the Graph page")
	public void the_user_clicks_link_on_the_tree_page(String OptionOnGraph) {
		graphpage.clickGraphOptions(OptionOnGraph);
	}
	
	@When("The user clicks {string} button")
	public void the_user_clicks_button(String string) {
		graphpage.clickTryMeButton();
	}

	@And("run invalid code by clicking run button after entering {string} in try editor for tree module")
	public void run_invalid_code_by_clicking_run_button_after_entering_in_try_editor(String code) {
		graphpage.codeEditorSendKeys(code);
		graphpage.clickRunBtn();
	}

	@Then("The user should see alert with  error message {string} on Array in Python page")
	public void the_user_should_see_alert_with_error_message(String expectedMessage) {
		String actualMessage = graphpage.getAlertMessageAndAccept();
		Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch!");
	}
	
	
	
	@When("The user clicks {string} link on tree page")
	public void the_user_clicks_link_on_tree_page(String OptionOnGraph) {
		graphpage.clickGraphOptions(OptionOnGraph);
	}

	@When("The user clicks {string} button on tree page")
	public void the_user_clicks_button_on_tree_page(String string) {
		graphpage.clickTryMeButton();
	}

	 @Then("The user should see the correct output") public void
	 the_user_should_see_the_correct_output() {
		 graphpage.outputDisplayed();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
//
//public class GraphSteps extends DriverScripts {
//	Background background;
//	GraphPage graphpage;
//	LoginPage loginpage;
//	
//	public GraphSteps() {
//		System.out.println(">> In GraphSteps constructor.");
//		graphpage = new GraphPage(driver);
//	}
//	
//	
//	@Given("The user is on the Home page after Sign in")
//	public void theUserIsOnTheHomePageAfterLogin() {
//		System.out.println("The user is on the home page after login");
//		loginpage = new LoginPage(driver);
//		loginpage.clickLoginLink();
//		loginpage.login("qatitans1", "1@Chicago");
//	}
//	
//	//Graph1
//	//Scenario: Verify that user is able to navigate to "Graph" data structure page--Y/Done
//	//Given The user is on the Home page after Sign in --Done
//	//When The user clicks the "Getting Started" button in Graph Panel -- Done
//	//Then The user be directed to "Graph" Data Structure Page -- Done
//	
//	@When("The user clicks the {string} button in Graph Panel")
//	public void the_user_clicks_the_button_in_graph_panel(String string) {
//		System.out.println("The user clicks the " + string + " button  for Graph module on Home page");
//		graphpage = new GraphPage(driver);
//		graphpage.clickGraphStartBtn();
//	}
//
//	/*
//	 * @Then("The user be directed to {string} Data Structure Page") // this should
//	 * be Graph Page??? public void
//	 * the_user_be_directed_to_data_structure_page(String string) {
//	 * System.out.println("The user lands on the " + string + " page"); String
//	 * expectedTitle = string; //"Graph"; String actualTitle =
//	 * graphpage.getTitleGraphPage(); Assert.assertEquals(actualTitle,
//	 * expectedTitle, "Title mismatch!"); }
//	 */
//	
//	
//	@When("The user select Graph item from the drop down")
//	public void the_user_select_graph_item_from_the_drop_down() {
//		driver.get("https://dsportalapp.herokuapp.com/home");
//		//graphpage.clickDataStructuredropdown();
//		graphpage.clickDataStructuredropdown();
//		graphpage.selectGraphFromDropDown();
//	}
//	
//
//
//	@When("The user clicks on the {string} link on  the Linked List page")
//	public void theUserClicksOnTheLinkOnTheLinkedListPage(String string) {
//		System.out.println("The user clicks on the " + string + " link on  the Linked List page");
//		graphpage = new GraphPage(driver);
//		graphpage.clickGraphPythonLink();
//	}	
//}	

/*
 * @Given("The user is in the Assessments Page") public void
 * the_user_is_in_the_assessments_page() { }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @When("The user clicks the Case Details button") public void
 * the_user_clicks_the_case_details_button() { }
 * 
 * @Then("The user should be redirected to {string} page") public void
 * the_user_should_be_redirected_to_page(String string) { }
 * 
 * @When("The user clicks {string} button in Graphs in Python page") public void
 * the_user_clicks_button_in_graphs_in_python_page(String string) { }
 * 
 * @Then("The user should be redirected to a page having an Editor with a {string} button"
 * ) public void
 * the_user_should_be_redirected_to_a_page_having_an_editor_with_a_button(String
 * string) { }
 * 
 * @Given("The user is in the tryEditor page") public void
 * the_user_is_in_the_try_editor_page() { }
 * 
 * @When("The user clicks the {string} button without entering the code in the Editor"
 * ) public void
 * the_user_clicks_the_button_without_entering_the_code_in_the_editor(String
 * string) { }
 * 
 * @When("The user write the invalid code in Editor and click the {string} Button"
 * ) public void
 * the_user_writes_the_invalid_code_in_editor_and_click_the_button(String
 * string) { // Write code here that turns the phrase above into concrete
 * actions throw new io.cucumber.java.PendingException(); }
 * 
 * @When("The user write the valid code in Editor and click the {string} Button"
 * ) public void
 * the_user_write_the_valid_code_in_editor_and_click_the_button(String string) {
 * }
 * 
 * @Then("The user should able to see output in the console with no error message"
 * ) public void
 * the_user_should_able_to_see_output_in_the_console_with_no_error_message() { }
 * 
 * @Given("The user is in the {string} page after Sign in") public void
 * the_user_is_in_the_page_after_sign_in(String string) { }
 * 
 * @When("The user clicks {string} link in the left navigation bar") public void
 * the_user_clicks_link_in_the_left_navigation_bar(String string) { }
 * 
 * @When("The user clicks the {string} link in the left navigation bar") public
 * void the_user_clicks_the_link_in_the_left_navigation_bar(String string) { }
 * 
 * @Then("The user should be redirected to {string} page, and try Editor with {string} button"
 * ) public void
 * the_user_should_be_redirected_to_page_and_try_editor_with_button(String
 * string, String string2) { }
 * 
 * @When("The user write the invalid code in Editor and Click the {string} Button"
 * ) public void
 * the_user_write_the_invalid_code_in_editor_and_click_the_button(String string)
 * { // Write code here that turns the phrase above into concrete actions throw
 * new io.cucumber.java.PendingException(); }
 * 
 * @When("The user write the invalid code in Editor and Clicks {string} Button")
 * public void
 * the_user_write_the_invalid_code_in_editor_and_clicks_button(String string) {
 * }
 * 
 * @Then("The user see output with no error message") public void
 * the_user_see_output_with_no_error_message() { }
 * 
 * }
 */
