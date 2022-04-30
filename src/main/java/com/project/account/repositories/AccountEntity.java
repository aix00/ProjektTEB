package com.project.account.repositories;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @Pattern(regexp =
/*            local-part:
*            Allows numeric values from 0 to 9,
*            Allows both uppercase and lowercase letters from A to Z,
*            Allows underscore "_" and hyphen "-" and dot ".",
*            Dot isn't allowed at the start and end of the local-part,
*            Consecutive dots aren't allowed,
*            Maximum of 64 characters are allowed
*
*            domain-part:
*            Allows numeric values from 0 to 9,
*            Allows both uppercase and lowercase letters from A to Z,
*            Hyphen “-” and dot “.” isn't allowed at the start and end of the domain-part,
*            Consecutive dots aren't allowed
*/
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
    )
    @Column(name = "EMAIL", length = 30, nullable = false)
    private String email;
    @Column(name = "IS_ADMIN", nullable = false)
    @Value("false")
    private boolean isAdmin;

    AccountEntity(){
    }

    public AccountEntity(String userName, String password, String email, boolean isAdmin) {
        this.userName = userName;
        this.password = password;
        this.email = email;
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

    public boolean isAdmin() {
        return this.isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
