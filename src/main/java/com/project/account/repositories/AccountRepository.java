package com.project.account.repositories;

import com.project.shop.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class AccountRepository {
    @Autowired
    AccountDatabaseRepository accountDatabaseRepository;

    public long createAccount(AccountEntity account){
        AccountEntity accountEntity = new AccountEntity(account.getUserName(), account.getPassword(),account.getEmail(),account.isAdmin());
        AccountEntity savedAccount = accountDatabaseRepository.save(accountEntity);
        return savedAccount.getId();
    }
    //Get all accounts from AccountEntity
    public Collection<AccountEntity> getAccounts(){
        List<AccountEntity> account = new ArrayList<>();
        for (AccountEntity accountEntity : accountDatabaseRepository.findAll()){
            account.add(new AccountEntity(accountEntity.getUserName(), accountEntity.getPassword(),accountEntity.getEmail(), accountEntity.isAdmin()));
        }
        return account;
    }

    public void updateAccount(long id, AccountEntity accountEntity){
        AccountEntity account = new AccountEntity(accountEntity.getUserName(), accountEntity.getPassword(),accountEntity.getEmail(), accountEntity.isAdmin());
        account.setId(id);
        accountDatabaseRepository.save(account);
    }

    public void deleteAccount(long id){
        accountDatabaseRepository.deleteById(id);
    }

    public AccountEntity getAccount(long id) throws NotFoundException{
        AccountEntity accountEntity = accountDatabaseRepository.findById(id).orElse(null);
        if (accountEntity == null)
            throw new NotFoundException();
        return new AccountEntity(accountEntity.getUserName(), accountEntity.getPassword(), accountEntity.getEmail(),accountEntity.isAdmin());
    }
}
