package com.example.votingapp.service;

import com.example.votingapp.dto.RequestDto.AuthenticationRequest;
import com.example.votingapp.dto.RequestDto.VoteRequest;
import com.example.votingapp.models.*;
import com.example.votingapp.repository.PartyRepo;
import com.example.votingapp.repository.VoteRepo;
import com.example.votingapp.repository.VoterRepo;
import com.example.votingapp.util.VoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImp implements VoteService {
    private long count;


    @Autowired
    VoteRepo voteRepo;


    @Autowired
    VoterRepo voterRepo;

    @Autowired
    PartyRepo partyRepo;
    VoteMapper voteMapper;
    Vote vote;
    Party party;
   // Admin admin;

    @Override
    public Boolean canVote(VoteRequest voteRequest) {
        Voter voter = voterRepo.findById(voteRequest.getVoterId());
        if (voter == null) {
            throw new IllegalArgumentException("Voter Does not Exist");
        }

        Party party = partyRepo.findByName(voteRequest.getPartyName());
        if (party == null) {
            throw new IllegalArgumentException("Party Does Not Exist");
        }
        return true;

        //  if(voteRequest.getVoterId() == voteRequest.getPartyId());
        //     partyGetNewVote(vote);


//        voteMapper=new VoteMapper();
//        vote=new Vote();
//        party=new Party();
//
//        voteMapper.map(voteRequest);
//        return voteRepo.save(vote);

    }

//    private void partyGetNewVote(Vote vote) {
//        vote=new Vote();
//        party=new Party();
//        vote.setVoteId(count+1);
//        voteRepo.save(vote);
//        count++;
//
//    }


    @Override
    public String vote(VoteRequest voteRequest) {
        boolean canVote = canVote(voteRequest);
        if (canVote) {
            //    Vote vote = voteMapper.map(voteRequest);
            Vote vote = new Vote();
            vote.setPartyName(voteRequest.getPartyName());
            vote.setVoterId(voteRequest.getVoterId());
            voteRepo.save(vote);
            return "Voted Successfully";
        }
        return null;
    }

    @Override
    public Long voteCountResult(AuthenticationRequest request) {

        request.getEmailAddress();
        request.getPassword();


        return voteRepo.count();
    }

}
