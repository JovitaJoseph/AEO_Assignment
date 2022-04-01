package jovita.ae.checkout;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import jovita.ae.driverChrome.AEChromeDriverSetup;

public class CheckoutFlow {

	static WebDriver driver;
	//static Properties p;
	public static final String path="src\\main\\resources\\ExcelFile\\BillingInfoAE.xlsx";
	public final static String pdpURL ="https://www.ae.com/us/en/p/men/skinny-jeans/skinny-jeans/ae-airflex-360-patched-skinny-jean/0119_6026_048?menu=cat4840004";


	public CheckoutFlow(WebDriver driver) {
		this.driver=driver;
//		this.p =getConfigProperty();
	}


	public static Properties getConfigProperty() {
		try{
			Properties props = new Properties();
			props.load(new FileInputStream("src/main/resources/AEConfig.properties"));
			return props;
		}catch(Exception e) {e.printStackTrace();return null;}
	}


	public static WebDriver getDriver() {
		WebDriver driver;
		driver=AEChromeDriverSetup.getDriver(pdpURL);
		return driver;
	}


	public  WebDriver select_color(WebDriver driver,Properties p) throws Exception {
		driver.findElement(By.xpath(p.getProperty("Color"))).click();
		Thread.sleep(2000);

		//to scroll the page down
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,550)","");
		return driver;
	}



	public  WebDriver selectSize(WebDriver driver,Properties p) throws Exception {
		WebElement dropdown=driver.findElement(By.xpath(p.getProperty("SizeDropdown1")));
		dropdown.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(p.getProperty("ClickSize"))).click();

		return driver;


	}

	public  WebDriver quantity(WebDriver driver,Properties p) {
		driver.findElement(By.xpath(p.getProperty("Quantity"))).click();

		return driver;
	}

	public  WebDriver AddToBag(WebDriver driver,Properties p) {
		driver.findElement(By.xpath(p.getProperty("AddToBagButton"))).click();
		return driver;

	}

	public  WebDriver ViewBag(WebDriver driver,Properties p) {
		driver.findElement(By.xpath(p.getProperty("ViewBagButton"))).click();
		return driver;
	}

	public  WebDriver ProceedToCheckout(WebDriver driver,Properties p) throws Exception {

		//Scroll page to see the proceed to checkout button
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)","");
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("ProceedToCheckoutButton"))).click();
		Thread.sleep(2000);

		return driver;
	}

	public  WebDriver PersonalInformation(WebDriver driver,Properties p) throws Exception {
		//Scroll page to see the proceed to checkout button
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)","");
		Thread.sleep(3000);

		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);

		List<WebElement> Loc_Element = new ArrayList();

		Loc_Element.add(driver.findElement(By.xpath(p.getProperty("EmailTextBox"))));
		Loc_Element.add(driver.findElement(By.xpath(p.getProperty("FirstNameTextBox"))));
		Loc_Element.add(driver.findElement(By.xpath(p.getProperty("LastNameTextBox"))));
		Loc_Element.add(driver.findElement(By.name(p.getProperty("StreetAddressTextBox"))));

		List<String> strdata=new ArrayList();

		int RowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();

		for(int i=1;i<=RowCount;i++) {
			int CellCount=sheet.getRow(i).getLastCellNum();
			for(int j=0;j<CellCount;j++) {

				strdata.add(sheet.getRow(i).getCell(j).getStringCellValue());
				Loc_Element.get(j).sendKeys(strdata.get(j));

			}
		}
		Thread.sleep(2000);
		return driver;

	}


	public  WebDriver AutoCompletionSelect(WebDriver driver,Properties p) throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath(p.getProperty("AutoComplete"))).click();

		return driver;

	}


	public  WebDriver GiftCard(WebDriver driver,Properties p) throws Exception {
		Thread.sleep(2000);
		//to scroll the page down
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,850)","");
		Thread.sleep(2000);
		driver.findElement(By.name(p.getProperty("RedeemGC"))).click();

		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(2);

		List<WebElement> Loc_GiftCard = new ArrayList();
		List<String> cardDetails=new ArrayList();

		Loc_GiftCard.add(driver.findElement(By.name(p.getProperty("GiftCardNumber"))));
		Loc_GiftCard.add(driver.findElement(By.name(p.getProperty("Pin"))));

		int RowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();

		for(int i=0;i<=RowCount;i++) {
			int CellCount=sheet.getRow(i).getLastCellNum();
			for(int j=0;j<CellCount;j++) {
				//	System.out.println(sheet.getRow(i).getCell(j).getCellType());
				switch(sheet.getRow(i).getCell(j).getCellType()) {
				case STRING:
					cardDetails.add(sheet.getRow(i).getCell(j).getStringCellValue());
					Loc_GiftCard.get(j).sendKeys(cardDetails.get(j));
					break;
				case NUMERIC:
					cardDetails.add(sheet.getRow(i).getCell(j).getNumericCellValue()+"");
					//  System.out.println(cardDetails);
					Loc_GiftCard.get(j).sendKeys(cardDetails.get(j));
					break;
				}
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.name(p.getProperty("ApplyButton"))).click();
		Thread.sleep(2000);
		return driver;

	}

	public  String getErrorMessage(WebDriver driver,Properties p) throws Exception {
		Thread.sleep(2000);
		WebElement errorMessage=driver.findElement(By.xpath(p.getProperty("ErrorMessage")));
		String headerMessage=errorMessage.getText();
		System.out.println(headerMessage);
		return headerMessage;
		//return driver;
	}


	public  WebDriver PaymentInfo(WebDriver driver,Properties p) throws Exception {
		Thread.sleep(1000);
		//to scroll the page down
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,950)","");

		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(1);

		List<WebElement> Loc_CCard = new ArrayList();
		List<String> data=new ArrayList();

		Loc_CCard.add(driver.findElement(By.name(p.getProperty("CreditCardNo"))));
		Loc_CCard.add(driver.findElement(By.name(p.getProperty("ExpDate"))));
		Loc_CCard.add(driver.findElement(By.name(p.getProperty("CVV"))));
		Loc_CCard.add(driver.findElement(By.name(p.getProperty("Phone"))));

		int RowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();

		for(int i=0;i<=RowCount;i++) {
			int CellCount=sheet.getRow(i).getLastCellNum();
			for(int j=0;j<CellCount;j++) {
				//System.out.println(sheet.getRow(i).getCell(j).getCellType());
				switch(sheet.getRow(i).getCell(j).getCellType()) {
				case STRING:
					data.add(sheet.getRow(i).getCell(j).getStringCellValue());
					Loc_CCard.get(j).sendKeys(data.get(j));
					break;
				case NUMERIC:
					data.add(sheet.getRow(i).getCell(j).getNumericCellValue()+"");
					//System.out.println(data);
					Loc_CCard.get(j).sendKeys(data.get(j));
					break;
				}
			}
		}
		return driver;

	}


	public  WebDriver PlaceOrder(WebDriver driver,Properties p) throws Exception {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,850)","");
		driver.findElement(By.name(p.getProperty("PlaceOrderButton"))).click();

		Thread.sleep(2000);
		System.out.println("Order placed successfully");
		return driver;

	}


	public  String OrderConfirmation(WebDriver driver,Properties p) throws Exception {

		Thread.sleep(2000);
		WebElement OrderConfirmMessage=driver.findElement(By.xpath(p.getProperty("OrderConfirmationMessage")));
		String OrderConf=OrderConfirmMessage.getText();
		System.out.println(OrderConf);
		return OrderConf;

	}


	public static void main(String[] args) throws Exception {

		WebDriver driver=getDriver();
		Properties p=getConfigProperty();
		CheckoutFlow cFlow=new CheckoutFlow(driver);

		Thread.sleep(4000);
		cFlow.select_color(driver,p);
		Thread.sleep(4000);
		//	select_size(driver,p);
		cFlow.selectSize(driver,p);
		Thread.sleep(3000);
		cFlow.quantity(driver,p);
		Thread.sleep(3000);
		cFlow.AddToBag(driver,p);
		Thread.sleep(3000);
		cFlow.ViewBag(driver,p);
		cFlow.ProceedToCheckout(driver,p);
		cFlow.PersonalInformation(driver,p);
		cFlow.AutoCompletionSelect(driver,p);
		Thread.sleep(2000);
		cFlow.GiftCard(driver,p);
		Thread.sleep(2000);
		cFlow.getErrorMessage(driver,p);
		//	PaymentInfo(driver,p);
		//	PlaceOrder(driver,p);
		//	driver.close();


	}

}
