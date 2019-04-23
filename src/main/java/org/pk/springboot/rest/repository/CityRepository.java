package org.pk.springboot.rest.repository;

import java.util.List;

import org.pk.springboot.rest.domian.City;
import org.pk.springboot.rest.domian.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pravin P Patil
 *
 */
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

	/**
	 * @param state
	 * @return list of cities if found by state otherwise will return null
	 */
	public List<City> findByState(State state);
}
