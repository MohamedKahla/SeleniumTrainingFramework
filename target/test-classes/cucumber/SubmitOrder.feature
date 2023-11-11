
@tag
Feature: Purchase order from rahulshettyacademy.com site
  I want to use this template for my feature file

Background:
Given User landed on e-commerce page


  @SubmiOrder
  Scenario Outline: Positive test of submitting order
  
    Given User connected with valid <email> and <password>
    When User added product <productName> to card
    And Check out <productName> and submit the order
    Then Rederection to order confirmation page with header "THANKYOU FOR THE ORDER."

    Examples: 
      | email                    |      password |    productName  |
      | kahlouchmamado@gmail.com | MEDKHL@ssw0rd | ADIDAS ORIGINAL |

