package com.example.votingapp.util;

import com.example.votingapp.dto.RequestDto.VoteRequest;
import com.example.votingapp.models.Party;
import com.example.votingapp.models.Vote;
import com.example.votingapp.models.Voter;
import com.example.votingapp.repository.VoteRepo;
import com.example.votingapp.service.VoteService;
import com.example.votingapp.service.VoteServiceImp;
import org.springframework.beans.factory.annotation.Autowired;


public class VoteMapper {
    Party party;
    Voter voter;

    Vote vote;

    VoteService voteService;


    public Vote map(VoteRequest voteRequest) {
        Vote vote = new Vote();
        VoteMapper voteMapper = new VoteMapper();
        vote.setPartyName(voteRequest.getPartyName());
        vote.setVoterId(voteRequest.getVoterId());
        return vote;

    }
}