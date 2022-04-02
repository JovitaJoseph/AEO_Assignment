package jovita.ae.Assignment;

import org.testng.annotations.Test;

import jovita.ae.checkout.CheckoutFlow;
import jovita.ae.checkout.SearchFlow;
import jovita.ae.driverChrome.AEChromeDriverSetup;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class AESearchCCardCheckout {
	//Scenario: Search for a product from homepage search textbox and trying to place order 
	//with 411 test credit card. Able to place test order successfully from our side
	// although the order can't go through as it goes to fraud. 
	// We check whether the expected order confirmation message is same 
	//as the actual one.
	
	WebDriver driver;
	Properties p;
	public final String searchURL ="https://www.ae.com/us/en";
	
	
	@Test (priority=1)
	  public void locateSearch() throws Exception {
		  SearchFlow sf=new SearchFlow(driver);
		 sf.search(driver, getProp());
	  }
	

	@Test (priority=2,dependsOnMethods= {"locateSearch"})
	  public void locateProduct() throws Exception {
		  SearchFlow sf=new SearchFlow(driver);
		 sf.selectProduct(driver, getProp());
	  }
	

	@Test (priority=3,dependsOnMethods= {"locateProduct"})
	  public void selectColor() throws Exception {
		  CheckoutFlow cf=new CheckoutFlow(driver);
		 cf.select_color(driver, getProp());
		 Thread.sleep(2000);
	  }
	

	@Test (priority=4,dependsOnMethods= {"selectColor"})
	  public void selectSize() throws Exception {
		CheckoutFlow cf=new CheckoutFlow(driver);
		 cf.selectSize(driver, getProp());
		 Thread.sleep(2000);
	}
	
	
	@Test (priority=5,dependsOnMethods= {"selectSize"})
	  public void selectQuantity() throws Exception {
		CheckoutFlow cf=new CheckoutFlow(driver);
		 cf.quantity(driver, getProp());
	}
	
	@Test (priority=6,dependsOnMethods= {"selectQuantity"})
	  public void clickAddToBag() throws Exception {
		CheckoutFlow cf=new CheckoutFlow(driver);
		 cf.AddToBag(driver, getProp());
		 Thread.sleep(2000);
	}
	
	@Test (priority=7,dependsOnMethods= {"clickAddToBag"})
	  public void clickViewBag() throws Exception {
		CheckoutFlow cf=new CheckoutFlow(driver);
		Thread.sleep(2000);
		 cf.ViewBag(driver, getProp());
	}
	
	@Test (priority=8,dependsOnMethods= {"clickViewBag"})
	  public void proceedToCheckout() throws Exception {
		CheckoutFlow cf=new CheckoutFlow(driver);
		Thread.sleep(2000);
		 cf.ProceedToCheckout(driver, getProp());
	}
	
	
	@Test (priority=9,dependsOnMethods= {"proceedToCheckout"})
	  public void personalInfo() throws Exception {
		CheckoutFlow cf=new CheckoutFlow(driver);
		 cf.PersonalInformation(driver, getProp());
	}
	
	@Test (priority=10,dependsOnMethods= {"personalInfo"})
	  public void addressInfo() throws Exception {
		CheckoutFlow cf=new CheckoutFlow(driver);
		 cf.AutoCompletionSelect(driver, getProp());
	}
	
	@Test (priority=11,dependsOnMethods= {"addressInfo"})
	  public void creditCardDetails() throws Exception {
		CheckoutFlow cf=new CheckoutFlow(driver);
		 cf.PaymentInfo(driver, getProp());
	}
	
	@Test (priority=12,dependsOnMethods= {"creditCardDetails"})
	  public void clickPlaceOrder() throws Exception {
		CheckoutFlow cf=new CheckoutFlow(driver);
		 cf.PlaceOrder(driver, getProp());
	}
	
	@Test (priority=13,dependsOnMethods= {"clickPlaceOrder"})
	  public void orderConfirmationMessage() throws Exception {
		CheckoutFlow cf=new CheckoutFlow(driver);
	    String orderConfMessage=cf.OrderConfirmation(driver, getProp());
	    assertEquals("Thanks for your order!",orderConfMessage);
	  Thread.sleep(2000);
	}
	
  @Test
  public Properties getProp() {
	  SearchFlow sf=new SearchFlow(driver);
	 return sf.getConfigProperty();
  }
  
  @BeforeClass
  public void openBrowser() {
	  driver=AEChromeDriverSetup.getDriver(searchURL);
  }

  @AfterClass
  public void closeBrowser() {
	  driver.close();
  }

}
