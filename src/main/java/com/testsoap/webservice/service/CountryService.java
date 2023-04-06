package com.testsoap.webservice.service;

import io.gigaforce.testsoap.webservice.Country;
import io.gigaforce.testsoap.webservice.Currency;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CountryService {

    private static final Map<String, Country> countryMap = new HashMap<>();

    public Country find (String code) {
        /**
         * country 1
         */
        Country country1 = new Country();
        country1.setName("Russia");
        country1.setCurrency(Currency.EUR);
        country1.setCapital("MOSCOW");
        country1.setPopulation(281546982);
        countryMap.put("Russia", country1);

        /**
         * country 2
         */
        Country country2 = new Country();
        country2.setName("India");
        country2.setCurrency(Currency.EUR);
        country2.setCapital("New Delhi");
        country2.setPopulation(38521456);
        countryMap.put("India", country2);

        /**
         * Getting the data
         */
        return countryMap.get(code);
    }
}
