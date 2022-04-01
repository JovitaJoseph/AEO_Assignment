package jovita.ae.Assignment;

import org.testng.annotations.Test;

import jovita.ae.checkout.CheckoutFlow;
import jovita.ae.checkout.SearchFlow;
import jovita.ae.driverChrome.AEChromeDriverSetup;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class AESearchGiftCardCheckout {
	
	// Scenario: Search for a product from home page search Textbox and trying to
	//place order with 4111 gift card as a guest user. As this is not a real 
	//gift card number, it throws error message. We check whether the expected
	//error message is same as the actual one.
	
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
		 Thread.sleep(2000);
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
	  public void giftCardInfo() throws Exception {
		CheckoutFlow cf=new CheckoutFlow(driver);
		 cf.GiftCard(driver, getProp());
		 Thread.sleep(2000);
	}
	
	@Test (priority=12,dependsOnMethods= {"giftCardInfo"})
	public void ErrorMessage() throws Exception {
		CheckoutFlow cf=new CheckoutFlow(driver);
		Thread.sleep(2000);
		String message =cf.getErrorMessage(driver, getProp());
		assertEquals("THERE'S A PROBLEM WITH YOUR ORDER",message);
	}
	
	@Test
	  public Properties getProp() {
		  SearchFlow sf=new SearchFlow(driver);
		 return sf.getConfigProperty();
	  }
	
   @BeforeTest
  public void openBrowser() {
	  driver=AEChromeDriverSetup.getDriver(searchURL);
  }

  @AfterTest
  public void closeBrowser() {
	  driver.quit();
  }

}
