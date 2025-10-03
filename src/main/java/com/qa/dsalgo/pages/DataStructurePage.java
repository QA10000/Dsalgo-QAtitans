package com.qa.dsalgo.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
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

    @FindBy(id = "id_username")
    WebElement Username;

    @FindBy(id = "id_password")
    WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//a[normalize-space()='Sign out']")
    WebElement signOutLnk;

    @FindBy(xpath = "//div[contains(@class, 'alert alert-primary')]")
    WebElement loginSuccessMessage;

    @FindBy(xpath = "//a[@href='data-structures-introduction']")
    WebElement dataStructuresGetStartedButton;

    @FindBy(linkText = "Time Complexity")
    WebElement timeComplexityButton;

    @FindBy(linkText = "Try here>>>")
    WebElement tryHereButton;

    @FindBy(xpath = "//a[@class='btn btn-info']")
    WebElement tryButton;

    @FindBy(xpath = "//button[text()='Run']")
    WebElement runButton;

    @FindBy(id = "output")
    WebElement editorMsg;

    @FindBy(xpath = "//h4[@class='bg-secondary text-white']")
    WebElement dsLabel;

    @FindBy(xpath = "//p[@class='bg-secondary text-white']")
    WebElement timeComplexityLabel;

    @FindBy(xpath = "//a[@class='navbar-brand']")
    WebElement numpyNinjaLink;

    @FindBy(xpath = "//a[text()='Data Structures']")
    WebElement dataStructuresDropdown;

    @FindBy(xpath = "//a[normalize-space()='Qatitans1']") // Update to dynamic locator if needed
    private WebElement usernameLabel;

    @FindBy(css = "div.CodeMirror")
    WebElement codeMirrorEditor;

    Actions acts;

    String printMsg;
    String title = "";
    String successMessage = "";

    // URLs
    String loginPageURL = "https://dsportalapp.herokuapp.com/login";
    String dataStructurePage = CommonUtils.DS_URL;
    String dataStructuresTimeComp = CommonUtils.DS_TS_URL;
    String tryEditorPage = CommonUtils.TRY_EDTR_URL;
    String homePageURL = CommonUtils.HOME_URL;

    public DataStructurePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        acts = new Actions(driver);
    }

    public void Login() {
        driver.get(loginPageURL);
    }

    public void CorrectUsernameAndPassword(String uid, String pwd) {
        Username.sendKeys(uid);
        password.sendKeys(pwd);
        loginButton.click();
        successMessage = loginSuccessMessage.getText();
        logger.info("The Login is successful: " + successMessage);
    }

    public void homePage() {
        driver.get(homePageURL);
    }
    
	public String getTitleDatapage() { 
		return driver.getTitle();
	}


    public void dataStructuresIntroPage() {
        driver.get(dataStructurePage);
    }

    public void clickStartBtn() {
    	dataStructuresGetStartedButton.click();
	}

    public void clickTimeComplexity() {
        acts.moveToElement(timeComplexityButton).perform();
        timeComplexityButton.click();
        title = driver.getTitle();
    }

    public void timeComplexityPage() {
        driver.get(dataStructuresTimeComp);
    }

    public void tryHereEditorPage() {
        driver.get(tryEditorPage);
    }

    public void clickDataStructuresGetStarted() {
        dataStructuresGetStartedButton.click();
        title = driver.getTitle();
    }
    public void clickSection(String sectionName) {
        if (!"Time Complexity".equalsIgnoreCase(sectionName.trim())) {
            throw new IllegalArgumentException("Unknown section: " + sectionName);
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(timeComplexityButton));
        timeComplexityButton.click();
        logger.info("Clicked on section: " + sectionName);
    }


    public void clickTryHere() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(tryHereButton));
        tryHereButton.click();
    }
    public void codeEditorSendKeys(String code) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Wait for CodeMirror editor container to be visible
	    wait.until(ExpectedConditions.visibilityOf(codeMirrorEditor));

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Clear existing content
	    js.executeScript("document.querySelector('.CodeMirror').CodeMirror.setValue('');");

	    // Enter new code
	    js.executeScript("document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);", code);

	    try {
	        Thread.sleep(500); // Small pause (not mandatory but helpful sometimes)
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
	}
    
    public void clickRunBtn() {
		runButton.click();

	}

    public boolean codeTextAreaDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(codeMirrorEditor));
        logger.info("codeTextAreaDisplayed() | " + codeMirrorEditor.isDisplayed());
        return codeMirrorEditor.isDisplayed();
    }

    public boolean codeExecutionDisplayed() {
        return codeTextAreaDisplayed(); // Reuse method
    }

    public boolean codeExecutionOPDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(editorMsg));
        logger.info("codeExecutionOPDisplayed() | " + editorMsg.isDisplayed());
        return editorMsg.isDisplayed();
    }

    public void setCodeMirrorText(String code) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(codeMirrorEditor));
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].CodeMirror.setValue(arguments[1]);", codeMirrorEditor, code);
    }

    public void getPythonCode(String pycode) throws InterruptedException {
        setCodeMirrorText(pycode);
        runButton.click();
        Thread.sleep(2000);
        logger.info("Python code submitted for execution.");
    }

    public String getPythonCodeExcMsg() {
        acts.scrollToElement(editorMsg).perform();
        printMsg = editorMsg.getText();
        logger.info("Execution output: " + printMsg);
        return printMsg;
    }

    public void invalidPythonCode(String pycode) throws InterruptedException {
        setCodeMirrorText(pycode);
        runButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            printMsg = alert.getText();
            logger.info("Alert message: " + printMsg);
            alert.accept();
        } catch (TimeoutException e) {
            logger.error("Alert did not appear after running invalid code", e);
            throw new AssertionError("No alert present after running invalid code");
        } finally {
            driver.navigate().to(homePageURL);
        }
    }

    public String getAlertMessageAndAccept() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String message = alert.getText();
            alert.accept();
            return message;
        } catch (TimeoutException e) {
            logger.error("Alert did not appear", e);
            throw new AssertionError("Expected alert not present");
        }
    }

    public boolean dsLabelDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dsLabel));
        return dsLabel.isDisplayed();
    }

    public boolean timeComplexityLabelDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(timeComplexityLabel));
        return timeComplexityLabel.isDisplayed();
    }
    
    
   public String getTitle() {
        return title;
    }

    public String getLoginSuccessMessage() {
        return successMessage;
    }

    public String getSuccessMessage() {
        return printMsg;
    }

    public String getSignOutLinkText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public String getUsernameLblText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(usernameLabel));
        return usernameLabel.getText();
    }
}
