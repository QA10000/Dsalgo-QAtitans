/*package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class CommonUtils {
	public static String APP_URL;
	public static String BROWSER;
	public static String UserName;
	public static String Password;
	public static String CHROME_DRIVER;
	public static String APP_TITLE;
	public static String USERNAME;
	public static String PASSWORD;
	public static String EXCELREADER;
	public static String  REGISTER_LINK;
	public static List<String> LINKLISTPAGE_LINKS;
	public static List<String> LINKLISTSUBPAGE_LINKS;
    public static List<String> LINKLISTPAGE_HEADERS;
    public static List<String> STACKPAGE_LINKS;
	
	static Properties properties = new Properties();
		
	public static void loadProperties() {
		
		FileInputStream inputstr = null;
		
		try {
		 inputstr = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config//configuration.properties");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	
	try {
	    properties.load(inputstr);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	APP_URL = properties.getProperty("applicationURL");  
	BROWSER = properties.getProperty("BROWSER");
	CHROME_DRIVER = properties.getProperty("CHROME_DRIVER");
	UserName = properties.getProperty("UserName");
	Password = properties.getProperty("Password");
	APP_TITLE = properties.getProperty("APP_TITLE");
	EXCELREADER = properties.getProperty("excelfilepath");
    REGISTER_LINK = properties.getProperty("registerurl");
    

	}
	
}*/

package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class CommonUtils {
	public static String APP_URL;
	public static String BROWSER;
//	public static String UserName;
//	public static String Password;
	public static String APP_TITLE;
	public static String USERNAME;
	public static String PASSWORD;
	public static String EXCELREADER;
	public static String  REGISTER_LINK;
	public static String CHROME_DRIVER;
	public static String HOME_URL ;
	public static String LOGIN_URL ;
	public static String DS_URL;
	public static String DS_TS_URL;
	public static String TRY_EDTR_URL;	
	public static List<String> LINKLISTPAGE_LINKS;
	public static List<String> LINKLISTSUBPAGE_LINKS;
    public static List<String> LINKLISTPAGE_HEADERS;
    public static List<String> STACKPAGE_LINKS;
	
	
	static Properties properties = new Properties();
		
	public static void loadProperties() {
		
		FileInputStream inputstr = null;
		try {
		 inputstr = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config//configuration.properties");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	
	try {
	    properties.load(inputstr);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	APP_URL = properties.getProperty("applicationURL");  
	BROWSER = properties.getProperty("BROWSER");
	CHROME_DRIVER = properties.getProperty("CHROME_DRIVER");
	USERNAME = properties.getProperty("UserName");
	PASSWORD = properties.getProperty("Password");
	APP_TITLE = properties.getProperty("APP_TITLE");
	EXCELREADER = properties.getProperty("excelfilepath");
    REGISTER_LINK = properties.getProperty("registerurl"); 
    HOME_URL = properties.getProperty("homepageURL");
    LOGIN_URL=properties.getProperty("homepageURL");
    LINKLISTPAGE_LINKS = Arrays.stream((properties.getProperty("LinkedListPageLinks")).split(",")).map(String::trim).toList();
    LINKLISTSUBPAGE_LINKS = Arrays.stream((properties.getProperty("LinkedListPageLinks")).split(",")).map(String::trim).toList();
    LINKLISTPAGE_HEADERS =Arrays.stream((properties.getProperty("LinkedListPageHeaders")).split(",")).map(String::trim).toList();
    STACKPAGE_LINKS = Arrays.stream((properties.getProperty("StackPageLinks")).split(",")).map(String::trim).toList();
    DS_URL = properties.getProperty("dataStructurePage");
    DS_TS_URL = properties.getProperty("dataStructuresTimeComp");
    TRY_EDTR_URL = properties.getProperty("tryEditorPage");
   	
	}
	

	
}

