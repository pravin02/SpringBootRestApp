package org.pk.springboot.rest.repository;

import org.pk.springboot.rest.domian.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pravin P Patil
 *
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
