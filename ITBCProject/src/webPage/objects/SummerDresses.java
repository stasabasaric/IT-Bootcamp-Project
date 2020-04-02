package webPage.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SummerDresses {
	
	public static final String PAGE_URL = "http://automationpractice.com/index.php?id_category=11&controller=category";
	
	private static final String WOMEN_TAB = "WOMEN"; // one can find the Women tab element by link locator
	private static final String WOMEN_SD_XPATH ="//ul[@class='submenu-container clearfix first-in-line-xs']"
			+ "//ul//li//a[contains(text(),'Summer Dresses')]"; // Rel xpath for summer dresses shown in WOMEN tab
	
	private static final String DRESSES_TAB = "DRESSES"; // one can find the Dress tab element by link locator
	private static final String DRESSES_SD_XPATH = "//body[@id='index']/div[@id='page']/div[@class='header-container']"
			+ "/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul"
			+ "[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/ul[@class='submenu-container clearfix first-in-line-xs']"
			+ "/li[3]/a[1]"; // Rel xpath for summer dresses shown in DRESSES tab
	
	
	//Method for getting to Summer Dresses page via WOMEN Tab
	public static String viaWomenTab(WebDriver wd) {
		Actions hover = new Actions(wd);
		WebElement dress = wd.findElement(By.linkText(WOMEN_TAB));
		hover.moveToElement(dress).perform();
		hover.moveToElement(wd.findElement(By.xpath(WOMEN_SD_XPATH))).click().build().perform();
		
		return wd.getCurrentUrl();
	}
	
	//Method for getting to Summer Dresses page via DRESSES Tab
	public static String viaDressesTab(WebDriver wd) {
		Actions hover = new Actions(wd);
		WebElement dress = wd.findElement(By.linkText(DRESSES_TAB));
		hover.moveToElement(dress).perform();
		hover.moveToElement(wd.findElement(By.xpath(DRESSES_SD_XPATH))).click().build().perform();
		
		return wd.getCurrentUrl();
		
	}
	

	
	
}
