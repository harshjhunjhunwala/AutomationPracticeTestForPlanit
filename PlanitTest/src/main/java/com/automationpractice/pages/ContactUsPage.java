package com.automationpractice.pages;

import com.automationpractice.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends BasePage {

    public ContactUsPage()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="id_contact")
    WebElement subjectHeadingDropDown;

    @FindBy(id="email")
    WebElement contactUsEmail;

    @FindBy(id="id_order")
    WebElement contactUsOrderReference;

    @FindBy(id="message")
    WebElement contactUsMessage;

    @FindBy(id="submitMessage")
    WebElement sendMessageButton;
    //*[@id="center_column"]/p
    @FindBy(xpath="//*[@id=\"center_column\"]/p")
    WebElement successMessage;


    public boolean sendMessageToCustomerService()
    {

        // Note : We will make this dynamic and store it in prop file email, orderref, message

        Select dropdown = new Select(subjectHeadingDropDown);
        dropdown.selectByIndex(1);

        contactUsEmail.clear();
        contactUsEmail.sendKeys("randomemail@gmail.com");

        contactUsOrderReference.clear();
        contactUsOrderReference.sendKeys("random product number");

        contactUsMessage.clear();
        contactUsMessage.sendKeys("random message");

        sendMessageButton.click();

        WebDriverWait wait = new WebDriverWait(this.driver,60);
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.isDisplayed();

    }

}
