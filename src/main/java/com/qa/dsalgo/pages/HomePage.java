package com.qa.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.CommonUtils;

public class HomePage {
	private WebDriver driver;
	
	String errorMessage ="";
	String homePage = CommonUtils.HOME_URL;

	private static final Logger logger = LogManager.getLogger(HomePage.class);
	
	@FindBy(xpath = "html/body/div/div/div/a/button")
	private WebElement getStartedButton;

	@FindBy(xpath = "//div[@id='navbarCollapse']//a[@href='/register']")
	private WebElement registerLnk;
	
	@FindBy(xpath = "//a[@href='login']")
	private WebElement signInLnk;	
	
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
	private WebElement graphGetgetStartedButtonHomePageGraphModulestarted;
	
 	@FindBy(xpath="//div[contains(@class, 'alert alert-primary')]")
	private WebElement ntloggedinMsg;
 	
	@FindBy(xpath = "//a[@class='navbar-brand']")
	private WebElement numpyNinjaLink;

	@FindBy(xpath = "//a[text()='Data Structures']")
	private WebElement dataStructuresDropdown;
	
	@FindBy(xpath = "//div[@id='navbarCollapse']//ul//a[contains(text(), 'Sign in')]")
	private WebElement signinLink;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getTitle() {
		logger.info("In HomePage:getTitle() method");
		return driver.getTitle();
	}
	
	public void homePageLogin() {
		driver.get(homePage);		
	}

	public void clickGetStartedButton() {
		getStartedButton.click();
	}

	public void clickGetStartedButtonHomePageDSIntroModule() {
		getStartedButtonHomePageDSIntroModule.click();
	}
	public void clickGetStartedButtonHomePageArrayModule() {
		getStartedButtonHomePageArrayModule.click();
	}	
	public void clickGetStartedButtonHomePageLinkedListModule() {
		getStartedButtonHomePageLinkedListModule.click();
	}
	public void clickGetStartedButtonHomePageStackModule() {
		getStartedButtonHomePageStackModule.click();
	}
	public void clickGetStartedButtonHomePageQueueModule() {
		getStartedButtonHomePageQueueModule.click();
	}	
	public void clickGetStartedButtonHomePageTreeModule() {
		getStartedButtonHomePageTreeModule.click();
	}
	public void clickGetStartedButtonHomePageGraphModule() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		graphGetgetStartedButtonHomePageGraphModulestarted.click();
	}	
	
	public void homePage() {
		driver.get(homePage);
	}
	
	public void linkOnTopRightCorner(String urltext) {
		driver.get(homePage);
		
		if (urltext!=null && !urltext.equals("") && urltext.equals("Register"))
			registerLnk.click();
		if (urltext!=null && !urltext.equals("") && urltext.equals("Sign In"))
			signInLnk.click();
		logger.info("In HomePage:linkOnTopRightCorner() URL TEXT : "+urltext);
	}
	
	public boolean isLinkOnTopRightCornerDisplayed(String urltext) {
		driver.get(homePage);
		WebElement lnk = signInLnk;
		if (urltext!=null && !urltext.equals("") && urltext.equals("Register"))
			lnk = registerLnk;
		if (urltext!=null && !urltext.equals("") && urltext.equals("Sign In"))
			lnk = signInLnk;
		return lnk.isDisplayed();
	}	
	
	public String getAlertMessageAndAccept() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		alert.accept();
		return message;
	}
	
	public String getnotlogedMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
		wait.until(ExpectedConditions.elementToBeClickable(ntloggedinMsg));
		return ntloggedinMsg.getText().trim();
	}
	
	public String getErrormessage() {
		return errorMessage;
	}	
	
	public String getRegisterLinkText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(registerLnk));
		return registerLnk.getText();
	}
	
	public String getDataStructureLblText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dataStructuresDropdown));
		return dataStructuresDropdown.getText();
	}

	public String getNumpyNinjaLinkText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(numpyNinjaLink));
		return numpyNinjaLink.getText();
	}

	public String getSigninLinkText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(signinLink));
		return signinLink.getText();
	}
}