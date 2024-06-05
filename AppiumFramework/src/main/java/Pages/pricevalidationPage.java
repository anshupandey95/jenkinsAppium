package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class pricevalidationPage extends AndroidActions {
	
AndroidDriver driver;
	
	public pricevalidationPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

		
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productList;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement longPre; ;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
	public WebElement webdriverWaitElement; 
	
	
	public List<WebElement> getProductList() {
		return productList;
	}
	
	
	public double getProductSum() {
		
		//WebdriverwaitWithElementTextName(webdriverWaitElement, "Cart");
		int count = productList.size();
double Totalsum = 0;
        
        for(int i =0; i<count; i++) {
	   
        String FirstAmount = productList.get(0).getText();
       Double price =  Double.parseDouble(FirstAmount.substring(1));
       Totalsum = Totalsum + price;
	}
        return Totalsum;
	
	
	
	}
	
	public double gettotalAmountDisplayed() {
		return formattedamount(totalAmount.getText());
		 
		
	}
	

}
