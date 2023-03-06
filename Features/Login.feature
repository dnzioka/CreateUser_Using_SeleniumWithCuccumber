Feature: Login Functionality

Scenario: Successful Login with valid Credentials
    Given User launches Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on log out link
    Then Page Title should be "Your store. Login"
    And close browser



Scenario Outline: Login Data Driven
    Given User launches Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on log out link
    Then Page Title should be "Your store. Login"
    And close browser
    
    
    Examples:
    |email               | password|
    |admin@yourstore.com | admin	 |
    |admin1@yourstore.com | admin123|
    
    
    
    
    
    
    
    
    
    
    
    

    