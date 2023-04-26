package com.webstaurantstore.pages;

import com.webstaurantstore.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {


    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
