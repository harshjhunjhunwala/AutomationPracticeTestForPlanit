package com.automationpractice.pages;

import com.automationpractice.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {


   @FindBy(css =  "a[class='login']")
    WebElement signInButton;

    @FindBy(linkText = "Add to cart")
   WebElement addToCartText;

    @FindBy(linkText = "Faded Short Sleeve T-shirts")
    WebElement fadedShortSleeveTshirtText;

   @FindBy(linkText =  "Proceed to checkout")
   WebElement proceedToCheckoutButton;

   @FindBy(name ="search_query")
   WebElement searchQueryBox;

   @FindBy(id="contact-link")
   WebElement contactUsButton;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    public AuthenticationPage navigateToAuthenticatedPage()
    {
        WebDriverWait wait = new WebDriverWait(this.driver,60);
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();

        return new AuthenticationPage();
    }

    public boolean isHomePageLoaded()
    {
        return searchQueryBox.isDisplayed();
    }

    public CartSummaryPage addItemToCartAndProceedToSummaryPage()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0, 600);");

        WebDriverWait wait = new WebDriverWait(this.driver,60);
        wait.until(ExpectedConditions.visibilityOf(fadedShortSleeveTshirtText));

        Actions actions = new Actions(driver);
        actions.moveToElement(fadedShortSleeveTshirtText).perform();

        wait.until(ExpectedConditions.visibilityOf(addToCartText));
        addToCartText.click();

        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutButton));

        proceedToCheckoutButton.click();

        return PageFactory.initElements(driver,CartSummaryPage.class);
    }

    public ContactUsPage navigateToContactUsPage()
    {
        contactUsButton.click();

        return new ContactUsPage();
    }

}
