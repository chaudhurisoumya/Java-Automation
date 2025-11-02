
@tag
Feature: Purchase the order from Ecommerce website

  Background:
  Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." is displayed on the confirmation page. 

    Examples: 
      | name 											  | password | productName    |
      | chaudhuri28soumya@gmail.com |AxByCz99  | ZARA COAT 3	  |
      | tulikatty@gmail.com 				|AxByCz99  | ADIDAS ORIGINAL |
