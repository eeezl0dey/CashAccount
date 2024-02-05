package com.inworn.test.cashaccount.controllers;

import com.inworn.test.cashaccount.controllers.dtos.UserResponse;
import com.inworn.test.cashaccount.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Page<UserResponse> getUsers(
            @RequestParam(required = false) Long dateOfBirth,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @PageableDefault(sort = "name", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        return userService.getUsers(dateOfBirth, phone, name, email, pageable);
    }

}
