package com.atm.thread;

import com.atm.model.Account;
import com.atm.processor.AtmProcessor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class PickMoneyThread extends Thread {
    @Autowired
    private AtmProcessor atmProcessor;

    private Long idAtm;
    private Account account;
    public PickMoneyThread(Long idAtm,Account account) {
        this.idAtm= idAtm;
        this.account = account;

    }

    @Override
    public void run() {
        try {
            atmProcessor.pickMoney(idAtm,account);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
