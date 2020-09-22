Feature: Test Blaze Demo
	
@Sanity 
Scenario: Check user able to book flight
  Given user is in home screen of blaze demo 
	And user selects departure city and destination city and find flights
	Then user is navigated to flights list screen
	
