package com.example.votingapp.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
public class AdminAlreadyExist extends Throwable {
   private String message;
   private HttpStatus httpStatus;
}
