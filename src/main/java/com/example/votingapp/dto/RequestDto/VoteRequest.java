package com.example.votingapp.dto.RequestDto;

import com.example.votingapp.util.VoteMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class VoteRequest {
    private long voterId;
    private String partyName;



}
