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
@tag118
Feature: Add any three products into the cart and delete any two products from the cart
  I want to add any three products into the cart and delete any two products from the cart

  @tag10
  Scenario: Add any three products and delete any two products
    Given user is logged in and currently in the home page
    When user adds first product into the cart
    When user adds second product into the cart
    When user adds third product into the cart
    And user deletes any two products from the cart
    Then two products are deleted and only one product is in the shopping cart