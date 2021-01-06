Feature: Search website for item and confirm it has been found 

Scenario: search for dress and assert it was found
	Given I can open the shopping site
	When I search for a dress
	Then I can add it to my cart