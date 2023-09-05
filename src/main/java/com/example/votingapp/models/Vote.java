package com.example.votingapp.models;

import com.example.votingapp.util.VoteMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity

public class Vote extends Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long voteId;
    private long voterId;
    private long adminId;

    private String partyName;
    private String password;




}
