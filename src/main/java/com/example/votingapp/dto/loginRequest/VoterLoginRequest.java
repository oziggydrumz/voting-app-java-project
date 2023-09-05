package com.example.votingapp.dto.loginRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class VoterLoginRequest {
    private String password;
    private String emailAddress;

}
