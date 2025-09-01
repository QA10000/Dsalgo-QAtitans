package com.qa.dsalgo.stepdefinitions;

import org.testng.Assert;

import com.qa.dsalgo.base.DriverScripts;
import com.qa.dsalgo.pages.Background;
import com.qa.dsalgo.pages.LinkedListPage;
import com.qa.dsalgo.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LinkedListSteps extends DriverScripts {
	Background background;
	LinkedListPage linkedlistpage;
	LoginPage loginpage;
	
	public LinkedListSteps() {
		System.out.println(">> In LinkedListSteps constructor.");
		linkedlistpage = new LinkedListPage(driver);
	}

	@Given("The user is on the home page after login")
	public void theUserIsOnTheHomePageAfterLogin() {
		System.out.println("The user is on the home page after login");
		loginpage = new LoginPage(driver);
		loginpage.clickLoginLink();
		loginpage.login("qatitans1", "1@Chicago");
	}

	@When("The user clicks the {string} button for Linked List module on Home page")
	public void theUserClicksTheButtonForLinkedListModuleOnHomePage(String string) {
		System.out.println("The user clicks the " + string + " button  for Linked List module on Home page");
		linkedlistpage = new LinkedListPage(driver);
		linkedlistpage.clicklinkedListGetStarted();
	}

	@Then("The user lands on the {string} page")
	public void theUserLandsOnThePage(String string) {
		System.out.println("The user lands on the " + string + " page");
		//linkedlistpage = new LinkedListPage(driver);
		String expectedTitle = string; //"Linked List";
		String actualTitle = linkedlistpage.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
	}

	@When("The user select Linked List  item from the drop down menu")
	public void theUserSelectLinkedListItemFromTheDropDownMenu() {
		driver.get("https://dsportalapp.herokuapp.com/home");
		linkedlistpage.clickDataStructuredropdown();
		linkedlistpage.SelectLinkedListFromDropDown();
		
	}

	@Given("The user is on the Linked List page")
	public void the_user_is_on_the_linked_list_page() {
		loginpage = new LoginPage(driver);
		loginpage.clickLoginLink();
		loginpage.login("qatitans1","1@Chicago");
		linkedlistpage = new LinkedListPage(driver);
		linkedlistpage.clicklinkedListGetStarted();
	}

	@When("The user clicks on the {string} link on  the Linked List page")
	public void theUserClicksOnTheLinkOnTheLinkedListPage(String string) {
		System.out.println("The user clicks on the " + string + " link on  the Linked List page");
		linkedlistpage = new LinkedListPage(driver);
		linkedlistpage.goToCreatingLinkedListPage();
	}	
}

