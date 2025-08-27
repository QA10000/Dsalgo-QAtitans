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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArrayPage {
	@FindBy(xpath = "//a[@href='array']")
	private WebElement arrayStartBtn;
	@FindBy(xpath = "//div[@role='alert' and contains(text(), 'You are not logged in')]")
	private WebElement ntloggedinMsg;
	// locators from array module page
	@FindBy(xpath = "//h4[@class='bg-secondary text-white']")
	private WebElement arrayLabel;
	@FindBy(xpath = "//a[normalize-space()='Arrays in Python']")
	private WebElement arrPythonLink;
	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
	private WebElement dropdown;	
	@FindBy(xpath = "//a[@class='dropdown-item' and text()='Arrays']")
	private WebElement arraysLinkItem;// from dropdown 	
	@FindBy(xpath = "//a[@class='list-group-item']")
	private List<WebElement> topicLinks; // locators for links on array module
	@FindBy(xpath = "//h4")  
	private WebElement pageHeader;
	@FindBy(xpath = "//a[@class='btn btn-info']")
	private WebElement tryMeButton;

	
	@FindBy(css = "div.CodeMirror-scroll")
	private WebElement codeEditorTxtBx;
	@FindBy(xpath = "//button[@type='button']")
	private WebElement runBtn;
	

@FindBy(css = "textarea")
private WebElement codeMirrorTextArea;
			
	
 //for now i am creating a login code here , we need to have login here because we can't use background step logged in because we have a scenario for nonlogged in user
	@FindBy(xpath = "//div[@id='navbarCollapse']//a[@href='/login']")
	private WebElement signinLink;
	@FindBy(name = "username")
	private WebElement usernametextbox;
	@FindBy(name = "password")
	private WebElement passwordtextbox;
	@FindBy(xpath = "//form//input[@type='submit' and @value='Login']")
	private WebElement loginButton;
	

	private WebDriver driver;

	public ArrayPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickStartBtn() {
		arrayStartBtn.click();
	}

	public void clickArrayPythonLink() {
		arrPythonLink.click();
	}

	public String getnotlogedMessage() {// this will go to home page as it shows on home page
		return ntloggedinMsg.getText().trim();
	}

	public void clickLoginLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(signinLink));
		signinLink.click();
	}

	public void userLoggedin() {
		signinLink.click();
		usernametextbox.sendKeys("qatitans1");
		passwordtextbox.sendKeys("1@Chicago");
		loginButton.click();
	}

	
public void selectArrayfrmDrpdown(String visibleText) {
	userLoggedin();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions actions = new Actions(driver);

    // Click or hover the dropdown to open it
    wait.until(ExpectedConditions.elementToBeClickable(dropdown));
    actions.moveToElement(dropdown).click().perform();

    // Wait for the dropdown item to be visible and click it
    wait.until(ExpectedConditions.visibilityOf(arraysLinkItem));
    wait.until(ExpectedConditions.elementToBeClickable(arraysLinkItem));
    actions.moveToElement(arraysLinkItem).click().perform();
}

	
	public boolean arrayLabelDisplayed() {
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOf(arrayLabel));
		    return arrayLabel.isDisplayed();
		
	}
	
	public void clickLinksAndVerifyheader() {
		for(WebElement link : topicLinks) {
			String linkText = link.getText().trim();
			link.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(pageHeader));
	        String headerText = pageHeader.getText().trim();  // like "Arrays in Python"
	        System.out.println("Landed on page with header: " + headerText);
			
		}
	}
	
	public String getTitleArraypage() { // please check to remove duplicate methods
		return driver.getTitle();
	}

	public void clickTryMeButton() {
		tryMeButton.click();
		}
	
	
	public void codeEditorSendKeys(String code) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(codeEditorTxtBx));
	    ((JavascriptExecutor) driver).executeScript(
	        "document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);", code);
	}
	
	public void clickRunBtn() {
		runBtn.click();
		
	}
	
	public String getAlertMessageAndAccept() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
	    String message = alert.getText();
	    alert.accept();
	    return message;
	}
}
