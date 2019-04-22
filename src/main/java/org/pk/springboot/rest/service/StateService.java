package org.pk.springboot.rest.service;

import java.util.List;

import org.pk.springboot.rest.domian.Country;
import org.pk.springboot.rest.domian.State;
import org.pk.springboot.rest.exception.StateNotFoundException;
import org.pk.springboot.rest.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pravin P Patil
 *
 */
@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;

	/**
	 * @param countryId
	 * @return will return list of states otherwise throw StateNotFoundException
	 * @throws StateNotFoundException
	 */
	public List<State> findByCountryId(int countryId) throws StateNotFoundException {

		Country country = new Country();
		country.setCountryId(countryId);
		List<State> states = stateRepository.findByCountry(country);
		if (states != null && !states.isEmpty())
			return states;
		throw new StateNotFoundException("states not found");
	}
}