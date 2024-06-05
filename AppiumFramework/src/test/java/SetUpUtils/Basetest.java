package SetUpUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.common.collect.ImmutableMap;

import Pages.FormPage;
import Utils.CommonUtilForIOS_ANDROID;
import io.appium.java_client.android.AndroidDriver;

public class Basetest extends CommonUtilForIOS_ANDROID{
	Logger loggger = LogManager.getLogger(Basetest.class);
	
	
	public AndroidDriver driver;
	
	public FormPage f ;
	
	@BeforeMethod(alwaysRun=true)
	public void launchBrowser() throws MalformedURLException, InterruptedException, FileNotFoundException {
		
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		FileInputStream fis = new FileInputStream("C:\\Users\\pc\\eclipse-workspace\\AppiumFramework\\src\\main\\java\\Resources\\data.properties");
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String device = prop.getProperty("Devicename");
		String appLoc = prop.getProperty("appLocCaps");
		
		

		
		
		
		
		Thread.sleep(3000);

		
		   DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", prop.getProperty("Devicename"));
	       // caps.setCapability("deviceName", "ZF652577LF");
	        caps.setCapability("app", prop.getProperty("appLocCaps"));
	        caps.setCapability("automationName", "uiautomator2");
	        caps.setCapability("platformName", "Android");
//	        caps.setCapability("browserName", "Chrome");
//	        caps.setCapability("chromedriverExecutable", "C:\\Users\\pc\\eclipse-workspace\\AutomationTest\\driver\\chromedriver.exe");
		
		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		// URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
		driver = new AndroidDriver(url, caps);
		 f  = new FormPage(driver);
		 loggger.info("Launched Suscessfully");
		

	

}
	
	
	
	
}
