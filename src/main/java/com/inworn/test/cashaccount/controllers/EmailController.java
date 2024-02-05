package com.inworn.test.cashaccount.controllers;

import com.inworn.test.cashaccount.controllers.dtos.EmailActionRequest;
import com.inworn.test.cashaccount.controllers.dtos.EmailUpdateRequest;
import com.inworn.test.cashaccount.services.EmailService;
import com.inworn.test.cashaccount.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users/{id}/email")
@Validated
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PutMapping
    @PreAuthorize("@authService.isCurrentUser(#id)")
    public void addEmail(@PathVariable Long id, @RequestBody @Valid EmailActionRequest request) {
        emailService.addUserEmail(id, request.getEmail());
    }

    @PostMapping
    @PreAuthorize("@authService.isCurrentUser(#id)")
    public void updateEmail(@PathVariable Long id, @RequestBody @Valid EmailUpdateRequest request) {
        emailService.updateUserEmail(id, request.getOldEmail(), request.getNewEmail());
    }

    @DeleteMapping
    @PreAuthorize("@authService.isCurrentUser(#id)")
    public void updateEmail(@PathVariable Long id, @RequestBody @Valid EmailActionRequest request) {
        emailService.deleteUserEmail(id, request.getEmail());
    }
}
