package com.example.votingapp.service;

import com.example.votingapp.dto.RequestDto.PartyRegisterRequest;
import com.example.votingapp.models.Party;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class PartyServiceTest extends VoteServiceImp {

    @Autowired
    PartyService partyService;
    PartyRegisterRequest partyRegisterRequest;
    Party party;

    @Test
    void registerParty() throws PartyAlreadyExist {
        partyRegisterRequest=new PartyRegisterRequest();
     //  party=new Party(1,"apc","osa", "1111");

        partyRegisterRequest.setEmailAddress("osas");
        partyRegisterRequest.setName("raymond");
        var registerParty1=partyService.registerParty(partyRegisterRequest);
       // assertNotNull(registerParty);
        assertNotNull(registerParty1.getPartyId());





    }

    @Test
    void findParty() throws PartyDoesNotExist {
       // party=new Party(1,"apc","osas", "1111");
        party.setName("apc");
        Party findParty1=partyService.findParty(party.getName());
        assertNotNull(findParty1.getName());




    }

    @Test
    void deleteParty() throws PartyDoesNotExist {
        //party=new Party(1,"apc","osas", "1111");
        party.setPartyId(1);
        party.getPartyId();
        String deleteParty=partyService.deleteParty(party.getPartyId());
        Party party1=partyService.findParty(party.getName());
       // assertNotNull(deleteParty.equals("delete successfully"),count());
        assertEquals(1,party1.getName());


    }
}