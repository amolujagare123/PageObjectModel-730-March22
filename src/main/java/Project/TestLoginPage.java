package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestLoginPage {

    @Test
    public void loginTest()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://[::1]/ip/index.php/sessions/login");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("amolujagare@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }
}
