package regression;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Menu;
import utility.DoLogin;

import java.io.IOException;
import java.text.ParseException;

import static utility.DataProviderUtil.getMyDataXLSX;

public class AddClientTestDataProvider extends DoLogin {


    @Test(dataProvider = "getData")
    public void addClientTest(String name,String surname,String language,
                              String address1,String address2,String city,
                              String state,String zip,String country,
                              String gender,String date,String phone,
                              String fax,String mobile,String email,
                              String web,String vat,String tax) throws ParseException {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName(name);
        addClient.setClientSurname(surname);
        addClient.setlanguage(language);
        addClient.setClientAddress1(address1);
        addClient.setClientAddress2(address2);
        addClient.setClientCity(city);
        addClient.setClientState(state);
        addClient.setClientZip(zip);
        addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.setDate2(date); // MM/dd/yyyy
        addClient.setClientPhone(phone);
        addClient.setClientFax(fax);
        addClient.setClientMobile(mobile);
        addClient.setClientEmail(email);
        addClient.setClientWeb(web);
        addClient.setClientVat(vat);
        addClient.setClientTax(tax);

        addClient.clickSave();


    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return getMyDataXLSX("Data/MyData.xlsx","add client");
    }

}
