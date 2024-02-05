package com.inworn.test.cashaccount.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 500, nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "password", length = 500, nullable = false)
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<EmailData> emails;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<PhoneData> phones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<EmailData> getEmails() {
        return emails;
    }

    public void setEmails(Set<EmailData> emails) {
        this.emails = emails;
    }

    public Set<PhoneData> getPhones() {
        return phones;
    }

    public void setPhones(Set<PhoneData> phones) {
        this.phones = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!name.equals(user.name)) return false;
        if (!dateOfBirth.equals(user.dateOfBirth)) return false;
        if (!password.equals(user.password)) return false;
        if (!account.equals(user.account)) return false;
        if (!emails.equals(user.emails)) return false;
        return phones.equals(user.phones);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
