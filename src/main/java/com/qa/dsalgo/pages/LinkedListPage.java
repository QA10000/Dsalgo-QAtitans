package com.qa.dsalgo.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedListPage {
private WebDriver driver;
	
	@FindBy(xpath = "//div[@class='card-body d-flex flex-column'][h5[text()='Linked List']]//a[contains(@href, 'linked-list')]")
	private WebElement linkedListGetStarted;
	 @FindBy(xpath = "//a[text()='Data Structures']")
	    WebElement dataStructuresDropdown;
	 @FindBy(xpath = "//a[@class='dropdown-item' and @href='/linked-list']")
	    WebElement linkedListItem;
    //private WebElement dropdown;
	 @FindBy(xpath = "//a[@href='creating-linked-list']")
	    WebElement CreatingLinkedListItem;
	 @FindBy(xpath = "//div[@id='content']//a[text()='Creating Linked LIst']")
	    WebElement CreatingLinkedListTitleLink;
	
	public LinkedListPage(WebDriver driver) {
		System.out.println(">> LinkedListPage constructor.");		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clicklinkedListGetStarted() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(linkedListGetStarted));
		linkedListGetStarted.click();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String GetTitleFromPage(WebElement Link) {
		return Link.getText();		
	}
	
	public void clickDataStructuredropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dataStructuresDropdown));
		dataStructuresDropdown.click();
	}
	public void SelectLinkedListFromDropDown() {
        //dataStructuresDropdown.click();
        linkedListItem.click();
    }
	
	public void goToCreatingLinkedListPage() {
        CreatingLinkedListItem.click();
    }
}

