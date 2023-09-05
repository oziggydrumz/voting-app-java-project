package com.example.votingapp.service;

import org.springframework.beans.BeansException;

public class INCORRECTEMAILADDRESS extends BeansException {
    public INCORRECTEMAILADDRESS(String incorrect_email_address) {
        super(incorrect_email_address);

    }

    public INCORRECTEMAILADDRESS(String msg, Throwable cause) {
        super(msg, cause);
    }
}
