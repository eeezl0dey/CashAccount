package com.inworn.test.cashaccount.auth;

import com.inworn.test.cashaccount.auth.dtos.AuthenticationRequest;
import com.inworn.test.cashaccount.auth.dtos.AuthenticationResponse;
import com.inworn.test.cashaccount.dao.EmailDataRepository;
import com.inworn.test.cashaccount.dao.PhoneDataRepository;
import com.inworn.test.cashaccount.entities.EmailData;
import com.inworn.test.cashaccount.entities.PhoneData;
import com.inworn.test.cashaccount.entities.User;
import com.inworn.test.cashaccount.validator.PhoneValidator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final EmailDataRepository emailDataRepository;
    private final PhoneDataRepository phoneDataRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(EmailDataRepository emailDataRepository, PasswordEncoder passwordEncoder, PhoneDataRepository phoneDataRepository, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.emailDataRepository = emailDataRepository;
        this.phoneDataRepository = phoneDataRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        User user;
        if (PhoneValidator.pattern.matcher(request.getLogin()).matches()) {
            PhoneData phoneData = phoneDataRepository.findPhoneDataByPhone(request.getLogin()).orElseThrow();
            user = phoneData.getUser();
        } else {
            EmailData emailData = emailDataRepository.findEmailDataByEmail(request.getLogin()).orElseThrow();
            user = emailData.getUser();
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getId().toString(),
                        request.getPassword()
                )
        );

        CustomUserDetails userDetails = new CustomUserDetails(user);
        var jwtToken = jwtService.generateToken(userDetails);
        return new AuthenticationResponse(jwtToken);
    }

    public boolean isCurrentUser(Long userId) {
        return getCurrentPrincipal().getUser().getId().equals(userId);
    }

    protected CustomUserDetails getCurrentPrincipal() {
        return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
