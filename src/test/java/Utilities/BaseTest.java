package Utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static Utilities.CucumberReportGenerator.generateCucumberReport;


public class BaseTest {


    private static ChromeDriver driver;
   public static String appPath="D:\\eclipse_projects\\Automation_Framework\\src\\test\\resources\\application.properties";

    public static ChromeDriver getDriver() {
        return driver;
    }

    @Before()
    public void beforeFeature() {
        System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);


        Properties properties = new Properties();
        try (FileInputStream fileInput = new FileInputStream(appPath)) {
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }


        driver.get(properties.getProperty("URL"));
        driver.manage().deleteAllCookies();



    }

    @After()
    public void AfterFeature() {
        driver.quit();
        generateCucumberReport();


    }


}