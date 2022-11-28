Feature: Customer

@Test1
Scenario: Verify user is able to add Customer
	Given User launch Chrome Browser
	When User Navigates to "https://admin-demo.nopcommerce.com/" 
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click Login-Btn
	Then Page Title Should be "Dashboard / nopCommerce administration"
	When User Clicks on Customers Menu
	And User clicks on Customers Icon
	And User Clicks on Add-btn
	Then Add Customer Page Opens
	When user Enters all required Fields
	And click on Save Btn
	Then user can see message "The new customer has been added successfully."
	And Close the Browser

@Test2	
Scenario: Search Customer by EmailID
	Given User launch Chrome Browser
	When User Navigates to "https://admin-demo.nopcommerce.com/" 
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click Login-Btn
	Then Page Title Should be "Dashboard / nopCommerce administration"
	When User Clicks on Customers Menu
	And User clicks on Customers Icon
	Then Customer Page Opens
	When user Enters Email as "victoria_victoria@nopCommerce.com"
	And click on Search Btn
	Then User having searched email shall be displayed
	And Close the Browser