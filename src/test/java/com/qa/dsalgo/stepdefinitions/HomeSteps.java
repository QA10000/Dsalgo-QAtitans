package com.qa.dsalgo.stepdefinitions;

import org.testng.Assert;

import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomeSteps {
	Background background;
	private WebDriver driver;
	HomePage homePage;
	
	private static final Logger logger = LogManager.getLogger(HomeSteps.class);
	
	public HomeSteps(){
		driver = Hooks.getDriver();
		homePage =  new HomePage(driver);
	}	
	@Given("The user is in the DS Algo Home Page")
	public void the_user_is_in_the_ds_algo_home_page() {
		homePage.homePageLogin();
		logger.info("In Given Step: The user is in the DS Algo Home Page");
	}

	@When("The User clicks Get Started button present under Data Structure Introduction box")
	public void the_user_clicks_get_started_button_present_under_data_structure_introduction_box() {
		homePage.clickGetStartedButtonHomePageDSIntroModule();
	}
	
	@When("The User clicks Get Started button present under Array box")
	public void the_user_clicks_getStarted_button() {
		homePage.clickGetStartedButtonHomePageArrayModule();
	}

	@When("The User clicks Get Started button present under Stack box")
	public void the_user_clicks_get_started_button_of_stack_module_on_ds_algo_home_page() {
		homePage.clickGetStartedButtonHomePageStackModule();
	}

	@When("The User clicks GetStarted button of Data Structures-Introduction module on DS Algo Home page")
	public void the_user_clicks_get_started_button_of_DS_Intro_module_on_ds_algo_home_page() {
		homePage.clickGetStartedButtonHomePageDSIntroModule();
	}

	@When("The User clicks Get Started button present under Linked List box")
	public void the_user_clicks_get_started_button_of_Linked_List_module_on_ds_algo_home_page() {
		homePage.clickGetStartedButtonHomePageLinkedListModule();
	}
	
	@When("The User clicks Get Started button present under Queue box")
	public void the_user_clicks_get_started_button_of_queue_module_on_ds_algo_home_page() {
		homePage.clickGetStartedButtonHomePageQueueModule();
	}

	@When("The User clicks  Get Started button present under Tree box")
	public void the_user_clicks_get_started_button_present_under_tree_box() {
		homePage.clickGetStartedButtonHomePageTreeModule();    
	}

	@When("The User clicks Get Started button present under Graph box")
	public void the_user_clicks_get_started_button_of_Graph_module_on_ds_algo_home_page() {
		homePage.clickGetStartedButtonHomePageGraphModule();
	}
	
	@Then("The user should able to see an warning message {string}")
	public void the_user_should_able_to_see_an_warning_message(String expectedMessage) {
		String actualMessage = homePage.getnotlogedMessage();
		logger.info("In Then Step: The user should able to see an warning actualMessage : "+actualMessage+" || Expected Message : "+expectedMessage);
	    Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Message mismatch!");
	}
	
	@Given("The user is on the DS-Algo portal")
	public void the_user_is_on_the_ds_algo_portal() {
		homePage.homePageLogin();
	}

	@When("The user clicks {string} button on welcome-page")
	public void the_user_clicks_button_on_welcome_page(String string) {
		homePage.clickGetStartedButton();
	}
	
	@Then("The user lands on the home page of DS-Algo portal")
	public void the_user_lands_on_the_home_page_of_ds_algo_portal() {
		String actualPageTitle = homePage.getErrormessage();
		String expectedPageTitle = driver.getTitle();
		logger.info("The user lands on the home page of DS-Algo portal : actualPageTitle "+actualPageTitle+" Expected "+expectedPageTitle);
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
	}
	
	@Then("The user sees \"NumpyNinja\" label on the top left corner of {string} page")
	public void the_user_see_s_numpy_ninja_label_on_the_top_left_corner_of_the_page(String paig) {
		logger.info("The user see s\\\"NumpyNinja\\\" label on the top left corner of the "+paig+" page");
		Assert.assertEquals(homePage.getNumpyNinjaLinkText(), "NumpyNinja");
	}

	@Then("The user sees the data structures select box on the top left corner of the {string} page")
	public void the_user_sees_the_data_structures_select_box_on_the_top_left_corner_of_the_page(String string) {
		logger.info("The user sees the data structures select box on the top left corner of the {string} page");
		Assert.assertEquals(homePage.getDataStructureLblText(), "Data Structures");
	}

	@Then("The user sees {string} link on the top right corner of Home page")
	public void the_user_sees_link_on_the_top_right_corner_of_the_home_page(String expectedLabel) {
		String actualLabel = homePage.getRegisterLinkText();
		logger.info("Verifying that the user sees Register link");
		Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
	}	

	@Then("The user sees {string} link on the top right corner of the Home page")
	public void the_user_sees_link_on_the_top_right_most_corner_of_the_home_page(String expectedLabel) {
		String actualLabel = homePage.getSigninLinkText();
		logger.info("Verifying that the user sees Signin Link");
		Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
	}	

	@Given("the user is on the DS Algo Home Page")
	public void the_user_is_on_the_ds_algo_home_page() {
		homePage.homePage();
		logger.info("the user is on the DS Algo Home Page");
	}

	@When("the user has not logged in")
	public void the_user_has_not_logged_in() {
		homePage.getnotlogedMessage();
		logger.info("the user has not logged in");
	}
	
	@Then("The user sees {string} label on top left corner of {string} page")
	public void the_user_sees_label_on_the_top_left_corner_of_the_page_module(String expectedLabel, String page) {
		String actualLabel = homePage.getNumpyNinjaLinkText();
		logger.info("Verifying that the user sees NumpaiNinja logo | expectedLabel | "+expectedLabel+" | actualLabel | "+actualLabel);
		Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
	}
	@Then("The user sees the {string} drop-down box on the top left corner of the {string} page")
	public void the_user_sees_the_dropdown_box_on_the_top_left_corner_of_the_page_module(String expectedLabel,String lblTxt) {
		String actualLabel = homePage.getDataStructureLblText();
		logger.info("Verifying that the user sees label for  Data Structure dropdown | expectedLabel | "+expectedLabel+" | actualLabel | "+actualLabel);
		Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
	}	
}