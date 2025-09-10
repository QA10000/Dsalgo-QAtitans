package com.qa.dsalgo.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TryEditorPage {

	private WebDriver driver;
	
	@FindBy(css = "div.CodeMirror-scroll")
	private WebElement codeEditorTxtBx;
	
	@FindBy(xpath = "//button[@type='button']")
	private WebElement runBtn;

	@FindBy(xpath = "//pre[@id='output']")
	private WebElement tryHereOutput;
	 
	public TryEditorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	public void codeEditorSendKeys(String code) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(codeEditorTxtBx));
	    ((JavascriptExecutor) driver).executeScript(
	        "document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);", code);
	}
	
	public void clickRunBtn() {
		runBtn.click();
		
	}
	
	public String getAlertMessageAndAccept() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
	    String message = alert.getText();
	    alert.accept();
	    return message;
	}
	
	public String getTryHereOutput() {
		return tryHereOutput.getText();		
	}
}
