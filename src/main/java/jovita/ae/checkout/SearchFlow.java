package jovita.ae.checkout;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import jovita.ae.driverChrome.AEChromeDriverSetup;

public class SearchFlow {

	static WebDriver driver;
	public static final String searchURL ="https://www.ae.com/us/en/";

//	static Properties p;

	public SearchFlow(WebDriver driver) {
		this.driver=driver;
	}


	public static WebDriver getDriver() {
		WebDriver driver;
		driver=AEChromeDriverSetup.getDriver(searchURL);
		return driver;
	}

	public static Properties getConfigProperty() {
		try{
			Properties props = new Properties();
			props.load(new FileInputStream("src/main/resources/AEConfig.properties"));
			return props;
		}catch(Exception e) {e.printStackTrace();return null;}
	}


	public static WebDriver search(WebDriver driver,Properties p) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(p.getProperty("SearchIcon"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(p.getProperty("SearchTextBox"))).sendKeys(p.getProperty("SearchKeyword"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(p.getProperty("AutoSuggestionClick1"))).click();
		Thread.sleep(2000);
		return driver;
	}


	public static WebDriver selectProduct(WebDriver driver,Properties p) throws Exception {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)","");
		Thread.sleep(4000);
		driver.findElement(By.xpath(p.getProperty("Product"))).click();
		Thread.sleep(3000);

		return driver;
	}


	public static void main(String[] args) throws Exception {
		WebDriver driver=getDriver();
		Properties configProp=getConfigProperty();

		Thread.sleep(2000);
		search(driver,configProp);
		selectProduct(driver,configProp);

		CheckoutFlow checkout=new CheckoutFlow(driver);
		checkout.select_color(driver,configProp);
		Thread.sleep(2000);
		checkout.selectSize(driver,configProp);
		Thread.sleep(2000);
		checkout.quantity(driver,configProp);
		Thread.sleep(2000);
		checkout.AddToBag(driver, configProp);
		Thread.sleep(2000);
		checkout.ViewBag(driver, configProp);
		Thread.sleep(2000);
		checkout.ProceedToCheckout(driver, configProp);
		checkout.PersonalInformation(driver, configProp);
		checkout.AutoCompletionSelect(driver, configProp);
		checkout.PaymentInfo(driver, configProp);

	}

}
