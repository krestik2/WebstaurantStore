package com.webstaurantstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//div[@class='details ']/span/a")
    public WebElement lastItemTitle;

    @FindBy(xpath = "//div[@class='itemPrice price']")
    public WebElement lastItemPrice;

    @FindBy(xpath = "//input[@aria-label='Quantity']")
    public WebElement quantityInCart;

    @FindBy(xpath = "//button[.='Empty Cart']")
    public WebElement emptyCartBtn;

    @FindBy(xpath = "//div/footer/button[1]")
    public WebElement popUpEmptyCart;

    @FindBy(xpath = "//div[@class='empty-cart__text']/p[1]")
    public WebElement emptyCartMessage;



}
