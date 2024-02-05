package com.inworn.test.cashaccount.controllers;

import com.inworn.test.cashaccount.controllers.dtos.PhoneActionRequest;
import com.inworn.test.cashaccount.controllers.dtos.PhoneUpdateRequest;
import com.inworn.test.cashaccount.services.PhoneService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users/{id}/phone")
@Validated
public class PhoneController {
    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PutMapping
    @PreAuthorize("@authService.isCurrentUser(#id)")
    public void addPhone(@PathVariable Long id, @RequestBody @Valid PhoneActionRequest request) {
        phoneService.addUserPhone(id, request.getPhone());
    }

    @PostMapping
    @PreAuthorize("@authService.isCurrentUser(#id)")
    public void updateEmail(@PathVariable Long id, @RequestBody @Valid PhoneUpdateRequest request) {
        phoneService.updateUserPhone(id, request.getOldPhone(), request.getNewPhone());
    }

    @DeleteMapping
    @PreAuthorize("@authService.isCurrentUser(#id)")
    public void updateEmail(@PathVariable Long id, @RequestBody @Valid PhoneActionRequest request) {
        phoneService.deleteUserPhone(id, request.getPhone());
    }
}
