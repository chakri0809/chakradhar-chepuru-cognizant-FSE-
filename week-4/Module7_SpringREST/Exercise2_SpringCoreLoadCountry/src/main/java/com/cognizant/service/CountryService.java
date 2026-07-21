package com.cognizant.service;

import com.cognizant.model.Country;
import org.springframework.stereotype.Service;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

// This service loads Country objects from our country.xml file using Spring
@Service
public class CountryService {

    // We use ClassPathXmlApplicationContext to read the country.xml file
    public List<Country> getAllCountriesFromXML() {
        // Create the context that reads beans from resources/country.xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        // We get each country bean by its id from xml
        Country india = (Country) context.getBean("india");
        Country usa = (Country) context.getBean("usa");
        Country uk = (Country) context.getBean("uk");
        Country japan = (Country) context.getBean("japan");
        Country australia = (Country) context.getBean("australia");

        // Add them to a list to return
        List<Country> list = new ArrayList<>();
        list.add(india);
        list.add(usa);
        list.add(uk);
        list.add(japan);
        list.add(australia);

        // Always close context to free memory
        context.close();

        System.out.println("Successfully loaded countries from XML: " + list.size());
        return list;
    }
}
