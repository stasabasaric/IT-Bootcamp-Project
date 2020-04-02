package webPage.tests.test2;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webPage.objects.HomePage;
import webPage.objects.signIn.SignInPage;
import webPage.objects.signIn.registration.RegForm;
import webPage.tests.BaseClass;

public class RegFormTest extends BaseClass {

	JavascriptExecutor js;

	@BeforeClass
	public void openHomePage() {
		js = (JavascriptExecutor) wd;
		HomePage.openHomePage(wd);

	}

	@BeforeMethod
	public void waitM() {
		wait(4000);
	}
	
	// Following test are testing all methods from RegForm class that are used for filling out fields in reg form
	
	@Test(priority = 0)
	public void getSignInPageTest() {
		String actURL = SignInPage.open(wd);
		String expURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		Assert.assertEquals(actURL, expURL);

	}

	@Test(priority = 1)
	public void createAccTest() {
		js.executeScript("window.scrollBy(0,350)", "");
		String actURL = SignInPage.createAccount(wd, "stasa95@www.com");
		String expURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
		Assert.assertEquals(actURL, expURL);
	}

	@Test(priority = 2)
	public void firstNameTest() {
		String fname = RegForm.firstName(wd, "Stasa");
		Assert.assertEquals(fname, "Stasa");

	}

	@Test(priority = 3)
	public void lastNameTest() {
		String lname = RegForm.lastName(wd, "Basaric");
		Assert.assertEquals(lname, "Basaric");
	}

	@Test(priority = 4)
	public void passwordTest() {
		String pass = RegForm.Password(wd, "stasa123");
		Assert.assertEquals(pass, "stasa123");
	}

	@Test(priority = 5)
	public void addressTest() {
		String address = RegForm.Address(wd, "21th Ave");
		Assert.assertEquals(address, "21th Ave");
	}

	@Test(priority = 6)
	public void cityTest() {
		String city = RegForm.City(wd, "Hawi");
		Assert.assertEquals(city, "Hawi");
	}
	
	@Test(priority = 7) 
	public void stateTest() {
		String state = RegForm.State(wd, "Hawaii");
		Assert.assertEquals(state, "Hawaii");
	}
	
	@Test(priority = 8) 
	public void countryTest() {
		String country = RegForm.Country(wd, "United States");
		Assert.assertEquals(country, "United States");
	}
	@Test(priority = 9)
	public void postcodeTest() {
		String zip = RegForm.Postcode(wd, "22000");
		Assert.assertEquals(zip, "22000");
	}

	@Test(priority = 10)
	public void mobileTest() {
		String mob = RegForm.mobilePhone(wd, "06211411");
		Assert.assertEquals(mob, "06211411");
	}

	@Test(priority = 11)
	public void aliasAddressTest() {
		String alias = RegForm.aliasAddress(wd, "9th Ave");
		Assert.assertEquals(alias, "9th Ave");
	}

	
}
