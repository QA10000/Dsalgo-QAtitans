package com.qa.dsalgo.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Background {
	@FindBy(linkText = "Get Started")
	WebElement getStartedBtn; // Adjust if your structure differs
	
	private WebDriver driver;

	public Background(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
		
	public void ClickGetStarted() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(getStartedBtn));
		getStartedBtn.click();
	}
}
