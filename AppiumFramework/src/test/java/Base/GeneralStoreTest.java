package Base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import SetUpUtils.Basetest;
import io.appium.java_client.AppiumBy;

public class GeneralStoreTest extends Basetest{
	//@Test
	public void FillForm() throws InterruptedException {
		
		Thread.sleep(4000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ayush Pandey");
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(2000);
		

		
	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	    Thread.sleep(2000);
	  // String toastmsg =  driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
	   // Assert.assertEquals(toastmsg,"Please enter your name");
	    Thread.sleep(2000);
	    
	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
	   // driver.findElement(By.xpath("android.widget.TextView[@text='Jordan 6 Rings']"));
        int proCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        Thread.sleep(3000);
        
        for(int i=0; i<proCount;i++) {
        	String proName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
        	
        	if(proName.equals("Jordan 6 Rings")) {
        		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
        	}
        }
        
        Thread.sleep(3000);
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
        
      String CartElement =  driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
      Thread.sleep(3000);
      Assert.assertEquals(CartElement, "Jordan 6 Rings");
      
		
	}

}
