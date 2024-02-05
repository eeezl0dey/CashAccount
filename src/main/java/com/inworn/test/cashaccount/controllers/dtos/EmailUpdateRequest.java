package com.inworn.test.cashaccount.controllers.dtos;

import javax.validation.constraints.Email;

public class EmailUpdateRequest {

    @Email
    private String oldEmail;
    @Email
    private String newEmail;

    public String getOldEmail() {
        return oldEmail;
    }

    public void setOldEmail(String oldEmail) {
        this.oldEmail = oldEmail;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}
