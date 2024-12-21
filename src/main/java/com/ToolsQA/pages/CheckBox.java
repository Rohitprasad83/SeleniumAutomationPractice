package com.ToolsQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBox extends BasePage {

    public CheckBox(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Check Box']")
    WebElement checkBoxSideBar;

    public void clickCheckBoxSideBar(){
        checkBoxSideBar.click();
    }


}
