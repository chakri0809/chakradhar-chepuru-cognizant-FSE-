package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Doc 1 - Hands on 1: entry point created via https://start.spring.io.
 * The three display*() methods below are the Spring-Core XML-config hands-on
 * exercises (Hands on 2, 4, 5, 6); they run once at startup so you can see
 * the results in the console log without needing a REST call.
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START");
        SpringApplication.run(SpringLearnApplication.class, args);

        SpringLearnApplication app = new SpringLearnApplication();
        app.displayDate();
        app.displayCountry();
        app.displayCountries();
        LOGGER.info("END");
    }

    /**
     * Doc 1 - Hands on 2: "Spring Core – Load SimpleDateFormat from Spring Configuration XML"
     */
    public void displayDate() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug(date.toString());
        } catch (ParseException e) {
            LOGGER.debug("Unable to parse date", e);
        }
        LOGGER.info("END");
    }

    /**
     * Doc 1 - Hands on 4 & 5: "Spring Core – Load Country from Spring Configuration XML"
     * + singleton scope demonstration (constructor is invoked only once for two getBean() calls).
     */
    public void displayCountry() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        Country anotherCountry = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString());
        LOGGER.debug("Same instance (singleton scope)? {}", country == anotherCountry);
        LOGGER.info("END");
    }

    /**
     * Doc 1 - Hands on 6: "Spring Core – Load list of countries from Spring Configuration XML"
     */
    @SuppressWarnings("unchecked")
    public void displayCountries() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = (List<Country>) context.getBean("countryList", ArrayList.class);
        LOGGER.debug("Countries : {}", countries);
        LOGGER.info("END");
    }
}
