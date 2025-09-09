package com.qa.dsalgo.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class LoginPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//div[@id='navbarCollapse']//a[@href='/login']")
	private WebElement signinLink;
	@FindBy(name = "username")
	private WebElement usernametextbox;
	@FindBy(name = "password")
	private WebElement passwordtextbox;
	@FindBy(xpath = "//form//input[@type='submit' and @value='Login']")
	private WebElement loginButton;
	@FindBy(xpath = "//div[@role='alert']")
	WebElement errorMessage;
	@FindBy(css = ".alert.alert-primary")
	private WebElement successMessage;
	@FindBy(xpath = "//input[@name='username']/following-sibling::div[contains(@class, 'invalid-feedback')")
	WebElement popupErrorMessage;
	
	public LoginPage(WebDriver driver) {
		System.out.println(">> LoginPage constructor.");		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getErrorMessage() {
		System.out.println("getErrorMessage()");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		String ErrMsg = errorMessage.getText();
		return ErrMsg;
	}
	
	public void clickLoginLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(signinLink));
		signinLink.click();
	}
	
	public void fillTextBox(WebElement Textbox, String FieldName, String InputValue) 
	{
		if (InputValue != null) {
			Textbox.sendKeys(InputValue);
	    } else {
	        throw new IllegalArgumentException(FieldName + " value is null. Check your test data.");
	    }
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(Textbox));
		Textbox.clear();
		Textbox.sendKeys(InputValue);		
	}
	
	public void enterUsername(String username) {
		if (username != null) {
	        usernametextbox.sendKeys(username);
	    } else {
	        throw new IllegalArgumentException("Username value is null. Check your test data.");
	    }
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(usernametextbox));
		usernametextbox.clear();
		usernametextbox.sendKeys(username);	
	}

	public void enterPassword(String password) {
		if (password == null) {
	        throw new IllegalArgumentException("Password value is null. Check your test data.");
	    }
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(passwordtextbox));
		passwordtextbox.clear();
		passwordtextbox.sendKeys(password);
	}
	
	public void login(String username, String password) {
		fillTextBox(usernametextbox, "Username", username);
		fillTextBox(passwordtextbox, "Password", password);
		System.out.println("submitForm()");
		submitForm();
    }
	public void submitForm() {
		loginButton.click();
	}
	
	public String getSuccessMessage() {// this will go to home page as it shows on home page
        return successMessage.getText().trim();
    }
	
	public String getPasswordValidationMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(passwordtextbox));
		String validationMessage = passwordtextbox.getAttribute("validationMessage");
		System.out.println( "Passwordvalidationmessage:" + validationMessage);
		return validationMessage;
	}
	public String getUsernameValidationMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(usernametextbox));
		String Uservalidationmessage = usernametextbox.getAttribute("validationMessage");
		System.out.println( "Uservalidationmessage:" + Uservalidationmessage);
		return Uservalidationmessage;
	}
	
	
}

