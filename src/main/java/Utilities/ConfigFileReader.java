package Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath= System.getProperty("user.dir") + "/src/test/resources/App.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getDBUrl(){
        String url = properties.getProperty("dbUrl");
        if(url!= null) return url;
        else throw new RuntimeException("Database url not specified in the Configuration.properties file.");
    }

    public String getDBUsername(){
        String dbPassword = properties.getProperty("dbUsername");
        if(dbPassword!= null) return dbPassword;
        else throw new RuntimeException("Database username not specified in the Configuration.properties file.");
    }

    public String getDBPassword(){
        String dbUsername = properties.getProperty("dbPassword");
        if(dbUsername!= null) return dbUsername;
        else throw new RuntimeException("Database password not specified in the Configuration.properties file.");
    }


}
