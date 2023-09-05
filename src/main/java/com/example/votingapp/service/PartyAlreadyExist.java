package com.example.votingapp.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.http.HttpStatus;

public class PartyAlreadyExist extends BeansException {


  public PartyAlreadyExist(String msg) {
    super(msg);
  }

  public PartyAlreadyExist(String msg, Throwable cause) {
    super(msg, cause);
  }
}
