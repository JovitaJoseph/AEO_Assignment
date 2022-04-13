Feature: Add product to bag from PDP
#As a guest user, user adds product to bag

@AddToBag
Scenario: Add to Bag 

#Given User is on PDP
#When User selects the color
#And User selects the size
#And User selects the quantity
#Then User should be able to add to bag successfully

Given User opens the browser 
And User lands on PDP
When User selects the color
And User selects the size
And User selects the quantity
Then User should be able to add to bag successfully


@ProceedToCheckout
Scenario: After adding products to bag, proceed to checkout

Given user is in AddedToBag page
When User clicks ViewBag, user is taken to shopping bag page
And User clicks Proceed to Checkout
Then User is taken to Checkout page successfully 


