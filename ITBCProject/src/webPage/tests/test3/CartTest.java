package webPage.tests.test3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import webPage.objects.HomePage;
import webPage.objects.SummerDresses;
import webPage.objects.cart.AddToCart;
import webPage.objects.cart.ShoppingCart;
import webPage.tests.BaseClass;

public class CartTest extends BaseClass {

	AddToCart dress;

	// Test1 - testing if constructor is selecting the expected item (first dress shown in page Summer Dresses)
	final String dressPage_URL = "http://automationpractice.com/index.php?id_product=5&controller=product";  // URL for the selected dress

	// Test2 - testing method for selecting quantity, size and color for the selected dress
	final String quantity_id = "quantity_wanted"; // id for quantity field
	final String size_xpath = "//option[contains(text(),'M')]"; // xpath for size M
	final String selected_color_xpath = "//li[@class='selected']//a"; // xpath for selected color

	// Test3 - testing if method btnAddToCart adds the specified item/dress to shopping cart
	final String rows_xpath = "//tbody//tr"; // xpath for rows in table body
	final String prName_xpath = "//td[@class='cart_description']//p[@class='product-name']//a"; // xpath for product name in table body (tb)
	final String prSizeAndColor_xpath = "//td[@class='cart_description']//a[contains(text(),'Color : ')]"; // xpath for product size and color in tb
	final String prQuantity_xpath = "//td[@class='cart_quantity text-center']//input[@size='2']"; // xpath for quanitity field in tb
																									


	@BeforeClass
	public void openSummerDresses() {
		HomePage.openHomePage(wd);
		SummerDresses.viaDressesTab(wd);
	}

	@Test(priority = 0) // Test1
	public void Constructor() {
		dress = new AddToCart(wd, 0);
		// select 0 - first dress shown in Summer Dresses page
		Assert.assertEquals(dress.getURL(wd), dressPage_URL);
	}

	@Test(priority = 1) // Test2
	public void SelectQSCTest() {

		wait(3000);
		dress.selectQSC(wd, "2", "M", "Blue");
		// choose: quantity = 2; size = M; color = Blue

		wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		SoftAssert sa = new SoftAssert();

		String quant = wd.findElement(By.id(quantity_id)).getAttribute("value");
		sa.assertEquals(quant, dress.getQuant());

		boolean size = wd.findElement(By.xpath(size_xpath)).isSelected();
		sa.assertTrue(size);

		String color = wd.findElement(By.xpath(selected_color_xpath)).getAttribute("name");
		sa.assertEquals(color, dress.getColor());

		sa.assertAll();

	}

	@Test(priority = 2) // Test3
	public void btnAddToCartTest() {

		dress.btnAddToCart(wd, "close");
		ShoppingCart.openSummary(wd);

		wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// list of rows in table body
		int i = 0;
		List<WebElement> rows = wd.findElements(By.xpath(rows_xpath));
		String prName = rows.get(i).findElement(By.xpath(prName_xpath)).getText();
		String prSizeColor = rows.get(i).findElement(By.xpath(prSizeAndColor_xpath)).getText();
		String prQuantity = rows.get(i).findElement(By.xpath(prQuantity_xpath)).getAttribute("value");

		SoftAssert sa = new SoftAssert();

		// checking if the dress selected exists and matches the dress in cart (by:
		// name, color, size and quantity)
		sa.assertEquals(prName, "Printed Summer Dress");
		sa.assertTrue(prSizeColor.contains(dress.getColor()));
		sa.assertTrue(prSizeColor.contains(dress.getSize()));
		sa.assertEquals(prQuantity, dress.getQuant());

		sa.assertAll();

	}

	// Test4 - testing if method checkout - cheks out from shopping cart, and proceeds on sign in page
	@Test(priority = 3) 
	public void checkoutTest() {
		ShoppingCart.checkout(wd);
		wait(3000);
		boolean secStep = wd.findElement(By.xpath("//li[@class='step_current second']")).isDisplayed();
		Assert.assertTrue(secStep);
	}


}
