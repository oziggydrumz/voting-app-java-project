package com.example.votingapp.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.http.HttpStatus;

public class PartyDoesNotExist extends BeansException {


    public PartyDoesNotExist(String msg) {
        super(msg);
    }

    public PartyDoesNotExist(String msg, Throwable cause) {
        super(msg, cause);
    }
}
