package org.pk.springboot.rest.repository;

import javax.transaction.Transactional;

import org.pk.springboot.rest.domian.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Pravin P Patil
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * @param email
     * @param password
     * @return
     */
    User findByEmailAndPassword(String email, String password);

    /**
     * @param email
     * @return
     */
    User findByEmail(String email);

    /**
     * @param userId
     * @param newPassword
     * @return
     */
    @Transactional
    @Modifying
    @Query("UPDATE User u set u.password = :password where u.userId = :userId")
    int updatePassword(@Param("userId") int userId, @Param("password") String newPassword);
}
