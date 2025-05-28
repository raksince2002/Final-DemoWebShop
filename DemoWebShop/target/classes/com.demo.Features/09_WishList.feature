@tag119
Feature: To Check the functionality of WishList
  @tag11
  Scenario: Add and Remove Product from the WishList
  #Add all products into wishList
    Given pre-request for project
    When user click on DigitalDownloads
    And add all products into wishlist
    Then all products are added into the wishlist
  #Remove product from the wishList
    Given user is on WishList page
    When user select a product from the WishList to remove
    And click update wishlist to remove
    Then a product removed  from the wishlist
  #Remove all product from the WishList
    When user select all product in wishlist
    And clicks update wishlist to remove
    Then all product removed  from the wishlist