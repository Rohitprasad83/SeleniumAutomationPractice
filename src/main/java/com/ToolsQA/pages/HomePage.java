package com.ToolsQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h5[normalize-space()='Elements']")
    public WebElement elementsPage;

    public void clickElementsPage(){
        pageFunctionsObj.elementIsClickable(elementsPage);
        elementsPage.click();
    }

}
