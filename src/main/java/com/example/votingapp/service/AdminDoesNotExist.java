package com.example.votingapp.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
public class AdminDoesNotExist extends Throwable {

  private String message;
  private HttpStatus httpStatus;
}