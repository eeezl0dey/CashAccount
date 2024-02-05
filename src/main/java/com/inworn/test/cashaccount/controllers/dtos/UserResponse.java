package com.inworn.test.cashaccount.controllers.dtos;

import com.inworn.test.cashaccount.entities.Account;
import com.inworn.test.cashaccount.entities.EmailData;
import com.inworn.test.cashaccount.entities.PhoneData;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

public class UserResponse {
    private Long id;
    private String name;
    private Date dateOfBirth;

    public UserResponse(Long id, String name, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
