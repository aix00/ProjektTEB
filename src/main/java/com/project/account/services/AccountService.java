package com.project.account.services;

import com.project.account.models.AccountEntity;
import com.project.account.models.Role;
import com.project.account.repositories.AccountRepository;
import com.project.account.repositories.RoleRepository;
import com.project.shop.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AccountEntity createAccount(AccountEntity accountEntity) {
        Set<Role> roles = new HashSet<Role>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        AccountEntity account = new AccountEntity(accountEntity.getFirstName(),accountEntity.getLasttName(), passwordEncoder.encode(accountEntity.getPassword())
                , accountEntity.getEmail(),roles);
        return accountRepository.save(account);
    }

    public AccountEntity getAccount(long id) throws NotFoundException {
        return accountRepository.findById(id).orElse(null);
    }

    public List<AccountEntity> getAccounts() {
        return accountRepository.findAll();
    }

    public AccountEntity updateAccount(long id, AccountEntity newAcount) throws NotFoundException {
        AccountEntity account = accountRepository.findById(id).get();
        account.setFirstName(newAcount.getFirstName());
        account.setLasttName(newAcount.getLasttName());
        account.setEmail(newAcount.getEmail());
        account.setPassword(newAcount.getPassword());
        return accountRepository.save(account);
    }

    public void deleteAccount(long id) {

        accountRepository.deleteById(id);
    }

   public AccountEntity getAccountByEmail(String email){
        return accountRepository.findByEmail(email);
   }
}