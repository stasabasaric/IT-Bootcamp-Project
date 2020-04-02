package webPage.objects.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AddToCart extends ShoppingCart {

	// fields for objects that one wants to add to cart
	private String quant;
	private String size;
	private String color;
	
	// index of items shown in page
	public int item;

	private final String items_class = "product_img_link"; // class for available dresses shown in summer dresses page
	private final String addToCart_xpath = "//button[@name='Submit']"; // xpath for button - Add To Cart

	//CONSTRUCTOR
	// one can choose an item thorugh constructor by sending the index of item shown in page
	// e.g. for summer dresses, 3 types of dresses are shown on the, so indexes go from 0 to 2
	public AddToCart(WebDriver wd, int item) {
		this.item = item;
		wait(2000);
		wd.findElements(By.className(items_class)).get(item).click();

	}
	
	// united method from ShoppingCart select methods - quantity, size and color
	// it also sets fields for AddToCart object
	public void selectQSC(WebDriver wd, String quant, String size, String color) {
		quantity(wd, quant);
		size(wd, size);
		color(wd, color);
		
		this.quant=quant;
		this.size=size;
		this.color=color;
	}
	

	// method that adds the product to cart, by clicking the button a window opens
	// with following options - continue shopping or proceed to payment
	// default closes the window clicking on cross sign
	public void btnAddToCart(WebDriver wd, String option) {

		wd.findElement(By.xpath(addToCart_xpath)).click();

		wait(3000);

		Actions action = new Actions(wd);

		switch (option) {
		case "continue":
			action.moveToElement(
					wd.findElement(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']")));
			action.click().perform();
			break;

		case "proceed":
			action.moveToElement(wd.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")));
			action.click().perform();
			break;
		default:
			action.moveToElement(wd.findElement(By.xpath("//span[@class='cross']")));
			action.click().perform();

		}

	}

	public String getQuant() {
		return quant;
	}

	public String getSize() {
		return size;
	}

	public String getColor() {
		return color;
	}

	public String getURL(WebDriver wd) {
		return wd.getCurrentUrl();
	}

}
