package JavaVkClient.Config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    public static ConfigReader instance;
    String result = "";
    String access_token;
    InputStream inputStream;

    private ConfigReader() throws IOException {
        getPropValues();
    }

    public static ConfigReader getInstance() throws IOException {
        if (instance == null) {
            instance = new ConfigReader();

        }
        return instance;
    }

    public String getToken() {
        return access_token;
    }

    public String getPropValues() throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);


            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            System.out.println(prop.getProperty("access_token"));
            access_token = prop.getProperty("access_token");

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            inputStream.close();
        }
        return result;
    }
}
