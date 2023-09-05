package com.example.votingapp.repository;

import com.example.votingapp.models.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepo extends JpaRepository<Party,Long> {
    Party findByEmailAddress(String emailAddress);

    Party findByName(String name);

    Party findById(long id);



}
