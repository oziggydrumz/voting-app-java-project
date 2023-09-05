package com.example.votingapp.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Party  {
    @Id


    @GeneratedValue(strategy = GenerationType.AUTO)
    private boolean enabled=false;
    private long partyId;
    private String name;
    private String emailAddress;

    private String passwordEncoder;






    public boolean isEnabled() {
        return enabled;
    }
}
