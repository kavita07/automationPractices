Feature: User registration and validating product checkout workflow

  Background: Below are the common steps
    Given User opens URL in appropriate browser
    And User clicks on Signin on landing page

  Scenario Outline: Register new User with valid credentials
    When User enters unique email id
    And User clicks on create account button
    And User selects title as "<title>"
    And User enters first name as "<firstName>"
    And User enters last name as "<lastName>"
    And User enters password
    And User enters address line1 as "<addressLine1>"
    And User enters city as "<city>"
    And User enters state as "<state>"
    And User enters zipcode as "<zipCode>"
    And User enters country as "<country>"
    And User enters additional phone no as "<additionalPhoneNo>"
    And User enters mobile no "<mobileNo>"
    And User clicks on Register button
    Then User verifies on landing screen correct "<firstName>" and "<lastName>" is displayed
    And User logout from application

    Examples: 
      | title | firstName | lastName  | addressLine1 | city  | state   | zipCode | country       | additionalPhoneNo | mobileNo   |
      | Mr.   | Sanika    | Agnihotri | DP road      | Moody | Alabama |   35004 | United States |        2050880880 | 2560880880 |

  Scenario Outline: Newly created user is able to do login as well as add product to cart and checkout
    When User enters registered email id
    And User enters password for login
    And User clicks on SignIn button
    And User selects product catagory as "<catagory>"
    And User selects first product
    And User adds the product to cart
    And User clicks on proceed to checkout button
    Then User verifies the product details

    Examples: 
      | catagory |
      | T-shirt  |
