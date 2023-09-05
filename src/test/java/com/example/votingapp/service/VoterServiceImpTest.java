package com.example.votingapp.service;

import com.example.votingapp.dto.RequestDto.VoterRegisterRequest;
import com.example.votingapp.models.AppRole;
import com.example.votingapp.models.Voter;
import com.example.votingapp.repository.VoterRepo;
import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class VoterServiceImpTest {

    @Autowired
    VoterService voterService;
    VoterRegisterRequest voterRegisterRequest;

    @Autowired
    VoterRepo voterRepo;
   // VoterFindRequest candidateFindRequest;
  //  FindVoterResponse findCandidateResponse;
    Voter voter;
    @Test
    void registerVoter() throws VoterAlreadyExist, EmailDeleveringException {
        voterRegisterRequest = new VoterRegisterRequest("jon","doe","jondoe@gmail.com",
                "111", "09065639842" );

        var voterCanRegister = voterService.registerVoter(voterRegisterRequest);
        var loadedUser = voterRepo.findByEmailAddress("oziggydrumz@gmail.com").getFirstName();
//        assertNotNull(voterCanRegister);
        assertEquals("osazee", loadedUser);
    }

    @Test
    void checkUserRole() {
        var loadedUser = voterRepo.findByEmailAddress("oziggydrumz@gmail.com").getAppRole();
//        assertNotNull(voterCanRegister);
        assertEquals(AppRole.VOTER, loadedUser.get(0));
    }
    @Test
    public void  checkUserRole2(){

    }

    @Test
    void assignRole() {

        var loadedUser = voterRepo.findByEmailAddress("oziggydrumz@gmail.com");
        loadedUser.getAppRole().add(AppRole.ADMIN);
//        assertNotNull(voterCanRegister);
        assertEquals(AppRole.ADMIN, loadedUser.getAppRole().get(1));
        assertEquals(AppRole.VOTER, loadedUser.getAppRole().get(0));
       // assertEquals(AppRole.PARTY, loadedUser.getAppRole().get(2));
    }


    @Test
    void findVoter() throws Exception, VoterDoesNotExist {
        voter =new Voter();
       // candidate.setId(1);
        var voterCanFindById= voterService.findVoter(voter.getId());
        assertNotNull(voterCanFindById);
    }
    @Test
    void deleteCandidate() {
        String deleteVoter= voterService.deleteVoter(1);
        assertEquals(deleteVoter,"delete successfully");
    }
}