package org.pk.springboot.rest.service;

import java.util.List;

import org.pk.springboot.rest.domian.State;
import org.pk.springboot.rest.exception.StateNotFoundException;
import org.pk.springboot.rest.repository.CountryRepository;
import org.pk.springboot.rest.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pravin P Patil
 */
@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;

    /**
     * @param countryId country id
     * @return will return list of states otherwise throw StateNotFoundException
     * @throws StateNotFoundException if 0 states returned by state repository then throwing this exception
     */
    public List<State> findByCountryId(int countryId) throws StateNotFoundException {
        List<State> states = stateRepository.findAllByCountry(countryRepository.getOne(countryId));
        if (states != null && !states.isEmpty())
            return states;
        throw new StateNotFoundException("states not found");
    }
}