package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	
	//WebElements
		@FindBy (xpath= "//a[text()='Logout']") private WebElement logout_Button;
		@FindBy (xpath= "//a[@href='#']//p[contains(text(), 'Customers')]") private WebElement CustomerMenu;
		@FindBy (xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(), 'Customers')]") private WebElement CustomerOption;
		@FindBy (xpath ="//a[@class='btn btn-primary']") private WebElement AddNewbtn;
		
		//Constructor
		public HomePage (WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}

		
		//Action Methods will copy from step defn file
		public void logout() 
		{
	      logout_Button.click();
		}
		
		public void clickCustomerMenu() 
		{
			CustomerMenu.click();
		}
		
		public void clickCustomerOption() 
		{
			CustomerOption.click();
		}
		
		public void AddNewCustomer() 
		{
			AddNewbtn.click();
		}
}
