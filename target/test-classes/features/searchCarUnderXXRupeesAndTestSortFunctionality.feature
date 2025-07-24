Feature: Search car under Best category Sort it and verify sorting is working fine or not

Scenario Outline: Searching cars Applying sorting and verifing the sorting
Given User navigates to carwale
And User clicks and enters the text " Best Cars Under 10 lakh" in the search box
And User clicks on the searched criteria
When User clicks on Sort dropdown and select sort using "Price - High to Low" 
Then User will be able to sort the cars and verify the sorted cars based on the criteria

