Feature: To validate the magento site

Scenario: Has to get the order number
Given Has to launch the websit
When Enter the product name in search bar
When Choose the product,size,colour and then clik to add to cart
And Click on cart proceed to checkout
And then fill the details and then click next
Then Get the order num
