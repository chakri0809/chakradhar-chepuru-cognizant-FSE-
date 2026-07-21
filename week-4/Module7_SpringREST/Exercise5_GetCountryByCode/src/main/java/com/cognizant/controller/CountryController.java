package com.cognizant.controller;

import com.cognizant.model.Country;
import com.cognizant.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Exercise 5 Controller - This is specifically for getting country by country code
@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private CountryService countryService;

    // Get all countries - for testing purposes
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    // === THIS IS THE MAIN MANDATORY ENDPOINT ===
    // This endpoint gets a country when you provide its code
    // Example: GET /api/countries/IN returns India
    // Example: GET /api/countries/US returns United States
    @GetMapping("/countries/{code}")
    public ResponseEntity<?> getCountryByCode(@PathVariable String code) {
        System.out.println("=== Get Country by Code endpoint called with code: " + code + " ===");
        try {
            Country c = countryService.getCountryByCode(code);
            return new ResponseEntity<>(c, HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>("Country not found: " + code, HttpStatus.NOT_FOUND);
        }
    }

    // Add new country for testing
    @PostMapping("/countries")
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        Country saved = countryService.addCountry(country);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
