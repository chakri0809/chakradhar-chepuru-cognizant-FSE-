package com.cognizant.model;

// This is a simple Country class - it holds country information
public class Country {

    // Name of the country
    private String countryName;

    // ISO code of the country like IN, US
    private String countryCode;

    // Capital city name
    private String capital;

    // Population as a long number
    private long population;

    // Empty constructor needed by Spring to create objects
    public Country() {
    }

    // Getter and setter for countryName
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    // Getter and setter for countryCode
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    // Getter and setter for capital
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    // Getter and setter for population
    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    // Simple toString for logging and debugging
    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                '}';
    }
}
