package com.qa.dsalgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingLinkedListPage {
	
	private WebDriver driver;
	
	 @FindBy(xpath = "//a[@href='/tryEditor']")
	    private WebElement tryHereButton;
	
	public CreatingLinkedListPage(WebDriver driver) {
		System.out.println(">> CreatingLinkedListPage constructor.");		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickTryHere() {
        tryHereButton.click();
    }
}
