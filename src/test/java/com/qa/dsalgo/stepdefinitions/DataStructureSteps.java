package com.qa.dsalgo.stepdefinitions;

import com.qa.dsalgo.base.DriverScripts;
import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.DataStructurePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
//import org.openqa.selenium.WebDriver;

public class DataStructureSteps extends DriverScripts {
	Background background;
	//private WebDriver driver;
	// HomePage homePage;
	DataStructurePage dataStructurePage;   
	
	public static void main(String[] args) {
		System.out.println("In HomePageSteps main(): " +new DataStructureSteps());		
	}

	public DataStructureSteps(){
		// driver = Hooks.getDriver();
		initializeApplication();// Initialize the page object with the current driver
		System.out.println("In DataStructureSteps() driver "+driver);
		dataStructurePage = new DataStructurePage(driver);
		System.out.println("In DataStructureSteps() DataStructurePage "+dataStructurePage);		
	}

	@Given("The user is on signon page of the DS-Algo page")
	public void the_user_is_on_signon_page_of_the_ds_algo_page() {
		dataStructurePage.Login();
		System.out.println("In GIVEN : The user is on signon page of the DS-Algo page");	
	}

	@When("The user enter valid username {string} and password {string}")
	public void the_user_enter_valid_username_and_password(String uid, String pwd) {
		dataStructurePage.CorrectUsernameAndPassword(uid, pwd);
		// LOG.info("User logged into the homepage entering valid user name and password");
		System.out.println("In WHEN : In The user enter valid username "+uid+" and password "+pwd);
	}

	@Then("It should display {string}")
	public void it_should_display(String msg) {
		String getSuccessMessage = dataStructurePage.getLoginSuccessMessage();
		Assert.assertEquals(getSuccessMessage,msg);
		System.out.println("In THEN : it_should_display.getSuccessMessage--> "+getSuccessMessage+" | Msg --> "+msg);		
	}

	@Given("The user is on the home page after successful login with username {string} and password {string} with message {string}")
	public void the_user_is_on_the_home_page_after_successful_login_with_username_password(String uid, String pwd, String msg) {
		dataStructurePage.Login();
		dataStructurePage.CorrectUsernameAndPassword(uid, pwd);
		String getSuccessMessage = dataStructurePage.getLoginSuccessMessage();
		Assert.assertEquals(getSuccessMessage,msg);
		dataStructurePage.homePage();
		System.out.println("In GIVEN : The user is on home page after successful login getSuccessMessage--> "+getSuccessMessage+" | Msg --> "+msg);
	}
	
	@When("The user clicks the Get Started button under Data Structures introduction panel")
	public void the_user_clicks_the_get_started_button_under_data_structures_introduction_panel() {
		dataStructurePage.clickDataStructuresGetStarted();
		// LOG.info("User logged into the homepage entering valid user name and password");
		System.out.println("In WHEN : The user clicks the Get Started button under Data Structures introduction panel::getTitle() "+dataStructurePage.getTitle());
	}

	@Then("The user should be redirected to Data Structures introduction page")
	public void the_user_should_be_redirected_to_data_structures_introduction_page() {
		dataStructurePage.dataStructuresIntroPage();
		System.out.println("In THEN : The user should be redirected to Data Structures introduction page ");		
	}	
}