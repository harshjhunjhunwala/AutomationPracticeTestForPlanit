package com.automationpractice.pages;

import com.automationpractice.base.BasePage;
import org.apache.commons.codec.binary.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage extends BasePage {

    public AuthenticationPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="email_create")
    WebElement createEmailAddress;

    @FindBy(id="SubmitCreate")
    WebElement createAnAccount;

    @FindBy(id = "create_account_error")
    WebElement invalidEmailErrorMessage;

    @FindBy(id="email")
    WebElement loginUsername;

    @FindBy(id="passwd")
    WebElement loginPassword;

    @FindBy(id="SubmitLogin")
    WebElement loginButton;

    @FindBy(className = "navigation_page")
    WebElement authenticationText;

    public boolean validateMandatoryFieldsOnUserRegistration()
    {
        WebDriverWait wait = new WebDriverWait(this.driver,60);
        wait.until(ExpectedConditions.visibilityOf(createAnAccount));
        createAnAccount.click();


        wait.until(ExpectedConditions.visibilityOf(invalidEmailErrorMessage));

        return invalidEmailErrorMessage.isDisplayed();
    }

    public RegistrationPage createEmailAddress()
    {
        createEmailAddress.clear();
        createEmailAddress.sendKeys(properties.getProperty("username"));
        createAnAccount.click();

        return PageFactory.initElements(driver,RegistrationPage.class);
    }

    public boolean isAuthenticationPageLoaded()
    {
        WebDriverWait wait = new WebDriverWait(this.driver,60);
        wait.until(ExpectedConditions.visibilityOf(authenticationText));
        return StringUtils.equals(authenticationText.getText(),"Authentication");
    }

    public MyAccountPage loginWithExistingUser()
    {
        loginUsername.sendKeys(properties.getProperty("username"));
        loginPassword.sendKeys(properties.getProperty("password"));

        loginButton.click();

        return PageFactory.initElements(driver,MyAccountPage.class);

    }


}
