package com.midwesttape.project.challengeapplication.service;

import com.midwesttape.project.challengeapplication.model.Address;
import com.midwesttape.project.challengeapplication.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JdbcTemplate template;

    public User user(final Long userId) {
        try {

            return template.queryForObject(
                "select " +
                    "id, " +
                    "firstName, " +
                    "lastName, " +
                    "username, " +
                    "password " +
                    "from User " +
                    "where id = ?",
                new BeanPropertyRowMapper<>(User.class),
                userId
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    /**
     *
     * @param userId input
     * @return Address of the user
     */
    public Address getAddressByUserId(Long userId){
       try{
           return template.queryForObject(
               "select " +
                   "a.*" +
                   " from Address a INNER JOIN User u ON u.addressId=a.id" +
                   " where u.id = ?",
               new BeanPropertyRowMapper<>(Address.class),userId
           );
       } catch (EmptyResultDataAccessException e) {
           return null;
       }
    }

    /**
     *
     * @param user input
     * @return if updated 1 not 0
     */
    public int updateUser(User user){
        try{
            return template.update(
                "UPDATE USER set firstName = ?, lastName =? where id =?", user.getFirstName(),user.getLastName(),user.getId());
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }

    }

}
