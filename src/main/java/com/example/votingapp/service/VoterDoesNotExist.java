package com.example.votingapp.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
@AllArgsConstructor

public class VoterDoesNotExist extends RuntimeException {
    private String message;
    private HttpStatus errorCode;


}
