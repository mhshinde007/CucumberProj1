package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer {

	
	@FindBy (xpath ="//input[@id='Email']") private WebElement email;
	@FindBy (xpath ="//input[@id='Password']") private WebElement password;
	@FindBy (xpath ="//input[@id='FirstName']") private WebElement fName;
	@FindBy (xpath ="//input[@id='LastName']") private WebElement lName;
	@FindBy (xpath ="//input[@id='Gender_Male']") private WebElement gender_Male;
	@FindBy (xpath ="//input[@id='Gender_Female']") private WebElement gender_Female;
	@FindBy (xpath ="//input[@id='DateOfBirth']") private WebElement dateOfBirth;
	@FindBy (xpath ="//input[@id='Company']") private WebElement companyName;
	@FindBy (xpath ="//input[@id='IsTaxExempt']") private WebElement taxExempt;
	@FindBy (xpath ="//div[@class='input-group-append']//div[@class='k-multiselect-wrap k-floatwrap']") private WebElement newsletter;
	@FindBy (xpath ="//ul[@id='SelectedNewsletterSubscriptionStoreIds_listbox']//li") private List<WebElement> newsletterOpions;
	
	@FindBy (xpath ="//div[contains(@class,'input-group-required')]//div[@class='k-multiselect-wrap k-floatwrap']") private WebElement customerRoles;
	@FindBy (xpath ="//ul[@id='SelectedCustomerRoleIds_listbox']//li") private List<WebElement> customerRolesOpions;
	
	@FindBy (xpath ="//select[@id='VendorId']") private WebElement managerOfVendor_drpdown;
	
	@FindBy (xpath ="//input[@id='Active']") private WebElement active_Status_chkbox;
	@FindBy (xpath ="//textarea[@id='AdminComment']") private WebElement admin_Comment;
	@FindBy (xpath ="//button[@name='save']") private WebElement save_btn;
	

	//Constructor
	public AddCustomer (WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Action Methods
	
	public void setEmail(String emailID) 
	{
		email.sendKeys(emailID);
	}
	
	public void setpassword(String pswd) 
	{
		password.sendKeys(pswd);
	}
	
	public void setFirstname(String firstName) 
	{
		fName.sendKeys(firstName);
	}
	
	public void setLastname(String lastName) 
	{
		lName.sendKeys(lastName);
	}
	
	public void setGender(String gen) 
	{
		if(gen.equals("male")) 
		{
			gender_Male.click();
		}else 
		{
			gender_Female.click();
		}
	}
	
	public void setDOB(String dob) 
	{
		dateOfBirth.sendKeys(dob);
	}
	
	public void setCompanyName(String cmpName) 
	{
		companyName.sendKeys(cmpName);
	}
	
	public void setIsTaxExempt() 
	{
		taxExempt.click();
	}
	
	public void setNewsLetter(String newsName) 
	{
		
		newsletter.click();
		
		for (WebElement op:newsletterOpions) 
		{
			if (op.getText().contains(newsName))
			{
				op.click();
				break;
			}	
		}
		

	}
	public void setCustomerRole(String cusRole) 
	{
		
		customerRoles.click();
		
		for (WebElement cusop:customerRolesOpions) 
		{
			if (cusop.getText().contains(cusRole))
			{
				cusop.click();
				break;
			}	
		}
		
	}
	
	public void setManagerOfVendor(String vendorName) 
	{
		Select list = new Select(managerOfVendor_drpdown);
		
		List<WebElement> listOfVendors = list.getOptions();
		
		for (WebElement vendor:listOfVendors) 
		{
			if (vendor.getText().contains(vendorName))
			{
				vendor.click();
				break;
			}	
		}
		
	}
	
	public void setActiveStatus () 
	{
		active_Status_chkbox.click();
	}
	
	public void adminComments(String comments) 
	{
		admin_Comment.sendKeys(comments);
	}
	
	public void saveCustomer() 
	{
		save_btn.click();
	}
	
	
	
}