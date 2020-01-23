package com.automationpractice.pages;

import com.automationpractice.base.BasePage;
import org.apache.commons.codec.binary.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationPage extends BasePage {

    public RegistrationPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css= ".alert.alert-danger")
    WebElement registrationErrorMessage;

    @FindBy(id = "id_gender1")
    WebElement title;

    @FindBy(id="customer_firstname")
    WebElement firstName;

    @FindBy(id="customer_lastname")
    WebElement lastName;

    @FindBy(name="email")
    WebElement email;

    @FindBy(id="passwd")
    WebElement password;

    @FindBy(id="days")
    WebElement dayOfBirth;

    @FindBy(id="months")
    WebElement monthOfBirth;

    @FindBy(id="years")
    WebElement yearOfBirth;

    @FindBy(id="firstname")
    WebElement addressFirstName;

    @FindBy(id="lastname")
    WebElement addressLastName;

    @FindBy(id="address1")
    WebElement address;

    @FindBy(id="city")
    WebElement city;

    @FindBy(id="id_state")
    WebElement state;

    @FindBy(id="postcode")
    WebElement postCode;

    @FindBy(id="id_country")
    WebElement country;

    @FindBy(id="phone_mobile")
    WebElement mobileNumber;

    @FindBy(id="alias")
    WebElement addressAlias;

    @FindBy(id="submitAccount")
    WebElement registerButton;

    @FindBy(linkText="You must register at least one phone number.")
    WebElement phoneNumberErrorMessage;

    @FindBy(className = "navigation_page")
    WebElement createAnAccountText;


    public boolean isAuthenticationPageLoaded()
    {
        WebDriverWait wait = new WebDriverWait(this.driver,60);
        wait.until(ExpectedConditions.visibilityOf(createAnAccountText));



        return StringUtils.equals(createAnAccountText.getText(),"Authentication");
    }

    public boolean validateMandatoryFields()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView();",registerButton );
        js.executeScript("scroll(0, 1300);");


        WebDriverWait wait = new WebDriverWait(this.driver,60);
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        registerButton.click();
        js.executeScript("scroll(0, -1300);");

        wait.until(ExpectedConditions.visibilityOf(registrationErrorMessage));

        return registrationErrorMessage.isDisplayed();
    }

    public MyAccountPage registerUser()
    {
        title.click();
        firstName.sendKeys("Harsh");
        lastName.sendKeys("Jhunjhunwala");


        WebDriverWait wait = new WebDriverWait(this.driver,60);
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(properties.getProperty("password"));


        addressFirstName.sendKeys("Harsh");
        addressLastName.sendKeys("Jhunjhunwala");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("scroll(0, 1300);");

        address.sendKeys("random address");
        city.sendKeys("Derby");
        Select selectState = new Select(state);

        selectState.selectByIndex(1);

        postCode.sendKeys("55555");

        Select selectCountry = new Select(country);
        selectCountry.selectByIndex(1);
        mobileNumber.sendKeys("09999955555");
        addressAlias.sendKeys("HomeAddress");
        registerButton.click();

        return PageFactory.initElements(driver,MyAccountPage.class);
    }
}
