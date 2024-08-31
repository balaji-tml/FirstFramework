package com.bit.CucumberPOMSeries.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    /*
     *
     * This is used to load the Properties from config.properties file
     * @param path
     * @return Properties prop object
     */
    public Properties init_properties(String path)
    {
        try
        {
            prop = new Properties();

                FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/config.properties");
//            FileInputStream fis = new FileInputStream(path);
            prop.load(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }//end init_properties
}

