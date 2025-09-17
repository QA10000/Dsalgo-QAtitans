package com.qa.dsalgo.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.qa.dsalgo.pages.ArrayPage;
import com.qa.dsalgo.pages.Background;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArraySteps {
	private WebDriver driver;
	ArrayPage arraypage;
	Background background;

	public ArraySteps() {
		driver = Hooks.getDriver();
		background = new Background(driver);
		arraypage = new ArrayPage(driver);
	}

	@When("The user logs in with valid username {string} and password {string}")// i have this here because registeration steps dont have login step will create a background feature file and step file 
	public void the_user_logs_in_with_valid_username_and_password(String username, String password) {
	   background.userLoggedin(username, password);
	}

	@When("user clicks {string} button in Array Panel")
	public void user_clicks_button_in_array_panel(String string) {
		arraypage.clickStartBtn();
	}

	@When("user selects {string} item from {string} drop down")
	public void user_selects_item_from_drop_down(String dropdwnItem, String drpdownlbl) {
		arraypage.selectArrayFrmDropdown();
	}

	@Then("The User land on Array Page")
	public void the_user_land_on_array_page() {
		Assert.assertTrue(arraypage.arrayLabelDisplayed(), "Array page header not visible!");
	}
	
	@Then("the user should be directed to {string} Module page")
	public void the_user_should_be_directed_to_array_page_module_page(String moduleName) {
	    String actualTitle = driver.getTitle();
	    Assert.assertTrue(actualTitle.contains(moduleName), 
	        "Page title does not contain: " + moduleName + " | Actual title: " + actualTitle);
	}

	
	@Given("The user is on Array Data Structure")// scenario 2
	public void the_user_is_on_array_data_structure() {
	    arraypage.clickStartBtn(); // Navigates to Array main page
	    Assert.assertEquals(arraypage.getTitleArraypage(), "Array", "Not on Array page!");
	}

	@When("The user clicks {string} link")
	public void the_user_clicks_link(String optionOnArray) // clicking options on array page
	{
	    arraypage.clickArraySection(optionOnArray); 
	}

	@And("The user clicks \"Try Here\" button in Arrays in Python")
	public void the_user_clicks_try_here_button_in_arrays_in_python() {
	    arraypage.clickTryMeButton();
	}

	@And("run invalid code by clicking run button after entering {string} in try editor")
	public void run_invalid_code_by_clicking_run_button_after_entering_in_try_editor(String code) {
	    arraypage.codeEditorSendKeys(code);
	    arraypage.clickRunBtn();
	}

	@Then("The user should see alert with  error message {string} on Array in Python page")// till here
	public void the_user_should_see_alert_with_error_message(String expectedMessage) {
	    String actualMessage = arraypage.getAlertMessageAndAccept();
	    Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch!");
	}


@Given("The user is on the {string} page")// user is on practice question page
public void the_user_is_on_the_page(String string) {
	arraypage.practicQuestionValidScn();
}

@When("The user clicks the {string} link")// user clicks search array link 
public void the_user_clicks_the_link(String string) {
	arraypage.clickSearchArrayLink();		
}

@Given("run valid code by clicking run button after entering {string} in try editor")
public void run_valid_code_by_clicking_run_button_after_entering_in_try_editor(String code) {
    arraypage.codeEditorSendKeys(code);
    arraypage.clickRunBtn();
}



@Then("The user should able to see {string} output in the console")
public void the_user_should_able_to_see_output_in_the_console(String message) {
    arraypage.outputDisplayed();
    String actualMessage = arraypage.getTextoutput();
    Assert.assertEquals(actualMessage.trim(), message.trim(), "Alert message mismatch!");
 }

@When("The user write the valid {string} in Editor on practice question page and Click the Run Button")
public void the_user_write_the_valid_in_editor_on_practice_question_page_and_click_the_run_button(String code) {
	  arraypage.codeEditorSendKeys(code);
	    arraypage.clickRunBtn();
	}


@Then("The user see an error message {string}")
public void the_user_see_an_error_message(String string) {

}

@When("The user write the valid code in Editor and Click the Run Button")
public void the_user_write_the_valid_code_in_editor_and_click_the_run_button() {

}

@Then("The user see s\"NumpyNinja\" label on the top left corner of the {string} page")
public void the_user_see_s_numpy_ninja_label_on_the_top_left_corner_of_the_page(String string) {

}

@Then("The user sees the data structures select box on the top left corner of the {string} page")
public void the_user_sees_the_data_structures_select_box_on_the_top_left_corner_of_the_page(String string) {

}

@Then("The user sees {string} label on  the top right corner of the  Array page")
public void the_user_sees_label_on_the_top_right_corner_of_the_array_page(String string) {

}

@Then("The user sees {string} link on  the top right corner of the Array page")
public void the_user_sees_link_on_the_top_right_corner_of_the_array_page(String string) {



}
}