package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jovita.ae.driverChrome.AEChromeDriverSetup;
import useCaseBDD.Checkout;

import java.util.Properties;

import org.openqa.selenium.WebDriver;


public class AddToBagStepDefinition {

	public WebDriver driver;
	Properties p;



	@And ("User lands on PDP")
	public String landingToPDP() {
		final String pdpURL ="https://www.ae.com/us/en/p/men/skinny-jeans/skinny-jeans/ae-airflex-360-patched-skinny-jean/0119_6026_048?menu=cat4840004";
		return pdpURL;
	}

	@When ("User selects the color")
	public void color() throws Exception {
		Checkout pdp=new Checkout(driver);
		Properties getProp= pdp.getConfigProperty();
		Thread.sleep(5000);
		pdp.select_color(driver, getProp);
		Thread.sleep(3000);
	}

	@And ("User selects the size")
	public void size() throws Exception {
		Checkout pdp=new Checkout(driver);
		Properties getProp= pdp.getConfigProperty();
		pdp.selectSize(driver, getProp);
		Thread.sleep(2000);
	}

	@And ("User selects the quantity")
	public void noOfItems() throws Exception {
		Checkout pdp=new Checkout(driver);
		Properties getProp= pdp.getConfigProperty();
		pdp.quantity(driver, getProp);
		Thread.sleep(2000);
	}

	@Then ("User should be able to add to bag successfully")
	public ProceedToCheckoutStepDefinition addBag() throws Exception {
		Checkout pdp=new Checkout(driver);
		Properties getProp= pdp.getConfigProperty();
		pdp.AddToBag(driver, getProp);
		Thread.sleep(2000);
		System.out.println("Product added to bag successfully"); 
		return new ProceedToCheckoutStepDefinition(null,driver);
	//	return null;
	}
	
	/*

	@Given ("user is in AddedToBag page")
	public void addedToBagSlider() {
		Checkout pdp=new Checkout(driver);
		Properties getProp= pdp.getConfigProperty();
		pdp.getHeaderAddedToBagWindow(driver, getProp);
//		String ExpHeader=driver.findElement(By.xpath("//h2[@class='modal-title']")).getText();
//		System.out.println(ExpHeader);
//		String ActualHeader="Added To Bag:";
//		Assert.assertEquals(ActualHeader, Expected);
		System.out.println("User landed in Added to Bag window");

	}

	@When ("User clicks ViewBag, user is taken to shopping bag page")
	public void viewBag() throws Exception {
		Checkout pdp=new Checkout(driver);
		Properties getProp= pdp.getConfigProperty();
		Thread.sleep(4000);
		pdp.ViewBag(driver, getProp);
		Thread.sleep(2000);
	}

	@And ("User clicks Proceed to Checkout")
	public void proceedCheckout() throws Exception {
		Checkout pdp=new Checkout(driver);
		Properties getProp= pdp.getConfigProperty();
		pdp.ProceedToCheckout(driver, getProp);
		Thread.sleep(2000);
	}

	@Then ("User is taken to Checkout page successfully") 
	public void checkoutPage() {
		System.out.println("User is taken to checkout page successfully");
	}

*/
	@Given("User opens the browser")
	public WebDriver openBrowser() throws Exception {
		Properties p;

		AddToBagStepDefinition bag=new AddToBagStepDefinition();
		String URL=	bag.landingToPDP();
		return driver=new AEChromeDriverSetup().getDriver(URL);

	}



//	@After
//	public void afterTest() {
//		driver.close();
//	}

}

