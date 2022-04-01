# AEO Assignment

### Case 1 : From PDP to Place Order Using credit card
- Choose a product from PDP

- URL used:
  https://www.ae.com/us/en/p/men/skinny-jeans/skinny-jeans/ae-airflex-360-patched-skinny-jean/0119_6026_048?menu=cat4840004

- Select color,size,quantity and click Add To Bag button.

- Click View Bag and proceed to Checkout

- Fill all the personal information,mailing address and credit card information (Used 4111 card)

- Click Place Order and the order is placed.

- Order confirmation message is extracted and compared with the expected message.

** Personal information and credit card information is passed from Excel file(BillingInfoAE.xlsx). All locators were passed from properties file(AEconfig.properties).

Automation code is available in the following location:
1.src/main/java/jovita.ae.checkout/CheckoutFlow.java
2. TestNG - src/test/java/AEPdpCreditCardCheckout.java


### Case 2 : From PDP Page to Place Order Using gift card

- Choose a product from PDP

- URL used:
  https://www.ae.com/us/en/p/men/skinny-jeans/skinny-jeans/ae-airflex-360-patched-skinny-jean/0119_6026_048?menu=cat4840004

- Select color,size,quantity and click Add To Bag button.

- Click View Bag and proceed to Checkout

- Fill all the personal information,mailing address and gift card information (Used 4111 card)

- Click Apply.Error message will be displayed and the order cannot be placed.

- Error message is extracted and compared with the expected message.

** Personal information and gift card information is passed from Excel file(BillingInfoAE.xlsx). All locators were passed from properties file(AEconfig.properties).

Automation code is available in the following location:
1.src/main/java/jovita.ae.checkout/CheckoutFlow.java
2. TestNG - src/test/java/AEPdpGiftCardCheckout.java


### Case 3 : From Home Page, search product and proceed to checkout Using credit card

- Go to home page (https://www.ae.com/us/en) and enter the search keyword (sweater) in the search textbox.

- PDP is opened. Select a product.

- Select color,size,quantity and click Add To Bag button.

- Click View Bag and proceed to Checkout

- Fill all the personal information,mailing address and credit card information (Used 4111 card)

- Click Place Order and the order is placed.

- Order confirmation message is extracted and compared with the expected message.

** Personal information and credit card information is passed from Excel sheet(BillingInfoAE.xlsx). All locators were passed from properties file(AEconfig.properties).

Code is available in the following location:
1.src/main/java/jovita.ae.checkout/SearchFlow.java
2. TestNG - src/test/java/AESearchCCardCheckout.java



### Case 4 : From Home Page, search product and proceed to checkout Using gift card

- Go to home page (https://www.ae.com/us/en) and enter the search keyword (sweater) in the search textbox.

- PDP is opened. Select a product.

- Select color,size,quantity and click Add To Bag button.

- Click View Bag and proceed to Checkout

- Fill all the personal information,mailing address and gift card information (Used 4111 card)

- Click Apply.Error message will be displayed and cannot place an order.

- Error message is extracted and compared with the expected message.

** Personal information and gift card information is passed from Excel sheet(BillingInfoAE.xlsx). All locators were passed from properties file(AEconfig.properties).

Code is available in the following location:
1.src/main/java/jovita.ae.checkout/SearchFlow.java
2. TestNG - src/test/java/AESearchGiftCardCheckout.java


Tech Stack Used:
GitHub
Java
TestNG
Selenium

Driver Set up code is available at src/main/java/jovita.ae.driverChrome/AEChromeDriverSetup.java

ChromeDriver.exe, BillingInfoAE.xlsx (Excel file), AEconfig.properties are available at src/main/java/resources