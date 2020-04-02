package webPage.objects;

import org.openqa.selenium.WebDriver;

public class HomePage {

	public static final String HOME_URL = "http://automationpractice.com/index.php";

	
	//Method for getting to the page which is tested in this project
	public static void openHomePage(WebDriver wd) {
		wd.get(HOME_URL);
	}

	//Method to navigate to Home Page if another page is opened 
	public static void navigateToHomePage(WebDriver wd) {
		wd.navigate().to(HOME_URL);
	}
}
