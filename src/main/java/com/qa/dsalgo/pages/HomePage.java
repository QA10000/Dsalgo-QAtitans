package com.qa.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.dsalgo.*;
//import com.dsalgoproject.utility.LoggerLoad;

// import io.cucumber.messages.types.Duration;


public class HomePage {
	private WebDriver driver;
	
	String errorMessage ="";

	String application = "https://dsportalapp.herokuapp.com/";
	String homePage = "https://dsportalapp.herokuapp.com/home";
	String loginPage = "https://dsportalapp.herokuapp.com/login";
	String registerPage = "https://dsportalapp.herokuapp.com/register";
	
	// private final static Logger LOG = LogManager.getLogger(HomePage.class);
	
	@FindBy(xpath = "html/body/div/div/div/a/button")
	private WebElement getStartedButton;

	// @FindBy(xpath = "html/body/div/div/div/a/href")

	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	private WebElement getStartedButtonHomePageDSIntroModule;
	
	@FindBy(xpath = "//a[@href='array']")
	private WebElement getStartedButtonHomePageArrayModule;

	@FindBy(xpath = "//a[@href='linked-list']")
	private WebElement getStartedButtonHomePageLinkedListModule;
	
	@FindBy(xpath = "//a[@href='stack']")
	private WebElement getStartedButtonHomePageStackModule;
	
	@FindBy(xpath = "//a[@href='queue']")
	private WebElement getStartedButtonHomePageQueueModule;	

	@FindBy(xpath = "//a[@href='tree']")
	private WebElement getStartedButtonHomePageTreeModule;
	
	@FindBy(xpath = "//a[@href='graph']")
	private WebElement getStartedButtonHomePageGraphModule;	
	
	@FindBy(xpath = "//div[@role='alert' and contains(text(), 'You are not logged in')]") // on home page
	private WebElement ntloggedinMsg;
	
	public HomePage(WebDriver driver) {
		System.out.println("In HomePage Constructor");		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getTitle() {
		// TODO Auto-generated method stub
		System.out.println("In HomePage:getTitle() method");
		return driver.getTitle();
	}
	
	public void homePageLogin() {
		driver.get(application);
		// LOG.info("DS ALGO Page Opened");
		System.out.println("In HomePage:homePageLogin() ");
	}

	public void clickGetStartedButton() {
		getStartedButton.click();
		System.out.println("In HomePage:clickGetStartedButton() ");
	}

	public void clickGetStartedButtonHomePageDSIntroModule() {
		getStartedButtonHomePageDSIntroModule.click();
		System.out.println("In HomePage:clickGetStartedButtonHomePageDSIntroModule() ");
	}
	public void clickGetStartedButtonHomePageArrayModule() {
		getStartedButtonHomePageArrayModule.click();
		System.out.println("In HomePage:clickGetStartedButtonHomePageArrayModule() ");
	}	
	public void clickGetStartedButtonHomePageLinkedListModule() {
		getStartedButtonHomePageLinkedListModule.click();
		System.out.println("In HomePage:clickGetStartedButtonHomePageLinkedListModule() ");
	}
	public void clickGetStartedButtonHomePageStackModule() {
		getStartedButtonHomePageStackModule.click();
		System.out.println("In HomePage:clickGetStartedButtonHomePageStackModule() ");
	}
	public void clickGetStartedButtonHomePageQueueModule() {
		getStartedButtonHomePageQueueModule.click();
		System.out.println("In HomePage:clickGetStartedButtonHomePageQueueModule() ");
	}	
	public void clickGetStartedButtonHomePageTreeModule() {
		getStartedButtonHomePageTreeModule.click();
		System.out.println("In HomePage:clickGetStartedButtonHomePageTreeModule() ");
	}
	public void clickGetStartedButtonHomePageGraphModule() {
		getStartedButtonHomePageGraphModule.click();
		System.out.println("In HomePage:clickGetStartedButtonHomePageGraphModule() ");
	}	
	
	public void homePage() {
		driver.get(homePage);
	}
	
	public String getAlertMessageAndAccept() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		alert.accept();
		return message;
	}
	
	public String getnotlogedMessage() {
		return ntloggedinMsg.getText().trim();
	}	

}