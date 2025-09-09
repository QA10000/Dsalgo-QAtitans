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

public class TreePage {
	@FindBy(xpath = "//div[@id='navbarCollapse']//a[@href='/login']")
	private WebElement signinLink;
	@FindBy(name = "username")
	private WebElement usernametextbox;
	@FindBy(name = "password")
	private WebElement passwordtextbox;
	@FindBy(xpath = "//form//input[@type='submit' and @value='Login']")
	private WebElement loginButton;
	@FindBy(xpath = "//a[@href='tree']")
	private WebElement treeStartButton;
	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
	private WebElement dropdown;
    @FindBy(xpath = "//div[contains(.,'Topics Covered')]//a")
	private List<WebElement> treeLinkItem;

			@FindBy(xpath = "//h4[@class='bg-secondary text-white']")
	private WebElement treeLabel;
	@FindBy(xpath = "//a[normalize-space()='Overview of Trees']")
	private WebElement overviewLink;
	@FindBy(xpath = "//a[@class='btn btn-info']")
	private WebElement tryMeTreeButton;
	@FindBy(xpath = "//a[@class='btn btn-info']")
	private WebElement linksTreePg;
	@FindBy(xpath = "//a[@class='btn btn-info']")
	private WebElement tryMeButton;
	@FindBy(xpath = "//button[@type='button']")
	private WebElement runBtn;
	@FindBy(css = "textarea")
	private WebElement codeMirrorTextArea;
	@FindBy(css = "div.CodeMirror-scroll")
	private WebElement codeEditorTxtBx;
	@FindBy(id = "output")
	private WebElement outputMessage;
	
	private WebDriver driver;

	public TreePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickTreeStrtBtn() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable(treeStartButton));
		    
		    // Scroll into view before clicking
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", treeStartButton);

		    treeStartButton.click();	
		}	
	
	
	
	public String getTreePageTitle() {
		return driver.getTitle();
	}
	
	
	public void treeLabelDisplayed() {
		treeLabel.isDisplayed();
	}
	
	public void clickOverviewLink() {
		overviewLink.click();
	}
	

	public void cickTryMeButtonTree() {
		// TODO Auto-generated method stub
		tryMeTreeButton.click();

	}
	
	public void clickTreeOptiions(String sectionName) {
		boolean found = false;// this is used for making sure we have found the link before we click
		for (WebElement link :treeLinkItem ) {
			if(link.getText().trim().equalsIgnoreCase(sectionName.trim())) {
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



