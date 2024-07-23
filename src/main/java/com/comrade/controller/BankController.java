package com.comrade.controller;

import com.comrade.model.Author;
import com.comrade.model.BankAccount;
import com.comrade.model.Book;
import com.comrade.resolver.BankService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @QueryMapping
    public List<BankAccount> getAllBankAccounts(){
       return bankService.getAllBankAccounts();
    }

}
