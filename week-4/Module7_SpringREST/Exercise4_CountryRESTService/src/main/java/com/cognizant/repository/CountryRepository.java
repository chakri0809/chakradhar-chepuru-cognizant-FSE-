package com.cognizant.repository;

import com.cognizant.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// This interface gives us free CRUD methods - no need to write SQL!
// Spring Data JPA automatically creates the implementation for us
public interface CountryRepository extends JpaRepository<Country, Long> {

    // Spring automatically creates SQL: SELECT * FROM countries WHERE country_code = ?
    Optional<Country> findByCountryCode(String countryCode);
}
