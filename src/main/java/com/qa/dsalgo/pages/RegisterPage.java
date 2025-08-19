package com.qa.dsalgo.pages;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

	@FindBy(xpath = "//div[@id='navbarCollapse']//a[@href='/register']")
	private WebElement registerLink;
	@FindBy(name = "username")
	private WebElement usernametextbox;
	@FindBy(name = "password1")
	private WebElement passwordtextbox;
	@FindBy(name = "password2")
	private WebElement confirmedPswdtextbox;
	@FindBy(xpath = "//form//input[@type='submit' and @value='Register']")
	private WebElement registerButton;
	@FindBy(xpath = "//*[contains(text(), 'password_mismatch')]")
	private WebElement mismatchpassword;
	@FindBy(css = ".alert.alert-primary")
	private WebElement successMessage;


	private WebDriver driver;// declared a private instance variable

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void clickRegisterLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(registerLink));
		registerLink.click();
	}

	public void enterUsername(String username) {
		if (username != null) {
	        usernametextbox.sendKeys(username);
	    } else {
	        throw new IllegalArgumentException("Username value is null. Check your test data.");
	    }
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//usernametextbox.sendKeys(username);
		wait.until(ExpectedConditions.visibilityOf(confirmedPswdtextbox));
		confirmedPswdtextbox.clear();
		
		
	}

	public void enterPassword(String password) {
		if (password == null) {
	        throw new IllegalArgumentException("Password value is null. Check your test data.");
	    }
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(confirmedPswdtextbox));
		confirmedPswdtextbox.clear();
		passwordtextbox.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmpassword) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(confirmedPswdtextbox));
		confirmedPswdtextbox.clear();
		confirmedPswdtextbox.sendKeys(confirmpassword);
	}

	public void submitForm() {
		registerButton.click();
	}

	 public String getMismatchMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(mismatchpassword));
		return mismatchpassword.getText();
	 }
	 
	   public String getSuccessMessage() {// this will go to home page as it shows on home page
	        return successMessage.getText().trim();
	    }
}
	  