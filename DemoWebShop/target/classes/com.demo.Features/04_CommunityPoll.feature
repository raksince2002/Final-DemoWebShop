#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag114
Feature: Poll Voting
  
  @tag5
  Scenario: Unregisterd users cannot vote
    Given The user is logged out and is on poll page
    When User selects an option to vote
    And Clicks on vote
    Then Only registered users can vote
    
  @tag6
   Scenario: Registered users can vote
   	Given The user is on poll page
   	And User has registered and logged in
   	When User selects an option to vote
   	And Clicks on vote
   	Then Vote is accepted