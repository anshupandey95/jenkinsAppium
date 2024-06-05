package Utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class CommonUtilForIOS_ANDROID  {
	Logger logg = LogManager.getLogger(CommonUtilForIOS_ANDROID.class);

	
	
//	AndroidDriver driver;
//	
//	public CommonUtilForIOS_ANDROID(AndroidDriver driver) {
//		this.driver = driver;
//		
//	}
//	
	public void Logdetails(String logvalue) {
		logg.info(logvalue);
		
	}

	public Double formattedamount(String amount) {
		 Double price =  Double.parseDouble(amount.substring(1));
		 return price;
		
		
	}
	
	public List<HashMap<String, String>> getJsonDataType(String pathfile) throws IOException {
		//String jsonContent = File.readFileToString( new File (System.getProperty("user.dir")+"\\src\\test\\java\\testData\\eCommerce.json"),StandardCharsets);
		  String jsonContent = FileUtils.readFileToString( new File(pathfile),  StandardCharsets.UTF_8 );
		ObjectMapper mapper = new ObjectMapper();
		 List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {
		});
		 return data;
	}
	
	
	

	public void WebdriverwaitWithElementTextName(AppiumDriver driver,WebElement ele, String ElementText) {
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
      wait.until(ExpectedConditions.attributeContains(ele, "text", "ElementText"));
	}
	
	public String getScreenshot(String TestCaseName ,AppiumDriver driver) throws IOException {
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		String dest =   System.getProperty("user.dir")+"//Reportss"+ TestCaseName+ ".png";
		FileUtils.copyFile(source, new File(dest) );
		return dest;
		
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
