package com.example.votingapp.repository;


import com.example.votingapp.models.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface VoterRepo extends JpaRepository<Voter,Long> {

 Voter findByEmailAddress(String emailAddress);

 Voter findById(long id);

// Voter findByPassword(String password);




}
