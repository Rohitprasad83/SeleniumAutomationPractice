import com.ToolsQA.pages.HomePage;
import com.ToolsQA.pages.TextBoxPage;
import com.ToolsQA.testsuitebase.SuiteBase;

import com.ToolsQA.utility.PageFunctions;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.*;

public class TextBoxPageTest extends SuiteBase {
    PageFunctions pageFunctionsObj;
    @BeforeMethod
    public void textBoxSetup(){
        setup();
        pageFunctionsObj = new PageFunctions();
    }

    @Test
    public void testTextBoxPage() throws InterruptedException{
        HomePage homePageObj = new HomePage(driver);
        pageFunctionsObj.scrollIntoElement(homePageObj.elementsPage);
        TextBoxPage textBoxPageObj = new TextBoxPage(driver);
        homePageObj.clickElementsPage();
        textBoxPageObj.clickTextBoxSidebar();
        String str_name = "Rohit Prasad", str_email = "rohit@prasad.com", str_currentAddress = "Full Address Lines",
                str_permanentAddress="Permanent Address Lines";
        textBoxPageObj.enterUserName(str_name);
        textBoxPageObj.enterEmail(str_email);
        textBoxPageObj.enterCurrentAddress(str_currentAddress);
        textBoxPageObj.enterPermanentAddress(str_permanentAddress);
        textBoxPageObj.clickSubmit();

        pageFunctionsObj.elementIsVisible(textBoxPageObj.nameResult);

        Assert.assertEquals(str_name, textBoxPageObj.getName());
        Assert.assertEquals(str_email, textBoxPageObj.getEmail());
        Assert.assertEquals(str_currentAddress, textBoxPageObj.getCurrentAddress());
        Assert.assertEquals(str_permanentAddress, textBoxPageObj.getPermanentAddress());

    }

    @AfterMethod
    public void afterTest(){
        tearDown();
    }
}
