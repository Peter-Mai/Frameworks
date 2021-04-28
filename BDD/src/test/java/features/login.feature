Feature: Validate Techfios Login functionality

  Background: 
    Given User is on the TechFios Login Page

  Scenario: User should be able to login with valid credentials
    When User enters username
    When User enters password
    And User clicks on the sign in button
    Then User should land on the Dashboard page
