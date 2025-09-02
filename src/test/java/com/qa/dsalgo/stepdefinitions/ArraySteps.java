/*package com.qa.dsalgo.stepdefinitions;

import org.testng.Assert;

import com.qa.dsalgo.base.DriverScripts;
import com.qa.dsalgo.pages.ArrayPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;*/


/*public class ArraySteps extends DriverScripts {
	ArrayPage arraypage;
	
    public ArraySteps() {
	this.arraypage = new ArrayPage(driver);
	}


	@When("The user clicks {string} button for the Array")
	public void the_user_clicks_button_for_the_array(String string) {
		arraypage.clickStartBtn();
	}

	@Then("the user should not be directed to {string} Module page but a message {string} should be displayed at the top of the homepage.")
	public void the_user_should_not_be_directed_to_module_page_but_a_message_should_be_displayed_at_the_top_of_the_homepage(
			String actualMessage, String expectedMessage) {
		String actualerrorMessage = arraypage.getnotlogedMessage();
		Assert.assertEquals(actualerrorMessage.trim(), expectedMessage, "Alert message does not match");
		System.out.println(actualerrorMessage);
	}

	@Given("The user signed in to dsAlgo Portal")
	public void the_user_signed_in_to_ds_algo_portal() {
		arraypage.userLoggedin();
	}

	@When("user clicks {string} button in Array Panel")
	public void user_clicks_button_in_array_panel(String string) {
		arraypage.clickStartBtn();
	}

	@When("user selects {string} item from {string} drop down")
	public void user_selects_item_from_drop_down(String dropdwnItem, String drpdownlbl) {
		arraypage.userLoggedin();
		arraypage.selectArrayFrmDropdown();
	}

	@Then("The User land on Array Page")
	public void the_user_land_on_array_page() {
		System.out.println("Actual page title: " + driver.getTitle());
		Assert.assertTrue(arraypage.arrayLabelDisplayed(), "Array page header not visible!");
	}
	
	@Then("the user should be directed to {string} Module page")
	public void the_user_should_be_directed_to_array_page_module_page(String moduleName) {
	    String actualTitle = driver.getTitle();
	    Assert.assertTrue(actualTitle.contains(moduleName), 
	        "Page title does not contain: " + moduleName + " | Actual title: " + actualTitle);
	}

	
	@Given("The user is on Array Data Structure")
	public void the_user_is_on_array_data_structure() {
	    arraypage.userLoggedin();
	    arraypage.clickStartBtn(); // Navigates to Array main page
	    Assert.assertEquals(arraypage.getTitleArraypage(), "Array", "Not on Array page!");
	}

	@And("The user clicks {string} link")
	public void the_user_clicks_link(String optionOnArray) {
	 //   ArrayPage arraypage = new ArrayPage(driver);
	    arraypage.clickArraySection(optionOnArray); // See method below
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

	@Then("The user should see alert with  error message {string} on Array in Python page")
	public void the_user_should_see_alert_with_error_message_on_array_in_python_page(String expectedMessage) {
	    String actualMessage = arraypage.getAlertMessageAndAccept();
	    Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch!");
	}
	
	/*@Given("The user is in the {string} page")
	public void the_user_is_in_the_page(String string) {

	}

	@When("The user clicks {string} button in Arrays in Python page")
	public void the_user_clicks_button_in_arrays_in_python_page(String string) {

	}

	@Then("The user should be redirected to a page having a try Editor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_a_try_editor_with_a_run_button_to_test() {

	}

	@Given("The user is in the tryEditor page for Array in Python module")
	public void the_user_is_in_the_try_editor_page_for_array_in_python_module() {

	}

	@When("The user clicks the Run Button without entering the code in the Editor")
	public void the_user_clicks_the_run_button_without_entering_the_code_in_the_editor() {

	}

	@Then("The user should able to see an error message in alert window")
	public void the_user_should_able_to_see_an_error_message_in_alert_window() {

	}

	@When("The user write the invalid code in Editor and click the Run Button")
	public void the_user_write_the_invalid_code_in_editor_and_click_the_run_button() {

	}

	@When("The user write the valid code in Editor and click the Run ButtonThe user write the valid code in Editor and click the Run Button")
	public void the_user_write_the_valid_code_in_editor_and_click_the_run_button_the_user_write_the_valid_code_in_editor_and_click_the_run_button() {

	}

	@Then("The user should able to see output in the console")
	public void the_user_should_able_to_see_output_in_the_console() {

	}

	@Given("The user is in the Array page after Sign in")
	public void the_user_is_in_the_array_page_after_sign_in() {

	}

	/*@When("The user clicks the {string} link")
	public void the_user_clicks_the_link(String string) {

	}*/

	/*@Then("The user should be redirected to {string} page contains a question,and try Editor with Run and Submit buttons")
	public void the_user_should_be_redirected_to_page_contains_a_question_and_try_editor_with_run_and_submit_buttons(
			String string) {

	}*/

	/*@Given("The user is on the practice question editor")
	public void the_user_is_on_the_practice_question_editor() {
		arraypage.practicQuestionValidScn();
	}*/
	
	/*@Given("The user is on the {string} page")// user is on practice question page
	public void the_user_is_on_the_page(String string) {
		arraypage.practicQuestionValidScn();
	}
	
	@When("The user clicks the {string} link")// user clicks search array link 
	public void the_user_clicks_the_link(String string) {
		arraypage.clickSearchArrayLink();		

	}


   /*@When("The user write the valid code in Editor on practice question page and Click the Run Button")
   public void the_user_write_the_valid_code_in_editor_on_practice_question_page_and_click_the_run_button() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }*/
	
	/*@Given("run valid code by clicking run button after entering {string} in try editor")
	public void run_valid_code_by_clicking_run_button_after_entering_in_try_editor(String code) {
	    arraypage.codeEditorSendKeys(code);
	    arraypage.clickRunBtn();
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
	
	/*@Given("The user clicks {string} button in Arrays in Pythonn")
	public void the_user_clicks_button_in_arrays_in_pythonn(String string) {
	    arraypage.clickTryMeButton();
    
	}*/
	

	/*@Then("The user should able to see {string} output in the console")
	public void the_user_should_able_to_see_output_in_the_console(String message) {
	    arraypage.outputDisplayed();
	    String actualMessage = arraypage.getTextoutput();
	    Assert.assertEquals(actualMessage.trim(), message.trim(), "Alert message mismatch!");

	    
	}

	
	
}*/
	
	
	
	package com.qa.dsalgo.stepdefinitions;

	import org.testng.Assert;

	import com.qa.dsalgo.base.DriverScripts;
	import com.qa.dsalgo.pages.ArrayPage;
	import io.cucumber.java.en.And;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;


	public class ArraySteps extends DriverScripts {
		ArrayPage arraypage;
		
	    public ArraySteps() {
		this.arraypage = new ArrayPage(driver);
		}


		@When("The user clicks {string} button for the Array")
		public void the_user_clicks_button_for_the_array(String string) {
			arraypage.clickStartBtn();
		}

		@Then("the user should not be directed to {string} Module page but a message {string} should be displayed at the top of the homepage.")
		public void the_user_should_not_be_directed_to_module_page_but_a_message_should_be_displayed_at_the_top_of_the_homepage(
				String actualMessage, String expectedMessage) {
			String actualerrorMessage = arraypage.getnotlogedMessage();
			Assert.assertEquals(actualerrorMessage.trim(), expectedMessage, "Alert message does not match");
			System.out.println(actualerrorMessage);
		}

		@Given("The user signed in to dsAlgo Portal")
		public void the_user_signed_in_to_ds_algo_portal() {
			arraypage.userLoggedin();
		}

		@When("user clicks {string} button in Array Panel")
		public void user_clicks_button_in_array_panel(String string) {
			arraypage.clickStartBtn();
		}

		@When("user selects {string} item from {string} drop down")
		public void user_selects_item_from_drop_down(String dropdwnItem, String drpdownlbl) {
			arraypage.userLoggedin();
			arraypage.selectArrayFrmDropdown();
		}

		@Then("The User land on Array Page")
		public void the_user_land_on_array_page() {
			System.out.println("Actual page title: " + driver.getTitle());
			Assert.assertTrue(arraypage.arrayLabelDisplayed(), "Array page header not visible!");
		}
		
		@Then("the user should be directed to {string} Module page")
		public void the_user_should_be_directed_to_array_page_module_page(String moduleName) {
		    String actualTitle = driver.getTitle();
		    Assert.assertTrue(actualTitle.contains(moduleName), 
		        "Page title does not contain: " + moduleName + " | Actual title: " + actualTitle);
		}

		
		@Given("The user is on Array Data Structure")
		public void the_user_is_on_array_data_structure() {
		    arraypage.userLoggedin();
		    arraypage.clickStartBtn(); // Navigates to Array main page
		    Assert.assertEquals(arraypage.getTitleArraypage(), "Array", "Not on Array page!");
		}

		@And("The user clicks {string} link")
		public void the_user_clicks_link(String optionOnArray) {
		 //   ArrayPage arraypage = new ArrayPage(driver);
		    arraypage.clickArraySection(optionOnArray); // See method below
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

		@Then("The user should see alert with  error message {string} on Array in Python page")
		public void the_user_should_see_alert_with_error_message_on_array_in_python_page(String expectedMessage) {
		    String actualMessage = arraypage.getAlertMessageAndAccept();
		    Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch!");
		}
		
		@Given("The user is in the {string} page")
		public void the_user_is_in_the_page(String string) {

		}

		@When("The user clicks {string} button in Arrays in Python page")
		public void the_user_clicks_button_in_arrays_in_python_page(String string) {

		}

		@Then("The user should be redirected to a page having a try Editor with a Run button to test")
		public void the_user_should_be_redirected_to_a_page_having_a_try_editor_with_a_run_button_to_test() {

		}

		@Given("The user is in the tryEditor page for Array in Python module")
		public void the_user_is_in_the_try_editor_page_for_array_in_python_module() {

		}

		@When("The user clicks the Run Button without entering the code in the Editor")
		public void the_user_clicks_the_run_button_without_entering_the_code_in_the_editor() {

		}

		@Then("The user should able to see an error message in alert window")
		public void the_user_should_able_to_see_an_error_message_in_alert_window() {

		}

		@When("The user write the invalid code in Editor and click the Run Button")
		public void the_user_write_the_invalid_code_in_editor_and_click_the_run_button() {

		}

		@When("The user write the valid code in Editor and click the Run ButtonThe user write the valid code in Editor and click the Run Button")
		public void the_user_write_the_valid_code_in_editor_and_click_the_run_button_the_user_write_the_valid_code_in_editor_and_click_the_run_button() {

		}

		@Then("The user should able to see output in the console")
		public void the_user_should_able_to_see_output_in_the_console() {

		}

		@Given("The user is in the Array page after Sign in")
		public void the_user_is_in_the_array_page_after_sign_in() {

		}

		/*@When("The user clicks the {string} link")
		public void the_user_clicks_the_link(String string) {

		}*

		@Then("The user should be redirected to {string} page contains a question,and try Editor with Run and Submit buttons")
		public void the_user_should_be_redirected_to_page_contains_a_question_and_try_editor_with_run_and_submit_buttons(
				String string) {

		}

		/*@Given("The user is on the practice question editor")
		public void the_user_is_on_the_practice_question_editor() {
			arraypage.practicQuestionValidScn();
		}*/
		
		@Given("The user is on the {string} page")// user is on practice question page
		public void the_user_is_on_the_page(String string) {
			arraypage.practicQuestionValidScn();
		}
		
		@When("The user clicks the {string} link")// user clicks search array link 
		public void the_user_clicks_the_link(String string) {
			arraypage.clickSearchArrayLink();		

		}


	   /*@When("The user write the valid code in Editor on practice question page and Click the Run Button")
	   public void the_user_write_the_valid_code_in_editor_on_practice_question_page_and_click_the_run_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	  }*/
		
		@Given("run valid code by clicking run button after entering {string} in try editor")
		public void run_valid_code_by_clicking_run_button_after_entering_in_try_editor(String code) {
		    arraypage.codeEditorSendKeys(code);
		    arraypage.clickRunBtn();
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
		
		/*@Given("The user clicks {string} button in Arrays in Pythonn")
		public void the_user_clicks_button_in_arrays_in_pythonn(String string) {
		    arraypage.clickTryMeButton();
	    
		}*/
		

		@Then("The user should able to see {string} output in the console")
		public void the_user_should_able_to_see_output_in_the_console(String message) {
		    arraypage.outputDisplayed();
		    String actualMessage = arraypage.getTextoutput();
		    Assert.assertEquals(actualMessage.trim(), message.trim(), "Alert message mismatch!");

		    
		}

		
		
	}




