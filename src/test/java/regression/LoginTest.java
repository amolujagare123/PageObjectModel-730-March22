package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Login;
import utility.OpenUrl;

import java.io.IOException;

import static util.ConfigReader.*;

public class LoginTest extends OpenUrl {

    @Test
    public void loginTest() throws IOException {

        Login login = new Login(driver);

        login.setTxtUsername(getUsername());
        login.setTxtPassword(getPassword());
        login.clickLogin();
    }
}
