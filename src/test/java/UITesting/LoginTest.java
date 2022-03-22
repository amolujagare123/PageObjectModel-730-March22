package UITesting;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import utility.OpenUrl;

public class LoginTest extends OpenUrl {

    Login login;

    @BeforeClass
    public void initLogin()
    {
        login = new Login(driver);
    }

    @Test
    public void txtUsernameVisibilityCheck()
    {
        boolean expected = true;
        boolean actual=true;
        try {
           actual = login.txtUsername.isDisplayed();//true
        }
        catch (Exception e)
        {
            actual = false;
        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,"username textbox is not available");
    }

    @Test
    public void btnLoginEnabilityChecck()
    {
        boolean expected = true;
        boolean actual = false;
        try {
             actual = login.btnLogin.isEnabled();
        }
        catch (Exception e)
        {

        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,"login button is not enabled");

    }

    @Test
    public void lblPasswordSpellCheck()
    {
        String expected = "Password";
        String actual="";
        try {
             actual = login.lblPassword.getText();
        }
        catch (Exception e)
        {

        }
        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,"password spelling is wrong");

    }


    @Test
    public void txtPasswordWatermarkCheck()
    {
        String expected = "Password";
        String actual="";
        try {
            actual = login.txtPassword.getAttribute("placeholder");
        }
        catch (Exception e)
        {

        }
        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,"wrong watermark");

    }

    @Test
    public void lblPasswordFontSizeCheck()
    {
        String expected = "14px";
        String actual = "";
        try {
             actual = login.lblPassword.getCssValue("font-size");
        }
        catch(Exception e)
        {

        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,"wrong font size");
    }
}
