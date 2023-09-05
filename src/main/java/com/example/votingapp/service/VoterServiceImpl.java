package com.example.votingapp.service;


import com.example.votingapp.dto.RequestDto.AuthenticationRequest;
import com.example.votingapp.dto.RequestDto.TokenRequest;
import com.example.votingapp.dto.RequestDto.VoterRegisterRequest;
import com.example.votingapp.dto.response.AuthenticationResponse;
import com.example.votingapp.models.OtpValidation;
import com.example.votingapp.models.Voter;
import com.example.votingapp.repository.OTPRepository;
import com.example.votingapp.repository.VoterRepo;
import com.example.votingapp.security.config.JwtService;
import com.example.votingapp.util.OtpGenerator;
import com.example.votingapp.util.VoterMapper;

import jakarta.servlet.annotation.WebServlet;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
//@RequiredArgsConstructor

public class VoterServiceImpl implements VoterService {
    @Autowired
    private final  VoterRepo voterRepo;
    @Autowired

    private final OTPRepository otpRepository;

private final OtpGenerator otp;
private final AuthenticationManager authManager;
private final JwtService jwtService;



    private PasswordEncoder passwordEncoder;
    private EmailService emailService;

 // VoterFindRequest candidateFindRequest;

    VoterRegisterRequest voterRegisterRequest;


    private final VoterMapper voterMapper;

    public VoterServiceImpl(OtpGenerator otp, JwtService jwtService, AuthenticationManager authManager, VoterRepo voterRepo, VoterRegisterRequest voterRegisterRequest,
                        OTPRepository otpRepository, VoterMapper voterMapper) {
        this.otp = otp;
        this.jwtService = jwtService;
        this.authManager = authManager;
        this.voterRepo = voterRepo;
        this.voterRegisterRequest = voterRegisterRequest;
        this.otpRepository = otpRepository;
        this.voterMapper = voterMapper;
    }

    @Override
    public AuthenticationResponse registerVoter(VoterRegisterRequest voterRegisterRequest) throws VoterAlreadyExist, EmailDeleveringException {
        Voter voter=new Voter();



            if(voterRepo.findByEmailAddress(voterRegisterRequest.getEmailAddress())!=null) {
                throw new VoterAlreadyExist("voter already exist");

           }
        AuthenticationResponse authenticate = voterMapper.map(voterRegisterRequest,  new Voter());
         voterRepo.save(voter);


        String otpGen = otp.otpGenerator();
        OtpValidation validation = new OtpValidation();
        validation.setVoter(voter);
        validation.setToken(otpGen);
        validation.setCreatedAt(LocalDateTime.now());
        validation.setConfirmAt(null);
        validation.setExpiredAt(LocalDateTime.now().plusMinutes(30) );

        otpRepository.save(validation);
      //  emailService.sendOtpConfirmation(voter.getEmailAddress(), otpGen);

         var jwtToken=jwtService.generateToken(voter);
         return AuthenticationResponse.builder()
                 .token(jwtToken)
                 .otp(otpGen)
                 .build();

    }










    @Override
    public Voter findVoter(long id)  {
         Voter voter = voterRepo.findByEmailAddress(voterRegisterRequest.getEmailAddress());
         if(voter==null){
             throw new IllegalArgumentException("Voter does not exist");


         }





//
        return  voterRepo.findByEmailAddress(voterRegisterRequest.getEmailAddress());

        // }
    }


    @Override
    public String deleteVoter(long id) {
        Voter voter = voterRepo.findById(id);
        if (voter == null) {
            throw new VoterDoesNotExist("Invalid id", HttpStatus.BAD_REQUEST);
        }
        voter.setAppRole(null);
        voterRepo.deleteById(id);
        return "delete successfully";

    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) throws INCORRECTEMAILADDRESS {
        var voter= voterRepo.findByEmailAddress(request.getEmailAddress());
        if (voter == null){
            throw new INCORRECTEMAILADDRESS("INCORRECT EMAIL ADDRESS");
        }
        if (!passwordEncoder.matches(request.getPassword(), voter.getPassword())){
            throw new INCORRECTEMAILADDRESS("INCORRECT PASSWORD");
        }

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmailAddress(),
                        request.getPassword()
                )
        );

        var jwtToken=jwtService.generateToken(voter);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public String confirmAccount(TokenRequest request) {
        OtpValidation otpValidation = otpRepository.findAllByToken(request.getToken());
        if (otpValidation == null) {
            throw new VoterDoesNotExist("invalid otp", HttpStatus.BAD_REQUEST);
        }

        Voter voter = otpValidation.getVoter();

        LocalDateTime expiryTime = otpValidation.getExpiredAt();
        boolean isValidDate = expiryTime.isBefore(LocalDateTime.now());

        if (!isValidDate) {
            voter.setAppRole(null);
            voterRepo.deleteById(voter.getId());
            otpValidation.setVoter(null);
            voterRepo.delete(voter);
            return "Expired OTP";
        }
        voter.setEnabled(true);
        otpValidation.setExpiredAt(LocalDateTime.now());
        voterRepo.save(voter);
        otpRepository.save(otpValidation);
        return "Account confirmed";

    }



}
