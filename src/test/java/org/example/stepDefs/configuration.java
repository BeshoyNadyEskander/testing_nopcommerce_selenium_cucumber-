package org.example.stepDefs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class configuration {


    public static void set(String key ,String value)  {
        try {
        // create object from properties
        Properties   prop = new Properties();
        // create FileInputStream and put name of config file
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            prop.load(fis);

            prop.setProperty(key, value);
            fis.close();

            FileOutputStream fos = new FileOutputStream("src/main/resources/config.properties");
            prop.store(fos,"");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static String get(String key)
    {
        String value;
        try {
            // create object from properties
            Properties   prop = new Properties();
            // create FileInputStream and put name of config file
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            prop.load(fis);

            // take attention we use getproperty
            value = prop.getProperty(key);
            fis.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return value;


    }
}
