package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;
import utility.DoLogin;

import java.text.ParseException;

public class AddClientTest extends DoLogin {


    @Test
    public void addClientTest() throws ParseException {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName("Sonali");
        addClient.setClientSurname("Bhagat");
        addClient.setlanguage("Spanish");
        addClient.setClientAddress1("xyz");
        addClient.setClientAddress2("pqr");
        addClient.setClientCity("Pune");
        addClient.setClientState("Maharastra");
        addClient.setClientZip("787878");
        addClient.setCountry("Nepal");
        addClient.setGender("Female");
        addClient.setDate2("10/11/2011"); // MM/dd/yyyy
        addClient.setClientPhone("77878787");
        addClient.setClientFax("898989");
        addClient.setClientMobile("787878");
        addClient.setClientEmail("a@b.com");
        addClient.setClientWeb("www.xyz.com");
        addClient.setClientVat("898989");
        addClient.setClientTax("787878");

        addClient.clickSave();


    }
}
