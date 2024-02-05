package com.inworn.test.cashaccount.dao;

import com.inworn.test.cashaccount.entities.EmailData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailDataRepository extends JpaRepository<EmailData, Long> {
    Optional<EmailData> findEmailDataByEmail(String email);

    int countEmailDataByUserId(Long userId);
}
