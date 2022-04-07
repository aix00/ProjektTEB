package com.account.controllers;

import com.account.repositories.AccountEntity;
import com.account.services.AccountService;
import com.shop.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/account")
    public long createAccount(@RequestBody AccountEntity accountEntity){
        return accountService.createAccount(accountEntity);
    }

    @GetMapping("/account")
    public Collection<AccountEntity> accountEntities(){
        List<AccountEntity> accountEntities = new ArrayList<>();
        for (AccountEntity accountEntity : accountService.getAccounts()){
            accountEntities.add(new AccountEntity(accountEntity.getUserName(),accountEntity.getPassword(),accountEntity.getEmail(),accountEntity.getBirthDate(),accountEntity.getFavouriteThing(),accountEntity.getSex(),accountEntity.isAdmin()));
        }
        return accountEntities;
    }

    @PutMapping("/account/{id}")
    public void updateAccount(@PathVariable long id, @RequestBody AccountEntity accountEntity){
        try{
            accountService.updateAccount(id, accountEntity);
        }catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/account/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable long id){
        accountService.deleteAccount(id);
    }
}
