package com.example.votingapp.controller;

import com.example.votingapp.dto.RequestDto.PartyRegisterRequest;
import com.example.votingapp.service.PartyAlreadyExist;
import com.example.votingapp.service.PartyDoesNotExist;
import com.example.votingapp.service.PartyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class PartyController {
  //  private final PartyRegisterRequest partyRegisterRequest;
    private final PartyService partyService;

    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }
    // PartyRegisterRequest partyRegisterRequest

    @PostMapping("party/partyRegisterRequest")
    public ResponseEntity<?> register(PartyRegisterRequest partyRegisterRequest) throws PartyAlreadyExist {
        return new ResponseEntity<>(partyService.registerParty(partyRegisterRequest), HttpStatus.CREATED);

    }



    @GetMapping("party/findParty")
  public ResponseEntity<?>findParty(String name) throws PartyDoesNotExist {
      return new ResponseEntity<>(partyService.findParty(name),HttpStatus.OK);
    }
    @DeleteMapping("party/deleteParty")
  public ResponseEntity<?>deleteParty(long id ){
      return new ResponseEntity<>(partyService.deleteParty(id),HttpStatus.OK);
    }

}
