package com.qa.dsalgo.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.CommonUtils;

public class Background {
	private WebDriver driver;

	@FindBy(linkText = "Get Started")
	WebElement getStartedBtn; // Adjust if your structure differs
	@FindBy(xpath = "//div[@id='navbarCollapse']//a[@href='/login']")
	private WebElement signinLink;
	@FindBy(name = "username")
	private WebElement usernametextbox;
	@FindBy(name = "password")
	private WebElement passwordtextbox;
	@FindBy(xpath = "//form//input[@type='submit' and @value='Login']")
	private WebElement loginButton;

	public Background(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void launchUrl() {
		driver.get(CommonUtils.APP_URL);
		
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public void ClickGetStarted() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(getStartedBtn));
		getStartedBtn.click();
	}

	public void userLoggedin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(signinLink));
		signinLink.click();
		usernametextbox.sendKeys(CommonUtils.UserName);
		passwordtextbox.sendKeys(CommonUtils.Password);
		loginButton.click();
	}

	public void verifyHomePageIsDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("NumpyNinja"));
		String expectedTitle = CommonUtils.APP_TITLE;
		String actualTitle = getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");

	}
}

