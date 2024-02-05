package com.inworn.test.cashaccount.services;


import com.inworn.test.cashaccount.controllers.dtos.UserResponse;
import com.inworn.test.cashaccount.dao.UserRepository;
import com.inworn.test.cashaccount.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<UserResponse> getUsers(Long dateOfBirthTimestamp, String phone, String name, String email, Pageable pageable)
    {
        Date dateOfBirth = null;
        if (dateOfBirthTimestamp != null) {
            dateOfBirth = new Date(dateOfBirthTimestamp);
        }

        String username = null;
        if (name != null) {
            username = name + "%";
        }

        Page<User> users = userRepository.getUsersByDateAndPhoneAndNameAndEmail(dateOfBirth, phone, username, email, pageable);
        return  users.map(user -> new UserResponse(user.getId(), user.getName(), user.getDateOfBirth()));
    }

}
