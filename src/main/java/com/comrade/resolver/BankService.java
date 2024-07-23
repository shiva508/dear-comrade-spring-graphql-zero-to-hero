package com.comrade.resolver;

import com.comrade.model.BankAccount;
import com.comrade.model.Currency;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankService {


    public List<BankAccount> getAllBankAccounts(){
        return List.of(new BankAccount(1,"SBI", Currency.Rupee));
    }


}
