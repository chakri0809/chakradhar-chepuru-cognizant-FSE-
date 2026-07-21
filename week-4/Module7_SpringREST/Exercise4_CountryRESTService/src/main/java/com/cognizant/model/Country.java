package com.cognizant.model;

import jakarta.persistence.*;

// This is our Country entity - @Entity means this class maps to a database table
@Entity
@Table(name = "countries")
public class Country {

    // @Id @GeneratedValue - id is primary key and generated automatically
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Country code like IN, US
    private String countryCode;

    // Full country name
    private String countryName;

    // Capital city
    private String capital;

    // Population as long
    private Long population;

    // No-arg constructor required by JPA
    public Country() {
    }

    // Constructor without id for easy creation
    public Country(String countryCode, String countryName, String capital, Long population) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.capital = capital;
        this.population = population;
    }

    // Getters and setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                '}';
    }
}
