Feature: Verify search functionality and add product to cart
@wip
  Scenario: Search for 'stainless work table' and add last item to cart
    Given I am on the home page of "https://www.webstaurantstore.com/"
    When I search for "stainless work table"
    And every product in the search results should have the word "Table" in its title
   # When I add the last item on the last page of the search results to Cart
   # Then Cart should have 1 item
   # When I empty the Cart
    #Then Cart should be empty