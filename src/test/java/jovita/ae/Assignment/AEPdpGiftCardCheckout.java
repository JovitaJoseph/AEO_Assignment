package jovita.ae.Assignment;


import org.testng.annotations.Test;

import jovita.ae.checkout.CheckoutFlow;
import jovita.ae.driverChrome.AEChromeDriverSetup;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class AEPdpGiftCardCheckout {
	
// Scenario: Selecting a product from PDP and trying to place order 
//with 4111 gift card.As this is not a real gift card number, it throws 
//error message. We check whether the expected error message is same 
//as the actual one.
	
	WebDriver driver;
	Properties p;
	public final String pdpURL ="https://www.ae.com/us/en/p/men/skinny-jeans/skinny-jeans/ae-airflex-360-patched-skinny-jean/0119_6026_048?menu=cat4840004";

	@Test (priority=1)
	public void color() throws Exception {
		CheckoutFlow pdp=new CheckoutFlow(driver);
		Thread.sleep(4000);
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
	public void GiftCardInfo() throws Exception {
		CheckoutFlow pdp=new CheckoutFlow(driver);
		pdp.GiftCard(driver, getProp());
		Thread.sleep(2000);
	}

	@Test (priority=10,dependsOnMethods= {"GiftCardInfo"})
	public void ErrorMessage() throws Exception {
		CheckoutFlow pdp=new CheckoutFlow(driver);
		Thread.sleep(2000);
		String message =pdp.getErrorMessage(driver, getProp());

		//Thread.sleep(2000);

		assertEquals("THERE'S A PROBLEM WITH YOUR ORDER",message);
	}

	@BeforeClass
	public void beforeTest() {
		driver=AEChromeDriverSetup.getDriver(pdpURL);

	}

	@Test
	public Properties getProp() throws Exception {
		CheckoutFlow pdp=new CheckoutFlow(driver);

		return pdp.getConfigProperty();
	}


	@AfterClass
	public void afterTest() {
		driver.close();
	}

}





