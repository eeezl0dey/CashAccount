package com.inworn.test.cashaccount.controllers.dtos;

import com.inworn.test.cashaccount.validator.Phone;

public class PhoneUpdateRequest {
    @Phone
    private String oldPhone;
    @Phone
    private String newPhone;

    public String getOldPhone() {
        return oldPhone;
    }

    public void setOldPhone(String oldPhone) {
        this.oldPhone = oldPhone;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
    }
}
