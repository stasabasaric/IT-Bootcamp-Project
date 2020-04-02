package webPage.tests.test1;

import org.testng.Assert;
import org.testng.annotations.Test;

import webPage.objects.HomePage;
import webPage.tests.BaseClass;

public class HomePageTest extends BaseClass {

	
	@Test(priority = 0) // Testing if method opens the correct page
	public void openHPTest() {

		HomePage.openHomePage(wd);
		Assert.assertEquals(wd.getCurrentUrl(), "http://automationpractice.com/index.php");

	}

	@Test (priority = 1) // Testing if method navigates from another page to the wanted page
	public void navigateToHPTest() {
		wd.navigate().to("https://google.com");
		HomePage.navigateToHomePage(wd);
		Assert.assertEquals(wd.getCurrentUrl(), "http://automationpractice.com/index.php");
	}
}
