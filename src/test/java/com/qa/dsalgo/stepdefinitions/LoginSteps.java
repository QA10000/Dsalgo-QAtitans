

package com.qa.dsalgo.stepdefinitions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.qa.dsalgo.pages.ArrayPage;
import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;


public class LoginSteps {
	private WebDriver driver;
	Background background;
	LoginPage loginpage;
	
	public LoginSteps() {
		System.out.println(">> In Loginsteps constructor.");
		driver = Hooks.getDriver();
		background = new Background(driver);
		loginpage = new LoginPage(driver);
		
	}
	/*
	@Given("The user is on the DSAlgo portal")
	public void the_user_is_on_the_ds_algo_portal() {
		System.out.println(">> The user is on the DSAlgo portal.");
		initializeApplication();
		background = new Background(driver); // driver must not be null		
	}
		*/
	
	/*
	@Given("The user is on the DSAlgo portal")
	public void the_user_is_on_the_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("The user clicks {string} button on welcome page")
	public void the_user_clicks_button_on_welcome_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("The user lands on the home page of DSAlgo portal")
	public void the_user_lands_on_the_home_page_of_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
*/
	

	/*@When("The user clicks on the Signin link on home page")
	public void the_user_clicks_on_the_signin_link_on_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/

	
	
	
	@Given("The user is on the home page of the portal")
	public void theUserIsOnTheHomePageOfThePortal() {
		driver.get("https://dsportalapp.herokuapp.com/home");
	}
	
	/*@When("The user clicks \"GetStarted\" button on welcome page")
	public void the_user_clicks_get_started_button_on_wellcome_page() {
		System.out.println(">> The user clicks \"GetStarted\" button on welcome page.");
		//background = new Background(driver); // driver must not be null
		background.ClickGetStarted();
		
	}*/

	@When("The user clicks on the Signin link on home page")
	public void the_user_clicks_on_the_signin_link_on_home_page() {
		System.out.println(">> The user clicks on the Signin link on home page");
		loginpage = new LoginPage(driver);
		loginpage.clickLoginLink();
	}

	@When("The user clicks login button after entering valid username as {string} and password as {string}")
	public void theUserClicksLoginButtonAfterEnteringValidUsernameAsAndPasswordAs(String string, String string2) {
		System.out.println(">> The user clicks login button after entering valid username as " + string  + " and password as " + string2);
		loginpage = new LoginPage(driver);
		loginpage.clickLoginLink();
		loginpage.enterUsername(string);
		loginpage.enterPassword(string2);
		loginpage.submitForm();
	}
	
	@When("The user clicks login button after entering valid values from {string}")
	public void the_user_clicks_login_button_after_entering_valid_values_from_Sheet(String string) {
		System.out.println(">> The user clicks login button after entering valid values from " + string);
		loginpage = new LoginPage(driver);
		loginpage.clickLoginLink();
	    String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/testdata.xlsx";
	    List<Map<String, String>> users = ExcelReader.readMultiRowData(filePath, string);
	    //validateLogin(loginpage, users);
	    for (Map<String, String> row : users) {
	    	System.out.println("DEBUG: Number of data rows read from Excel: " + row.size());
		    System.out.println("password: " + row.get("password"));
		    System.out.println("username: " + row.get("username"));        
		    String username =row.get("username");
		    String password =row.get("password");
		    System.out.println("DEBUG - Username from test data: " + username);
			loginpage.enterUsername(username);
		    loginpage.enterPassword(password);
		    loginpage.submitForm();	    	
	    }	    
	}

	@Given("The user is on the Login page of the portal")
	public void The_user_is_on_the_Login_page_of_the_portal() {
		driver.get("https://dsportalapp.herokuapp.com/login");
	}
	
	@When("The user enters invalid username and password in the textboxes")
	public void The_user_enters_invalid_username_and_password_in_the_textboxes(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("The user enters invalid username and password in the textboxes");
		LoginPage loginpage = new LoginPage(driver);
		List<Map<String, String>> users = dataTable.asMaps(String.class, String.class); 
		validateLogin(loginpage, users);
	}
	
	private void validateLogin(LoginPage loginpage, List<Map<String, String>> users) {
		System.out.println("DEBUG: Number of data rows read from Excel: " + users.size());
		for (Map<String, String> user : users) 
		{
			String username = Optional.ofNullable(user.get("username")).orElse("");
		    String password = Optional.ofNullable(user.get("password")).orElse("");
		    String IsValidData = "";
		    if(user.containsKey("isdatavalid"))
		    	IsValidData = Optional.ofNullable(user.get("isdatavalid")).orElse("");
			
			System.out.println("Test username: " + username + " and password: " + password+ " and IsValidData: " + IsValidData);
			
			boolean usernameEmpty = username == null || username.trim().isEmpty();
	        boolean passwordEmpty = password == null || password.trim().isEmpty();
	        
			loginpage.login(username, password);
			
			String error = loginpage.getErrorMessage();
			if (usernameEmpty == false && passwordEmpty== false) {
				
				//if(IsValidData == "Y" || IsValidData.isEmpty()) {
				if ("Y".equalsIgnoreCase(IsValidData) || IsValidData.isEmpty())

				System.out.println("Actual valid login/pwd error text: '" + error + "'");
					Assert.assertTrue(error.contains("Invalid Username and Password"));
				}
			
 			     else if ("N".equalsIgnoreCase(IsValidData)) {

				//else if(IsValidData == "N") {
 			    System.out.println("Actual valid login/pwd error text: '" + error + "'");
				Assert.assertTrue(error.contains("Invalid Username and Password"));
				}
			
	  
	
		        if (usernameEmpty) {
	            String actualUsernameMessage = loginpage.getUsernameValidationMessage();
	            String expectedUsernameMessage = "Please fill out this field.";
	    		System.out.println("Expected error text: '" + expectedUsernameMessage + "', Observed Msg: '" + actualUsernameMessage + "'");
	    		Assert.assertTrue(actualUsernameMessage.contains(expectedUsernameMessage));
	        }

	        if (passwordEmpty) {
	            String actualPasswordValidationMessage = loginpage.getPasswordValidationMessage();
	    		String expectedPasswordValidationMessage = "Please fill out this field.";
	    		System.out.println("Expected error text: '" + expectedPasswordValidationMessage + "', Observed Msg: '" + actualPasswordValidationMessage + "'");
	    		Assert.assertTrue(actualPasswordValidationMessage.contains(expectedPasswordValidationMessage));
	        }
		}
	}
	
	@Then ("The user should see an error message")
	public void The_user_should_see_an_error_message(){
		//System.out.println("it should display the error message \"<errorMessage>\"");
		// Already asserted in the loop above, this step can be left empty or used for logging
        driver.quit();
	}
	
	@Then("The user lands on the DS Algo Home portal with success message {string}")
	public void the_user_lands_on_the_ds_algo_home_portal_with_success_message(String message) {
		LoginPage loginpage = new LoginPage(driver);
	    String expectedMessage = "You are logged in";
		String actualMessage = loginpage.getSuccessMessage(); // you'll implement this method
		Assert.assertEquals(actualMessage, expectedMessage, "Success message mismatch!");
	}
	@Then("The user sees {string} label on the top left corner of the {string} page")
	public void theUserSeesLabelOnTheTopLeftCornerOfThePage(String expectedLabel, String pageName) {
		LoginPage loginpage = new LoginPage(driver);		
        String actualLabel = loginpage.getNumpyNinjaLinkText();
        System.out.println("Expected label text: '" + expectedLabel + "', Observed Msg: '" + actualLabel + "'");
        Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
    }
	
	@Then("The user sees the {string} dropdown box on the top left corner of the {string} page")
	public void theUserSeesTheDropdownBoxOnTheTopLeftCornerOfThePage(String expectedLabel, String pageName) {
		LoginPage loginpage = new LoginPage(driver);		
        String actualLabel = loginpage.getDataStructureDropdownText();
        System.out.println("Expected label text: '" + expectedLabel + "', Observed Msg: '" + actualLabel + "'");
        Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
	}
	
	@Then("The user sees the {string} link on the top right corner of the {string} page")
	public void theUserSeesTheLinkOnTheTopRightCornerOfThePage(String expectedLabel, String pageName) {
		LoginPage loginpage = new LoginPage(driver);		
        String actualLabel = loginpage.getRegisterLinkText();
        System.out.println("Expected label text: '" + expectedLabel + "', Observed Msg: '" + actualLabel + "'");
        Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
	}
	
	@Given("The user opens a web browser")
    public void the_user_opens_a_web_browser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
		System.out.println("The user opens a web browser");
    }

  /*  @When("The user enters the application URL with {string} instead of {string}")
    public void the_user_enters_the_application_url_with_http_instead_of_https(String protocol1, String protocol2) {
    	System.out.println("The user enters the application URL with " + protocol1 + " instead of " + protocol2);
    	System.out.println("Url : 'http://dsportalapp.herokuapp.com'");
    	driver.get("http://dsportalapp.herokuapp.com");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	String currentUrl = driver.getCurrentUrl();
    	System.out.println("currentUrl : '" + currentUrl + "'");
    }*/

   /* @Then("The Home Page should not load")
    public void the_home_page_should_not_load() {
    	System.out.println("The Home Page should not load");
        String currentUrl = driver.getCurrentUrl();
        // Case 1: If app blocks HTTP completely, page won't load
        // Case 2: If app redirects to HTTPS, then the URL will start with "https"
        System.out.println("currentUrl : '" + currentUrl + "'");
        boolean isRedirectedToHttps = currentUrl.startsWith("https");
        boolean isBlockedPage = driver.getPageSource().contains("This site can’t be reached") 
                                || driver.getTitle().contains("Error");
        System.out.println("isRedirectedToHttps: '" + isRedirectedToHttps + "', isBlockedPage: '" + isBlockedPage + "'");
        Assert.assertTrue((isRedirectedToHttps || isBlockedPage), "HTTP access should not be allowed");
        //assertTrue("HTTP access should not be allowed", isRedirectedToHttps || isBlockedPage);
        driver.quit();
    }*/
	@Then("The user sees {string} link on  the top right most corner of the Login page")
	public void The_user_sees_link_on_the_top_right_most_corner_of_the_Login_page (String expectedLabel) {
	LoginPage loginpage = new LoginPage(driver);		
    String actualLabel = loginpage. getSigninLinkText();
    System.out.println("Expected label text: '" + expectedLabel + "', Observed Msg: '" + actualLabel + "'");
    Assert.assertEquals(actualLabel, expectedLabel, "Label mismatch!");
	}
	
}
