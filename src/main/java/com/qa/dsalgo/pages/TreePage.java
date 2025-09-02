package com.qa.dsalgo.pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TreePage {
	@FindBy(xpath = "//div[@id='navbarCollapse']//a[@href='/login']")
	private WebElement signinLink;
	@FindBy(name = "username")
	private WebElement usernametextbox;
	@FindBy(name = "password")
	private WebElement passwordtextbox;
	@FindBy(xpath = "//form//input[@type='submit' and @value='Login']")
	private WebElement loginButton;
	@FindBy(xpath = "//a[@href='tree']")
	private WebElement treeStartButton;
	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
	private WebElement dropdown;
	@FindBy(xpath = "//a[@class='dropdown-item' and text()='Tree']")
	private WebElement arraysLinkItem;// from dropdown
	
	private WebDriver driver;

	public TreePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickTreeStrtBtn() {
		treeStartButton.click();	
	}
	public void selectTreeFrmDropdown() { // how we can avoid this method to be repeated in different modules, can we put it in home module?
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		dropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(arraysLinkItem));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", arraysLinkItem);
		wait.until(
		ExpectedConditions.or(ExpectedConditions.titleContains("Tree"), ExpectedConditions.urlContains("tree")																												// both
						));
	}
	}



