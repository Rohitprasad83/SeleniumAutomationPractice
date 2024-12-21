package com.ToolsQA.utility;

import com.ToolsQA.testsuitebase.SuiteBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageFunctions extends SuiteBase {

    public void scrollIntoElement(WebElement el){
        js.executeScript("arguments[0].scrollIntoView(true);", el);
    }

    public void elementIsVisible(WebElement el){
        wait.until(ExpectedConditions.visibilityOf(el));
    }

    public void elementIsClickable(WebElement el){
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }
}
