package com.project.account.repositories;

import com.project.account.models.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    AccountEntity findByEmail(String email);
}
