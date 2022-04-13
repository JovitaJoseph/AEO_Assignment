package stepDefinition1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jovita.ae.driverChrome.AEChromeDriverSetup;
import useCaseBDD.Checkout;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PDPCheckoutStepDefinition {

	public WebDriver driver;
	AEChromeDriverSetup driverSetup;
	Properties p;



	@And ("User lands on PDP")
	public String landingToPDP() {
		final String pdpURL ="https://www.ae.com/us/en/p/men/skinny-jeans/skinny-jeans/ae-airflex-360-patched-skinny-jean/0119_6026_048?menu=cat4840004";
		return pdpURL;
	}

	@When ("User selects the color")
	public void color() throws Exception {
		Checkout pdp=new Checkout(driver);
		Properties getProp= Checkout.getConfigProperty();
		Thread.sleep(5000);
		pdp.select_color(driver, getProp);
		Thread.sleep(3000);
	}

	@And ("User selects the size")
	public void size() throws Exception {
		Checkout pdp=new Checkout(driver);
		Properties getProp= Checkout.getConfigProperty();
		pdp.selectSize(driver, getProp);
		Thread.sleep(2000);
	}

	@And ("User selects the quantity")
	public void noOfItems() throws Exception {
		Checkout pdp=new Checkout(driver);
		Properties getProp= Checkout.getConfigProperty();
		pdp.quantity(driver, getProp);
		Thread.sleep(2000);
	}

	@Then ("User should be able to add to bag successfully")
	public void addBag() throws Exception {
		Checkout pdp=new Checkout(driver);
		Properties getProp= Checkout.getConfigProperty();
		pdp.AddToBag(driver, getProp);
		Thread.sleep(2000);
	//	System.out.println("Product added to bag successfully"); 
	}
	
	
/*
	@Given ("user is in AddedToBag page")
	public void addedToBagSlider() {
		Checkout pdp=new Checkout(driver);
		Properties getProp= Checkout.getConfigProperty();
		pdp.getHeaderAddedToBagWindow(driver, getProp);
		String ExpHeader=driver.findElement(By.xpath("//h2[@class='modal-title']")).getText();
		System.out.println(ExpHeader);
		String ActualHeader="Added To Bag:";
		Assert.assertEquals(ActualHeader, ExpHeader);
		System.out.println("User landed in Added to Bag window");

	}

*/
	
	@Given ("User clicks View bag in AddedToBag page")
	public void viewBag() throws Exception {
		//Checkout pdp=new Checkout(driver);
		Checkout pdp=new Checkout(driverSetup);
		Properties getProp= Checkout.getConfigProperty();
		Thread.sleep(4000);
		pdp.ViewBag(driver, getProp);
		Thread.sleep(2000);
	}

	@And ("User clicks Proceed to Checkout from shopping bag page")
	public void proceedCheckout() throws Exception {
		Checkout pdp=new Checkout(driver);
		Properties getProp= Checkout.getConfigProperty();
		pdp.ProceedToCheckout(driver, getProp);
		Thread.sleep(2000);
	}

	@Then ("User is taken to Checkout page successfully") 
	public void checkoutPage() {
		System.out.println("User is taken to checkout page successfully");
	}


	@Given("User opens the browser")
	public WebDriver openBrowser() throws Exception {
		Properties p;

		PDPCheckoutStepDefinition bag1=new PDPCheckoutStepDefinition();
		String URL=	bag1.landingToPDP();
		AEChromeDriverSetup driverSetup= new AEChromeDriverSetup();
	//	return driver=AEChromeDriverSetup.getDriver(URL);
		driver=driverSetup.getDriver(URL);
		return driver;

	}



//	@After
//	public void afterTest() {
//		driver.close();
//	}

}






