package stepDefinition;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import useCaseBDD.Checkout;

public class ProceedToCheckoutStepDefinition {

	public WebDriver driver;
	Properties getProp;
//	public ProceedToCheckoutStepDefinition(String s,WebDriver driver){
//		
//		this.driver=driver;
//		System.out.println("C DRIVER :"+driver);
//	}
		
	@Given ("user is in AddedToBag page")
	public WebDriver addedToBagSlider() throws Exception {
		System.out.println("-------------------addToBagSlier");
//		if(driver==null) {
//			 driver=new ChromeDriver();
//			
//		}
		Checkout pdp=new Checkout(driver);
		Properties getProp= pdp.getConfigProperty();
	//	pdp.getHeaderAddedToBagWindow(driver, getProp);
//		String ExpHeader=driver.findElement(By.xpath("//h2[@class='modal-title']")).getText();
//		System.out.println(ExpHeader);
//		String ActualHeader="Added To Bag:";
//		Assert.assertEquals(ActualHeader, Expected);
		System.out.println("User landed on Added to Bag window");
		return driver;

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
	
	
}
