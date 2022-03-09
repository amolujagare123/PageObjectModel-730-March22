package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

   /* WebDriver driver;
    WebElement txtEmail = driver.findElement(By.xpath("//input[@id='email']"));*/

    @FindBy (xpath="//input[@id='email']")
    WebElement txtUsername;

    @FindBy (xpath="//input[@id='password']")
    WebElement txtPassword;

    @FindBy (xpath = "//button[normalize-space()='Login']")
    WebElement btnLogin;

    @FindBy(xpath = "//a[normalize-space()='I forgot my password']")
    WebElement lnkForgotPassword;

    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void clickForgotPassword()
    {
        lnkForgotPassword.click();
    }

    public void setTxtUsername(String username)
    {
        txtUsername.sendKeys(username);
    }

    public void setTxtPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void clickLogin()
    {
        btnLogin.click();
    }
}
