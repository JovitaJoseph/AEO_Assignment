package jovita.ae.driverChrome;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AEChromeDriverSetup {

public WebDriver d;
static Properties p;
	public AEChromeDriverSetup() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\ChromeDriver\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.84 Safari/537.36";
		options.addArguments(String.format("user-agent=%s", userAgent));
		d=new ChromeDriver(options);
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	public  WebDriver getDriver(String urlString) {
	//	System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\ChromeDriver\\chromedriver.exe");
	
		//to avoid BOT detection

//		ChromeOptions options = new ChromeOptions();
//		String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.84 Safari/537.36";
//		options.addArguments(String.format("user-agent=%s", userAgent));
//		d=new ChromeDriver(options);
//		d.manage().window().maximize();
//		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		d.get(urlString);
	//	d.get("https://www.ae.com/us/en/p/men/shoes/sneakers/ae-classic-running-sneaker/0214_7300_106?menu=cat4840004");
		//d.get("https://www.ae.com/us/en/p/men/athletic-fit-jeans/athletic-fit-jeans/ae-airflex-athletic-fit-jean/0118_5307_001?menu=cat4840004");
		return d;		
	}
	
	
	
}
