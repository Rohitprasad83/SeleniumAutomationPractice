import com.ToolsQA.pages.HomePage;
import com.ToolsQA.pages.RadioButtonPage;
import com.ToolsQA.testsuitebase.SuiteBase;
import com.ToolsQA.utility.PageFunctions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class RadioButtonTest extends SuiteBase {
    PageFunctions pageFunctionsObj;
    @BeforeMethod
    public void textBoxSetup(){
        setup();
        pageFunctionsObj = new PageFunctions();
    }

    @Test(enabled = true)
    public void radioYesTest() throws InterruptedException {

        HomePage homePageObj = new HomePage(driver);
        pageFunctionsObj.scrollIntoElement(homePageObj.elementsPage);
        homePageObj.clickElementsPage();

        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.clickRadioButtonSideBar();

        pageFunctionsObj.scrollIntoElement(radioButtonPage.yesRadio);
        radioButtonPage.clickYesRadioButton();

        pageFunctionsObj.elementIsVisible(radioButtonPage.output);

        Assert.assertEquals(radioButtonPage.output.getText(), "You have selected Yes");
    }

    @Test(enabled = true)
    public void impressiveRadioTest() throws InterruptedException {

        HomePage homePageObj = new HomePage(driver);
        pageFunctionsObj.scrollIntoElement(homePageObj.elementsPage);
        homePageObj.clickElementsPage();

        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.clickRadioButtonSideBar();
        pageFunctionsObj.scrollIntoElement(radioButtonPage.impressiveRadio);
        radioButtonPage.clickImpressiveRadioButton();

        pageFunctionsObj.elementIsVisible(radioButtonPage.output);

        Assert.assertEquals(radioButtonPage.output.getText(), "You have selected Impressive");
    }

    @Test(enabled = true)
    public void noRadioTest() throws InterruptedException {
        HomePage homePageObj = new HomePage(driver);
        pageFunctionsObj.scrollIntoElement(homePageObj.elementsPage);
        homePageObj.clickElementsPage();

        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.clickRadioButtonSideBar();
        pageFunctionsObj.scrollIntoElement(radioButtonPage.noRadio);

        Assert.assertFalse(radioButtonPage.noRadio.isEnabled());
    }
    @AfterMethod
    public void afterTest(){
        tearDown();
    }
}
