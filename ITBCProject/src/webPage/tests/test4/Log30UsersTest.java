package webPage.tests.test4;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.DataSetExcel;
import utility.ExcelUtils;
import webPage.objects.HomePage;
import webPage.objects.signIn.LogUser;
import webPage.objects.signIn.SignInPage;
import webPage.tests.BaseClass;

public class Log30UsersTest extends BaseClass {

	String xlFile = DataSetExcel.FILE_NAME;
	String sheet = DataSetExcel.SHEET_NAME_2;
	String account_xpath = "//a[@class='account']";
	

	@BeforeClass // opening xlsx file
	public void setXL() {
		HomePage.openHomePage(wd);
		ExcelUtils.setExcel(xlFile, sheet);
	}

	@AfterClass // closing xlsx file
	public void closeXL() {
		ExcelUtils.closeExcel();
	}

	@Test(priority = 0) // testing if method for sending keys to email field works
	public void inputEmailTest() {
		HomePage.openHomePage(wd);
		SignInPage.open(wd);
		wait(3000);
		String email = LogUser.inputEmail(wd, ExcelUtils.getCellData(1, 1));
		Assert.assertEquals(email, "lmarchand0@arstechnica.com");
	}
	
	@Test(priority = 1) // testing if method for sending keys to password field works
	public void inputPasswordTest() {
		String pass = LogUser.inputPassword(wd, ExcelUtils.getCellData(1, 2));
		Assert.assertEquals(pass, "0MBtNpH");
	}
	
	@Test(priority = 2) // testing if method for clicking on sign in button works (expected - successful login)
	public void signInTest() {
		LogUser.signIn(wd);
		wait(3000);
		Assert.assertTrue(wd.findElement(By.xpath(account_xpath)).isDisplayed()); 
		// if login is successful account button appears
		
	}
	
	@Test(priority = 3) // testing if method for clicking on sign out button works 
	public void signOutTest() {
		LogUser.signOut(wd);
		boolean found;
		  try {
		  wd.findElement(By.xpath(account_xpath)).isDisplayed();
		  found = true;
		  
		  } catch (NoSuchElementException e) {
		  found = false;
		  }
		  // account button disappears (cannot find element)
		  Assert.assertFalse(found);
	}
	
	@Test(priority = 4) // test for remaining 29 logs from xlsx file 
	public void logIn29UsersTest() {
		
		SoftAssert sa = new SoftAssert();
		
		// for loop for 29 remaining users 
		// i goes from 2, as we have already tested the first row (user) 
		for (int i = 2; i<ExcelUtils.getRowCount(sheet); i++) {
			LogUser.inputEmail(wd, ExcelUtils.getCellData(i, 1));
			LogUser.inputPassword(wd, ExcelUtils.getCellData(i, 2));
			LogUser.signIn(wd);
			wait(3000);
			sa.assertTrue(wd.findElement(By.xpath(account_xpath)).isDisplayed());
			LogUser.signOut(wd);
		}
		
		wait(2000);
		sa.assertAll();
	}


}
