Feature: Customers Module

  Scenario: Add a new Customer
    Given User launches Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password "admin"
    And Click on Login
    Then User can view Dashboard page
    When User clicks on customers menu
    And Click on customers menu item
    And Click on Add new button
    Then User can view Add a new customer page
    When User enters customer info
    And Click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser


