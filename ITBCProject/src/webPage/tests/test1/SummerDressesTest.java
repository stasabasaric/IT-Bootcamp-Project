package webPage.tests.test1;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import webPage.objects.HomePage;
import webPage.objects.SummerDresses;
import webPage.tests.BaseClass;

public class SummerDressesTest extends BaseClass {

	@BeforeClass
	public void openHomePage() {
		if (wd.getCurrentUrl().equals("data:,"))
			HomePage.openHomePage(wd);
	}

	@Test // Testing method in SummerDresses class, if one can get to SummerDresses page
			// via WOMEN Tab
	public void viaWomenTabTest() {

		String actURL = SummerDresses.viaWomenTab(wd);
		String expURL = SummerDresses.PAGE_URL;

		Assert.assertEquals(actURL, expURL);

	}

	@Test // Testing method in SummerDresses class, if one can get to SummerDresses page
			// via DRESSES Tab

	public void viaDressTabTest() {

		HomePage.navigateToHomePage(wd);
		String actURL = SummerDresses.viaDressesTab(wd);
		String expURL = SummerDresses.PAGE_URL;

		Assert.assertEquals(actURL, expURL);

	}

	@Test // Testing if final URLs of both methods tested above match
	public void matchingURLs() {

		HomePage.navigateToHomePage(wd);
		String wURL = SummerDresses.viaWomenTab(wd);
		HomePage.navigateToHomePage(wd);
		String dURL = SummerDresses.viaDressesTab(wd);

		Assert.assertEquals(wURL, dURL);

	}
}
