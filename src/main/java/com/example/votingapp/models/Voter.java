package com.example.votingapp.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
public class Voter implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean enabled =false;
    private String firstName;
    private String lastName;
    private String  PhoneNumber;
    private String emailAddress;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<AppRole> appRole = new ArrayList<>();

    public Voter(long id,
                 String emailAddress,
                 String password,
                 Collection<? extends GrantedAuthority> authorities) {
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String name=null;
        for(AppRole role : appRole) {
            name = role.name();
        }
        return List.of(new  SimpleGrantedAuthority(
                "ROLE_" + name
                ));
        }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return emailAddress;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
