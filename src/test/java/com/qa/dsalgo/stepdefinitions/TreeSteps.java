package com.qa.dsalgo.stepdefinitions;

import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.RegisterPage;
import com.qa.dsalgo.pages.TreePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.dsalgo.base.DriverScripts;

public class TreeSteps {
	private WebDriver driver;
	TreePage treepage;
	Background background;

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

	@Then("The user should see alert with  error message {string} on tree page") // till here
	public void the_user_should_see_alert_with_error_message(String expectedMessage) {
		String actualMessage = treepage.getAlertMessageAndAccept();
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

 @Then("The user should see the correct output") public void
 the_user_should_see_the_correct_output() {
	 treepage.outputDisplayed();
	 
}
	
	
	/*
	 * @Given("The user is on the {string} Data Structure page")//scn2/step given1
	 * step 1 public void the_user_is_on_the_data_structure_page(String string) {
	 * treepage.clickTreeStrtBtn(); Assert.assertEquals(treepage.getTreePageTitle(),
	 * "Tree", "Not on Tree page!");
	 * 
	 * }
	 * 
	 * @When("The user clicks on {string} link on the Tree page")// scn3 step2
	 * public void the_user_clicks_on_link_on_the_tree_page(String string) {
	 * treepage.clickOverviewLink(); }
	 * 
	 * @When("The user clicks on {string} button on {string}") public void
	 * the_user_clicks_on_button_on(String string, String string2) {
	 * treepage.cickTryMeButtonTree(); }
	 * 
	 * @Then("The user has navigated to {string} page")// user clicks option on tree
	 * page public void the_user_has_navigated_to_the_page(String pageName) {
	 * 
	 * // Write code here that turns the phrase above into concrete actions throw
	 * new io.cucumber.java.PendingException(); }
	 * 
	 * @Then("The user clicks on {string} button")// user clicks try me link public
	 * void the_user_clicks_on_button(String string) { // Write code here that turns
	 * the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @When("The user clicks on {string} button without entering any python code")/
	 * / run button without entry public void
	 * the_user_clicks_on_button_without_entering_any_python_code(String string) {
	 * // Write code here that turns the phrase above into concrete actions throw
	 * new io.cucumber.java.PendingException(); }
	 * 
	 * @Then("The user should see an error message stating that the user should enter valid python code"
	 * ) public void
	 * the_user_should_see_an_error_message_stating_that_the_user_should_enter_valid_python_code
	 * () { // Write code here that turns the phrase above into concrete actions
	 * throw new io.cucumber.java.PendingException(); }
	 * 
	 * @When("The user clicks on {string} button after entering wrong python code")
	 * public void the_user_clicks_on_button_after_entering_wrong_python_code(String
	 * string) { // Write code here that turns the phrase above into concrete
	 * actions throw new io.cucumber.java.PendingException(); }
	 * 
	 * @When("The user clicks on {string} button after entering correct python code"
	 * ) public void
	 * the_user_clicks_on_button_after_entering_correct_python_code(String string) {
	 * // Write code here that turns the phrase above into concrete actions throw
	 * new io.cucumber.java.PendingException(); }
	 * 
	 
	 * 
	 * @Given("The user is on the DSAlgo Tree page") public void
	 * the_user_is_on_the_ds_algo_tree_page() { // Write code here that turns the
	 * phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @Then("The user sees {string} label on the {string} page") public void
	 * the_user_sees_label_on_the_page(String string, String string2) { // Write
	 * code here that turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @Then("The user sees a button with {string} label on the {string} page")
	 * public void the_user_sees_a_button_with_label_on_the_page(String string,
	 * String string2) { // Write code here that turns the phrase above into
	 * concrete actions throw new io.cucumber.java.PendingException(); }
	 * 
	 * @Given("The user is on the DSAlgo Tree page of the portal") public void
	 * the_user_is_on_the_ds_algo_tree_page_of_the_portal() { // Write code here
	 * that turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @Then("The user sees {string} dropdown") public void
	 * the_user_sees_dropdown(String string) { // Write code here that turns the
	 * phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 */

}
