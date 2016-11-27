package by.dorohovich.site.resource;

import java.util.ResourceBundle;

/**
 * Created by User on 26.11.2016.
 */
public class ConfigurationManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.config");

    private ConfigurationManager() { }
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
