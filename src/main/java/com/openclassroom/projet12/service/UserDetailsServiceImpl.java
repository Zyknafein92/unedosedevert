package com.openclassroom.projet12.service;


import com.openclassroom.projet12.exceptions.ErrorCode;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.model.User;
import com.openclassroom.projet12.model.UserPrinciple;
import com.openclassroom.projet12.respository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new NotFoundException("L'email est introuvable ou le mot de passe est incorrect", ErrorCode.USER_NOT_FOUND_ERROR);
        }

        return UserPrinciple.build(user);
    }
}
