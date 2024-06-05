package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {
	Logger loggger = LogManager.getLogger(FormPage.class);
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

		
	}
	
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	
	//Female
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement FemaleRadio;
	
	@AndroidFindBy(id = "android:id/text1")
	private WebElement countrybt
	;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Albania']")
	private WebElement coun;
	
	
	@AndroidFindBy(xpath  = "//android.widget.TextView[@text='Argentina']")
	private WebElement tapargentina;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement Submit;
	
	
	
	public void SetnameField(String usrName) {
		normalSendKey(nameField, usrName, "nameField");
		//normalSendKey(nameField, usrName);
		//Logdetails(LogfordetailElement);
		//loggger.info("Clicked Suscess");
		
		driver.hideKeyboard();

	}
	
	public void clickFemale(String gender) {
		if(gender.contains("female")) {
			FemaleRadio.click();
			
		} else {
			System.out.println("Not Found");
		}
		//FemaleRadio.click();
	}
	
	
	
	public void clickcountryBar() {
		countrybt.click();
	}
	
	public void selectCountry(String contryname) throws InterruptedException {
		if(contryname.contains("Albania")) {
			Thread.sleep(2000);
			
			
			coun.click();
			
		} else {
			System.out.println("not country found");
		}
		
		
		
		//scroll("Albania");
		Thread.sleep(2000);
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		//tapargentina.click();
	}
	
	public productCatalogue submitfrm() {
		Submit.click();
		return new productCatalogue(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
   // driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
    
	
	
	
	
}
