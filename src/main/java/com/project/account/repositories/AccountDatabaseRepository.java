package com.project.account.repositories;

import org.springframework.data.repository.CrudRepository;

public interface AccountDatabaseRepository extends CrudRepository <AccountEntity, Long> {
}
