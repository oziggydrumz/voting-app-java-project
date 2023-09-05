package com.example.votingapp.controller;

import com.example.votingapp.dto.RequestDto.AuthenticationRequest;
import com.example.votingapp.dto.RequestDto.TokenRequest;
import com.example.votingapp.dto.RequestDto.VoterRegisterRequest;
import com.example.votingapp.dto.response.AuthenticationResponse;
import com.example.votingapp.models.OtpValidation;
import com.example.votingapp.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/voter", produces = {MediaType.APPLICATION_JSON_VALUE})
public class VoterController {
    VoterService voterService;

    public VoterController(VoterService voterService) {
        this.voterService = voterService;
    }



    @PostMapping(value = "/register")
    public ResponseEntity<?>register(@RequestBody VoterRegisterRequest request) throws VoterAlreadyExist, EmailDeleveringException {
        return new ResponseEntity<>(voterService.registerVoter(request),HttpStatus.CREATED);

    }
    @PostMapping(value = "/confirmation")
    public  ResponseEntity<?>otpConfirmation(@RequestBody TokenRequest request){
        return new ResponseEntity<>(voterService.confirmAccount(request),HttpStatus.OK);
    }





    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse>login(@RequestBody AuthenticationRequest request) throws INCORRECTEMAILADDRESS {
        return new ResponseEntity<AuthenticationResponse>(voterService.login(request),HttpStatus.OK);
    }
    @GetMapping("/findVoter")
    public ResponseEntity<?>findVoter(long id) throws Exception {
        return new  ResponseEntity<>(voterService.findVoter(id), HttpStatus.OK);

    }
    @PostMapping("/delete")
    public ResponseEntity<?>deleteVoter(long id ){
        return new ResponseEntity<>(voterService.deleteVoter(id),HttpStatus.OK);
    }



}
