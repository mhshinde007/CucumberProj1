package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	
	
	//WebElements
	@FindBy (xpath = "//input[@id='Email']") private WebElement email;
	@FindBy (xpath = "//input[@id='Password']") private WebElement password;
	@FindBy (xpath = "//button[text()='Log in']") private WebElement login_Button;
	
	//Constructor
	public LoginPage (WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	
	//Action Methods will copy from step defn file
	
	
	public void enterEmail(String emailID) 
	{
		email.clear();
		email.sendKeys(emailID);
	}
	
	public void enterPasword(String pswd) 
	{
		password.clear();
		password.sendKeys(pswd);
	}
	
	public void login() 
	{
		login_Button.click();
	}
	
}
