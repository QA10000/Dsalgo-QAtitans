package com.qa.dsalgo.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverScripts {
	protected static WebDriver driver;
		public static Alert alert;
		public static Properties prop;
		public DriverScripts(){
			
			try {
				File file = new File("src/test/resources/config/configuration.properties");
				FileInputStream files = new FileInputStream(file);
				prop = new Properties();
				prop.load(files);
				System.out.println(">> In DriverScripts constructor.");
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static WebDriver initializeApplication(Properties prop) {
		    String browsers = prop.getProperty("browser").trim();

		    if (browsers.equalsIgnoreCase("chrome")) {
		        driver = new ChromeDriver();
		    } else if (browsers.equalsIgnoreCase("firefox")) {
		        driver = new FirefoxDriver();
		    } else if (browsers.equalsIgnoreCase("edge")) {
		        driver = new EdgeDriver();
		    } else {
		        throw new RuntimeException("Unsupported browser: " + browsers);
		    }

		    // ✅ Always navigate to the URL, regardless of browser
		    String dsalgourl = prop.getProperty("url");
		    if (dsalgourl != null && !dsalgourl.isEmpty()) {
		        driver.manage().window().maximize();
		        driver.get(dsalgourl);
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    } else {
		        throw new RuntimeException("URL is missing from properties file.");
		    }
			return driver;
		}		    
		
		 public void closeCurrentWindow() {
		        if (driver != null) {
		            driver.close();  // only closes the current browser window
		        }
		 }
		   
	   }