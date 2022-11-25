@Login
Feature: Login Test
  Description: Login to the amazon account with valid credentials
  
  Background: 
  	* we opened amazon site
  	
  	Scenario:
  		* we are on HomePage
  		When we click on signInLink
  		Then we are on LoginPage
  		And the title should be "Amazon Sign In"
  		And we wait for 5 seconds
			Then we enter "kulkarni.pranav022@gmail.com" into the EmailTextBox element
			And we click on ContinueBtn
			Then we enter "Pck@1998" into the PasswordTextBox element
			And we click on SignInBtn
			And we wait for 5 seconds
			