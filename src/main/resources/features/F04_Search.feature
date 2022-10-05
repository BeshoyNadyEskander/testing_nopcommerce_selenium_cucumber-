@smoke
Feature: F04_Search | validate that search works exactly

  #we should use Scenario Outline if we want to use more than one value to search on it

  Scenario Outline: user could search on any product
    Given user could go to field of search
    When user could search with valid product "<productName>"
    Then verify that the user could find a product relative for result "<productName>"
    Examples:
    |productName|
    | macbook |
    | Laptop  |
     | Android |

    Scenario Outline: user could search for product with sku
      When user could search with valid sku "<serialNumber>"
      Then verify that user could find product relative for sku of result "<serialNumber>"
      And click on picture of product to navigate details for product
      And verify that main sku relative for sku for searching product "<serialNumber>"
      Examples:
      |  serialNumber      |
      |       SCI_FAITH             |
      |                APPLE_CAM    |
      |                SF_PRO_11    |
