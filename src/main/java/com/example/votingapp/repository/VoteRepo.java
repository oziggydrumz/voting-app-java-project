package com.example.votingapp.repository;

//import com.example.votingapp.models.Admin;
import com.example.votingapp.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface VoteRepo extends JpaRepository<Vote,Long> {


 // Vote findByAdminId(long adminId);
  Vote findByPartyId(long partyId);
}
