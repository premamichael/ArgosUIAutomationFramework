Feature: Search test feature
  As a user
  I can able to search products

  Background:
    Given I am on home page "https://www.argos.co.uk/" with page title "Argos | Order online today for fast home delivery"

  @Search
  Scenario: Verify valid product search

    When I enter valid product name "jeans"
    And I click search button
    Then I get redirected to that product page with page heading "Jeans"

  @Search
  Scenario: Verify invalid product search

    When I enter invalid product name "asdf"
    And I click search button
    Then I get error message

  @Search
  Scenario: Verify 3 letter auto suggestion

    When I enter invalid product name "Jea"
    Then auto suggestion will be displayed