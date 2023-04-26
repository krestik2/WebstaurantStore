package com.webstaurantstore.step_definitions;

import com.webstaurantstore.pages.CartPage;
import com.webstaurantstore.pages.HomePage;
import com.webstaurantstore.utilities.BrowserUtils;
import com.webstaurantstore.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basic_search {
    HomePage homepage = new HomePage();
    CartPage cartPage = new CartPage();
    String lastItemDescription;
    SoftAssertions softAssertions = new SoftAssertions();

    @Given("user is on the home page of {string}")
    public void user_is_on_the_home_page_of(String home_page) {

        Driver.getDriver().get(home_page);

    }
    @When("user search for {string}")
    public void user_search_for(String input) {

        homepage.searchBox.sendKeys(input);
        homepage.searchBtn.click();

    }

    @Then("every product in the search results should have the word {string} in its title")
    public void every_product_in_the_search_results_should_have_the_word_in_its_title(String input) {

        int size = homepage.pages.size();
        int count=0;


        do {
            homepage.resultNames.forEach(p ->
                    softAssertions.assertThat(p.getText().contains(input)));


            if (homepage.nextPageBtn.isDisplayed()) {
                homepage.nextPageBtn.click();
                homepage.resultNames.forEach(p ->
                        softAssertions.assertThat(p.getText().contains(input)));
            }
            count++;

        } while (homepage.nextPageBtn.isDisplayed() && count < size);

    }
    @When("user adds the last item on the last page of the search results to the cart")
    public void user_adds_the_last_item_on_the_last_page_of_the_search_results_to_the_cart() {

        lastItemDescription = homepage.lastItem.getText();
        homepage.addToCartlastItem.click();

    }
    @Then("correct item and quantity should be displayed in the cart")
    public void correct_item_and_quantity_should_be_displayed_in_the_cart() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.invisibilityOf(homepage.popUp));

        homepage.cartBtn.click();

        String lastItemTitle = cartPage.lastItemTitle.getText();
        String lastItemPrice = cartPage.lastItemPrice.getText();
        int quantityValue = Integer.parseInt(cartPage.quantityInCart.getAttribute("value"));


        Assert.assertTrue(lastItemDescription.contains(lastItemTitle));
        Assert.assertTrue(lastItemDescription.contains(lastItemPrice));
        Assert.assertEquals(1, quantityValue);

    }
    @When("user empties the cart")
    public void user_empties_the_cart() {

        cartPage.emptyCartBtn.click();
        cartPage.popUpEmptyCart.click();

    }

    @Then("cart is empty")
    public void cart_is_empty() {

        String expected = "Your cart is empty.";
        String actual = cartPage.emptyCartMessage.getText();

        Assert.assertEquals(expected,actual);

    }


}
