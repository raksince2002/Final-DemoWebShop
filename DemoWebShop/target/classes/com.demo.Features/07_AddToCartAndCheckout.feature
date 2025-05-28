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
 
@tag117
Feature: Checkout Functionality
  
  @tag91  
  Scenario: Valid Billing Address
    Given Pre-requisite for project
    And I click on shopping cart
    Then I am in cart page
    Given I am in checkout page
    When I click on New Address
    When I select country from dropdown
    And I enter city
    And I enter address1
    And I enter zip code
    And I enter phone number
    And I click on continue button in billing address section
    Then I am in shipping address section
  
  @tag92
  Scenario: Shipping Address
    Given Pre-requisite for project
    And I click on shopping cart
    Then I am in cart page
    Given I am in checkout page
    When I click on New Address
    When I select country from dropdown
    And I enter city
    And I enter address1
    And I enter zip code
    And I enter phone number
    And I click on continue button in billing address section
    Then I am in shipping address section
    And I click on continue button in shipping address
    Then I am in shipping shipment method section
  
  @tag93 
  Scenario: Shippment Method
    Given Pre-requisite for project
    And I click on shopping cart
    Then I am in cart page
    Given I am in checkout page
    When I click on New Address
    When I select country from dropdown
    And I enter city
    And I enter address1
    And I enter zip code
    And I enter phone number
    And I click on continue button in billing address section
    Then I am in shipping address section
    And I click on continue button in shipping address
    Then I am in shipping shipment method section
    When I click on next day air button
    And I click on continue button in shipment method section
    Then I am in payment method section
  
  @tag94  
  Scenario: Payment Method
    Given Pre-requisite for project
    And I click on shopping cart
    Then I am in cart page
    Given I am in checkout page
    When I click on New Address
    When I select country from dropdown
    And I enter city
    And I enter address1
    And I enter zip code
    And I enter phone number
    And I click on continue button in billing address section
    Then I am in shipping address section
    And I click on continue button in shipping address
    Then I am in shipping shipment method section
    When I click on next day air button
    And I click on continue button in shipment method section
    Then I am in payment method section
    When I click on credit card button
    And I click on continue button in payment method section
    Then I am in payment information section
    
  @tag95  
  Scenario: Invalid Payment Information
    Given Pre-requisite for project
    And I click on shopping cart
    Then I am in cart page
    Given I am in checkout page
    When I click on New Address
    When I select country from dropdown
    And I enter city
    And I enter address1
    And I enter zip code
    And I enter phone number
    And I click on continue button in billing address section
    Then I am in shipping address section
    And I click on continue button in shipping address
    Then I am in shipping shipment method section
    When I click on next day air button
    And I click on continue button in shipment method section
    Then I am in payment method section
    When I click on credit card button
    And I click on continue button in payment method section
    Then I am in payment information section
    When I select card type from dropdown
    And I enter invalid cardholder name
    And I enter invalid card number
    And I select date and year from expiration date dropdown
    And I enter invalid card code
    Then I click on button and error message is displayed

    
  @tag96 
  Scenario: Valid Payment Information
    Given Pre-requisite for project
    And I click on shopping cart
    Then I am in cart page
    Given I am in checkout page
    When I click on New Address
    When I select country from dropdown
    And I enter city
    And I enter address1
    And I enter zip code
    And I enter phone number
    And I click on continue button in billing address section
    Then I am in shipping address section
    And I click on continue button in shipping address
    Then I am in shipping shipment method section
    When I click on next day air button
    And I click on continue button in shipment method section
    Then I am in payment method section
    When I click on credit card button
    And I click on continue button in payment method section
    Then I am in payment information section
    When I select card type from dropdown
    And I enter cardholder name
    And I enter card number
    And I select date and year from expiration date dropdown
    And I enter card code
    And I click on continue button in payment information section
    When I click on confirm button in confirm order section
    Then A message is displayed
    And I click on the link for order details
    Then I am in order details page