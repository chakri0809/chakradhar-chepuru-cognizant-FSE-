package com.cognizant.service;

import com.cognizant.model.Country;
import com.cognizant.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

// This is the MAIN exercise - Get country based on country code
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Initialize sample data when application starts
    @PostConstruct
    public void initData() {
        countryRepository.save(new Country("IN", "India", "New Delhi", 1400000000L));
        countryRepository.save(new Country("US", "United States", "Washington DC", 331000000L));
        countryRepository.save(new Country("GB", "United Kingdom", "London", 67000000L));
        countryRepository.save(new Country("JP", "Japan", "Tokyo", 125000000L));
        countryRepository.save(new Country("AU", "Australia", "Canberra", 25000000L));
        countryRepository.save(new Country("CA", "Canada", "Ottawa", 38000000L));
    }

    // === MANDATORY HANDS-ON: REST - Get country based on country code ===
    // Step 1: Print what we are searching for
    // Step 2: Search in database ignoring uppercase lowercase
    // Step 3: Check if country was found
    public Country getCountryByCode(String code) {
        System.out.println("Searching for country with code: " + code);
        Optional<Country> opt = countryRepository.findByCountryCodeIgnoreCase(code);
        if (opt.isPresent()) {
            Country found = opt.get();
            System.out.println("Found country: " + found.getCountryName());
            return found;
        } else {
            System.out.println("Country not found with code: " + code);
            throw new RuntimeException("Country not found with code: " + code);
        }
    }

    // Return all countries
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // Save new country
    public Country addCountry(Country c) {
        return countryRepository.save(c);
    }
}
