package DatabaseTesting;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Menu;
import utility.DoLogin;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static utility.Conversion.getCountry;
import static utility.Conversion.getGender;
import static utility.DataProviderUtil.getMyDataXLSX;

public class AddClientTestDataProvider extends DoLogin {


    @Test(dataProvider = "myData")
    public void addClientTest(String name,String surname,String language,
                              String address1,String address2,String city,
                              String state,String zip,String country,
                              String gender,String date,String phone,
                              String fax,String mobile,String email,
                              String web,String vat,String tax) throws ParseException, ClassNotFoundException, SQLException {
        driver.navigate().refresh();
        Menu menu = new Menu(driver);
        menu.clickAddClient();


        ArrayList<String> expected = new ArrayList<>();
        expected.add(name);
        expected.add(surname);
        expected.add(language.toLowerCase());
        expected.add(address1);
        expected.add(address2);
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(country);
        expected.add(gender);
        expected.add(date);
        expected.add(phone);
        expected.add(fax);
        expected.add(mobile);
        expected.add(email);
        expected.add(web);
        expected.add(vat);
        expected.add(tax);
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

        Class.forName("com.mysql.cj.jdbc.Driver");

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/ip";

        Connection con = DriverManager.getConnection(url, user, pass);

        Statement st = con.createStatement();

        String sql = "SELECT * FROM ip_clients where client_name='" + name + "'";

        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

            actual.add(getCountry(rs.getString("client_country")));



            String genderId = rs.getString("client_gender");// 0,1,2
            String genderFull = getGender(genderId);
            actual.add(genderFull);


            actual.add(rs.getString("client_birthdate"));
            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        //   Assert.assertEquals(actual,expected);

    }

    @Test (dataProvider = "getData2")
    public void xyz()
    {

    }

    @DataProvider (name="myData")
    public Object[][] getData() throws IOException {

        return getMyDataXLSX("Data/MyData.xlsx","database testing");
    }



    public Object[][] getData2() throws IOException {

        return getMyDataXLSX("Data/MyData.xlsx","database testing");
    }

}
