package com.example.votingapp.dto.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Component
public class VoterRegisterRequest {

    private String firstname;
    private String lastname;
    private String emailAddress;
    private String password;
    private String phoneNumber;
}
