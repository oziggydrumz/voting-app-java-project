package com.example.votingapp.util;

import com.example.votingapp.dto.RequestDto.PartyRegisterRequest;
import com.example.votingapp.models.Party;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Builder
public class PartyMapper {
    public  Party map(PartyRegisterRequest request){
        Party party=new Party();
        party.setName(request.getName());
        party.setEmailAddress(request.getEmailAddress());

        return new Party();


    }
}
