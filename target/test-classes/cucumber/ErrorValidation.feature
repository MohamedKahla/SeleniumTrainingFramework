
@tag
Feature: Error validation
  I want to use this template for my feature file



  @ErrorValidation
  Scenario Outline: Positive test of submitting order
  
  	Given User landed on e-commerce page
    When User connected with valid <email> and <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | email                    |      password |   
      | kahlouchmamado@gmail.com | MED000000w0rd | 

