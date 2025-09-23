package com.qa.dsalgo.pages;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.Assert;
import java.time.Duration;
import org.openqa.selenium.By;
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
	 @FindBy(xpath ="//a[normalize-space(.)='Introduction']")
			 WebElement IntroductionLink;
	 @FindBy(xpath ="//p[contains(@class,'bg-secondary') and contains(@class,'text-white')]")
             WebElement IntroductionHeader; 
	 @FindBy(xpath = "//a[@href='creating-linked-list']")
	    WebElement CreatingLinkedListItem;
	 @FindBy(xpath = "//div[@id='content']//a[text()='Creating Linked LIst']")
	    WebElement CreatingLinkedListTitleLink;
	 
	 @FindBy(xpath = "//a[@href='types-of-linked-list']")
	    WebElement TypesOfLinkedListLink;
	 @FindBy(xpath = "//div[@id='content']//a[text()='Types of Linked List']")
	    WebElement TypesOfLinkedListTitleLink;
	 
	 @FindBy(xpath = "//a[@href='implement-linked-list-in-python']")
	    WebElement ImplementLinkedListInPythonLink;
	 @FindBy(xpath = "//div[@id='content']//a[text()='Implement Linked List in Python']")
	    WebElement ImplementLinkedListInPythonTitleLink;
	 
	 @FindBy(xpath = "//a[@href='traversal']")
	    WebElement TraversalLink;
	 @FindBy(xpath = "//div[@id='content']//a[text()='Traversal']")
	    WebElement TraversalTitleLink;
	 
	 @FindBy(xpath = "//a[@href='insertion-in-linked-list']")
	    WebElement InsertionLink;
	 @FindBy(xpath = "//div[@id='content']//a[text()='Insertion']")
	    WebElement InsertionTitleLink;
	 
	 @FindBy(xpath = "//a[@href='deletion-in-linked-list']")
	    WebElement DeletionLink;
	 @FindBy(xpath = "//div[@id='content']//a[text()='Deletion']")
	    WebElement DeletionTitleLink;
	
	 @FindBy(xpath = "//a[@href='/tryEditor']")
	    private WebElement tryHereButton;
	 
	
	 
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
	
	public void clickLinkedListOption(String optionName) {
      WebElement option= driver.findElement(By.linkText(optionName));
      //String text=option.getText();
      option.click();
      //return text;
    }
	
	public String getLinkedListLinkOptionText(String optionName) {
	      WebElement option= driver.findElement(By.linkText(optionName));
	      String text=option.getText();
	      return text;
	    }
	
	public String getLinkedListOptionText(String optionName) {
	      WebElement option= driver.findElement(By.xpath("//strong/p[@class='bg-secondary text-white']"));
	      String text=option.getText();
	      //option.click();
	      return text;
	    }
	
	public String getLinkedListOptionHeaderText(String headerName) {
      WebElement option= driver.findElement(By.xpath("//div[@class=‘col-sm’]//p[@class=‘bg-secondary text-white’]"));
		//WebElement option=  driver.findElement(By.xpath("//*[self::h4 or self::p][text()='" + headerName + "']"));
	 	//WebElement option= driver.findElement(By.linkText(optionName));
	      String text=option.getText();
	      //option.click();
	      return text;
	    }
	
	public void clickTryHere() {
        tryHereButton.click();
    }
	
	public void getButtonText(String expectedButtonText ) {
    WebElement button = driver.findElement(By.xpath("//a[@href='/tryEditor']" + expectedButtonText + "']"));
    String actualButtonText = button.getText();
  //  Assert.assertEquals("Button text mismatch", expectedButtonText, actualButtonText);
 //   Assert.assertEquals(actualButtonText, expectedButtonText, "Button text mismatch");
	}
	
}

