package com.project.account.controllers;

import com.project.account.models.AccountEntity;
import com.project.account.services.AccountService;
import com.project.shop.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;


    @GetMapping(value={"/login","/"})
    public String  loginView(){
        return "login";
    }

    @GetMapping("/register")
    public String  registerView(Model model){
        model.addAttribute("user",new AccountEntity());
        return "createAccount";
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String createAccount(@ModelAttribute AccountEntity accountEntity, Model model){
       System.out.println(accountEntity.toString());
        accountService.createAccount(accountEntity);
        model.addAttribute("Rejestracja","zostałeś zarejestrowany pomyślnie!");
        return "login";
    }

}
