package com.qa.dsalgo.stepdefinitions;

import com.qa.dsalgo.base.DriverScripts;
import com.qa.dsalgo.pages.LinkedListPage;
import com.qa.dsalgo.pages.LoginPage;
import com.qa.dsalgo.pages.StackPage;
import com.qa.dsalgo.pages.TryEditorPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StackSteps extends DriverScripts {
		StackPage stackpage;
		LoginPage loginpage;
		TryEditorPage tryEditorPage ;
		
		public StackSteps() {
			System.out.println(">> In StackSteps constructor.");
			stackpage = new StackPage(driver);
		}
		
		@When("The user clicks the {string} button for Stack module on Home page")
		public void theUserClicksTheButtonForLinkedListModuleOnHomePage(String string) {
			System.out.println("The user clicks the " + string + " button  for Stack module on Home page");
			stackpage = new StackPage(driver);
			stackpage.clicklinkedListGetStarted();
		}

		@Given("The user clicks {string} button in Operations in Stack")
		public void theUserClicksButtonInOperationsInStack(String string) {
			
		}

		@Given("The user is on Stack page after login")
		public void theUserIsOnStackPageAfterLogin() {
			System.out.println("The user is on Linked List page after login");
			loginpage = new LoginPage(driver);
			loginpage.clickLoginLink();
			loginpage.login("qatitans1","1@Chicago");
			stackpage = new StackPage(driver);
			stackpage.clicklinkedListGetStarted();
		}

		@When("The user clicks on the {string} link on Stack page")
		public void theUserClicksOnTheLinkOnStackPage(String OptionOnStack) {
			System.out.println("The user clicks on the " + OptionOnStack + " link on  the Linked List page");
			stackpage = new StackPage(driver);
			stackpage.clickLinkedListOption(OptionOnStack);
		}

		//@Then("The user should not be directed to {string} Module page but a message {string} should be displayed at the top of the homepage.")
		//public void theUserShouldNotBeDirectedToModulePageButAMessageShouldBeDisplayedAtTheTopOfTheHomepage(
			//	String string, String string2) {
			
		//}
}
		