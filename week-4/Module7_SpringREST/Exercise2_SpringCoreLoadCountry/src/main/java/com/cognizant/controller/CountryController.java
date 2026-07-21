package com.cognizant.controller;

import com.cognizant.model.Country;
import com.cognizant.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// This controller exposes REST endpoints for Country data loaded from XML
@RestController
@RequestMapping("/api")
public class CountryController {

    // Service that loads countries from XML
    @Autowired
    private CountryService countryService;

    // This endpoint returns all countries loaded from country.xml
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        System.out.println("Loading all countries from XML...");
        return countryService.getAllCountriesFromXML();
    }

    // This endpoint finds a country by its code like IN, US, UK
    @GetMapping("/countries/{code}")
    public Object getCountryByCode(@PathVariable String code) {
        System.out.println("Searching for country with code: " + code);
        List<Country> countries = countryService.getAllCountriesFromXML();
        for (Country c : countries) {
            if (c.getCountryCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return "Country not found with code: " + code;
    }
}
