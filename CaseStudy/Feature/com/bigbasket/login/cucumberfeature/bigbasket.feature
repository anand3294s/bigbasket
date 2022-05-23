@bigbasket 

Feature: Add products to the bigbasket cart 

  I want to add the products as configured in the excel with the respective quantity and navigate to the basket, check the total amount and empty the basket 

 

  @bigbasketTest1 

  Scenario: Add products that are required 

    Given I have opened a browser 

    When I add the product 

    Then navigate to the basket 

    Then close the browser 