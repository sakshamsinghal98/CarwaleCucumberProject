Feature: Search New Car
In order to search a new car
As a User
I have to navigate to Carwale.com

	Scenario Outline: Finding new Cars
		Given User navigates to carwale
		When User hovers over the new cars
		And User clicks on FindNewCars
		Then User clicks on "<carBrandName>" car
		Then User validates the car title as "<carBrandName>" cars
	Examples:

		| carBrandName |
		| Toyota	   |
		| Kia          |
		| BMW          |
		| Hyundai      |