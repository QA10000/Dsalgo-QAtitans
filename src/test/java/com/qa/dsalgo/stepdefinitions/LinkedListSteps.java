package com.qa.dsalgo.stepdefinitions;

import org.openqa.selenium.WebDriver;

//import java.util.List;
//import java.util.Map;
//import java.util.Optional;

import org.testng.Assert;
import com.qa.dsalgo.pages.Background;
//import com.qa.dsalgo.pages.CreatingLinkedListPage;
import com.qa.dsalgo.pages.LinkedListPage;
import com.qa.dsalgo.pages.LoginPage;
import com.qa.dsalgo.pages.TryEditorPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LinkedListSteps {
	private WebDriver driver;
	Background background;
     LinkedListPage linkedlistpage;
	//LoginPage loginpage;
	TryEditorPage tryEditorPage ;
	
	public LinkedListSteps() {
		System.out.println(">> In LinkedListSteps constructor.");
		    
			driver = Hooks.getDriver();
			background = new Background(driver);
			linkedlistpage = new LinkedListPage(driver);
		//	loginpage = new LoginPage(driver);
			
		}
	
	@Given("The user is on the home page after login")
	public void theUserIsOnTheHomePageAfterLogin() {
		System.out.println("The user is on the home page after login");
		//loginpage = new LoginPage(driver);
		//loginpage.clickLoginLink();
		//loginpage.login("qatitans1", "1@Chicago");
	}

	@When("The user clicks the {string} button for Linked List module on Home page")
	public void theUserClicksTheButtonForLinkedListModuleOnHomePage(String string) {
		System.out.println("The user clicks the " + string + " button  for Linked List module on Home page");
		//linkedlistpage = new LinkedListPage(driver);
		linkedlistpage.clicklinkedListGetStarted();
	}

	@Then("The user lands on {string} page")
	public void theUserLandsOnThePage(String string) {
		System.out.println("The user lands on the " + string + " page");
	//	linkedlistpage = new LinkedListPage(driver);
		String expectedTitle = string; //"Linked List";
		//String actualTitle = linkedlistpage.getLinkedListOptionText(expectedTitle); //.getTitle();
		String actualTitle = linkedlistpage.getLinkedListOptionHeaderText(expectedTitle); //.getTitle();
		System.out.println("actualTitle: '" + actualTitle + "'");
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}

	@When("The user select Linked List item from the drop down menu")
	public void theUserSelectLinkedListItemFromTheDropDownMenu() {
		System.out.println("The user select Linked List  item from the drop down menu");
		driver.get("https://dsportalapp.herokuapp.com/home");
	//	linkedlistpage.clickDataStructuredropdown();
		linkedlistpage.SelectLinkedListFromDropDown();
		
	}

	@Given("The user is on Linked List page after login")
	public void theUserIsOnLinkedListPageAfterLogin() {
		System.out.println("The user is on Linked List page after login");
		//loginpage = new LoginPage(driver);
		//loginpage.clickLoginLink();
		//loginpage.login("qatitans1","1@Chicago");
		//linkedlistpage = new LinkedListPage(driver);
		linkedlistpage.clicklinkedListGetStarted();
	}

	@When("The user clicks on the {string} link")
	public void theUserClicksOnTheLink(String OptionOnLinkedList) {
		System.out.println("The user clicks on the '" + OptionOnLinkedList + "' link on the Linked List page");
		//linkedlistpage = new LinkedListPage(driver);
		linkedlistpage.clickLinkedListOption(OptionOnLinkedList);

		//linkedlistpage.goToCreatingLinkedListPage();
	}
	
	/*@When("The user clicks {string} button on {string} page")
	public void theUserClicksButtonOnPage(String string, String string2) {
		System.out.println("The user clicks on the " + string + " button on " + string2 + " page");
		CreatingLinkedListPage creatingLinkedListPage = new CreatingLinkedListPage(driver);
		creatingLinkedListPage.clickTryHere();
	}*/

	@When("The user clicks {string} button after entering invalid code {string} in try editor")
	public void theUserClicksButtonAfterEnteringInvalidCodeImTryEditor(String string, String string2) {
		System.out.println("The user clicks " + string + "  button after entering invalid code " + string2 + " in try editor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		tryEditorPage.codeEditorSendKeys(string2);
		tryEditorPage.clickRunBtn();
	}
	
	
	
	@When("The user clicks {string} button on {string} page")
    public void the_user_clicks_button_on_page(String button, String pageName) {
		linkedlistpage.clickTryHere();
    }
	
	@When("The user clicks Run button after entering valid {string} in try editor")
	public void theUserClicksButtonAfterEnteringvalidCodeImTryEditor(String code) {
		System.out.println("The user clicks Run button after entering valid code in try editor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		tryEditorPage.codeEditorSendKeys(code);
		tryEditorPage.clickRunBtn();
	}	
	
	
	@Then("The user should see the output {string} on TryEditor")
	public void TheusershouldseetheoutputonTryEditor(String expectedMessage) {
		System.out.println("The user should see the output message " + expectedMessage + " on TryEditor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		String actualMessage = tryEditorPage.getTryHereOutput();
	    Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch");
		
	}

	@When("The user clicks on the {string} link on the Linked List page")
	public void theUserClicksOnTheLinkOnTheLinkedListPage(String string) {
		System.out.println("The user clicks on the " + string + " link on the Linked List page");
		//linkedlistpage = new LinkedListPage(driver);
		linkedlistpage.clickLinkedListOption(string);
		
	}

	/*@Then("The user should see alert with error message {string} on TryEditor")
	public void TheusershouldseetheoutputonTryEditor1(String expectedMessage) {
		System.out.println("The user should see the output message " + expectedMessage + " on TryEditor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		String actualMessage = tryEditorPage.getTryHereOutput();
	    Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Output message mismatch");
		
	}*/
	
	@Then("The user should see alert with error message {string} on TryEditor")
	public void theUserShouldSeeAlertWithErrorMessageOnTryEditor(String expectedMessage) {
		System.out.println("The user should see alert with error message " + expectedMessage + " on TryEditor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		String actualMessage = tryEditorPage.getAlertMessageAndAccept();
	    Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch");
	}

	@Then("The user should see the following {string} on the Linked List Page")
	public void theUserShouldSeeTheFollowingOnTheLinkedListPage(String string) {
		System.out.println("The user should see the following " + string + "  on the Linked List Page");
		String expectedTitle = string; //"Linked List";
		String actualTitle = linkedlistpage.getLinkedListOptionHeaderText(expectedTitle); //.getTitle();
		System.out.println("actualTitle: '" + actualTitle + "'");
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}

	/*@Then("The user should see the following {string} links on the Linked List Page")
	public void theUserShouldSeeTheFollowingLinksOnTheLinkedListPage(String string) {
		System.out.println("The user should see the following " + string + " links on the Linked List Page");
		linkedlistpage = new LinkedListPage(driver);
		String expectedTitle = string; //"Linked List";
		String actualTitle = linkedlistpage.getLinkedListLinkOptionText(expectedTitle); //.getTitle();
		System.out.println("actualTitle: '" + actualTitle + "'");
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}*/

	@Then("The user should see the following {string} links on the {string} Page")
	public void theUserShouldSeeTheFollowingLinksOnTheLinkedListPage(String string1, String string2) {
		System.out.println("The user should see the following " + string1 +  "links on the "  + string2 +" Page");
		//linkedlistpage = new LinkedListPage(driver);
		String expectedTitle = string1; //"Linked List";
		String actualTitle = linkedlistpage.getLinkedListLinkOptionText(expectedTitle); //.getTitle();
		System.out.println("actualTitle: '" + actualTitle + "'");
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}

}


