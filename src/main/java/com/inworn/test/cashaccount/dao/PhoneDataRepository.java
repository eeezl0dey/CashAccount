package com.inworn.test.cashaccount.dao;

import com.inworn.test.cashaccount.entities.PhoneData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhoneDataRepository extends JpaRepository<PhoneData, Long> {
    boolean existsByPhone(String phone);

    Optional<PhoneData> findPhoneDataByPhone(String phone);

    int countPhoneDataByUserId(Long userId);
}
