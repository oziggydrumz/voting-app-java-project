package com.example.votingapp.repository;

import com.example.votingapp.models.Voter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CandidateRepoTest {
    @Autowired
    VoterRepo candidateRepo;
    Voter candidate;
    @Test
void  candidateRepoCanSave(){
        candidate=new Voter();
        candidate.setEmailAddress("osaas@gmail.com");
        Voter saveCandidate=candidateRepo.save(candidate);
        System.out.println(candidate.getEmailAddress() + " i'm the eamil address");
        assertNotNull(saveCandidate.getId());
        assertNotNull(saveCandidate.getEmailAddress());



}
}