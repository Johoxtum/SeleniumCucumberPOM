@Amazon
Feature: Test automation search functionally
  @Cart
  Scenario Outline: As a Customer when I search for Alexa, I want to see if the third option on the second page is available for purchase and can be added to the cart
    Given the user navigate to amazon
    When Searches for "<products>"
    And navigates to the second pages
    And selects the third item
    Then the user is able to add it to the cart

    Examples:
        |products   |
        |Alexa      |
        |Playstation|

