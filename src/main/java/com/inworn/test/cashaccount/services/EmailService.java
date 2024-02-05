package com.inworn.test.cashaccount.services;

import com.inworn.test.cashaccount.dao.EmailDataRepository;
import com.inworn.test.cashaccount.dao.PhoneDataRepository;
import com.inworn.test.cashaccount.dao.UserRepository;
import com.inworn.test.cashaccount.entities.EmailData;
import com.inworn.test.cashaccount.entities.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class EmailService {

    private final EmailDataRepository emailDataRepository;

    public EmailService(EmailDataRepository emailDataRepository) {
        this.emailDataRepository = emailDataRepository;
    }

    public void addUserEmail(Long userId, String email) {
        EmailData emailData = new EmailData();
        emailData.setEmail(email);
        User user = new User();
        user.setId(userId);
        emailData.setUser(user);
        emailDataRepository.save(emailData);
    }

    @Transactional
    public void updateUserEmail(Long userId, String oldEmail, String newEmail) {
        EmailData updateEmailData = findEmail(userId, oldEmail);
        updateEmailData.setEmail(newEmail);
        emailDataRepository.save(updateEmailData);
    }

    @Transactional
    public void deleteUserEmail(Long userId, String email) {
        EmailData deleteEmailData = findEmail(userId, email);
        if (emailDataRepository.countEmailDataByUserId(userId) > 1) {
            emailDataRepository.delete(deleteEmailData);
        } else {
            throw new IllegalArgumentException("User must have at least one email");
        }
    }
    private EmailData findEmail(Long userId, String email) {
        return emailDataRepository
                .findEmailDataByEmail(email)
                .filter(emailData -> emailData.getUser().getId().equals(userId))
                .orElseThrow(() -> new EntityNotFoundException("Email not found or does not belong to the user"));
    }
}
