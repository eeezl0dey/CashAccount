package com.inworn.test.cashaccount.controllers.dtos;

import com.inworn.test.cashaccount.validator.Phone;

public class PhoneActionRequest {

    @Phone
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
