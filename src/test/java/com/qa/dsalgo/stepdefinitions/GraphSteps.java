package com.qa.dsalgo.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.GraphPage;

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



	@When("user clicks {string} button in Graph Panel")
	public void user_clicks_button_in_graph_panel(String string) {
		graphpage.clickGraphStrtBtn();

	   
	}
	@Then("The user be directed to {string} Data Structure Page")
	public void the_user_be_directed_to_data_structure_page(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "User did not land on the expected page");

	}
	
	@Given("The user is on Graph Data Structure")
	public void the_user_is_on_graph_data_structure() {
		graphpage.clickGraphStrtBtn();
		Assert.assertEquals(graphpage.getGraphPageTitle(), "Graph", "Not on Graph page!");
	}


	@When("The user select Graph item from the drop down")
	public void the_user_select_graph_item_from_the_drop_down(String OptionOnGraph) {
		graphpage.clickGraphOptions(OptionOnGraph);

	}

	@Given("The user is in the Assessments Page")
	public void the_user_is_in_the_assessments_page() {
	}

	@When("The user clicks the Case Details button")
	public void the_user_clicks_the_case_details_button(String OptionOnGraph) {
		graphpage.clickGraphOptions(OptionOnGraph);

	}
	
	@When("The user clicks {string} link on the Graph page")
	public void the_user_clicks_link_on_the_graph_page(String OptionOnGraph) {
		graphpage.clickGraphOptions(OptionOnGraph);

		}

	
	@When("run invalid code by clicking run button after entering {string} in try editor for graph module")
	public void run_invalid_code_by_clicking_run_button_after_entering_in_try_editor_for_graph_module(String code) {
	    graphpage.codeEditorSendKeys(code);
		graphpage.clickRunBtn();
	}
	
	@Then("The user should see alert with  error message {string} on Graph Module in the code page")
	public void the_user_should_see_alert_with_error_message_on_graph_module_in_the_code_page(String expectedMessage) {
		String actualMessage = graphpage.getAlertMessageAndAccept();
		Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch!");

	}
	
	
	@When("run valid code by clicking run button after entering {string} in try editor for graph module")
	public void run_valid_code_by_clicking_run_button_after_entering_in_try_editor_for_graph_module(String code) {
		graphpage.codeEditorSendKeys(code);
		graphpage.clickRunBtn();
	}

	@Then("The user should able to see {string} output in the console on Graph Module in the code page")
	public void the_user_should_able_to_see_output_in_the_console_on_graph_module_in_the_code_page(String string) {
		 graphpage.outputDisplayed();
	}

	@When("The user write the valid code in Editor and click the {string} Button")
	public void the_user_write_the_valid_code_in_editor_and_click_the_button(String string) {
	}

	@Then("The user should be redirected to {string} page")
	public void the_user_should_be_redirected_to_page(String string) {
	}
	

	@When("The user clicks {string} button on Graph page")
	public void the_user_clicks_button_on_graph_page(String OptionOnGraph) {
		graphpage.clickGraphOptions(OptionOnGraph);

	}
	
		@When("The user clicks {string} button on the Graph page")
	    public void the_user_clicks_button_on_the_graph_page(String OptionOnGraph) {
		graphpage.clickGraphOptions(OptionOnGraph);

	}


	
	@When("The user clicks {string} button in Graphs in Python page")
	public void the_user_clicks_button_in_graphs_in_python_page(String string) {
	}

	@Then("The user should be redirected to a page having an Editor with a {string} button")
	public void the_user_should_be_redirected_to_a_page_having_an_editor_with_a_button(String string) {
	}

	/*@Given("The user is in the tryEditor page")
	public void the_user_is_in_the_try_editor_page() {
	}*/
	
	



	@When("The user write the invalid code in Editor and click the {string} Button")
	public void the_user_writes_the_invalid_code_in_editor_and_click_the_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("The user clicks {string} link on Graph page")
	public void the_user_clicks_link_on_graph_page(String OptionOnGraph) {
		graphpage.clickGraphOptions(OptionOnGraph);
	}
	


	@Given("The user is on the DSAlgo Graph page")
	public void the_user_is_on_the_ds_algo_graph_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The user sees {string} label on the {string} page")
	public void the_user_sees_label_on_the_page(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	

	@Then("The user should able to see output in the console with no error message")
	public void the_user_should_able_to_see_output_in_the_console_with_no_error_message() {
	}

	@Given("The user is in the {string} page after Sign in")
	public void the_user_is_in_the_page_after_sign_in(String string) {
	}

	@When("The user clicks {string} link in the left navigation bar")
	public void the_user_clicks_link_in_the_left_navigation_bar(String string) {
	}

	@When("The user clicks the {string} link in the left navigation bar")
	public void the_user_clicks_the_link_in_the_left_navigation_bar(String string) {
	}

	@Then("The user should be redirected to {string} page, and try Editor with {string} button")
	public void the_user_should_be_redirected_to_page_and_try_editor_with_button(String string, String string2) {
	}

	@When("The user write the invalid code in Editor and Click the {string} Button")
	public void the_user_write_the_invalid_code_in_editor_and_click_the_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The user write the invalid code in Editor and Clicks {string} Button")
	public void the_user_write_the_invalid_code_in_editor_and_clicks_button(String string) {
	}

	@Then("The user see output with no error message")
	public void the_user_see_output_with_no_error_message() {
	}

}
