package com.jiratask.crud.service;

import com.jiratask.crud.model.UDetails;
import com.jiratask.crud.model.User;
import com.jiratask.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user;
        if (userRepository.findByEmail(email).isPresent())
            user = userRepository.findByEmail(email).get();
        else
            throw new UsernameNotFoundException("Email isn't registered");
        return new UDetails(user);
    }
}
