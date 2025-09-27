package com.qa.dsalgo.stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.LinkedListPage;
import com.qa.dsalgo.pages.TryEditorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CommonUtils;

public class LinkedListSteps {
	private WebDriver driver;
	Background background;
     LinkedListPage linkedlistpage;
	TryEditorPage tryEditorPage ;
	private static final Logger logger = LogManager.getLogger(LinkedListSteps.class);
	public LinkedListSteps() {
			driver = Hooks.getDriver();
			background = new Background(driver);
			linkedlistpage = new LinkedListPage(driver);
			
		}
	
	@Given("The user is on the home page after login")
	public void theUserIsOnTheHomePageAfterLogin() {
		logger.info("The User is on Home Page after Login");
		}

	@When("The user clicks the {string} button for Linked List module on Home page")
	public void theUserClicksTheButtonForLinkedListModuleOnHomePage(String string) {
		logger.info("The user clicks the " + string + " button  for Linked List module on Home page");
		linkedlistpage.clicklinkedListGetStarted();
	}
	
	@Then("The user should see the following {string} on the Linked List Page")
	public void theUserShouldSeeTheFollowingOnTheLinkedListPage(String string) {

		logger.info("The user should see the following " + string + "  on the Linked List Page");
		String expectedTitle = string; //needs changes as string is getting passed to expected title
		String actualTitle = linkedlistpage.getLinkedListOptionHeaderText(expectedTitle); //.getTitle();
		System.out.println("actualTitle: '" + actualTitle + "'");
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}

	@Then("The user should see the following {string} links on the {string} Page")
	public void theUserShouldSeeTheFollowingLinksOnTheLinkedListPage(String string1, String string2) {
		logger.info("The user should see the following " + string1 +  "links on the "  + string2 +" Page");
		String expectedTitle = string1; //needs changes as string is getting passed to expected title
		String actualTitle = linkedlistpage.getLinkedListLinkOptionText(expectedTitle); //.getTitle();
		System.out.println("actualTitle: '" + actualTitle + "'");
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}
	
	@Given("The user is on Linked List page after login")
	public void theUserIsOnLinkedListPageAfterLogin() {
		linkedlistpage.clicklinkedListGetStarted();
	}
	
	@When("The user clicks on the {string} link on the Linked List page")
	public void theUserClicksOnTheLinkOnTheLinkedListPage(String string) {

		linkedlistpage.clickLinkedListOption(string);
		
	}
	
	@Then ("The user lands on {string} page")
	public void theUserLandsOnThePage(String string) {
		logger.info("The user lands on the " + string + " page");
	}
	
	@Then("All expected headers and navigation links should be displayed")
	public void allexpectedheadersandnavigationlinksshouldbedisplayed() {
		List<String> expectedLinks = CommonUtils.LINKLISTPAGE_LINKS;
		 List<String> actualLinks = linkedlistpage.getAllLinkTexts();

		 logger.info("actualLinks : " + actualLinks.toString());
		 List<String> missing = new ArrayList<>();
		 for (String expected : expectedLinks) {
		     if (!actualLinks.contains(expected)) {
		         missing.add(expected);
		     }
		 }

		 Assert.assertTrue(
		     missing.isEmpty(),
		     "These expected links were missing: " + missing + 
		     "\nActual list: " + actualLinks
		 );

		 
	}

	@When("The user select Linked List item from the drop down menu")
	public void theUserSelectLinkedListItemFromTheDropDownMenu() {
		logger.info("The user selects Linked List item from Drop Down Menu");
		linkedlistpage.SelectLinkedListFromDropDown();
		
	}

	@Then("All expected navigation links should be displayed on Linked List Page")
	public void allExpectedNavigationLinksShouldBeDisplayedOnLinkedListPage() {
		List<String> expectedLinks = CommonUtils.LINKLISTSUBPAGE_LINKS;
		 List<String> actualLinks = linkedlistpage.getAllLinkTexts();

		 logger.info("actualLinks : " + actualLinks.toString());
		 List<String> missing = new ArrayList<>();
		 for (String expected : expectedLinks) {
		     if (!actualLinks.contains(expected)) {
		         missing.add(expected);
		     }
		 }

		 Assert.assertTrue(
		     missing.isEmpty(),
		     "These expected links were missing: " + missing + 
		     "\nActual list: " + actualLinks
		 );

	}
	
	@When("The user clicks on the {string} link")
	public void theUserClicksOnTheLink(String OptionOnLinkedList) {
		logger.info("The user clicks on the the " +  OptionOnLinkedList + " link on the Linked List page");
		linkedlistpage.clickLinkedListOption(OptionOnLinkedList);
		}
	
	@When("The user clicks {string} button on {string} page")
    public void the_user_clicks_button_on_page(String button, String pageName) {
		linkedlistpage.clickTryHere();
    }
	
	@When("The user clicks Run button after entering valid {string} in try editor")
	public void theUserClicksButtonAfterEnteringvalidCodeImTryEditor(String code) {
		logger.info("The user clicks Run button after entering valid code in try editor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		tryEditorPage.codeEditorSendKeys(code);
		tryEditorPage.clickRunBtn();
	}	
	
	@Then("The user should see the output {string} on TryEditor")
	public void TheusershouldseetheoutputonTryEditor(String expectedMessage) {
		logger.info("The user should see the output message " + expectedMessage + " on TryEditor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		String actualMessage = tryEditorPage.getTryHereOutput();
	    Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch");
		
	}
	
	@When("The user clicks {string} button after entering invalid code {string} in try editor")
	public void theUserClicksButtonAfterEnteringInvalidCodeImTryEditor(String string, String string2) {
		logger.info("The user clicks " + string + "  button after entering invalid code " + string2 + " in try editor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		tryEditorPage.codeEditorSendKeys(string2);
		tryEditorPage.clickRunBtn();
	}
	

	@Then("The user should see alert with error message {string} on TryEditor")
	public void theUserShouldSeeAlertWithErrorMessageOnTryEditor(String expectedMessage) {
		logger.info("The user should see alert with error message " + expectedMessage + " on TryEditor");
		TryEditorPage tryEditorPage = new TryEditorPage(driver);
		String actualMessage = tryEditorPage.getAlertMessageAndAccept();
	    Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "Alert message mismatch");
	}

	

	

	

}


