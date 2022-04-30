package com.project.account.controllers;

import com.project.account.repositories.AccountEntity;
import com.project.account.services.AccountService;
import com.project.shop.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    public long createAccount(@RequestBody AccountEntity accountEntity){
        return accountService.createAccount(accountEntity);
    }

    @PutMapping("/account/{id}")
    public void updateAccount(@PathVariable long id, @RequestBody AccountEntity accountEntity){
        try{
            accountService.updateAccount(id, accountEntity);
        }catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @POST
    @Path("/account/create")
    public Response createNewAccountWithHTML(
            @FormParam("username") String username,
            @FormParam("password") String password,
            @FormParam("email") String email
    ){
        String output = "Your username: " + username + ". Your password: " + password + ". Your email: "+ email;
        return Response.status(200).entity(output).build();
    }

}
