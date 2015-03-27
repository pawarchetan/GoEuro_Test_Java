package com.goeuro.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by sony on 3/22/2015.
 */
public class PropertiesLoader {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("application.properties"));
        } catch (IOException e) {
            logger.error("An error occurred while loading application properties!");
            e.printStackTrace();
        }
    }

    public static String getURL() {
        StringBuilder stringBuilder = new StringBuilder();
        String url = properties.getProperty("url");
        stringBuilder.append(url);
        if (url.endsWith("/")) {
            return stringBuilder.toString();
        } else {
            return stringBuilder.append("/").toString();
        }
    }
}
