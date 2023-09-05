//package com.example.votingapp.service;
//
//import com.example.votingapp.dto.RequestDto.VoteRequest;
//import com.example.votingapp.models.Party;
//import com.example.votingapp.models.Vote;
//import com.example.votingapp.models.Voter;
//import com.example.votingapp.util.VoteMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.stereotype.Service;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//
//class VoteServiceImpTest extends VoteServiceImp {
//    @Autowired
//    VoteService voteService;
//    Vote vote;
//    Voter voter;
//    VoteRequest voteRequest;
//    VoteMapper voteMapper;
//    Party party;
//
//    @Test
//    void testVoterCanVote() throws PartyAlreadyExist {
//
//        voteRequest=new VoteRequest();
//        party =new Party(3,"nnpd","oziggy");
//         voter = new Voter(2, "john", "doe", "0199", "ossas");
//
//        party.setPartyId(1);
//        party.setName("nnpd");
//        party.setEmailAddress("oziggy");
//
//        voteRequest.setVoterId(5);
//        voteRequest.setPartyName("nnpd");
//
//        Boolean canVote= voteService.canVote(voteRequest);
//        assertTrue(canVote);
//       // String voted = voteService.vote(voteRequest);
//     //   assertEquals(3, voteService.voteCountResult());
//
//
//    }
//
//
//
//    @Test
//    void testVoteCount() {
//    }
//}