package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class productCatalogue extends AndroidActions {

	AndroidDriver driver;

	public productCatalogue(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addtoCart;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartButton;;
	
	
	
	

	public void additemByIndex(int index) {
		//addtoCart.get(index).click();
	normallClick(addtoCart.get(index), "addedItemByIndex");

	}
	
	public pricevalidationPage gotoCart() {
		cartButton.click();
		return new pricevalidationPage(driver);
		
	}
}
