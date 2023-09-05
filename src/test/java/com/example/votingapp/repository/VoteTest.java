package com.example.votingapp.repository;

import com.example.votingapp.models.Vote;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class VoteTest {
    @Autowired
    VoteRepo voteRepo;
    Vote vote;
    @Test
    public void voteCanBeSaveInTheDataBase(){
        vote=new Vote();
        Vote saveVote=voteRepo.save(vote);
        assertNotNull(saveVote.getVoteId());

    }



}