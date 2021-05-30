package com.travlers.helper;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import javax.security.auth.login.Configuration;

public class PropertyLoader {
    public static PropertiesConfiguration loadProperties() throws ConfigurationException {
        Configurations configs = new Configurations();
        return configs.properties("/Users/tomaszpawlak/IdeaProjects/tutorialselenium/src/main/resources/test.properties");

    }

    public static void main(String[] args) throws ConfigurationException {
        PropertiesConfiguration config = loadProperties();
        System.out.println(config.getBoolean("isDev"));
        System.out.println(config.getString("driver"));
    }
}
