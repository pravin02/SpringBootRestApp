package org.pk.springboot.rest.service;

import java.util.List;
import java.util.Optional;

import org.pk.springboot.rest.domian.User;
import org.pk.springboot.rest.domian.UserRole;
import org.pk.springboot.rest.exception.EmployeeNotFoundException;
import org.pk.springboot.rest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pravin P Patil
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * @param userRole
     * @return
     * @throws EmployeeNotFoundException
     */
    public List<User> findByUserRole(String userRole) throws EmployeeNotFoundException {
        List<User> users = employeeRepository.findByRole(UserRole.getUserRole(userRole));
        if (users != null && !users.isEmpty())
            return users;
        throw new EmployeeNotFoundException("Employees not found");

    }

    /**
     * @param empId
     * @return
     * @throws EmployeeNotFoundException
     */
    public User findByUserId(Integer empId) throws EmployeeNotFoundException {
        Optional<User> user = employeeRepository.findById(empId);
        if (user.isPresent()) {
            return user.get();
        }
        throw new EmployeeNotFoundException("Employee not found");
    }
}
