package com.example.votingapp.service;

import com.example.votingapp.dto.RequestDto.AuthenticationRequest;
import com.example.votingapp.dto.RequestDto.VoteRequest;
import com.example.votingapp.models.Vote;

public interface VoteService {
    Boolean canVote(VoteRequest voteRequest) throws PartyAlreadyExist;

    String vote(VoteRequest voteRequest);


    Long voteCountResult(AuthenticationRequest request);

//
//    long count(Vote vote);


}
