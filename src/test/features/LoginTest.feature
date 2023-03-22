Feature: Login feature test
  As a user
  I have to login with valid credentials

Background:

  Given I am on home page "https://www.argos.co.uk/" with page title "Argos | Order online today for fast home delivery"
  When I click account button and get redirected to sign in page with title "Sign in | Argos"

@login
  Scenario: Verify login with valid email id and password

    And I enter email address "premamichael05@gmail.com" and password "Polite*123"
    Then I click Sign In Securely button and get redirected to home page

  Scenario: Verify login with valid email and invalid password

    And I enter email address "premamichael05@gmail.com" and password "Politee*123"
    Then I click Sign In Securely button and get error message is displayed
