package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.AddCustomer;
import pageObjects.CustomersPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;


public class Steps extends Baseclass{


	@Given("User launch Chrome Browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "./Drivers\\\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		addCustomerpage = new AddCustomer(driver);
		customerPage = new CustomersPage(driver);
		
	}

	@When("User Navigates to {string}")
	public void user_navigates_to(String url) {
		driver.get(url);
	   
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) {
	   loginPage.enterEmail(email);
	   loginPage.enterPasword(pwd);
	   
	}

	@When("Click Login-Btn")
	public void click_login_btn() {
		loginPage.login();
	}

	@Then("Page Title Should be {string}")
	public void page_title_should_be(String title) {
	   if(driver.getPageSource().contains("Login was unsuccessful")) 
	   {
		   driver.close();
		   Assert.assertTrue(false);
	   }else 
	   {
		   Assert.assertEquals(title, driver.getTitle());
	   }
	}

	@When("user Click LogOut-Btn")
	public void user_click_log_out_btn() throws InterruptedException {
	    homePage.logout();
	    Thread.sleep(3000);
	}

	@Then("Close the Browser")
	public void close_the_browser() {
	  driver.quit();
	}
	
	
	//Add Customer Feature Steps
	
	@When("User Clicks on Customers Menu")
	public void user_clicks_on_customers_menu() throws InterruptedException {
	    homePage.clickCustomerMenu();
	    Thread.sleep(1000);
	    
	}

	@When("User clicks on Customers Icon")
	public void user_clicks_on_customers_icon() {
	    homePage.clickCustomerOption();
	}

	@When("User Clicks on Add-btn")
	public void user_clicks_on_add_btn() throws InterruptedException {
	    homePage.AddNewCustomer();
	    Thread.sleep(1000);
	}

	@Then("Add Customer Page Opens")
	public void add_customer_page_opens() throws InterruptedException {
	    String customerTitle=driver.getTitle();
	    Assert.assertEquals("Add a new customer / nopCommerce administration",customerTitle);
	    Thread.sleep(1000);
	}

	@When("user Enters all required Fields")
	public void user_enters_all_required_fields() throws InterruptedException  {
		String randomemail = randomString() + "@gmail.com";
		String randompwd = randomString() + "@1234";
		
	    addCustomerpage.setEmail(randomemail);
	    addCustomerpage.setpassword(randompwd);
	    addCustomerpage.setFirstname("Mayur");
	    addCustomerpage.setLastname("kalashnikawo");
	    Thread.sleep(5000);
	    addCustomerpage.setGender("male");
	    addCustomerpage.setDOB("11/20/1994");
	    addCustomerpage.setCompanyName("QAtech");
	    addCustomerpage.setIsTaxExempt();
	    addCustomerpage.setNewsLetter("Your");
	    Thread.sleep(5000);
	    addCustomerpage.setCustomerRole("Admin");
	    Thread.sleep(5000);
	    addCustomerpage.setManagerOfVendor("Vendor 2");
	    Thread.sleep(2000);
	    addCustomerpage.setActiveStatus();
	    Thread.sleep(2000);
	    addCustomerpage.adminComments("User Generated");
	    
	}

	@When("click on Save Btn")
	public void click_on_save_btn() throws InterruptedException {
		
		addCustomerpage.saveCustomer();
	    Thread.sleep(2000);
	}

	@Then("user can see message {string}")
	public void user_can_see_message(String msgAsSaved) {
	    Assert.assertTrue(driver.getPageSource().contains("The new customer has been added successfully."));
	}
	
	
	// Search by Email ID
	
	@Then("Customer Page Opens")
	public void customer_page_opens() throws InterruptedException {
		String customerPageTitle=driver.getTitle();
	    Assert.assertEquals("Customers / nopCommerce administration",customerPageTitle);
	    Thread.sleep(1000); 
	}
	
	@When("user Enters Email as {string}")
	public void user_enters_email_as(String em) {
		customerPage.enterEmail(em);
	}

	@When("click on Search Btn")
	public void click_on_search_btn() throws InterruptedException {
	   customerPage.search();
	   Thread.sleep(30000);
	}
	
	@Then("User having searched email shall be displayed")
	public void user_having_searched_email_shall_be_displayed() {
	    boolean searchResult = customerPage.searchStatus("victoria_victoria@nopCommerce.com");
	    Assert.assertTrue(searchResult);
	}
}
