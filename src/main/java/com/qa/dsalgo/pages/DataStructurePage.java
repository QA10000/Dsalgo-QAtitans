package com.qa.dsalgo.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonUtils;

public class DataStructurePage {
	WebDriver driver;
	private static final Logger logger = LogManager.getLogger(DataStructurePage.class);
	
	@FindBy(id ="id_username")
 	WebElement Username;
 	
 	@FindBy(id="id_password")
 	WebElement password;
 	
 	@FindBy (xpath= "//input[@value='Login']")
 	WebElement loginButton;

	@FindBy(xpath = "//a[normalize-space()='Sign out']")
	WebElement signOutLnk;
 	
 	@FindBy(xpath="//div[contains(@class, 'alert alert-primary')]")
    WebElement loginSuccessMessage;
 	
 	@FindBy(xpath="//a[@href='data-structures-introduction']")
 	WebElement dataStructuresGetStartedButton;
 	
 	@FindBy(linkText = "Time Complexity")
 	WebElement timeComplexityButton;
 	
 	@FindBy(linkText = "Try here>>>")
 	WebElement tryHereButton;

 	@FindBy(xpath="//a[@href='tryEditor']")
 	WebElement tryHereLink;
 	
	@FindBy(xpath = "//a[@class='btn btn-info']")
	WebElement tryButton; 	
	
 	@FindBy(xpath="//form/div/div/div/textarea")
    WebElement tryEditor;
 	
 	@FindBy(xpath="//button[text()='Run']")
 	WebElement runButton;
 	
 	@FindBy(id="output")
 	WebElement editorMsg;
 	
	@FindBy(xpath = "//h4[@class='bg-secondary text-white']")
	WebElement dsLabel;
 	
	@FindBy(xpath = "//p[@class='bg-secondary text-white']")
	WebElement timeComplexityLabel;
	
	//@FindBy(css = "textarea")
 	@FindBy(id="editor")
	WebElement codeTextArea;
 	
	@FindBy(xpath = "//a[@class='navbar-brand']")
	WebElement numpyNinjaLink;

	@FindBy(xpath = "//a[text()='Data Structures']")
	WebElement dataStructuresDropdown;	
	
	@FindBy(xpath = "//a[normalize-space()='Roopzsohani@gmail.com']")
	private WebElement usernameLabel;
	
 	String path, pythonvalidcode;
 	// ExcelUtils excel;
 	Actions acts;
 	
 	String printMsg;
 	String title="";
 	
 	String successMessage="";

	String errorMessage ="";

 	String loginPageURL = "https://dsportalapp.herokuapp.com/login";
 	//String homePageURL = "https://dsportalapp.herokuapp.com/home";
 	// String dataStructurePage= "https://dsportalapp.herokuapp.com/data-structures-introduction/";
 	String dataStructurePage = CommonUtils.DS_URL;
 	// String dataStructuresTimeComp= "https://dsportalapp.herokuapp.com/data-structures-introduction/time-complexity/";
 	String dataStructuresTimeComp = CommonUtils.DS_TS_URL; 
 	//String tryEditorPage= "https://dsportalapp.herokuapp.com/tryEditor";
 	String tryEditorPage = CommonUtils.TRY_EDTR_URL; 
 	String excelURL = "//src//test//resources//ExcelData//ExcelData.xlsx";
	
	String homePageURL = CommonUtils.HOME_URL;

	public DataStructurePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		acts= new Actions(driver);
	}
	public void Login()	{
		driver.get(loginPageURL);
	}
	public void CorrectUsernameAndPassword(String uid, String pwd){
		Username.sendKeys(uid);
		password.sendKeys(pwd);
		loginButton.click();
		successMessage=loginSuccessMessage.getText();
		logger.info("The Login is successful:" +successMessage );
 	}
	public void homePage(){
		driver.get(homePageURL);
	}
	
	public void dataStructuresIntroPage(){
		driver.get(dataStructurePage);
	}
	
	public void clickTimeComplexity(){
		acts.moveToElement(timeComplexityButton);
		timeComplexityButton.click();
		title= driver.getTitle();
	}
	
	public void timeComplexityPage(){
		driver.get(dataStructuresTimeComp);
	}
	
	public void tryHereEditorPage()	{
		driver.get(tryEditorPage);
	}
	
	public boolean dsLabelDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOf(dsLabel));
		logger.info("dsLabelDisplayed() | "+dsLabel.isDisplayed());
		return dsLabel.isDisplayed();
	}
	
	public boolean timeComplexityLableDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOf(timeComplexityLabel));
		logger.info("timeComplexityLableDisplayed() | "+timeComplexityLabel.isDisplayed());
		return timeComplexityLabel.isDisplayed();
	}

	public boolean codeTextAreaDisplayed() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOf(codeTextArea));
		logger.info("codeTextAreaDisplayed() | "+codeTextArea.isDisplayed());
		return codeTextArea.isDisplayed();
	}
	
	public boolean codeExectuionDisplayed() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOf(codeTextArea));
		logger.info("codeTextAreaDisplayed() | "+codeTextArea.isDisplayed());
		return codeTextArea.isDisplayed();
	}

	public boolean codeExectuionOPDisplayed()throws 	InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOf(editorMsg));
		logger.info("codeExectuionOPDisplayed() | "+editorMsg.isDisplayed());
		return editorMsg.isDisplayed();
	}
	
	public void clickTryHere() {
		clickRunTryEditor();
	}
	
	public void clickDataStructuresGetStarted()	{
		dataStructuresGetStartedButton.click();
		title= driver.getTitle();
	}
	
	public void clickRunTryEditor()	{
		driver.get(tryEditorPage);
	}

	public void getPythonCode(String pycode){			
		 tryEditor.sendKeys(pycode);
	     runButton.click();
	     // acts.scrollToElement(editorMsg);
		 // printMsg= editorMsg.getText();  
	     logger.info("The message when a valid pytho code is entered is: ");
	}
	
	public String getPythonCodeExcMsg(){
	     acts.scrollToElement(editorMsg);
		 printMsg= editorMsg.getText();  
		 logger.info("The message when a valid pytho code is entered is, getPythonCodeExcMsg:" +printMsg);
		 return printMsg;
	}
	
	public void invalidPythonCode(String pycode)	{
		 tryEditor.sendKeys(pycode);
	     runButton.click();
	     printMsg=driver.switchTo().alert().getText();
	     logger.info("The error message is "+driver.switchTo().alert().getText());
	     driver.switchTo().alert().accept(); 
	     driver.navigate().to(homePageURL);
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getLoginSuccessMessage(){
		return successMessage;
	}
	
	public String getSuccessMessage(){
	   	return printMsg;
	}

	public String getSignOutLinkText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//if (signOutLnk.isDisplayed())
		wait.until(ExpectedConditions.elementToBeClickable(signOutLnk));
		return signOutLnk.getText();
	}

	public String getNumpyNinjaLinkText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(numpyNinjaLink));
		return numpyNinjaLink.getText();
	}
	public String getDataStructureLblText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dataStructuresDropdown));
		return dataStructuresDropdown.getText();
	}

	public String getUsernameLblText() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(usernameLabel));
		return  usernameLabel.getText();
	}	
}