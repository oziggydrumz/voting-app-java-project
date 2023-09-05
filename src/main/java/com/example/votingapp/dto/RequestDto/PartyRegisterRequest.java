package com.example.votingapp.dto.RequestDto;

import com.example.votingapp.models.Vote;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class PartyRegisterRequest {
    private String name;
    private String emailAddress;




}
