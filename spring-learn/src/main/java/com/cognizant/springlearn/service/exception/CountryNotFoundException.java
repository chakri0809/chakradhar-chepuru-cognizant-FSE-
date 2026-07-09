package com.cognizant.springlearn.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Doc 2 - "REST - Get country exceptional scenario":
 * thrown by CountryService when the requested code isn't in country.xml.
 * @ResponseStatus makes Spring translate this into an HTTP 404 automatically.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")
public class CountryNotFoundException extends Exception {

    public CountryNotFoundException(String message) {
        super(message);
    }
}
