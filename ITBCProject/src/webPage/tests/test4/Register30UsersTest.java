package webPage.tests.test4;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.DataSetExcel;
import utility.ExcelUtils;
import webPage.objects.HomePage;
import webPage.objects.signIn.SignInPage;
import webPage.objects.signIn.registration.RegisterUser;
import webPage.tests.BaseClass;

public class Register30UsersTest extends BaseClass {

	String xlFile = DataSetExcel.FILE_NAME;
	String sheet = DataSetExcel.SHEET_NAME_1;
	String account_xpath = "//a[@class='account']";

	@BeforeClass
	public void openHomePage() {
		HomePage.openHomePage(wd);
		ExcelUtils.setExcel(xlFile, sheet); // open xlsx file
	}

	@AfterClass
	public void closeXL() { //close xlsx file
		ExcelUtils.closeExcel();
	}

	@Test
	public void Reg30UsersTest() {

		SoftAssert sa = new SoftAssert();
		
		wait(2000);
		SignInPage.open(wd);
		
		// for loop - for registering 30 users
		for (int i = 1; i < ExcelUtils.getRowCount(sheet); i++) {
			
			wait(2000);
			
			// gets mail data from i row and first column
			SignInPage.createAccount(wd, ExcelUtils.getCellData(i, 1));
			
			// creating an array for storing remaining cells data in row i
			String[] data = new String[ExcelUtils.getColCount(i) - 3];
			
			// for loop  for loading the String array with remaining cells data in row i
			for (int j = 0, c = 2; j < data.length && c < ExcelUtils.getColCount(i); j++, c++) {
				data[j] = ExcelUtils.getCellData(i, c);

			}
			
			// generating the constructor with data loaded in string array
			int j = 0;
			RegisterUser user = new RegisterUser(data[j], data[++j], data[++j], data[++j], data[++j], data[++j],
					data[++j], data[++j], data[++j], data[++j]);
			
			
			user.completeRegForm(wd); //filling out reg form fields with data from constructor
			
			wait(2000);
			user.submit(wd); // submitting registration form

			wait(3000);
			sa.assertTrue(wd.findElement(By.xpath(account_xpath)).isDisplayed()); // Reg successful (account button appears)

			user.signOut(wd);

		}

		sa.assertAll();

	}



}
