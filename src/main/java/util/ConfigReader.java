package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    static Properties getLoadedPropertiesObject() throws IOException {
        // 1. read the file
        FileInputStream fileInputStream = new FileInputStream("Config/config.properties");

        //2. create the object of the properties class
         Properties prop = new Properties();

        // 3. load the file object with properties object
        prop.load(fileInputStream);

        return prop;
    }

    public static String getUrl() throws IOException {
        return getLoadedPropertiesObject().getProperty("url");
    }

    public static String getUsername() throws IOException {
        return  getLoadedPropertiesObject().getProperty("username");
    }

    public static String getPassword() throws IOException {
        return  getLoadedPropertiesObject().getProperty("password");
    }
}
