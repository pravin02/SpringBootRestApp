package org.pk.springboot.rest.repository;

import java.util.List;

import org.pk.springboot.rest.domian.Country;
import org.pk.springboot.rest.domian.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pravin P Patil
 */
@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

    /**
     * @param country country obj
     * @return list of states if found otherwise null
     */
    List<State> findAllByCountry(Country country);

}