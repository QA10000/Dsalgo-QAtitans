package utilities;

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
	public static String ARRAYSOPTIONS;
	public static String LINKEDLISTOPTIONS;
	public static String STACKOPTIONS;
	public static String QUEUEOPTIONS;
	public static String TREEOPTIONS;
	public static String GRAPHOPTIONS;
	public static String DATASTRUCTURESOPTIONS;
	static Properties properties = new Properties();
		
	public static void loadProperties() {
		
		//FileReader reader= null;
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
	DATASTRUCTURESOPTIONS=properties.getProperty("DataStructuresValue");
	ARRAYSOPTIONS = properties.getProperty("ArrayOptionValue");
	LINKEDLISTOPTIONS = properties.getProperty("LinkedListOptionValue");
	STACKOPTIONS = properties.getProperty("StackOptionValue");
	QUEUEOPTIONS = properties.getProperty("QueueOptionValue");
	TREEOPTIONS = properties.getProperty("TreeOptionValue");
	GRAPHOPTIONS = properties.getProperty("GraphOptionValue");	
		
	}
	

	
}