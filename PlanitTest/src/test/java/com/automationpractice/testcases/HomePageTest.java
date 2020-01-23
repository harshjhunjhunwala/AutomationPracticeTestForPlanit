package com.automationpractice.testcases;

import com.automationpractice.pages.*;
import com.automationpractice.base.BasePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;


public class HomePageTest extends BasePage {

    AuthenticationPage authenticationPage;
    RegistrationPage registrationPage;
    MyAccountPage myAccountPage;
    HomePage homePage ;
    CartSummaryPage cartSummaryPage;
    ContactUsPage contactUsPage;


    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup()
    {
        initialization();
        homePage = new HomePage();
        authenticationPage = new AuthenticationPage();
        registrationPage = new RegistrationPage();
        myAccountPage = new MyAccountPage();
        cartSummaryPage = new CartSummaryPage();
        contactUsPage = new ContactUsPage();
    }

    @Test(priority = 0)
    public void sendMessageToCustomerService()
    {
        contactUsPage = homePage.navigateToContactUsPage();
        Assert.assertTrue(contactUsPage.sendMessageToCustomerService());
    }

    @Test(priority = 1)
    public void registerNewUserAndPerformValidations()
    {
        authenticationPage = homePage.navigateToAuthenticatedPage();
        Assert.assertTrue( authenticationPage.validateMandatoryFieldsOnUserRegistration());

        registrationPage = authenticationPage.createEmailAddress();
        Assert.assertTrue( registrationPage.isAuthenticationPageLoaded());

        Assert.assertTrue(registrationPage.validateMandatoryFields());

        myAccountPage = registrationPage.registerUser();
        Assert.assertTrue(myAccountPage.isMyAccountPageLoaded());

        authenticationPage = myAccountPage.signOut();
        Assert.assertTrue(authenticationPage.isAuthenticationPageLoaded());

    }

    @Test(priority = 2)
    public void loginWithNewUser()
    {
        authenticationPage = homePage.navigateToAuthenticatedPage();
        Assert.assertTrue( authenticationPage.isAuthenticationPageLoaded());

        myAccountPage = authenticationPage.loginWithExistingUser();
        Assert.assertTrue(myAccountPage.isMyAccountPageLoaded());
    }


    @Test(priority = 3)
    public void addItemToCartAndValidateTheRightItem()
    {
        authenticationPage = homePage.navigateToAuthenticatedPage();
        Assert.assertTrue( authenticationPage.isAuthenticationPageLoaded());

        myAccountPage = authenticationPage.loginWithExistingUser();
        Assert.assertTrue(myAccountPage.isMyAccountPageLoaded());

        homePage = myAccountPage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded());

        cartSummaryPage = homePage.addItemToCartAndProceedToSummaryPage();
        Assert.assertTrue(cartSummaryPage.isCartSummaryPageLoaded());
        Assert.assertTrue(cartSummaryPage.isProductAddedToCart());

        cartSummaryPage.removeProduct();
        cartSummaryPage.isCartEmpty();
    }



    @AfterMethod
    public void quitBrowser()
    {
        driver.quit();

    }

}


