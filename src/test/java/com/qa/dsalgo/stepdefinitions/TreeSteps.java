package com.qa.dsalgo.stepdefinitions;

import com.qa.dsalgo.pages.TreePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;



import com.qa.dsalgo.base.DriverScripts;


public class TreeSteps extends DriverScripts {
	TreePage treepage;
	
    public TreeSteps() {
	this.treepage = new TreePage(driver);
	}


@When("The user clicks the {string} button for Tree on the Home page")// user clicks start button for tree module on home page
public void the_user_clicks_the_button_for_tree_on_the_home_page(String string) {
   treepage.clickTreeStrtBtn();
}

/*@Then("The user lands on the {string}")// use lands on data structure page 
public void the_user_lands_on_the_tree_data_structure_page(String expectedTitle) {
String actualTitle = driver.getTitle();
Assert.assertEquals(actualTitle, expectedTitle, "User did not land on the Tree Data Structure page");

}*/

@When("The user selects {string} item from the dropdown menu")
public void the_user_selects_item_from_the_dropdown_menu(String string) {
   treepage.selectTreeFrmDropdown();;
}

@Then("The user lands on the {string} Data Structure page")
public void the_user_lands_on_the_data_structure_page(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("The user is on the {string} Data Structure page")
public void the_user_is_on_the_data_structure_page(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("The user clicks on {string} link on the Tree page")
public void the_user_clicks_on_link_on_the_tree_page(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("The user lands on the {string} page")
public void the_user_lands_on_the_tree_page(String expectedTitle) {
	String actualTitle = driver.getTitle();
    Assert.assertEquals(actualTitle, expectedTitle, "User did not land on the expected page");
}


@Given("The user is on {string} page")
public void the_user_is_on_the_page(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("The user clicks on {string} button on {string}")
public void the_user_clicks_on_button_on(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("The user has navigated to {string} page")
public void the_user_has_navigated_to_the_page(String pageName) {

    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("The user clicks on {string} button without entering any python code")
public void the_user_clicks_on_button_without_entering_any_python_code(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("The user should see an error message stating that the user should enter valid python code")
public void the_user_should_see_an_error_message_stating_that_the_user_should_enter_valid_python_code() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("The user clicks on {string} button after entering wrong python code")
public void the_user_clicks_on_button_after_entering_wrong_python_code(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("The user clicks on {string} button after entering correct python code")
public void the_user_clicks_on_button_after_entering_correct_python_code(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("The user should see the correct output")
public void the_user_should_see_the_correct_output() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("The user is on the DSAlgo Tree page")
public void the_user_is_on_the_ds_algo_tree_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("The user sees {string} label on the {string} page")
public void the_user_sees_label_on_the_page(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("The user sees a button with {string} label on the {string} page")
public void the_user_sees_a_button_with_label_on_the_page(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("The user is on the DSAlgo Tree page of the portal")
public void the_user_is_on_the_ds_algo_tree_page_of_the_portal() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("The user sees {string} dropdown")
public void the_user_sees_dropdown(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

/*@Then("The user logs in with valid credentials")
public void the_user_logs_in_with_valid_credentials() {
	treepage.userLoggedin();
  
}*/

}
