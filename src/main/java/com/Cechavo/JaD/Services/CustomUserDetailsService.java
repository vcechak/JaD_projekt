package com.Cechavo.JaD.Services;

import com.Cechavo.JaD.CustomUserDetails;
import com.Cechavo.JaD.Entities.User;
import com.Cechavo.JaD.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByNick(username);
        if (user == null) {
            throw new UsernameNotFoundException("Uživatel nenalezen.");
        }
        return new CustomUserDetails(user);
    }

    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }
}
