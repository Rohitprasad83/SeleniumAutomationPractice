package com.ToolsQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage extends BasePage {

    public RadioButtonPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//ul/li/span[normalize-space()='Radio Button']")
    public WebElement RadioButtonSidebar;

    @FindBy(xpath = "//label[normalize-space()='Yes']")
    public WebElement yesRadio;

    @FindBy(xpath = "//label[normalize-space()='Impressive']")
    public WebElement impressiveRadio;

    @FindBy(id = "noRadio")
    public WebElement noRadio;

    @FindBy(css = ".mt-3")
    public WebElement output;

    public void clickRadioButtonSideBar(){
        RadioButtonSidebar.click();
    }
    public void clickYesRadioButton(){
        pageFunctionsObj.elementIsClickable(yesRadio);
        yesRadio.click();
    }

    public void clickImpressiveRadioButton(){
        pageFunctionsObj.elementIsClickable(impressiveRadio);
        impressiveRadio.click();
    }

    public void clickNoRadioButton(){
        pageFunctionsObj.elementIsClickable(noRadio);
        noRadio.click();
    }

}
