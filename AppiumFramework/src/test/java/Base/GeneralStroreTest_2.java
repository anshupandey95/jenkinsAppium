package Base;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.collect.ImmutableMap;

import Pages.CartPage;
import Pages.FormPage;
import Pages.pricevalidationPage;
import Pages.productCatalogue;
import SetUpUtils.Basetest;
import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
@Listeners(listenner.lostener.class)
public class GeneralStroreTest_2 extends Basetest{
	
	
	
	
	public void preSet() {

		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.SplashActivity");
		((JavascriptExecutor) driver).executeScript("mobile: startActivity",
				ImmutableMap.of("intent", "com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
	}
	
	
	@Test(dataProvider = "getData",groups = {"Smoke"})
	public void fillform_2(HashMap<String,String> input) throws InterruptedException {
	
		//FormPage f = new FormPage(driver);

		Thread.sleep(4000);
		f.SetnameField(input.get("name"));
		
		Thread.sleep(2000);
		f.clickFemale(input.get("gender"));

		Thread.sleep(3000);
	
		f.clickcountryBar();
		Thread.sleep(2000);
		
		
//		
		f.selectCountry(input.get("contryname"));
		Thread.sleep(3000);
		
		 productCatalogue p =     f.submitfrm();
		 Thread.sleep(3000);
		
		 p.additemByIndex(0);
		    Thread.sleep(2000);
		    p.additemByIndex(0);
		  
		    Thread.sleep(2000);
		
		
		
		
		
		
		
//		
//
//		
//	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
//	    Thread.sleep(2000);
//	    
//	    driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
//	    Thread.sleep(2000);
//		f.selectCountry();
//		Thread.sleep(3000);
//	    
//	   // driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//		 productCatalogue p =     f.submitfrm();
//		 Thread.sleep(2000);
//		//productCatalogue p = new productCatalogue(driver);
//		p.additemByIndex(0);
//	    Thread.sleep(2000);
//	    p.additemByIndex(0);
//	   // driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
//	    Thread.sleep(2000);
//	   
//	    //driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
//	   // Thread.sleep(4000);
//	   // driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//	    pricevalidationPage c =  p.gotoCart();
//	    Thread.sleep(2000);
//	   
////        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
////        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
////        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
////        Thread.sleep(4000);
////        int productSize =productPrices.size();
////        double Totalsum = 0;
////        
////        for(int i =0; i<productSize; i++) {
////	   
////        String FirstAmount = productPrices.get(0).getText();
////       Double price =  Double.parseDouble(FirstAmount.substring(1));
////       Totalsum = Totalsum + price;
////        }
//        
//        
//	    Thread.sleep(4000);
//	    double sum = c.getProductSum();
//	    Thread.sleep(2000);
//	    double displaySum = c.gettotalAmountDisplayed();
//	    
//
////		String totalprice = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
////		Double totalnewprice = formattedamount(totalprice);
////		System.out.println(totalnewprice);
//		Thread.sleep(2000);
//	//	Assert.assertEquals(sum, displaySum);
//		//Assert.assertEquals(Totalsum, "321.94");
//		
////		WebElement e = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
////		Longpress(e);
////		driver.findElement(By.id("android:id/button1")).click();
//	
	
	}
	
	//@Test
	public void NewTest() throws InterruptedException {
		
		
		
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ayush Pandey");
		//driver.hideKeyboard();
		Thread.sleep(8000);
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(2000);
		Logdetails("Second test started   ");
		Assert.assertTrue(false);

		
	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
	    Thread.sleep(2000);
	    Logdetails("Scrolled SuscessFully");
	    
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	    Thread.sleep(2000);
	   String toastmsg =  driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
	    AssertJUnit.assertEquals(toastmsg,"Please enter your name");
	    Thread.sleep(2000);
	    
	    
	    
      
		
	}
	
//	@DataProvider
//	public Object[][] getData() throws IOException
//	{
//		return new Object[][] {   {"Ayush Pandey", "female","Albania"},  {"James Jack", "female","Albania"}                  };
//		
//	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{            
		
		List<HashMap<String, String>>	data= getJsonDataType("./datt/eCommerce.json");
		return new Object[][] {   {data.get(0)},{data.get(1)  }  };
		}

		
	}


	
	
	
	   
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

