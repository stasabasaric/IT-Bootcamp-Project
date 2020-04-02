package webPage.objects.signIn.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegForm {
	

	// mandatory fields in Reg form

	// personal info
	private static final String F_NAME_CSS = "input#customer_firstname";
	private static final String L_NAME_CSS = "input#customer_lastname";
	private static final String PASS_CSS = "input#passwd";

	// adress
	
	//private static final String AF_NAME_ID = "firstname"; 
	//private static final String AL_NAME_ID = "lastname";
	// first two fields in adress part (firstname and lastname)
	//are already automatically filled out when typing in fname and lname in personal info they will not be used 
	private static final String ADDRESS_ID = "address1";
	private static final String CITY_ID = "city";
	private static final String STATE_ID = "id_state";
	private static final String COUNTRY_ID = "id_country";
	private static final String POSTCODE_ID = "postcode";
	private static final String MOBILE_ID = "phone_mobile";
	private static final String ALIAS_ADDRESS_ID = "alias";
	
	private static WebElement elem;
	
	

	
	//Methods inputs for text fields
	public static String firstName(WebDriver wd, String keys) {
		elem = findCSS(wd, F_NAME_CSS);
		elem.sendKeys(keys);
		return elem.getAttribute("value");
	}
	
	public static String lastName(WebDriver wd, String keys) {
		elem = findCSS(wd, L_NAME_CSS);
		elem.sendKeys(keys);
		return elem.getAttribute("value");
	}
	
	public static String Password(WebDriver wd, String keys) {
		elem = findCSS(wd, PASS_CSS);
		elem.sendKeys(keys);
		return elem.getAttribute("value");
	}
	
	public static String Address(WebDriver wd, String keys) {
		elem = findID(wd, ADDRESS_ID);
		elem.sendKeys(keys);
		return elem.getAttribute("value");
	}
	
	public static String City(WebDriver wd, String keys) {
		elem = findID(wd, CITY_ID);
		elem.sendKeys(keys);
		return elem.getAttribute("value");
	}
	
	public static String Postcode(WebDriver wd, String keys) {
		elem = findID(wd, POSTCODE_ID);
		elem.sendKeys(keys);
		return elem.getAttribute("value");
	}
	
	public static String mobilePhone(WebDriver wd, String keys) {
		elem = findID(wd, MOBILE_ID);
		elem.sendKeys(keys);
		return elem.getAttribute("value");
	}
	
	public static String aliasAddress(WebDriver wd, String keys) {
		elem = findID(wd, ALIAS_ADDRESS_ID);
		elem.clear();
		elem.sendKeys(keys);
		return elem.getAttribute("value");
	}
	
	//Select methods 
	public static String State(WebDriver wd, String state) {
		Select dropState = new Select(findID(wd,STATE_ID));
		dropState.selectByVisibleText(state);
		return dropState.getFirstSelectedOption().getText();
	}
	
	public static String Country(WebDriver wd, String country) {
		Select dropState = new Select(findID(wd,COUNTRY_ID));
		dropState.selectByVisibleText(country);
		return dropState.getFirstSelectedOption().getText();
	}
	
	
	// Methods for finding elements (by ID and CSS)
	private static WebElement findID(WebDriver wd, String id) {
		return wd.findElement(By.id(id));
	}
	private static WebElement findCSS(WebDriver wd, String css) {
		return wd.findElement(By.cssSelector(css));
	}
	
	
	}


