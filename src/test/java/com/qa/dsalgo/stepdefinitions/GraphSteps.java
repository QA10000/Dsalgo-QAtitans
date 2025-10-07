package com.qa.dsalgo.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.GraphPage;
import com.qa.dsalgo.pages.TryEditorPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GraphSteps {
	private WebDriver driver;
	GraphPage graphpage;
	Background background;
	TryEditorPage tryEditorPage;
	private static final Logger logger = LogManager.getLogger(RegistrationSteps.class);

	public GraphSteps() {
		driver = Hooks.getDriver();
		background = new Background(driver);
		graphpage = new GraphPage(driver);
	}

	/*@Given("The user is on the home page after login success")
	public void theUserIsOnTheHomePageAfterLoginSuccess() {
	}*/

	@When("The user clicks the {string} button for the Graph module on Home page")
	public void the_user_clicks_the_button_for_the_graph_module_on_home_page(String string) {
		graphpage.clickGraphStrtBtn();
	}

	@Then("The user should see the following {string} on the Graph Page")
	public void the_user_should_see_the_following_on_the_graph_page(String string) {
		String expectedTitle = string;
		String actualTitle = graphpage.getGraphOptionHeaderText(expectedTitle);
		logger.info("actualTitle: '" + actualTitle + "'");
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}
	
	@When ("The user select Graph item from the drop down menu")
	public void the_user_select_graph_item_from_the_drop_down_menu() {
		graphpage.SelectLGraphFromDropDown();
	}
		 
	@When("The user clicks the {string} button for Graph module on Home page")
	public void the_user_clicks_the_getting_started_button_for_graph_module_on_home_page(String string) {
		graphpage.graphItemGetStarted();
	}

	@When("The user clicks now on the {string} link on the Graph page")
	public void the_user_clicks_now_on_the_graph_link_on_the_graph_page(String string) {
		graphpage.graphItemOneClick();
	}

	@Given("The user is on Graph page after login")
	public void theUserIsOnGraphPageAfterLogin() {
		logger.info("The user is on Graph page after login");
		graphpage.clickGraphStrtBtn();
	}
	
	@When("The user clicks now on the {string} link")
	public void theUserClicksNowOnTheLink(String OptionOnGraph) {
		logger.info("The user clicks now on the '" + OptionOnGraph + "' link on the Graph page");
		graphpage.clickGraphOption(OptionOnGraph);
	}

	@When("The user clicked now on the {string} link on the Graph page")
	public void the_user_clicked_now_on_the_graph_representations_link_on_the_graph_page(String string) {
		graphpage.graphItemTwoClick();
	}
	
	@When("The user clicks on the {string} link on the Graph page")//FOR INVALID and VALID CODE
	public void the_user_clicks_link_on_the_link_on_the_graph_page(String string) {
		logger.info("The user clicks on the " + string + " link on the Graph page");
		graphpage.clickGraphOption(string);
	}

	@Then("The user should see an alert with error message {string} on the try editor") // changed-d (added An)
	public void the_user_should_see_an_alert_with_error_message_on_the_try_editor(String expectedMessage) {
		logger.info("The user should see alert with error message" + expectedMessage + " on the TryEditor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		String actualMessage = tryEditorPage.getAlertMessageAndAccept();
		Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch");
	}
	
	@When("The user clicks Run button here after entering an invalid {string} in try editor")
	public void the_user_clicks_run_button_here_after_entering_an_invalid_in_try_editor(String string) {
		logger.info("The user clicks Run button here after entering invalid code in try editor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		tryEditorPage.codeEditorSendKeys(string);
		tryEditorPage.clickRunBtn();	
	}
	
	@When("The user clicks Run button here after entering an valid {string} in try editor")
	public void the_user_clicks_run_button_here_after_entering_an_valid_in_try_editor(String code) {
		logger.info("The user clicks Run button after entering valid code in try editor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		tryEditorPage.codeEditorSendKeys(code);
		tryEditorPage.clickRunBtn();
	}

	@Then("The user should able to see {string} output in the console on the try editor")
	public void the_user_should_able_to_see_output_in_the_console_on_the_try_editor(String expectedMessage) {
		logger.info("The user should see the output message " + expectedMessage + " on TryEditor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		String actualMessage = tryEditorPage.getTryHereOutput();
		Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch");
	}
	
	@Then("The user should see alert with  error message {string} on Graph Module in the code page")
	public void the_user_should_see_alert_with_error_message_on_graph_module_in_the_code_page(String string) {
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("The user clicks {string} link on Graph page")
	public void the_user_clicks_link_on_graph_page(String string) {
		graphpage.graphItemOneClick();
	}
	
	@Then("The user should able to see {string} output in the console on Graph Module in the code page")
	public void the_user_should_able_to_see_output_in_the_console_on_graph_module_in_the_code_page(String string) {
		graphpage.graphItemTwoClick();	
	}
	
	@When("The user selects {string} link on Graph page")
	public void the_user_selects_link_on_graph_page(String OptionOnGraph) {
		logger.info("The user clicks now on the '" + OptionOnGraph + "' link on the Graph page");
		graphpage.clickGraphOption(OptionOnGraph);
  }

	@When("Now the user clicks {string} button on the {string} page")
	public void now_the_user_clicks_button_on_the_page(String button, String pageName) {
		graphpage.clickTryHere();
   }
	
	@When("run valid code by clicking run button after entering {string} in try editor for graph module")
		public void runValidCodeByClickingRunButtonAfterEnteringCodeInTryEditorForGraphModule(String code) {
		logger.info("The user clicks Run button after entering valid code in try editor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		tryEditorPage.codeEditorSendKeys(code);
		tryEditorPage.clickRunBtn();
	}
		
	@Then("The user should able to see {string} output in the console on Graph Module in teh code page")
	public void theUserShouldAbleToSeeMessageOutputInTheConsoleOnGraphModuleInTheCodePage(String expectedMessage) {
		logger.info("The user should see the output message " + expectedMessage + " on TryEditor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		String actualMessage = tryEditorPage.getTryHereOutput();
		Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch");
	}
}

