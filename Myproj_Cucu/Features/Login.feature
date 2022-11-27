Feature: Login
Scenario: Successful login through Valid Credentials

Given User launch Chrome Browser
When User Navigates to "https://admin-demo.nopcommerce.com/" 
And User enters Email as "admin@yourstore.com" and Password as "admin"
And Click Login-Btn
Then Page Title Should be "Dashboard / nopCommerce administration"
When user Click LogOut-Btn
Then Page Title Should be "Your store. Login"
And Close the Browser

Scenario Outline: login through Multiple Credentials

		Given User launch Chrome Browser
		When User Navigates to "https://admin-demo.nopcommerce.com/" 
		And User enters Email as "<email>" and Password as "<password>"
		And Click Login-Btn
		Then Page Title Should be "Dashboard / nopCommerce administration"
		When user Click LogOut-Btn
		Then Page Title Should be "Your store. Login"
		And Close the Browser
		Examples:
		|email | password|
		|admin@yourstore.com | admin|
		|admin@yourstore.com | admin123|


