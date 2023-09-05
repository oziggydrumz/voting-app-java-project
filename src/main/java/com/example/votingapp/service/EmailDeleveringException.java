package com.example.votingapp.service;

import jakarta.mail.MessagingException;
import org.springframework.beans.BeansException;

public class EmailDeleveringException extends BeansException {
    public EmailDeleveringException(MessagingException e) {
        super(e.getMessage());

    }

    public EmailDeleveringException(String msg) {
        super(msg);
    }

    public EmailDeleveringException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
