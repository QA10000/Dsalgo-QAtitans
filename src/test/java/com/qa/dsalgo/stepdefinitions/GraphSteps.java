package com.qa.dsalgo.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.GraphPage;
import com.qa.dsalgo.pages.TryEditorPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;

public class GraphSteps {
	private WebDriver driver;
	GraphPage graphpage;
	Background background;
	TryEditorPage tryEditorPage;

	public GraphSteps() {
		System.out.println(">> In GraphSteps constructor.");
		driver = Hooks.getDriver();
		background = new Background(driver);
		graphpage = new GraphPage(driver);
	}

	// BACKGROUND PASSED - LOGGING IN AND LANDS ON DSALGO PORTAL HOME PAGE
	@Given("The user is on the home page after login success")
	public void theUserIsOnTheHomePageAfterLoginSuccess() {
		System.out.println("The user is on the home page after login");
	}
//---------------//

	// STEP1 PASSED- Main Graph Page Headers
	// Click GetStarted in the Graph panel and verify both headers
	@When("The user clicks the {string} button for the Graph module on Home page")
	public void the_user_clicks_the_button_for_the_graph_module_on_home_page(String string) {
		System.out.println("The user clicks the " + string + " button  for Graph module on Home page");
		graphpage.clickGraphStrtBtn();
	}

	@Then("The user should see the following {string} on the Graph Page")
	public void the_user_should_see_the_following_on_the_graph_page(String string) {
		System.out.println("The user lands on the " + string + " page");
		String expectedTitle = string; // "Graph" and "Topics Covered";
		String actualTitle = graphpage.getGraphOptionHeaderText(expectedTitle); // .getTitle();
		System.out.println("actualTitle: '" + actualTitle + "'");
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}

	// STEP6-PASSED - REMOVED FOR NOW, DROP DOWN
	/*
	 * @When("The user select Graph item from the drop down menu") public void
	 * theUserSelectGraphItemFromTheDropDownMenu() {
	 * System.out.println("The user select Graph item from the drop down menu");
	 * driver.get("https://dsportalapp.herokuapp.com/home");
	 * graphpage.SelectLGraphFromDropDown();
	 * 
	 * }
	 */
	
	
	//#STEP 6 - From Home Page, go to Graph page by selecting Graph from dropdown menu
	
	@When ("The user select Graph item from the drop down menu")
	public void the_user_select_graph_item_from_the_drop_down_menu() {
		graphpage.SelectLGraphFromDropDown();
	}
		 
	//#STEP2 - Main Graph Page headers with links
	//when The user clicks the "Getting Started" button for Graph module on Home page
	//Added now for Step 2
	@When("The user clicks the {string} button for Graph module on Home page")
	public void the_user_clicks_the_getting_started_button_for_graph_module_on_home_page(String string) {
		graphpage.graphItemGetStarted();
	}

	
	//#STEP3 -  Main Graph Page >> 1. Graph Page headers with links
		//When The user clicks now on the "Graph" link on the Graph page
		//Added now for Step 3
	@When("The user clicks now on the {string} link on the Graph page")
	public void the_user_clicks_now_on_the_graph_link_on_the_graph_page(String string) {
		graphpage.graphItemOneClick();
	}

	
	

	//
	@Given("The user is on Graph page after login")
	public void theUserIsOnGraphPageAfterLogin() {
		System.out.println("The user is on Graph page after login");
		graphpage.clickGraphStrtBtn();
	}

	
	//CHECK THIS ---------------------------
	@When("The user clicks now on the {string} link")
	public void theUserClicksNowOnTheLink(String OptionOnGraph) {
		System.out.println("The user clicks now on the '" + OptionOnGraph + "' link on the Graph page");
		graphpage.clickGraphOption(OptionOnGraph);
	}

	//STEP PASSED New 8 - From Graph Page, going to 2.Graph Representations
	//When  The user clicks now on the "Graph Representations" link on the Graph page
	@When("The user clicked now on the {string} link on the Graph page")
	public void the_user_clicked_now_on_the_graph_representations_link_on_the_graph_page(String string) {
		graphpage.graphItemTwoClick();
	}
	
	//Then The user lands on "Graph Representations" page - not required
	
	
	
	
	
	
	
	
	
	// FOR INVALID CODE
	
	@When("The user clicks on the {string} link on the Graph page")//FOR INVALID and VALID CODE
	public void the_user_clicks_link_on_the_link_on_the_graph_page(String string) {
		System.out.println("The user clicks on the " + string + " link on the Graph page");
		graphpage.clickGraphOption(string);
	}

	@Then("The user should see an alert with error message {string} on the try editor") // changed-d (added An)
	public void the_user_should_see_an_alert_with_error_message_on_the_try_editor(String expectedMessage) {
		System.out.println("The user should see alert with error message" + expectedMessage + " on the TryEditor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		String actualMessage = tryEditorPage.getAlertMessageAndAccept();
		Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch");
	}
	
	@When("The user clicks Run button here after entering an invalid {string} in try editor")
	public void the_user_clicks_run_button_here_after_entering_an_invalid_in_try_editor(String string) {
		System.out.println("The user clicks Run button here after entering invalid code in try editor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		tryEditorPage.codeEditorSendKeys(string);
		tryEditorPage.clickRunBtn();	
	}
	
	
	//VALID CODE
	@When("The user clicks Run button here after entering an valid {string} in try editor")
	public void the_user_clicks_run_button_here_after_entering_an_valid_in_try_editor(String code) {
		System.out.println("The user clicks Run button after entering valid code in try editor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		tryEditorPage.codeEditorSendKeys(code);
		tryEditorPage.clickRunBtn();
	}

	@Then("The user should able to see {string} output in the console on the try editor")
	public void the_user_should_able_to_see_output_in_the_console_on_the_try_editor(String expectedMessage) {
		System.out.println("The user should see the output message " + expectedMessage + " on TryEditor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		String actualMessage = tryEditorPage.getTryHereOutput();
		Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch");
	}
	
	
	
	
	
	
	
	/*
	 * @When("run invalid code by clicking run button after entering {string} in try editor for graph module"
	 * ) public void
	 * runInvalidCodeByClickingRunButtonAfterEnteringCodeInTryEditorForGraphModule(
	 * String string, String string2) { System.out.println("The user clicks " +
	 * string + "  button after entering invalid code " + string2 +
	 * " in try editor"); TryEditorPage tryEditorPage = new TryEditorPage(driver);
	 * tryEditorPage.codeEditorSendKeys(string2); tryEditorPage.clickRunBtn(); }
	 */
	
	@Then("The user should see alert with  error message {string} on Graph Module in the code page")
	public void the_user_should_see_alert_with_error_message_on_graph_module_in_the_code_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	


	//
	
	
	//Old- In 2.Graph Representations Page, try valid code   
	// When The user clicks "<OptionOnGraph>" link on Graph page
	@When("The user clicks {string} link on Graph page")
	public void the_user_clicks_link_on_graph_page(String string) {
		graphpage.graphItemOneClick();
	}
	
	//#Old- In 2.Graph Representations Page, try invalid code
	// Then The user should see alert with  error message "<errorMessage>" on Graph Module in the code page
	@Then("The user should able to see {string} output in the console on Graph Module in the code page")
	public void the_user_should_able_to_see_output_in_the_console_on_graph_module_in_the_code_page(String string) {
		graphpage.graphItemTwoClick();
		
		
	}
	

// --------------//

	
//NEW 	#STEP9- In 2.Graph Representations Page, try valid code     
	   // And The user clicks "Try Here" button

	//CHECKED FINE-1
@When("The user selects {string} link on Graph page")
public void the_user_selects_link_on_graph_page(String OptionOnGraph) {
	    	System.out.println("The user clicks now on the '" + OptionOnGraph + "' link on the Graph page");
			graphpage.clickGraphOption(OptionOnGraph);
  
}

@When("Now the user clicks {string} button on the {string} page")
public void now_the_user_clicks_button_on_the_page(String button, String pageName) {
	graphpage.clickTryHere();
}
// FOR VALID CODE
		@When("run valid code by clicking run button after entering {string} in try editor for graph module")
			public void runValidCodeByClickingRunButtonAfterEnteringCodeInTryEditorForGraphModule(String code) {
			System.out.println("The user clicks Run button after entering valid code in try editor");
			TryEditorPage tryEditorPage = new TryEditorPage(driver);
			tryEditorPage.codeEditorSendKeys(code);
			tryEditorPage.clickRunBtn();
		}
		
		@Then("The user should able to see {string} output in the console on Graph Module in teh code page")
		public void theUserShouldAbleToSeeMessageOutputInTheConsoleOnGraphModuleInTheCodePage(String expectedMessage) {
			System.out.println("The user should see the output message " + expectedMessage + " on TryEditor");
			TryEditorPage tryEditorPage = new TryEditorPage(driver);
			String actualMessage = tryEditorPage.getTryHereOutput();
		    Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch");
			
		}
}

