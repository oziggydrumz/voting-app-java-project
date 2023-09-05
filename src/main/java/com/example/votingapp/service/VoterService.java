package com.example.votingapp.service;


import com.example.votingapp.dto.RequestDto.AuthenticationRequest;
import com.example.votingapp.dto.RequestDto.TokenRequest;
import com.example.votingapp.dto.RequestDto.VoterRegisterRequest;
import com.example.votingapp.dto.loginRequest.VoterLoginRequest;
import com.example.votingapp.dto.response.AuthenticationResponse;
import com.example.votingapp.models.Voter;
import lombok.RequiredArgsConstructor;


public interface VoterService {
    AuthenticationResponse registerVoter(VoterRegisterRequest voterRegisterRequest) throws VoterAlreadyExist, EmailDeleveringException;


    Voter findVoter(long id ) throws Exception, VoterDoesNotExist;

   // Optional<Candidate> findCandidate(Long id) throws CandidateDoesNotExist;

    String deleteVoter(long id);


    AuthenticationResponse login(AuthenticationRequest request) throws INCORRECTEMAILADDRESS;

    String confirmAccount(TokenRequest otp);


}
