package com.example.votingapp.util;

import com.example.votingapp.dto.RequestDto.VoterRegisterRequest;
import com.example.votingapp.repository.VoterRepo;
import com.example.votingapp.service.VoterService;
import com.example.votingapp.service.VoterServiceImpl;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class OtpGenerator {

       private int otpLength=4;


       public String otpGenerator(){

           int[]otpGenerator=new int[otpLength];
           for(int count=0;count<otpGenerator.length;count++){

               otpGenerator[count] = (int) (Math.random()*9);

           }
           String myOtp = "" + otpGenerator[0] + otpGenerator[1] + otpGenerator[2] + otpGenerator[3] +"";
           return myOtp;
       }




    }




