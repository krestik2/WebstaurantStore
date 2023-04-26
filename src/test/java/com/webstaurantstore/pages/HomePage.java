package com.webstaurantstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//input[@name='searchval']")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@value='Search']")
    public WebElement searchBtn;


    @FindBy(xpath = "//div[@data-testid='product-listing-container']/div/div/a")
    public List<WebElement> resultNames;

    @FindBy(xpath = "//nav[@aria-label='pagination']/ul/li")
    public List<WebElement> pages;

    @FindBy(xpath = "//nav[@aria-label='pagination']/ul/li[last()]")
    public WebElement nextPageBtn;

    @FindBy(xpath = "//div[@role='main']/div[3]/div[last()]")
    public WebElement lastItem;


    @FindBy(xpath = "//div[@role='main']/div[3]/div[last()]/div[@class='add-to-cart']")
    public WebElement addToCartlastItem;

    @FindBy(xpath = "//a[@data-testid='cart-nav-link']")
    public WebElement cartBtn;

    @FindBy(id = "watnotif-wrapper")
    public WebElement popUp;



}
