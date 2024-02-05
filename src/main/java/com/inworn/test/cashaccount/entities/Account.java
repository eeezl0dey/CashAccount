package com.inworn.test.cashaccount.entities;

import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "balance", scale = 2, nullable = false, columnDefinition = "DECIMAL(19,4) DEFAULT 0")
    @Check(constraints = "balance >= 0")
    private BigDecimal balance;

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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (!id.equals(account.id)) return false;
        if (!user.equals(account.user)) return false;
        return balance.equals(account.balance);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + balance.hashCode();
        return result;
    }
}
