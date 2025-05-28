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
@tag111
Feature: Title of your feature
  I want to use this template for my feature file
 
  @tag1
  Scenario Outline: Register the user with personal details
  	Given User is in homepage
  	And User clicks on Register link
  	When User chooses the Gender
  	When User enters firstname
  	When User enters lastname
  	When User enters email
  	When User enters password
  	And User enters confirmpassword
  	And User clicks on register button
  	Then User is registered successfully