Feature: Add product to bag from PDP
#As a guest user, user adds product to bag

@AddToBag
Scenario: Add to Bag 

Given User opens the browser 
And User lands on PDP
When User selects the color
And User selects the size
And User selects the quantity
Then User should be able to add to bag successfully

@ProceedToCheckout
Scenario: After adding products to bag, proceed to checkout

Given User clicks View bag in AddedToBag page
And User clicks Proceed to Checkout from shopping bag page
Then User is taken to Checkout page successfully 
