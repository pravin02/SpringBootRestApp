package org.pk.springboot.rest.service;

import java.util.List;

import org.pk.springboot.rest.domian.Country;
import org.pk.springboot.rest.exception.CountryNotFoundException;
import org.pk.springboot.rest.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pravin P Patil
 */
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    /**
     * @return list of countries otherwise will throw CountryNotFoundException
     * @throws CountryNotFoundException
     */
    public List<Country> findAll() throws CountryNotFoundException {
        List<Country> countries = countryRepository.findAll();
        if (!countries.isEmpty()) {
            return countries;
        }
        throw new CountryNotFoundException("No Countries not found");
    }
}