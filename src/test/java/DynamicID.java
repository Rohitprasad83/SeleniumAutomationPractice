import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DynamicID {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\browserDrivers\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--ignore-certificate-errors");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Properties prop = new Properties();

        try {
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\ToolsQA\\property\\Param.properties");
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


        driver.get(prop.getProperty("siteURL"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");

        WebElement elementsPage = driver.findElement(By.xpath("//h5[normalize-space()='Elements']"));
        elementsPage.click();

        driver.findElement(By.xpath("//ul/li/span[normalize-space()='Text Box']")).click();

        String str_name = "Rohit Prasad", str_email = "rohit@prasad.com", str_currentAddress = "Full Address Lines",
                str_permanentAddress="Permanent Address Lines";


        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys(str_name);
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys(str_email);
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(str_currentAddress);
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(str_permanentAddress);
        WebElement submitBtn = driver.findElement(By.id("submit"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        submitBtn.click();

        Thread.sleep(2000);

        WebElement nameResult = driver.findElement(By.id("name"));
        WebElement emailResult = driver.findElement(By.id("email"));
        WebElement currentAddressResult = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        WebElement permanentAddressResult = driver.findElement(By.xpath("//p[@id='permanentAddress']"));

        System.out.println(nameResult.getText());
        System.out.println(emailResult.getText());
        System.out.println(currentAddressResult.getText());
        System.out.println(permanentAddressResult.getText());

        Assert.assertEquals(str_name, nameResult.getText().split(":")[1]);
        Assert.assertEquals(str_email, emailResult.getText().split(":")[1]);
        Assert.assertEquals(str_currentAddress, currentAddressResult.getText().split(":")[1]);
        Assert.assertEquals(str_permanentAddress, permanentAddressResult.getText().split(":")[1]);

        driver.quit();
    }
}
