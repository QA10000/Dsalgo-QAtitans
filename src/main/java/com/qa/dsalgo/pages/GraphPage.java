package com.qa.dsalgo.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
	private WebElement graphGetstarted;// ---------- YES
	
	@FindBy(xpath = "//a[text()='Data Structures']")
	WebElement dataStructuresDropdown;
	
	//@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Graph']")
	//@FindBy(xpath = "//a[@class='dropdown-item' and text()='Graph']")
	@FindBy(xpath = "//a[@class='dropdown-item' and @href='/graph']")
	private WebElement graphDropDown;
	
	
	 @FindBy(xpath = "//a[@href='graph']")
	 WebElement GraphLinkOptionOne;
	 //@FindBy(xpath = "//div[@id='content']//a[text()='Creating Linked LIst']")
	   // WebElement CreatingLinkedListTitleLink;
	 
	 
	 @FindBy(xpath = "(//a[normalize-space()='Graph Representations'])[1]")
//	 @FindBy(xpath = "//a[normalize-space()=\"Graph Representations\"]")
	 //@FindBy(xpath = "//a[@href='graph-representations']")
	 WebElement GraphRepresentationsLinkOptionTwo;
	 
	 //NEW ADDED NOW
			
	@FindBy(xpath = "//a[@href='/graph/graph/']")
	WebElement GraphItem; // inside the graph page, locating Graph link
	@FindBy(xpath = "//div[@id='content']//a[text()='Graph']")
	WebElement GraphTitleLink;
	
	@FindBy(xpath = "//a[@href=\"/graph/graph-representations/\"]")
	WebElement GraphRepresentationsLink; // inside the graph page, locating Graph Representations link
	@FindBy(xpath = "//div[@id='content']//a[text()='Graph Representations']")
	WebElement GraphRepresentationsItemTitleLink;
	
	@FindBy(xpath = "//a[@href='/tryEditor']")
	private WebElement tryHereButton;
	
	
	
	// initialize driver
	//---------------------NIS-CHECK IF THIS NEEDED
	private WebDriver driver;
		
	//---------------------YES
	public GraphPage(WebDriver driver) {
		System.out.println(">> GraphPage constructor.");
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	

	//---------------------YES
	//STEP1 PASSED- Main Graph Page Headers
	//Click GetStarted in the Graph panel and verify both headers
	//OPTION2 MAD
	public void clickGraphStrtBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(graphGetstarted));
		graphGetstarted.click();
	}
		
		//WORKING OLD OPTION1 //NIS
		/*
		 * public void clickGraphStrtBtn() { WebDriverWait wait = new
		 * WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.elementToBeClickable(graphGetstarted));
		 * ((JavascriptExecutor) driver).executeScript(
		 * "arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",
		 * graphGetstarted); graphGetstarted.click(); }
		 */
		
	public String getGraphPageTitle() {
		return driver.getTitle();
	}
		
	public String GetTitleFromPage(WebElement Link) { 
		return Link.getText(); 
	}
			
	//-----------------//
	

	
	//REMOVED FOR NOW--------CHECKING DROPDOWN
	/*
	 * //PASSED public void clickDataStructuredropdown() { WebDriverWait wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(10));
	 * wait.until(ExpectedConditions.elementToBeClickable(dataStructuresDropdown));
	 * dataStructuresDropdown.click(); } public void SelectLGraphFromDropDown() {
	 * //WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	 * //WebElement graphdropdown =
	 * wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "//a[@class='dropdown-item'][normalize-space()='Graph']")));
	 * graphDropDown.click();
	 */
	 //}			
//				driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Graph']"));
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(graphdrop);
		
   
	//STEP6 NEW TAKEN FROM ARRAY
	public void SelectLGraphFromDropDown() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Actions actions = new Actions(driver);
	
	wait.until(ExpectedConditions.elementToBeClickable(dataStructuresDropdown));
	dataStructuresDropdown.click();
	
	wait.until(ExpectedConditions.elementToBeClickable(graphDropDown));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", graphDropDown);
	
	wait.until(ExpectedConditions.or(ExpectedConditions.titleContains("Graph"), ExpectedConditions.urlContains("graph"))); 
	}
	
	
	
	
	
	//-----------------//
	
	
	//3 - corrected, but not used in steps
	/*
	 * public void goToGraphLinkOptionOnePage() { GraphLinkOptionOne.click(); }
	 */
	//4
	public void clickGraphOption(String optionName) {
	  WebElement option= driver.findElement(By.linkText(optionName));
	  option.click();
	}
	
	//5
	public String getGraphLinkOptionText(String optionName) {
	      WebElement option= driver.findElement(By.linkText(optionName));
	      String text=option.getText();
	      return text;
	    }
	
	
	//6
	public String getGraphOptionText(String optionName) {
	      WebElement option= driver.findElement(By.xpath("//h4[normalize-space()=\"Graph\"]"));
	      String text=option.getText();
	      return text;
	    }
	//7
	//STEP1 THEN
	public String getGraphOptionHeaderText(String headerName) {
		WebElement option=  driver.findElement(By.xpath("//*[self::h4 or self::p][text()='" + headerName + "']"));
		String text=option.getText();
	    return text;
	 }
	
	public void goToGraphPage() {
		GraphItem.click();
    }
		
public void ClickGraphOptionsLink(String graphOption) {
		
		switch(graphOption) 
		{
			case "Graph":
				GraphItem.click();
				break;
			case "Graph Representations":
				GraphRepresentationsLink.click();
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
	//---------------------------------------------//
	
	
	
	//#STEP2 - Main Graph Page headers with links
//when The user clicks the "Getting Started" button for Graph module on Home page
//Added now for Step 2
	public void graphItemGetStarted() {
	graphGetstarted.click();
	}
	
	
	//#STEP3 -  Main Graph Page >> 1. Graph Page headers with links
			//When The user clicks now on the "Graph" link on the Graph page
			//Added now for Step 3
	public void graphItemOneClick() {
		GraphLinkOptionOne.click();
}
	
	
	public void graphItemTwoClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(GraphRepresentationsLinkOptionTwo));
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", GraphRepresentationsLinkOptionTwo);
		GraphRepresentationsLinkOptionTwo.click();
}

}