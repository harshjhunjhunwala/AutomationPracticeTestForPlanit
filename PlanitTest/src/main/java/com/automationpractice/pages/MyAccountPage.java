package com.automationpractice.pages;

import com.automationpractice.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage {

    public MyAccountPage()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(className =  "logout")
    WebElement logoutButton;

    @FindBy(className =  "account")
    WebElement myAccount;

    @FindBy(linkText = "Home")
    WebElement backToHomeButton;

    @FindBy(linkText = "MY PERSONAL INFORMATION")
    WebElement myPersonalInformationText;

    public boolean isMyAccountPageLoaded()
    {
        WebDriverWait wait = new WebDriverWait(this.driver,60);
        wait.until(ExpectedConditions.visibilityOf(myPersonalInformationText));

        return myPersonalInformationText.isDisplayed();
    }

    public AuthenticationPage signOut()
    {
        logoutButton.click();
        return PageFactory.initElements(driver,AuthenticationPage.class);
    }

    public  HomePage navigateToHomePage()
    {
        backToHomeButton.click();
        return PageFactory.initElements(driver,HomePage.class);
    }

}
