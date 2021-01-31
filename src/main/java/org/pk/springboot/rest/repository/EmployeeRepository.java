package org.pk.springboot.rest.repository;

import java.util.List;

import org.pk.springboot.rest.domian.User;
import org.pk.springboot.rest.domian.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pravin P Patil
 */
@Repository
public interface EmployeeRepository extends JpaRepository<User, Integer> {

    /**
     * @param userRole
     * @return
     */
    List<User> findByRole(UserRole userRole);
}
