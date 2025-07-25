@excelexport
Feature: Click on any car brand and export the name and price in an excel sheet

	Scenario Outline:User will click on a car Brand name and then will export the name and price in an excel sheet
	Given User navigates to carwale
	When User hovers over the new cars
	And User clicks on FindNewCars
	When User clicks on "<carBrandName>" car
	Then User validates the car title as "<carBrandName>" cars
	And User will export the names and prices of all the cars for that brand 
	
	Examples:
		| carBrandName |
		| Toyota	   |
	