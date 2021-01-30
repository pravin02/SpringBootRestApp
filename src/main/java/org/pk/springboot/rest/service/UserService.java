package org.pk.springboot.rest.service;

import org.pk.springboot.rest.domian.User;
import org.pk.springboot.rest.dto.UserDto;
import org.pk.springboot.rest.exception.EmailNotExistsException;
import org.pk.springboot.rest.exception.LoginFailedException;
import org.pk.springboot.rest.exception.UserNotFoundException;
import org.pk.springboot.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pravin P Patil
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * @param email
     * @param password
     * @return
     * @throws LoginFailedException
     */
    public UserDto findByEmailAndPassword(String email, String password) throws LoginFailedException {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            UserDto userDto = new UserDto(user);
            if (userDto != null) {
                return userDto;
            }
        }
        throw new LoginFailedException("Invalid Email or Password");
    }

    /**
     * @param email
     * @return
     * @throws EmailNotExistsException
     */
    public User findByEmail(String email) throws EmailNotExistsException {
        User user = userRepository.findByEmail(email);
        if (user == null)
            throw new EmailNotExistsException("Email not found in system");
        return user;
    }

    /**
     * @param userId
     * @return
     * @throws UserNotFoundException
     */
    public User findByUserId(int userId) throws UserNotFoundException {
        User user = userRepository.findOne(userId);
        if (user == null)
            throw new UserNotFoundException("User Not found");
        return user;
    }

    /**
     * @param user
     * @return
     */
    public User save(User user) {
        user.setPassword(userRepository.findOne(user.getUserId()).getPassword());
        user = userRepository.save(user);
        user.setPassword(null);
        return user;
    }

    /**
     * @param userId
     * @param newPassword
     * @return
     */
    public boolean updatePassword(int userId, String newPassword) {
        return userRepository.updatePassword(userId, newPassword) > 0;
    }

}