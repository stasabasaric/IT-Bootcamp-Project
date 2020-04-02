package webPage.objects.cart;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCart {


	private static final String QUANTITY_NAME = "qty"; // id for quantity field
	private static final String SIZE_ID = "group_1"; // id for size selection
	private static final String COLORS_CLASS = "color_pick"; // Class for colors

	private static final String CART_XPATH = "//body[@id='product']/div[@id='page']/div[@class='header-container']"
			+ "/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@class='col-sm-4 clearfix']"
			+ "/div[@class='shopping_cart']/a[1]"; // xpath for opening Shopping Cart page

	// method for quantity input
	public static void quantity(WebDriver wd, String quant) {
		WebElement elem = wd.findElement(By.name(QUANTITY_NAME));
		elem.clear();
		elem.sendKeys(quant);
	}

	// method for selecting size
	public static void size(WebDriver wd, String size) {
		Select dropSize = new Select(wd.findElement(By.id(SIZE_ID)));
		dropSize.selectByVisibleText(size);

	}

	// method for selecting color
	public static void color(WebDriver wd, String color) {
		List<WebElement> colors = wd.findElements(By.className(COLORS_CLASS));
		for (int i = 0; i < colors.size(); i++) {
			if (colors.get(i).getAttribute("name").contains(color)) {
				colors.get(i).click();
			}
		}
	}

	public static String openSummary(WebDriver wd) {
		wd.findElement(By.xpath(CART_XPATH)).click();

		return wd.getCurrentUrl();
	}

	public static String checkout(WebDriver wd) {
		try {
		wd.findElement(By.linkText("Proceed to checkout")).click();
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Cart is empty");
			return "emptycart";
		}

		return wd.getCurrentUrl();
	}

	public static void wait(int miliseconds) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
