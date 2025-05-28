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
@tag113
Feature: Newsletter Subscription
 
  @tag3
  Scenario: Successful subscription
    Given I am on the newsletter subscription page
    When I enter a valid email address
    And I click on the subscribe button
    Then I should see a confirmation message
 
  @tag4
  Scenario: Multiple subscriptions
    Given I am on the newsletter subscription page
    When I enter an already registered email address
    And I click on the subscribe button again
    Then I should see an error message