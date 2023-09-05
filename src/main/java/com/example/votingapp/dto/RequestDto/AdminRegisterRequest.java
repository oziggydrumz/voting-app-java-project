package com.example.votingapp.dto.RequestDto;

import lombok.Data;

@Data

public class AdminRegisterRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String EmailAddress;
    private String password ;
}
