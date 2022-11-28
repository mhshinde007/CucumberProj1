package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {
	
	@FindBy (xpath ="//input[@id='SearchEmail']") private WebElement emailSearch;
	@FindBy (xpath ="//input[@id='SearchFirstName']") private WebElement firstName;
	@FindBy (xpath = "//button[@id='search-customers']") private WebElement SearchBtn;
	@FindBy (xpath = "//table[@id='customers-grid']") private WebElement customer_Table;
	@FindBy (xpath ="//table[@id='customers-grid']//tr") private List<WebElement> tableRows;
	@FindBy (xpath = "//table[@id='customers-grid']//tr//td") private List<WebElement> tableColumns;

	//Constructor
	public CustomersPage (WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Action Methods
	
	public void enterEmail(String emailid) 
	{
		emailSearch.sendKeys(emailid);
	}
	
	public void enterFirstname(String fname) 
	{
		firstName.sendKeys(fname);
	}
	
	public void search() 
	{
		SearchBtn.click();
	
	}
	
	
	
	public  boolean searchStatus(String emailToSearch) 
	{
		boolean flag = false;
		for (int i= 1; i<=tableRows.size() ; i++ )
		{
			String cellvalue = customer_Table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			if (emailToSearch.equals(cellvalue)) 
			{
				flag= true;
			}
		}
		return flag;
	}
}
