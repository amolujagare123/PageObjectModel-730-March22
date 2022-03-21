package utility;

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
}
