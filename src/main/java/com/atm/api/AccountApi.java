package com.atm.api;

import com.atm.model.Account;
import com.atm.processor.AccountProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountApi {
    @Autowired
    private AccountProcessor accountProcessor;
    @GetMapping
    public ResponseEntity<Account> findByAccountNumber(@RequestParam("accountNumber") String accountNumber){
        Account account= null;
        try {
             account= accountProcessor.findByAccountNumber(accountNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @GetMapping("/all")
    public List<Account> findAll(){
        return accountProcessor.findAll();
    }

    @PutMapping("/{accountNumber}/enable")
    public void enable(@PathVariable("accountNumber") String accountNumber){
        accountProcessor.enable(accountNumber);
    }

    @PutMapping("/{accountNumber}/disable")
    public void disable(@PathVariable("accountNumber") String accountNumber){
        accountProcessor.disable(accountNumber);
    }
}
