package com.example.votingapp.service;

public interface EmailService {
    void sendOtpConfirmation(String emailAddress, String opt) throws EmailDeleveringException;


}
