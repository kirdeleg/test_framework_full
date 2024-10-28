package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties = new Properties();

    static {
        String env = System.getProperty("env");
        if (env == null) {
            env = System.getenv("ENV");
        }
        if (env == null) {
            env = "dev";
        }
        try {
            System.out.println("Using configs for env: " + env);
            FileInputStream fis = new FileInputStream("src/test/resources/config-" + env + ".properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Unable to use config file for env: " + env, e);
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value != null) {
            return value;
        } else {
            throw new RuntimeException("Key '" + key + "' was not found in config file");
        }
    }

    public static void main(String[] args) {
        System.out.println(ConfigLoader.getProperty("base.url"));
    }
}