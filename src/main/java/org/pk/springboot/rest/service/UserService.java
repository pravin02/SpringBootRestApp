package org.pk.springboot.rest.service;

import org.pk.springboot.rest.domian.User;
import org.pk.springboot.rest.dto.UserDto;
import org.pk.springboot.rest.exception.EmailNotExistsException;
import org.pk.springboot.rest.exception.LoginFailedException;
import org.pk.springboot.rest.exception.UserAlreadyExistsException;
import org.pk.springboot.rest.exception.UserNotFoundException;
import org.pk.springboot.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            return new UserDto(user);
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
    public User findByUserId(Integer userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        throw new UserNotFoundException("User Not found");

    }

    /**
     * @param user
     * @return
     */
    public User save(User user) throws UserAlreadyExistsException {
        Optional<User> userOptional = userRepository.findById(user.getUserId());
        if (userOptional.isPresent()) {
            User newUser = userOptional.get();
            user.setPassword(newUser.getPassword());
            user = userRepository.save(user);
            user.setPassword(null);
            return user;
        }
        throw new UserAlreadyExistsException("User already exist");
    }

    /**
     * @param userId
     * @param user
     * @return
     * @throws UserNotFoundException
     */
    public User update(Integer userId, User user) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User newUser = userOptional.get();
            user.setPassword(newUser.getPassword());
            user = userRepository.save(user);
            user.setPassword(null);
            return user;
        }
        throw new UserNotFoundException("User Not found");
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