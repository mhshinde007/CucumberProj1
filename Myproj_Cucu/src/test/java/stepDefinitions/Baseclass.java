package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomer;
import pageObjects.CustomersPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class Baseclass {

	public WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	AddCustomer addCustomerpage;
	CustomersPage customerPage;
	
	public static String randomString() 
	{
		String genratedString= RandomStringUtils.randomAlphabetic(5);
		return genratedString;
	}
}
