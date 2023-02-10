
Feature: product checkout

Scenario: user register , login , add item , remove it


 Given user Registered and logged in into demoblaze.com
 Then user Check the listed Categories has Items
 And Add random item to the cart & Remove item from cart
 When user Complete successful checkout with random item
 Then user should get successful checkout 