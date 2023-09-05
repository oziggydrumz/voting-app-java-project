package com.example.votingapp.util;


import com.example.votingapp.dto.RequestDto.VoterRegisterRequest;
import com.example.votingapp.dto.response.AuthenticationResponse;
import com.example.votingapp.models.AppRole;
import com.example.votingapp.models.Voter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Builder
public class VoterMapper {

   // @Autowired
    private PasswordEncoder passwordEncoder;


    public AuthenticationResponse map(VoterRegisterRequest voterRegisterRequest, Voter voter){

        voter.setFirstName(voterRegisterRequest.getFirstname());
        voter.setLastName(voterRegisterRequest.getLastname());
        voter.setEmailAddress(voterRegisterRequest.getEmailAddress());
        voter.setPassword(passwordEncoder.encode(voterRegisterRequest.getPassword()));
        voter.setPhoneNumber(voterRegisterRequest.getPhoneNumber());
        voter.getAppRole().add(AppRole.VOTER);




        return new AuthenticationResponse();
    }

}
