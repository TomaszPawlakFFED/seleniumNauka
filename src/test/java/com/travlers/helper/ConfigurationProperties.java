package com.travlers.helper;

import java.util.Properties;

public class ConfigurationProperties {
    //Statyczne pole do przechowywania properties
    private static Properties properties;

    //Konstrukotr prywatny potrzebny do posiadania tylko jednej instancji klasy configurationPropeties
    //Wzorec singelton

    private ConfigurationProperties() {

    }

    //Metoda służy do załadowania obiketu properties do statycznego obiektu typu Properties, dostepnego dla wszystkich
    // wątków

    public static void  setProperties(Properties properties){
        ConfigurationProperties.properties = properties;
    }

    //Metoda zwraca nam wszystkie załadowane properties, jeśli nie są one nullem
    public static Properties getProperties(){
        if(properties == null){
            throw  new IllegalStateException("Please set properties using setProperties() before calling get Properties");
        }
        return properties;
    }
}
