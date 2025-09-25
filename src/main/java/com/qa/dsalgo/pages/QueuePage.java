package com.qa.dsalgo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QueuePage {
	private WebDriver driver;

	@FindBy(xpath = "//a[@href=\"queue\"]")
	private WebElement QueueGetStarted;

	@FindBy(xpath = "//a[text()='Data Structures']")
	WebElement dataStructuresDropdown;
	
	@FindBy(xpath = "//a[normalize-space()=\"Queue\"]")
	WebElement QueueItem;
	
	
	@FindBy(xpath = "//a[@href='implementation-lists']")
	WebElement ImplementationOfQueueInPythonItem;
	
	@FindBy(xpath = "//div[@id='content']//a[text()='Implementation of Queue in Python']")
	WebElement ImplementationOfQueueInPythonTitleLink;
	
	@FindBy(xpath = "//a[@href='implementation-collections']")
	WebElement ImplementationUsingCollectionsDequeLink;
	
	@FindBy(xpath = "//div[@id='content']//a[text()='Implementation using collections.deque']")
	WebElement ImplementationUsingCollectionsDequeItemTitleLink;

	@FindBy(xpath = "//a[@href='Implementation-array']")
	WebElement ImplementationUsingArrayLink;
	
	@FindBy(xpath = "//div[@id='content']//a[text()='Implementation using array']")
	WebElement ImplementationUsingArrayItemTitleLink;
	
	@FindBy(xpath = "//a[@href='QueueOp']")
	WebElement QueueOperationsLink;
	
	@FindBy(xpath = "//div[@id='content']//a[text()='Queue Operations']")
	WebElement QueueOperationsTitleLink;
	
	@FindBy(xpath = "//a[@href='/tryEditor']")
    private WebElement tryHereButton;
	
	public QueuePage(WebDriver driver) {
		System.out.println(">> QueuePage constructor.");
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickQueueGetStarted() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(QueueGetStarted));
		QueueGetStarted.click();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String GetTitleFromPage(WebElement Link) {
		return Link.getText();
	}

	public void SelectQueueFromDropDown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dataStructuresDropdown));
		dataStructuresDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(QueueItem));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", QueueItem);
		wait.until(ExpectedConditions.or(ExpectedConditions.titleContains("Queue"), ExpectedConditions.urlContains("queue"))); 
	}
	
	public void goToImplementationOfQueueInPythonPage() {
		ImplementationOfQueueInPythonItem.click();
    }
	
	public void clickQueueOption(String optionName) {
		WebElement option = driver.findElement(By.linkText(optionName));
		option.click();
	}

	public String getQueueLinkOptionText(String optionName) {
		WebElement option = driver.findElement(By.linkText(optionName));
		String text = option.getText();
		return text;
	}

	public String getQueueOptionText(String optionName) {
		WebElement option = driver.findElement(By.xpath("//h4[normalize-space()=\"Queue\"]"));
		String text = option.getText();
		return text;
	}

	public String getQueueOptionHeaderText(String headerName) {
		WebElement option=  driver.findElement(By.xpath("//*[self::h4 or self::p][text()='" + headerName + "']"));
		String text=option.getText();
	    return text;
	    }
	
	public void ClickQueueOptionsLink(String QueueOption) {
		
		switch(QueueOption) 
		{
			case "Implementation of Queue in Python":
				ImplementationOfQueueInPythonItem.click();
				break;
			case "Implementation using collections Deque":
				ImplementationUsingCollectionsDequeLink.click();
				break;
			case "Implementation using array.click":
				ImplementationUsingArrayLink.click();
				break;
			case "Queue Operations":
				QueueOperationsLink.click();
				break;
		}       
    }
	
	public void clickTryHere() {
        tryHereButton.click();
    }
	
	public void getButtonText(String expectedButtonText ) {
	    WebElement button = driver.findElement(By.xpath("//a[@href='/tryEditor']" + expectedButtonText + "']"));
	    String actualButtonText = button.getText();
	}
}
