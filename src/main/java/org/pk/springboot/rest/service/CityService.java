package org.pk.springboot.rest.service;

import java.util.List;

import org.pk.springboot.rest.domian.City;
import org.pk.springboot.rest.domian.State;
import org.pk.springboot.rest.exception.CityNotFoundException;
import org.pk.springboot.rest.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pravin P Patil
 *
 */
@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;

	/**
	 * 
	 * @param stateId
	 * @return list of cities if found other wise will throw
	 *         CityNotFoundException
	 * @throws CityNotFoundException
	 */
	public List<City> findByStateId(int stateId) throws CityNotFoundException {
		State state = new State();
		state.setStateId(stateId);
		List<City> cities = cityRepository.findByState(state);
		if (cities != null && !cities.isEmpty())
			return cities;
		throw new CityNotFoundException("Cities not found");

	}
}