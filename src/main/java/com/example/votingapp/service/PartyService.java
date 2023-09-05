package com.example.votingapp.service;

import com.example.votingapp.dto.RequestDto.PartyRegisterRequest;
import com.example.votingapp.dto.RequestDto.TokenRequest;
import com.example.votingapp.models.Party;

public interface PartyService {
    Party registerParty(PartyRegisterRequest partyRegisterRequest) throws PartyAlreadyExist;

    String confirmation(TokenRequest request) throws PartyDoesNotExist;


    Party findParty(String name) throws PartyDoesNotExist;

    String deleteParty(long id);


    long count();


}