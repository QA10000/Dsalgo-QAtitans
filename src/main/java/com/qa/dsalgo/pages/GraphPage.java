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

public class GraphPage {

	@FindBy(xpath = "//a[@href='graph']")
	private WebElement graphGetstarted;
	
	@FindBy(xpath = "//a[text()='Data Structures']")
	WebElement dataStructuresDropdown;
	
	@FindBy(xpath = "//a[@class='dropdown-item' and @href='/graph']")
	private WebElement graphDropDown;
	
	@FindBy(xpath = "//a[@href='graph']")
	WebElement GraphLinkOptionOne;
		 
	@FindBy(xpath = "(//a[normalize-space()='Graph Representations'])[1]")
	WebElement GraphRepresentationsLinkOptionTwo;
	
	@FindBy(xpath = "//a[@href='/graph/graph/']")
	WebElement GraphItem;
	
	@FindBy(xpath = "//div[@id='content']//a[text()='Graph']")
	WebElement GraphTitleLink;
	
	@FindBy(xpath = "//a[@href=\"/graph/graph-representations/\"]")
	WebElement GraphRepresentationsLink;
	
	@FindBy(xpath = "//div[@id='content']//a[text()='Graph Representations']")
	WebElement GraphRepresentationsItemTitleLink;
	
	@FindBy(xpath = "//a[@href='/tryEditor']")
	private WebElement tryHereButton;
	
	
	private WebDriver driver;
		
	public GraphPage(WebDriver driver) {
		System.out.println(">> GraphPage constructor.");
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickGraphStrtBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(graphGetstarted));
		graphGetstarted.click();
	}
		
	public String getGraphPageTitle() {
		return driver.getTitle();
	}
		
	public String GetTitleFromPage(WebElement Link) { 
		return Link.getText(); 
	}
	
	public void SelectLGraphFromDropDown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(dataStructuresDropdown));
		dataStructuresDropdown.click();
	
		wait.until(ExpectedConditions.elementToBeClickable(graphDropDown));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", graphDropDown);
	
		wait.until(ExpectedConditions.or(ExpectedConditions.titleContains("Graph"), ExpectedConditions.urlContains("graph"))); 
	}
	
	
	public void clickGraphOption(String optionName) {
	  WebElement option= driver.findElement(By.linkText(optionName));
	  option.click();
	}
	
	
	public String getGraphLinkOptionText(String optionName) {
	      WebElement option= driver.findElement(By.linkText(optionName));
	      String text=option.getText();
	      return text;
	}
	
	public String getGraphOptionText(String optionName) {
	      WebElement option= driver.findElement(By.xpath("//h4[normalize-space()=\"Graph\"]"));
	      String text=option.getText();
	      return text;
	    }
	
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

	public void graphItemGetStarted() {
		graphGetstarted.click();
	}
	
	
	public void graphItemOneClick() {
		GraphLinkOptionOne.click();
	}
	
	public void graphItemTwoClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		GraphRepresentationsLinkOptionTwo.click();
	}

}