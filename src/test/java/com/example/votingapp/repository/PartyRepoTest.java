package com.example.votingapp.repository;

import com.example.votingapp.models.Party;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class PartyRepoTest {
    @Autowired
    PartyRepo partyRepo;
    Party party;
    @Test
    void PartyRepoCanSaveInTheVault(){
        party=new Party();
        Party saveParty=partyRepo.save(party);
        assertNotNull(saveParty.getPartyId(),party.getName());
    }



}