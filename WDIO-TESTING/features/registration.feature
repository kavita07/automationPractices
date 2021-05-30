Feature: The My Store Website

  Scenario Outline: As a user, I can register to my store app

    Given I am on the sigin page
    When I click on create my acount button
    And I select title as <title>
    And I enter first name first name as <firstName>
    And I enter last name first name as <lastName>
    And I enter password
    And I enter address line1 as <addressLine1>
    And I enter city as <city>
    And I select state as <state>
    And I enter zipcode as <zipCode>
    And I select country as <countryName>
    And I enter additional phone no as <additionalPhoneNo>
    And I enter mobile no <mobileNo>
    And I click on Register button
    Then I should see on landing screen correct <firstName> and <lastName> is displayed
    And I verify logout from application

    Examples: 
      | title | firstName | lastName  | addressLine1 | city  | state   | zipCode | countryName   | additionalPhoneNo | mobileNo   |
      | Mr.   | Sanika    | Agnihotri | DP road      | Moody | Alabama |   35004 | United States |        2050880880 | 2560880880 |
      
