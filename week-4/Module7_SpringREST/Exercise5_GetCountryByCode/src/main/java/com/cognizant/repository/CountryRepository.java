package com.cognizant.repository;

import com.cognizant.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repository to search countries from database
public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional<Country> findByCountryCode(String countryCode);

    // This method ignores uppercase/lowercase when searching for country code
    Optional<Country> findByCountryCodeIgnoreCase(String countryCode);
}
