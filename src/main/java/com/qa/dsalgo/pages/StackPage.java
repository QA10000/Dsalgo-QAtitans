package com.qa.dsalgo.pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StackPage {

	private WebDriver driver;
		
	@FindBy(xpath = "//div[@class='card-body d-flex flex-column'][h5[text()='Stack']]//a[contains(@href, 'stack')]")
	private WebElement stackGetStarted;
	
	@FindBy(xpath = "//a[@href and normalize-space(text()) != '']")
    private List<WebElement> navigationLinks;

	public StackPage(WebDriver driver) {
		System.out.println(">> StackPage constructor.");		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clicklinkedListGetStarted() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(stackGetStarted));
		stackGetStarted.click();
	}
	
	public void clickLinkedListOption(String optionName) {
        driver.findElement(By.linkText(optionName)).click();
    }
	
	public void clickOperationsinStackLink() {
        driver.findElement(By.linkText("Operations in Stack")).click();
    }

	public void clickImplementationLink() {
        driver.findElement(By.linkText("Implementation")).click();
    }

	public void clickApplicationsLink() {
        driver.findElement(By.linkText("Applications")).click();
    }

	public List<String> getAllLinkTexts() {
        return navigationLinks.stream()
                .map(link -> link.getText().trim()) // trim removes extra spaces
                .collect(Collectors.toList());
    }
}

