package com.openclassroom.projet12.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public String getCurrentLoggedInUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            Object principal = auth.getPrincipal();
            return principal instanceof UserDetails ? ((UserDetails) principal).getUsername() : null;
        }
        return null;
    }
}
