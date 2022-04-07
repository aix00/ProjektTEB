package com.account.services;

import com.account.repositories.AccountEntity;
import com.account.repositories.AccountRepository;
import com.cart.repositories.CartEntity;
import com.shop.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public long createAccount(AccountEntity accountEntity){
        AccountEntity account = new AccountEntity(accountEntity.getUserName(), accountEntity.getPassword(), accountEntity.getEmail(), accountEntity.getBirthDate(), accountEntity.getFavouriteThing(), accountEntity.getSex(), accountEntity.isAdmin());
        return accountRepository.createAccount(account);
    }

    public AccountEntity getAccount(long id) throws NotFoundException {
        return accountRepository.getAccount(id);
    }

    public Collection<AccountEntity> getAccounts(){
        return accountRepository.getAccounts();
    }

    public void updateAccount(long id, AccountEntity accountEntity) throws NotFoundException{
        AccountEntity account = new AccountEntity(accountEntity.getUserName(),accountEntity.getPassword(),accountEntity.getEmail(),accountEntity.getBirthDate(),accountEntity.getFavouriteThing(),accountEntity.getSex(),accountEntity.isAdmin());
        accountRepository.updateAccount(id, account);
    }

    public void deleteAccount(long id){
        accountRepository.deleteAccount(id);
    }
}
