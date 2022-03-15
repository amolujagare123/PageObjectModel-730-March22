package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) throws IOException {

        // 1. read the file
        FileInputStream fileInputStream = new FileInputStream("Config/config.properties");

        //2. create the object of the properties class
        Properties prop = new Properties();

        // 3. load the file object with properties object
        prop.load(fileInputStream);

        //4. read the value of the key using loaded properties object

        String myurl = prop.getProperty("url");

        System.out.println("URL="+myurl);

        System.out.println("Username="+prop.getProperty("username"));

        System.out.println("Password="+prop.getProperty("password"));

    }
}
