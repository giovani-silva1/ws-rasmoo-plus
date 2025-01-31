package com.client.ws.rasmooplus.services.impl;

import com.client.ws.rasmooplus.model.UserCredentials;
import com.client.ws.rasmooplus.repository.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserCredentialsRepository userCredentialsRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var useDetailsOpt =  userCredentialsRepository.findByUserName(username);
        if(useDetailsOpt.isPresent()){
            return useDetailsOpt.get();
        }
        throw new UsernameNotFoundException("Usuario não encontrado" + username);
    }
}
