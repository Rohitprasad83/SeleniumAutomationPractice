package com.ToolsQA.testsuitebase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SuiteBase {
    public static WebDriver driver;
    public static JavascriptExecutor js;
    public static WebDriverWait wait;
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\browserDrivers\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
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
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
