package utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static String getGender(String dbGender)
    {
        String genderFullForm="";

        switch (dbGender)
        {
            case "0" : genderFullForm = "Male";break;
            case "1" : genderFullForm = "Female";break;
            case "2" : genderFullForm = "Other";break;
        }
        return  genderFullForm;
    }


    public static String getCountry(String countyShort) // IN ,AU
    {
        String countryFullForm="";

        switch (countyShort)
        {
            case "IN" : countryFullForm="India";break;
            case "AR" : countryFullForm="Argentina";break;
            case "BR" : countryFullForm="Brazil";break;
            case "CZ" : countryFullForm="Czech Republic";break;
            case "DE" : countryFullForm="Germany";break;
            case "IQ" : countryFullForm="Iraq";break;
        }

        return countryFullForm;
    }

    public static String convertDate(String dbDate) throws ParseException // yyyy-dd-MM
    {
        // 1. convert string to date --> parse  // yyyy-dd-MM

        Date date = new SimpleDateFormat("yyyy-dd-MM").parse(dbDate);

        // 2. convert Date to String --> format  // dd/MM/yyyy

       return new SimpleDateFormat("dd/MM/yyyy").format(date);

    }

}
