Feature: Searching for a term
As a user
I want to submit a search term to the search bar
So that I can view results relevant to my interests
	
	
	Scenario Outline:
	Given I navigate to the home page
	When I click on the search bar
	And I enter a "<search term>"
	And I click the search button
	Then I should see a table of results
	
	Examples:
		|search term|
		|painting|
		|france|
		|sculpture|
	