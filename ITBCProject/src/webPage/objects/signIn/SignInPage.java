package webPage.objects.signIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

	public static final String SIGN_IN_CLASS = "login"; // class for Sign In button
	private static final String REG_EMAIL_ID = "email_create"; // registration email id for creating account
	private static final String CREATE_ACC_BTN_ID = "SubmitCreate"; // button id for submitting account creation

	// Method for getting to Registration page
	public static String open(WebDriver wd) {
		wd.findElement(By.className(SIGN_IN_CLASS)).click();
		return wd.getCurrentUrl();

	}

	// Method input for creating account on Authentication/Sign in page
	public static String createAccount(WebDriver wd, String email) {
		wd.findElement(By.id(REG_EMAIL_ID)).sendKeys(email);
		wd.findElement(By.id(CREATE_ACC_BTN_ID)).click();

		wait(5000);

		return wd.getCurrentUrl();
	}

	private static void wait(int milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
