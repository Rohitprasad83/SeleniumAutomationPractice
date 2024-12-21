package com.ToolsQA.pages;

import com.ToolsQA.testsuitebase.SuiteBase;
import com.ToolsQA.utility.PageFunctions;


public class BasePage extends SuiteBase {
    PageFunctions pageFunctionsObj;

    public BasePage(){
        pageFunctionsObj = new PageFunctions();
    }
}
