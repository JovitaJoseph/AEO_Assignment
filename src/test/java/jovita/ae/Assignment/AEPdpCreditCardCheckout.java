package jovita.ae.Assignment;

import org.testng.annotations.Test;

import jovita.ae.checkout.CheckoutFlow;
import jovita.ae.driverChrome.AEChromeDriverSetup;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

//Scenario: Selecting a product from PDP and trying to place order 
//with 411 test credit card. Able to place test order successfully from our side
// although the order can't go through as it goes to fraud. 
// We check whether the expected order confirmation message is same 
//as the actual one.

public class AEPdpCreditCardCheckout {
	
	WebDriver driver;
	Properties p;
	public final String pdpURL ="https://www.ae.com/us/en/p/men/skinny-jeans/skinny-jeans/ae-airflex-360-patched-skinny-jean/0119_6026_048?menu=cat4840004";
	
  @Test (priority=1)
  public void color() throws Exception {
	  CheckoutFlow pdp=new CheckoutFlow(driver);
	  Thread.sleep(5000);
	 pdp.select_color(driver, getProp());
	  Thread.sleep(3000);
  }
  
  @Test (priority=2,dependsOnMethods= {"color"})
  public void size() throws Exception {
	  CheckoutFlow pdp=new CheckoutFlow(driver);
	  pdp.selectSize(driver, getProp());
	  Thread.sleep(2000);
  }
  
  @Test (priority=3,dependsOnMethods= {"size"})
  public void noOfItems() throws Exception {
	  CheckoutFlow pdp=new CheckoutFlow(driver);
	  pdp.quantity(driver, getProp());
	  Thread.sleep(2000);
  }
  
  @Test (priority=4,dependsOnMethods= {"noOfItems"})
  public void addBag() throws Exception {
	  CheckoutFlow pdp=new CheckoutFlow(driver);
	  pdp.AddToBag(driver, getProp());
	  Thread.sleep(2000);
	    }
    
  @Test (priority=5,dependsOnMethods= {"addBag"})
  public void viewBag() throws Exception {
	  CheckoutFlow pdp=new CheckoutFlow(driver);
	  Thread.sleep(4000);
	  pdp.ViewBag(driver, getProp());
	  Thread.sleep(2000);
  }
  
  @Test (priority=6,dependsOnMethods= {"viewBag"})
  public void proceedCheckout() throws Exception {
	  CheckoutFlow pdp=new CheckoutFlow(driver);
	  pdp.ProceedToCheckout(driver, getProp());
	  Thread.sleep(2000);
  }
  
  @Test (priority=7,dependsOnMethods= {"proceedCheckout"})
  public void shippingInfo() throws Exception {
	  CheckoutFlow pdp=new CheckoutFlow(driver);
	  pdp.PersonalInformation(driver, getProp());
	  Thread.sleep(2000);
  }
  
  @Test (priority=8,dependsOnMethods= {"shippingInfo"})
  public void address() throws Exception {
	  CheckoutFlow pdp=new CheckoutFlow(driver);
	  pdp.AutoCompletionSelect(driver, getProp());
	  Thread.sleep(2000);
  }
  
  @Test (priority=9,dependsOnMethods= {"address"})
  public void CardInfo() throws Exception {
	  CheckoutFlow pdp=new CheckoutFlow(driver);
	  pdp.PaymentInfo(driver, getProp());
	  Thread.sleep(2000);
  }
  
  @Test (priority=10,dependsOnMethods= {"CardInfo"})
  public void placeOrder() throws Exception {
	  CheckoutFlow pdp=new CheckoutFlow(driver);
	   pdp.PlaceOrder(driver, getProp());
	  Thread.sleep(2000);
  }
  
  @Test (priority=11,dependsOnMethods= {"placeOrder"})
  public void OrderConfirmationTest() throws Exception {
	  CheckoutFlow pdp=new CheckoutFlow(driver);
	 String headerMessage= pdp.OrderConfirmation(driver,getProp());
	 assertEquals("Thanks for your order!",headerMessage);
	  Thread.sleep(2000);
  }
  
  
  @BeforeTest
  public void beforeTest() throws Exception {
	  Properties p;
		p=getProp();
	  driver=AEChromeDriverSetup.getDriver(pdpURL);
	  	  
  }
  
  @Test
    public Properties getProp() throws Exception {
	  CheckoutFlow pdp=new CheckoutFlow(driver);
	   
	   return pdp.getConfigProperty();
	  }
  

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
