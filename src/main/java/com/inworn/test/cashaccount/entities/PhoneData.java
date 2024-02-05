package com.inworn.test.cashaccount.entities;

import javax.persistence.*;

@Entity
@Table(name = "phone_data")
public class PhoneData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "phone", length = 13, nullable = false, unique = true)
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneData phoneData = (PhoneData) o;

        if (!id.equals(phoneData.id)) return false;
        if (!user.equals(phoneData.user)) return false;
        return phone.equals(phoneData.phone);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }
}
