package com.inworn.test.cashaccount.services;

import com.inworn.test.cashaccount.dao.PhoneDataRepository;
import com.inworn.test.cashaccount.entities.EmailData;
import com.inworn.test.cashaccount.entities.PhoneData;
import com.inworn.test.cashaccount.entities.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class PhoneService {

    private final PhoneDataRepository phoneDataRepository;

    public PhoneService(PhoneDataRepository phoneDataRepository) {
        this.phoneDataRepository = phoneDataRepository;
    }

    public void addUserPhone(Long userId, String phone) {
        PhoneData phoneData = new PhoneData();
        phoneData.setPhone(phone);
        User user = new User();
        user.setId(userId);
        phoneData.setUser(user);
        phoneDataRepository.save(phoneData);
    }

    @Transactional
    public void updateUserPhone(Long userId, String oldPhone, String newPhone) {
        PhoneData updatePhoneData = findPhone(userId, oldPhone);
        updatePhoneData.setPhone(newPhone);
        phoneDataRepository.save(updatePhoneData);
    }

    @Transactional
    public void deleteUserPhone(Long userId, String phone) {
        PhoneData deletePhoneData = findPhone(userId, phone);
        if (phoneDataRepository.countPhoneDataByUserId(userId) > 1) {
            phoneDataRepository.delete(deletePhoneData);
        } else {
            throw new IllegalArgumentException("User must have at least one phone");
        }
    }

    private PhoneData findPhone(Long userId, String phone) {
        return phoneDataRepository
                .findPhoneDataByPhone(phone)
                .filter(phoneData -> phoneData.getUser().getId().equals(userId))
                .orElseThrow(() -> new EntityNotFoundException("Phone not found or does not belong to the user"));
    }
}
