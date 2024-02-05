package com.inworn.test.cashaccount.controllers.dtos;

import javax.validation.constraints.Email;

public class EmailActionRequest {
    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
