package webPage.objects.signIn.registration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterUser extends RegForm {
	// object fields for mandatory fields in reg form
	private String fname;
	private String lname;
	private String pass;
	private String address;
	private String city;
	private String state;
	private String country;
	private String zip;
	private String mobile;
	private String aliasAdd;
	
	private final String submit_xpath = "//button[@id='submitAccount']"; // button xpath for sumbiting reg form
	private final String logOut_class = "logout"; // logout button class
	
	
	//CONSTRUCTOR 
	public RegisterUser(String fname, String lname, String pass, String address, String city, String state, String country,
			String zip, String mobile, String aliasAdd) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.pass = pass;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.mobile = mobile;
		this.aliasAdd = aliasAdd;
	}
	
	
	// method that fills out reg form by parameters set by constructor
	public void completeRegForm(WebDriver wd) {
		
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		firstName(wd, fname);
		lastName(wd, lname);
		Password(wd, pass);
		Address(wd, address);
		City(wd, city);
		State(wd, state);
		Country(wd, country);
		Postcode(wd, zip);
		mobilePhone(wd, mobile);
		aliasAddress(wd, aliasAdd);
	}
	
	//method for submitting the reg form - registering user
	public void submit(WebDriver wd) {
	wd.findElement(By.xpath(submit_xpath)).click();
	}
	
	
	// method for signing out
	public void signOut(WebDriver wd) {
		wd.findElement(By.className(logOut_class)).click();
	}
	
	
}
