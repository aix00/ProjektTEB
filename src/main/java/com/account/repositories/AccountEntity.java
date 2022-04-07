package com.account.repositories;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Accounts")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "USERNAME", length = 30, nullable = false)
    private String userName;
    @Column(name = "PASSWORD", length = 30, nullable = false)
    private String password;
    @Column(name = "EMAIL", length = 30, nullable = false)
    private String email;
    @Column(name = "BIRTH_DATE", nullable = false)
    private LocalDate birthDate;
    @Column(name = "FAVOURITE")
    private String favouriteThing;
    @Column(name = "ENUM_SEX", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private SexOptions sex;
    @Column(name = "IS_ADMIN", nullable = false)
    private boolean isAdmin;

    AccountEntity(){
    }

    public AccountEntity(String userName, String password, String email, LocalDate birthDate, String favouriteThing, SexOptions sex, boolean isAdmin) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.favouriteThing = favouriteThing;
        this.sex = sex;
        this.isAdmin = isAdmin;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getFavouriteThing() {
        return this.favouriteThing;
    }

    public void setFavouriteThing(String favouriteThing) {
        this.favouriteThing = favouriteThing;
    }

    public SexOptions getSex() {
        return this.sex;
    }

    public void setSex(SexOptions sex) {
        this.sex = sex;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
