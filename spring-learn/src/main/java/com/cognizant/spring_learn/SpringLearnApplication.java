package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args)
	{
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("SpringLearnApplication main() executed successfully!");
		displayDate();
		displayCountry();
		displaySingletonVsPrototype();
		displayCountries();
	}
	public static void displayDate(){
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try{
			Date date = format.parse("31/12/2018");
			System.out.println("parsed Date: "+date);
			LOGGER.debug("Parsed Date: {}", date);
		}
		catch(Exception e){
			LOGGER.error("Error parsing date", e);
		}
		LOGGER.info("END");
	}
	public static void displayCountry() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);

		LOGGER.debug("Country : {}", country.toString());

		LOGGER.info("END");
	}
	public static void displaySingletonVsPrototype() {
		LOGGER.info("START displaySingletonVsPrototype");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		// Singleton scope
		Country country1 = context.getBean("country", Country.class);
		Country country2 = context.getBean("country", Country.class);
		LOGGER.debug("Singleton Country 1 : {}", country1.toString());
		LOGGER.debug("Singleton Country 2 : {}", country2.toString());

		// Prototype scope
		Country proto1 = context.getBean("prototypeCountry", Country.class);
		Country proto2 = context.getBean("prototypeCountry", Country.class);
		LOGGER.debug("Prototype Country 1 : {}", proto1.toString());
		LOGGER.debug("Prototype Country 2 : {}", proto2.toString());

		LOGGER.info("END displaySingletonVsPrototype");
	}
	public static void displayCountries() {
		LOGGER.info("START displayCountries");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		@SuppressWarnings("unchecked")
		List<Country> countries = (List<Country>) context.getBean("countryList", java.util.List.class);

		for (Country country : countries) {
			LOGGER.debug("Country : {}", country.toString());
		}

		LOGGER.info("END displayCountries");
	}



}
