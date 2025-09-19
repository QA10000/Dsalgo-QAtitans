package com.qa.dsalgo.stepdefinitions;

// import java.util.List;
// import java.util.Map;

import org.testng.Assert;

import com.qa.dsalgo.base.DriverScripts;
import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.HomePage;
// import com.qa.dsalgo.pages.RegisterPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import com.qa.dsalgo.stepdefinitions.Hooks;

public class HomeSteps extends DriverScripts {
	Background background;
	//private WebDriver driver;
	HomePage homePage;
	
	public static void main(String[] args) {
		System.out.println("In HomeSteps main(): " +new HomeSteps());		
	}

	public HomeSteps(){
		driver = Hooks.getDriver();
		// initializeApplication();// Initialize the page object with the current driver
		System.out.println("In HomePageSteps() driver "+driver);
		homePage =  new HomePage(driver);
		System.out.println("In HomeSteps() homePage "+homePage);		
	}	

	@Given("The user is in the DS Algo Home Page")
	public void the_user_is_in_the_ds_algo_home_page() {
		//initializeApplication();// Initialize the page object with the current driver
		// background = new Background(driver); // driver must not be null
		// homePage.homePageLogin();
		System.out.println("In Given Step: The user is in the DS Algo Home Page");
	}

	@When("The User clicks GetStarted button of Array module on DS Algo Home page")
	// public void the_user_button_present_under_box(String string, String string2) {
	public void the_user_clicks_getStarted_button() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("In When Step: The User clicks GetStarted button of Array module on DS Algo Home page: ");
		homePage.clickGetStartedButtonHomePageArrayModule();
	}

	@When("The User clicks GetStarted button of Stack module on DS Algo Home page")
	public void the_user_clicks_get_started_button_of_stack_module_on_ds_algo_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("In When Step: The User clicks GetStarted button of Stack module on DS Algo Home page: ");
		homePage.clickGetStartedButtonHomePageStackModule();
	}

	@When("The User clicks GetStarted button of Data Structures-Introduction module on DS Algo Home page")
	public void the_user_clicks_get_started_button_of_DS_Intro_module_on_ds_algo_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("In When Step: The User clicks GetStarted button of Data Structures-Introduction module on DS Algo Home page: ");
		homePage.clickGetStartedButtonHomePageDSIntroModule();
	}

	@When("The User clicks GetStarted button of Linked List module on DS Algo Home page")
	public void the_user_clicks_get_started_button_of_Linked_List_module_on_ds_algo_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("In When Step: The User clicks GetStarted button of Linked List module on DS Algo Home page: ");
		homePage.clickGetStartedButtonHomePageLinkedListModule();
	}
	
	@When("The User clicks GetStarted button of Queue module on DS Algo Home page")
	public void the_user_clicks_get_started_button_of_queue_module_on_ds_algo_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("In When Step: The User clicks GetStarted button of queue module on DS Algo Home page: ");
		homePage.clickGetStartedButtonHomePageQueueModule();
	}

	@When("The User clicks GetStarted button of Tree module on DS Algo Home page")
	public void the_user_clicks_get_started_button_of_Tree_module_on_ds_algo_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("In When Step: The User clicks GetStarted button of Tree module on DS Algo Home page: ");
		homePage.clickGetStartedButtonHomePageTreeModule();
	}

	@When("The User clicks GetStarted button of Graph module on DS Algo Home page")
	public void the_user_clicks_get_started_button_of_Graph_module_on_ds_algo_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("In When Step: The User clicks GetStarted button of Graph module on DS Algo Home page: ");
		homePage.clickGetStartedButtonHomePageGraphModule();
	}
	
	@Then("The user should able to see an warning message {string}")
	public void the_user_should_able_to_see_an_warning_message(String expectedMessage) {
		String actualMessage = homePage.getnotlogedMessage();
		System.out.println("In Then Step: The user should able to see an warning actualMessage : "+actualMessage+" || Expected Message : "+expectedMessage);
	    Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Message mismatch!");
	}
	
	@Given("The user is on the DSAlgo portal")
	public void the_user_is_on_the_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
		homePage.homePageLogin();
		System.out.println("GIVEN :: The user is on the DSAlgo portal");	    
		// throw new io.cucumber.java.PendingException();
	}

	@When("The user clicks {string} button on welcome page")
	public void the_user_clicks_button_on_welcome_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
		homePage.clickGetStartedButton();
		System.out.println("WHEN :: The user clicks "+string+" button on welcome page");	    
		// throw new io.cucumber.java.PendingException();
	}
	
	@Then("The user lands on the home page of DSAlgo portal")
	public void the_user_lands_on_the_home_page_of_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("THEN :: The user lands on the home page of DSAlgo portal");	    
		// throw new io.cucumber.java.PendingException();
	}
	
	@Then("The user see s\"NumpyNinja\" label on the top left corner of the {string} page")
	public void the_user_see_s_numpy_ninja_label_on_the_top_left_corner_of_the_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("The user see s\\\"NumpyNinja\\\" label on the top left corner of the {string} page");
		//throw new io.cucumber.java.PendingException();
	}

	@Then("The user sees the data structures select box on the top left corner of the {string} page")
	public void the_user_sees_the_data_structures_select_box_on_the_top_left_corner_of_the_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("The user sees the data structures select box on the top left corner of the {string} page");
		//throw new io.cucumber.java.PendingException();
	}

	@Then("The user sees {string} link on  the top right corner of the  Home page")
	public void the_user_sees_link_on_the_top_right_corner_of_the_home_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("The user sees {string} link on  the top right corner of the  Home page");
		//throw new io.cucumber.java.PendingException();
	}

	@Given("the user is on the DS Algo Home Page")
	public void the_user_is_on_the_ds_algo_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("the user is on the DS Algo Home Page");
		// throw new io.cucumber.java.PendingException();
	}

	@When("the user has not logged in")
	public void the_user_has_not_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("the user has not logged in");
		// throw new io.cucumber.java.PendingException();
	}
	
	@When("The User {string} button present under {string} box")
	public void the_user_button_present_under_box(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see the following learning modules with {string} buttons:")
	public void the_user_should_see_the_following_learning_modules_with_buttons(String string, io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new io.cucumber.java.PendingException();
	}
	
	
}

