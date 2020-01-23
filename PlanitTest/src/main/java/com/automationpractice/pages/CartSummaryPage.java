package com.automationpractice.pages;

import com.automationpractice.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasePage {

    public CartSummaryPage()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="cart_title")
    WebElement cartTitle;

    @FindBy(linkText = "Faded Short Sleeve T-shirts")
    WebElement dressFadedShortSleeveTshirt;

    @FindBy(css =  "a[class='cart_quantity_delete']")
    WebElement removeFadedShortSleeveTshirtButton;

    @FindBy(xpath="//*[@id=\"center_column\"]/p")
    WebElement emptyCartMessage;

    public boolean isCartSummaryPageLoaded()
    {
        return cartTitle.isDisplayed();
    }

    public boolean isProductAddedToCart()
    {
        return dressFadedShortSleeveTshirt.isDisplayed();
    }

    public CartSummaryPage removeProduct()
    {
        removeFadedShortSleeveTshirtButton.click();
        return PageFactory.initElements(driver,CartSummaryPage.class);
    }

    public boolean isCartEmpty()
    {
        WebDriverWait wait = new WebDriverWait(this.driver,60);
        wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));
        return emptyCartMessage.isDisplayed();
    }

}
