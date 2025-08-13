package com.qa.dsalgo.stepdefinations;

import com.qa.dsalgo.base.DriverScripts;
import com.qa.dsalgo.pages.Background;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterationSteps extends DriverScripts{
   

	Background background;
	@Given("The user is on the DSAlgo portal")
	public void the_user_is_on_the_ds_algo_portal() {

        // Initialize the page object with the current driver
		initializeApplication();
		background = new Background(driver); // driver must not be null


    }
	

	@When("The user clicks \"GetStarted button on wellcome page")
	public void the_user_clicks_get_started_button_on_wellcome_page() {
		
		background.ClickGetStarted();

	}

/*	@Then("The user lands on the home page of DSAlgo portal")
	public void the_user_lands_on_the_home_page_of_ds_algo_portal() {
	    

	}

	@Given("The user is on the home page of the portal")
	public void the_user_is_on_the_home_page_of_the_portal() {
	    
	}

	@When("The user clicks on the Register link on home page")
	public void the_user_clicks_on_the_register_link_on_home_page() {
	    

	}

	@Then("The user lands on Register page")
	public void the_user_lands_on_register_page() {
	    
;
	}

	@Then("The user sees {string} label on the top left corner of the {string} page")
	public void the_user_sees_label_on_the_top_left_corner_of_the_page(String string, String string2) {
	    

	}

	@Then("The user sees the data structures select box on the top left corner of the {string} page")
	public void the_user_sees_the_data_structures_select_box_on_the_top_left_corner_of_the_page(String string) {
	    
	}

	@Then("The user sees {string} link on  the top right corner of the  Register page")
	public void the_user_sees_link_on_the_top_right_corner_of_the_register_page(String string) {
	    

	}

	@Then("The user sees {string} label on Regiser pagepage")
	public void the_user_sees_label_on_regiser_pagepage(String string) {
	    
	}

	@Then("The user sees {string} label on Register page")
	public void the_user_sees_label_on_register_page(String string) {
	    
	}

	@Then("The user sees {string} on the Register page")
	public void the_user_sees_on_the_register_page(String string) {
	    

	}

	@Given("The user is on the register page of the portal")
	public void the_user_is_on_the_register_page_of_the_portal() {
	    
	}

	@When("The user clicks {string} button without entering username")
	public void the_user_clicks_button_without_entering_username(String string) {
	    
	}

	@Then("The error message {string} should be displayed")
	public void the_error_message_should_be_displayed(String string) {
	    
	}

	@When("The user clicks Register button after entering {string} values in username text box and valid password")
	public void the_user_clicks_register_button_after_entering_values_in_username_text_box_and_valid_password(String string) {
	    
	}

	@When("The user clicks Register button after entering {string} values in password text box and valid username")
	public void the_user_clicks_register_button_after_entering_values_in_password_text_box_and_valid_username(String string) {
	    
	}

	@When("The user clicks Register button after entering {string} values in passwordtext box and valid username")
	public void the_user_clicks_register_button_after_entering_values_in_passwordtext_box_and_valid_username(String string) {
	    
	}

	/*@When("The user clicks Register button after entering a username with spacebar characters other than digits and @\\/.\\/+\\/-\\/_")
	public void the_user_clicks_register_button_after_entering_a_username_with_spacebar_characters_other_than_digits_and() {
	    .cucumber.java.PendingException();
	}*/

	/*@Then("The user should see an error message reading {string}")
	public void the_user_should_see_an_error_message_reading(String string) {
	    
	}

	@Given("The user clicks Register button after entering a username with spacebar characters other than digits and @\\/.\\/+\\/-\\/_")
	public void the_user_clicks_register_button_after_entering_a_username_with_spacebar_characters_other_than_digits_and() {
	    
	}

	@When("The user clicks Register button after entering {string} values in password text box and valid username and {string} value in confirm password text box")
	public void the_user_clicks_register_button_after_entering_values_in_password_text_box_and_valid_username_and_value_in_confirm_password_text_box(String string, String string2) {
	  
	}

	@Then("The user sees {string}")
	public void the_user_sees(String string) {
	    
	}

	@Then("The user sees {string} message on the Register page")
	public void the_user_sees_message_on_the_register_page(String string) {
	    
	}

	@When("The user enters admin in username text box and password in password textbox")
	public void the_user_enters_admin_in_username_text_box_and_password_in_password_textbox() {
	 
	}

	@Then("The user should see a message suggesting to enter a strong username and password")
	public void the_user_should_see_a_message_suggesting_to_enter_a_strong_username_and_password() {
	    
	}

	@When("The user enters {string} in username text box on register page")
	public void the_user_enters_in_username_text_box_on_register_page(String string) {
	    
	}

	@When("The user enters {string} in password text box on register page")
	public void the_user_enters_in_password_text_box_on_register_page(String string) {
	    
	}

	@When("The user enters {string} in confirm password text box on register page")
	public void the_user_enters_in_confirm_password_text_box_on_register_page(String string) {
	    
	}

	@When("The user clicks the Register button")
	public void the_user_clicks_the_register_button() {
	    
	}

	@Then("The user lands on the DSAlgo Home portal with Success Message {string}")
	public void the_user_lands_on_the_ds_algo_home_portal_with_success_message(String string) {
	    
	}*/




}
