package webPage.tests.test3;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import webPage.objects.HomePage;
import webPage.objects.signIn.SignInPage;
import webPage.objects.signIn.registration.RegisterUser;
import webPage.tests.BaseClass;

public class RegisterUserTest extends BaseClass {
	
	String account_xpath = "//a[@class='account']"; // xpath for account info button
	RegisterUser user;
	

  @Test (priority = 0) // Testing if methods from class RegisterUser are successful in registering
  public void RegUser() {
	  JavascriptExecutor js = (JavascriptExecutor) wd;
      js.executeScript("window.scrollBy(0,350)", "");
	  wait(2000);
	  SignInPage.createAccount(wd, "stasa95@stasa21.com");
	  user = new RegisterUser("Stasa", "Basaric", "stasa123", "Stasa 22", "Volcano", "Hawaii", "United States", "21000", "06212113", "Stasa 26");
	  
	  user.completeRegForm(wd);
	  wait(2000);
	  user.submit(wd);
	  wait(2000);
	  boolean success = wd.findElement(By.xpath(account_xpath)).isDisplayed(); // if account button appears registration is successful
	  
	  Assert.assertTrue(success);
	  
  }
  
  @Test (priority = 1) // Testing if method for singing out works
  public void signOutTest() {
	  
	  user.signOut(wd);
	  boolean found;
	  try {
	  wd.findElement(By.xpath(account_xpath)).isDisplayed();
	  found = true;
	  
	  } catch (NoSuchElementException e) {
	  found = false;
	  }
	  
	  Assert.assertFalse(found); // if account button cannout be found - signing out is successful
	  
  }
  
  
  @BeforeClass
  public void openSignInPage() {
	  if(wd.getCurrentUrl().equals("data:,"))
	  HomePage.openHomePage(wd);
	  SignInPage.open(wd);
  }

}
