package Utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends CommonUtilForIOS_ANDROID {
	//Logger log = LogManager.getLogger(AndroidActions.class);
	AppiumDriver  driver;

	
	public AndroidActions(AndroidDriver driver) {
		//super(driver);
		this.driver = driver;
	}
	
	
	public void startActivity() {
		
		
	}
	
	public void normalSendKey(WebElement ele, String val,String ElementNameFoRlOG) {
		ele.sendKeys(val);
		Logdetails(ElementNameFoRlOG+ "Keys sent suscessfully");
		
		
	}
	

	public void Longpress(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
		
	}
	
	public void scroll(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
		
	}
	

	public Double formattedamount(String amount) {
		 Double price =  Double.parseDouble(amount.substring(1));
		 return price;
		
		
	}
	
	public void WebdriverwaitWithElementTextName(WebElement ele, String ElementText) {
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
      wait.until(ExpectedConditions.attributeContains(ele, "text", "ElementText"));
	}
	
	public void normallClick(WebElement ele, String log) {
		ele.click();
		Logdetails(log + "clicked performed");
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	public void normalSendKeys(WebElement ele, String val, String logdetail) {
//		ele.sendKeys(val);
//		getExtentTest().log(Status.INFO,  "logdetail");
//		
//	}
//	
//	public ExtentTest getExtentTest() {
//		return test;
//	}
//
//	public void extentReport() {
//
//		DateFormat df = new SimpleDateFormat("mm-dd-yyyy-hh-mm-ss");
//		String timeStam = df.format(new Date());
//		ExtentSparkReporter htmlReport = new ExtentSparkReporter("ExtentReport" + timeStam + ".html");
//
//		htmlReport.config().setReportName("WoS WorkOver Solutions Test Report");
//		report = new ExtentReports();
//
//		report.attachReporter(htmlReport);
//
//	}
//
//	public void flush() {
//		report.flush();
//	}
//	
//	public void createTestCase(String teatCaseName) {
//		test = report.createTest(teatCaseName);
//	}
//	
//	public void testCaseId(String testCaseName) {
//		test = report.createTest(testCaseName);
//		test.log(Status.INFO, MarkupHelper.createLabel(testCaseName + "generate successfully", ExtentColor.GREEN));
//	}
//	
//	
//	
//	
//	public void capturedScreen(String trestname, AppiumDriver driver) throws IOException {
//		TakesScreenshot screening = ((TakesScreenshot) driver);
//		File src = screening.getScreenshotAs(OutputType.FILE);
//		File dest = new File(System.getProperty("user.dir") + "//ScreenShots//" + trestname + ".png");
//		FileUtils.copyFile(src, dest);
//
//	}
//
//	public ExtentTest SnapShot(String fileName, AppiumDriver driver) {
//		TakesScreenshot tscreen = (TakesScreenshot) driver;
//		File files = tscreen.getScreenshotAs(OutputType.FILE);
//
//		File file = new File(fileName + "SnapShot.png");
//		try {
//			com.google.common.io.Files.copy(files, file);
//			
//			test.log(Status.INFO,
//					MarkupHelper.createLabel("Takes ScreenShot is performed succesfully ", ExtentColor.GREY));
//		} catch (IOException e) {
//			test.log(Status.INFO,
//					MarkupHelper.createLabel("Takes ScreenShot isn't performed succesfully ", ExtentColor.RED));
//			e.printStackTrace();
//		}
//		return test.addScreenCaptureFromPath(file.getAbsolutePath());
//	}

}
