package org.pk.springboot.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pk.springboot.rest.domian.City;
import org.pk.springboot.rest.domian.Company;
import org.pk.springboot.rest.domian.User;
import org.pk.springboot.rest.domian.UserRole;

import java.io.Serializable;

/**
 * @author Pravin P Patil
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private int userId;
    private String fullName;
    private String email;
    private String password;
    private UserRole role;
    private String address;
    private String mobileNumber;
    private City city;
    private Company company;

    public UserDto(User user) {
        this.setUserId(user.getUserId());
        this.setFullName(user.getFullName());
        this.setEmail(user.getEmail());
        this.setRole(user.getRole());
        this.setAddress(user.getAddress());
        this.setMobileNumber(user.getMobileNumber());
        this.setCity(user.getCity());
        this.setCompany(user.getCompany());
    }
}
