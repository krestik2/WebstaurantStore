Feature: Verify search functionality, add product to cart, empty cart

@wip
  Scenario: Search for 'stainless work table', add last item to cart, empty cart

    Given user is on the home page of "https://www.webstaurantstore.com/"
    When  user search for "stainless work table"
    Then  every product in the search results should have the word "Table" in its title
    When  user adds the last item on the last page of the search results to the cart
    Then  correct item and quantity should be displayed in the cart
    When  user empties the cart
    Then  cart is empty

