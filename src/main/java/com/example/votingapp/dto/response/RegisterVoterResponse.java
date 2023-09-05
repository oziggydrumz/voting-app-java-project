package com.example.votingapp.dto.response;


import com.example.votingapp.dto.RequestDto.VoterRegisterRequest;
import com.example.votingapp.models.Voter;

public class RegisterVoterResponse {
    Voter candidate;
    public Voter candidateRegisterResponse(VoterRegisterRequest candidateRegisterRequest){
       return candidate;
    }
}
