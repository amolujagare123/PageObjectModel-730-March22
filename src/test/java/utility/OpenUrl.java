package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import static util.ConfigReader.getUrl;

public class OpenUrl {
    public static WebDriver driver;
    // static will make the driver copy same throughout the test execution
    // it means it will hold the instance of the browser throughout the test execution
    @BeforeClass
    public void openUrl() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getUrl());
    }
}
