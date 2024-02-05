package com.inworn.test.cashaccount.dao;

import com.inworn.test.cashaccount.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select distinct u from User u " +
            "left join u.phones p " +
            "left join u.emails e " +
            "where (:dateOfBirth is null or u.dateOfBirth >= :dateOfBirth) and " +
            "(:phone is null or p.phone = :phone) and " +
            "(:name is null or u.name like :name) and " +
            "(:email is null or e.email = :email)")
    Page<User> getUsersByDateAndPhoneAndNameAndEmail(
            @Param("dateOfBirth") Date dateOfBirth,
            @Param("phone") String phone,
            @Param("name") String name,
            @Param("email") String email,
            Pageable pageable
    );
}
