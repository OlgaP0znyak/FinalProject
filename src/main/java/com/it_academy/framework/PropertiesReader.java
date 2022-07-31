package com.it_academy.framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final String ENDPOINTS_FILE = "/endpoints.properties";
    private static final Properties ENDPOINTS_PROPERTIES = new Properties();

    static {
        initProperties();
    }

    public static String getEndpointProperty(String property) {
        return ENDPOINTS_PROPERTIES.getProperty(property);
    }

    private static synchronized void initProperties() {
        try (InputStream inputStream = PropertiesReader.class.getResourceAsStream(PropertiesReader.ENDPOINTS_FILE)) {
            PropertiesReader.ENDPOINTS_PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to load properties from file: " + PropertiesReader.ENDPOINTS_FILE);
        }
    }
}
