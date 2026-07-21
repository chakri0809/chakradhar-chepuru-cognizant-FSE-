package com.cognizant.service;

import com.cognizant.model.Country;
import com.cognizant.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

// Service class contains business logic for Country operations
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // This runs when app starts - adds sample countries to database
    @PostConstruct
    public void initData() {
        countryRepository.save(new Country("IN", "India", "New Delhi", 1400000000L));
        countryRepository.save(new Country("US", "United States", "Washington DC", 331000000L));
        countryRepository.save(new Country("GB", "United Kingdom", "London", 67000000L));
        countryRepository.save(new Country("JP", "Japan", "Tokyo", 125000000L));
        countryRepository.save(new Country("AU", "Australia", "Canberra", 25000000L));
    }

    // Get all countries from database
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // Get one country by its ID number
    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }

    // Get country by code like IN or US
    public Optional<Country> getCountryByCode(String code) {
        return countryRepository.findByCountryCode(code);
    }

    // Save a new country to database
    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    // Update existing country details
    public Optional<Country> updateCountry(Long id, Country country) {
        return countryRepository.findById(id).map(existing -> {
            existing.setCountryCode(country.getCountryCode());
            existing.setCountryName(country.getCountryName());
            existing.setCapital(country.getCapital());
            existing.setPopulation(country.getPopulation());
            return countryRepository.save(existing);
        });
    }

    // Remove a country from database
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
