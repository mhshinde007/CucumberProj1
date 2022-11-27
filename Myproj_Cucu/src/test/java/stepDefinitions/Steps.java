package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;


public class Steps {

	public WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@Given("User launch Chrome Browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "./Drivers\\\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
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
	
}
