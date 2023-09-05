package com.example.votingapp.repository;

import com.example.votingapp.models.OtpValidation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OTPRepository extends JpaRepository<OtpValidation, Long> {

    OtpValidation findAllByToken(String token);
}
