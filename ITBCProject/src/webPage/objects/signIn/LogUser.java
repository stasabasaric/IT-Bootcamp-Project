package webPage.objects.signIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogUser {
	
	
	private static final String LOG_EMAIL_ID = "email"; // id for email field on sign in page
	private static final String LOG_PASS_ID = "passwd";  // id for password field on sign in page
	private static final String SIGN_IN_BTN_ID = "SubmitLogin"; // sign in button 
	private static final String LOGOUT_CLASS = "logout"; // logout button 
	
	
	// method for sending mail address to email field 
	public static String inputEmail(WebDriver wd, String email) {
		WebElement elem = wd.findElement(By.id(LOG_EMAIL_ID));
		elem.sendKeys(email);
		return elem.getAttribute("value");
	}
	
	// method for sending password to password field 
	public static String inputPassword(WebDriver wd, String pass) {
		WebElement elem = wd.findElement(By.id(LOG_PASS_ID));
		elem.sendKeys(pass);
		return elem.getAttribute("value");
	}
	
	// method for clicking on sign in button
	public static void signIn(WebDriver wd) {
		wd.findElement(By.id(SIGN_IN_BTN_ID)).click();
	}
	
	// method for clicking on sign out button
	public static void signOut(WebDriver wd) {
		wd.findElement(By.className(LOGOUT_CLASS)).click();
	}
}
