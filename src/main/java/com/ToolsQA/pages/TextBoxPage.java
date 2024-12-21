package com.ToolsQA.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BasePage{

    public TextBoxPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul/li/span[normalize-space()='Text Box']")
    public WebElement textBoxSideBar;

    public void clickTextBoxSidebar(){
        textBoxSideBar.click();
    }

    @FindBy(id = "userName")
    public WebElement userName;

    public TextBoxPage enterUserName(String str_name){
        userName.sendKeys(str_name);
        return this;
    }

    @FindBy(id="userEmail")
    public WebElement email;

    public TextBoxPage enterEmail(String str_email){
        email.sendKeys(str_email);
        return this;
    }

    @FindBy(id="currentAddress")
    public WebElement currentAddress;

    public TextBoxPage enterCurrentAddress(String str_currentAddress){
        currentAddress.sendKeys(str_currentAddress);
        return this;
    }

    @FindBy(id="permanentAddress")
    public WebElement permanentAddress;

    public TextBoxPage enterPermanentAddress(String str_permanentAddress){
        permanentAddress.sendKeys(str_permanentAddress);
        return this;
    }

    @FindBy(id="submit")
    public WebElement submitBtn;

    public void clickSubmit(){
        pageFunctionsObj.scrollIntoElement(submitBtn);
        submitBtn.click();
    }

    @FindBy(id="name")
    public WebElement nameResult;

    public String getName(){
        return nameResult.getText().split(":")[1];
    }

    @FindBy(id="email")
    public WebElement emailResult;

    public String getEmail(){
        return emailResult.getText().split(":")[1];
    }

    @FindBy(xpath = "//p[@id='currentAddress']")
    public WebElement currentAddressResult;

    public String getCurrentAddress(){
        return currentAddressResult.getText().split(":")[1];
    }

    @FindBy(xpath = "//p[@id='permanentAddress']")
    public WebElement permanentAddressResult;

    public String getPermanentAddress(){
        return permanentAddressResult.getText().split(":")[1];
    }

}
