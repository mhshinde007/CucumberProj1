package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	
	//WebElements
		@FindBy (xpath= "//a[text()='Logout']") private WebElement logout_Button;
		
		
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
}
