package com.qa.dsalgo.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GraphPage {

	// Locators:

	@FindBy(xpath = "//a[@href='graph']")
	private WebElement graphGetstarted;
	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
	private WebElement dropdownList;
	@FindBy(xpath = "//a[@class='dropdown-item' and text()='Graph']")
	private WebElement graphDropDown;
	@FindBy(xpath = "//div[@role='alert' and contains(text(), 'You are not logged in')]")
	private WebElement ntloggedinMsg;

	// links in the Graph module page
	@FindBy(xpath = "//a[@class='list-group-item' and starts-with(normalize-space(text()), 'Graph')]")
	private List<WebElement> graphTopicLinks; // locators for 2 links on Graph module
	@FindBy(xpath = "//h4")
	private WebElement graphPageHeader; // all links same as above, locators for 2 links on Graph module
	@FindBy(xpath = "//a[@class='btn btn-info']")
	private WebElement tryMeGraphRepresentationButton;
	@FindBy(xpath = "//a[@class='btn btn-info']")
	private WebElement tryMeButton;

	///// CHECK THIS ONE////
	@FindBy(xpath = "//div[contains(.,'Topics Covered')]//a")
	private List<WebElement> graphLinkItem;// all Topics inside Graph Page i.e. Graph and Graph Representations

	// locators from Graph module page
	@FindBy(xpath = "//h4[normalize-space(text())='Graph']")
	private WebElement GraphLabel; // to check header
	@FindBy(xpath = "/html/body/div[2]/ul[2]/a")
	private WebElement graphPythonLink; // Graph link in the Graph page

	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement tryhere_Graph;// same from Graph page, duplicate, but can be used in Graph representation page

	@FindBy(css = "div.CodeMirror-scroll")
	private WebElement codeEditorTxtBx; // common for all
	@FindBy(xpath = "//*[@id='answer_form']/button")
	// (xpath = "//button[@type='button']")
	private WebElement graphRunButton;
	@FindBy(xpath = "//button[@type='button']")
	private WebElement runBtn;
	@FindBy(id = "output")
	private WebElement outputMessage;

	// --

	@FindBy(xpath = "//div[contains(@class,'CodeMirror') and contains(@class,'cm-s-default')]//textarea")
	private WebElement Grapheditor_Input;

	@FindBy(xpath = "//*[@id='content']/a")
	private WebElement Graph_Practiceqn;

	@FindBy(xpath = "//a[normalize-space()=\"Graph Representations\"]")
	private WebElement graphRepresentationLink;

	@FindBy(xpath = "//*[@id=\"output\"]")
	private WebElement Output; // check this, not correct

	@FindBy(id = "answer_form")
	WebElement answerForm;// check this, why needed

	@FindBy(css = "textarea") // check this, why needed
	private WebElement codeMirrorTextArea;

	// Login
	@FindBy(xpath = "//div[@id='navbarCollapse']//a[@href='/login']")
	private WebElement signinLink;
	@FindBy(name = "username")
	private WebElement usernametextbox;
	@FindBy(name = "password")
	private WebElement passwordtextbox;
	@FindBy(xpath = "//form//input[@type='submit' and @value='Login']")
	private WebElement loginButton;

	// -------------------------------------//
	// -------------------------------------//

	// Methods:

	// initialize driver
	private WebDriver driver;

	public GraphPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickGraphStrtBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(graphGetstarted));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", graphGetstarted);
		graphGetstarted.click();
	}

	public String getGraphPageTitle() {
		return driver.getTitle();
	}

	public void graphLabelDisplayed() {
		GraphLabel.isDisplayed();
	}

	public void clickGraphRepresentationLink() {
		graphRepresentationLink.click();
	}

	public void cickTryMeButtonGraphRepresentation() {
		tryMeGraphRepresentationButton.click();
	}

	public void clickGraphOptions(String sectionName) {
		boolean found = false;// this is used for making sure we have found the link before we click
		for (WebElement link : graphLinkItem) {
			if (link.getText().trim().equalsIgnoreCase(sectionName.trim())) {
				link.click();
				found = true;
				break;
			}
		}
		if (!found) {
			throw new IllegalArgumentException("Unknown section: " + sectionName);
		}
	}

	public void clickTryMeButton() {
		tryMeButton.click();
	}

	public void codeEditorSendKeys(String code) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for CodeMirror editor container to be visible
		wait.until(ExpectedConditions.visibilityOf(codeEditorTxtBx));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Clear existing content
		js.executeScript("document.querySelector('.CodeMirror').CodeMirror.setValue('');");

		// Enter new code
		js.executeScript("document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);", code);

		try {
			Thread.sleep(500); // Small pause (not mandatory but helpful sometimes)
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public String getAlertMessageAndAccept() {// alert on editor page on
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		alert.accept();
		return message;
	}

	public void clickRunBtn() {
		runBtn.click();

	}

	public void outputDisplayed() {
		outputMessage.isDisplayed();
	}

}
