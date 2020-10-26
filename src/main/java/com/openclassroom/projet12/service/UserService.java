package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.UserMapper;
import com.openclassroom.projet12.model.User;
import com.openclassroom.projet12.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public User addUser(UserDTO userDTO) {
        return userRepository.save(userMapper.userDTOtoUser(userDTO));
    }

    public User updateUser(UserDTO userDTO) {
        Optional<User> userOptional = getUser(userDTO.getId());
        User user = null;

        if(userOptional.isPresent()) {
            user = User.builder()
                    .nom(userOptional.get().getNom())
                    .prenom(userOptional.get().getPrenom())
                    .anniversaire(userOptional.get().getAnniversaire())
                    .email(userOptional.get().getEmail())
                    .telephone(userOptional.get().getTelephone())
                    .password(userOptional.get().getPassword())
                    .build();
        }
        if(user == null) throw new NotFoundException("L'utilisateur recherché n'a pas été trouvé");
        userMapper.updateUserFromUserDTO(userDTO,user);
        return userRepository.save(user);
    }

    public Long deleteUser(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
