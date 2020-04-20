package com.atm.api;

import com.atm.model.Account;
import com.atm.processor.AtmProcessor;
import com.atm.thread.PickMoneyThread;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/atm")
public class AtmApi {
    @Autowired
    private AtmProcessor atmProcessor;

    @PutMapping("/{id}/pick-money")
    public ResponseEntity<String> pickMoney(@PathVariable("id") Long atmId, @RequestBody Account account){

            Thread thread = new PickMoneyThread(atmId,account)
                {
                    public void run() {

                        try {
                            atmProcessor.pickMoney(atmId,account);
                        } catch (Exception e) {
                         e.printStackTrace();
                        }
                    }
                };
            thread.start();

        return new ResponseEntity<>("Success",HttpStatus.OK);
    }
}
