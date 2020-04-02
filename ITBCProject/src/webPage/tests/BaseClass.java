package webPage.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	// Base class for passing the WebDriver between testNG classes
	public static WebDriver wd;

	@BeforeTest
	public static void initDriver() {
		System.setProperty("web.driver.chromedriver", "chromedriver.exe");
		wd = new ChromeDriver();
	}

	@AfterTest
	public static void closeDriver() {
		wd.close();
	}
	
	  public static void wait(int milisec) {
			try {
				Thread.sleep(milisec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	  
}