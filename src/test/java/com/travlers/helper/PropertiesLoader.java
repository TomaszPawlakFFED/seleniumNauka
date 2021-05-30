package com.travlers.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private Logger logger = LogManager.getLogger(PropertiesLoader.class);

    //W klasie znajduje sie tylko jedna metoda. Służy ona do odczytyania właściowości z zadanego pliku properties
    public Properties getPropertiesFromFile(String propertiesFileName){

        //Tworzymy obiekt InputStream, który posłuzy nam do odczytwania pliku properties
        InputStream inputStream = null;

        //Obiekt Propeteis będzie przechowywał wałściwość
        Properties properties = new Properties();
        try {
            logger.info("Trying to load properties with file name:" + propertiesFileName);

            //Odczytujemy plik propeties i nicjalizujemy obiekt inputStream
            inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);

            //Jeśli plik properties by nie istniał, obiekt inputSteam będzie nullem. W ziwązku z czym
            // zostanie wyrzucony wyjątek FilenotFoundException
            if(inputStream != null){
                //Ładujemy properties w formie InputStream do właściwego obiektu typu Propertiees
                properties.load(inputStream);
                logger.info("Successfully loaded properties for file:" + propertiesFileName);
            } else {
                throw new FileNotFoundException("Property file" + propertiesFileName + "not found in the classpath" );
            }



        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot load properties due to IOException!");
        } finally {
            // Na sam koniec zamykamy INputStream wywołując prywatna metodę cloeResorce
            closeResource(inputStream);
        }

        return properties;
    }

    private void closeResource(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
