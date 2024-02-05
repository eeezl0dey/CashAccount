package com.inworn.test.cashaccount.controllers;

import com.inworn.test.cashaccount.auth.dtos.AuthenticationRequest;
import com.inworn.test.cashaccount.auth.dtos.AuthenticationResponse;
import com.inworn.test.cashaccount.auth.AuthService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthService authService;

    public AuthenticationController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(
            @RequestBody @Valid AuthenticationRequest request
    ) {
        return authService.authenticate(request);
    }
}
