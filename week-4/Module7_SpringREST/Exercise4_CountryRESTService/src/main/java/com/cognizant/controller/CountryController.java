package com.cognizant.controller;

import com.cognizant.model.Country;
import com.cognizant.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// REST Controller for Country - exposes endpoints for CRUD operations
// CRUD means Create Read Update Delete
@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    // HTTP GET - Read all countries. URL: GET /api/countries
    @GetMapping
    public List<Country> getAllCountries() {
        System.out.println("GET /api/countries called");
        return countryService.getAllCountries();
    }

    // HTTP GET - Read one country by ID. URL: GET /api/countries/1
    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        System.out.println("GET /api/countries/" + id + " called");
        Optional<Country> opt = countryService.getCountryById(id);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // HTTP GET - Read country by code. URL: GET /api/countries/code/IN
    @GetMapping("/code/{code}")
    public ResponseEntity<Country> getCountryByCode(@PathVariable String code) {
        System.out.println("GET /api/countries/code/" + code + " called");
        Optional<Country> opt = countryService.getCountryByCode(code);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // HTTP POST - Create new country. URL: POST /api/countries
    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        System.out.println("POST /api/countries called");
        Country created = countryService.createCountry(country);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // HTTP PUT - Update existing country. URL: PUT /api/countries/1
    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country country) {
        System.out.println("PUT /api/countries/" + id + " called");
        Optional<Country> updated = countryService.updateCountry(id, country);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // HTTP DELETE - Delete country. URL: DELETE /api/countries/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        System.out.println("DELETE /api/countries/" + id + " called");
        countryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
