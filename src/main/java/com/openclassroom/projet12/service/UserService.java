package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.UserMapper;
import com.openclassroom.projet12.model.Role;
import com.openclassroom.projet12.model.RoleName;
import com.openclassroom.projet12.model.User;
import com.openclassroom.projet12.respository.RoleRepository;
import com.openclassroom.projet12.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder encoder;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public User findByEmail(String email) { return userRepository.findByEmail(email);}

    public User addUser(UserDTO userDTO) {
        User userFind = userRepository.findByEmail(userDTO.getEmail());

        if(userFind == null) {

            if (userDTO.getRoles() == null) {
                Set<Role> roles = new HashSet<>();
                Role roleUser = roleRepository.findByName(RoleName.ROLE_USER);
                roles.add(roleUser);
                userDTO.setRoles(roles);
            }

            User user = userMapper.userDTOtoUser(userDTO);
            user.setPassword(encoder.encode(user.getPassword()));
            return userRepository.save(user);

        } else throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Cet email est déjà utilisé");
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
                    .roles(userOptional.get().getRoles())
                    .build();
        }
        if(user == null) throw new NotFoundException("L'utilisateur recherché n'a pas été trouvé");
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        userMapper.updateUserFromUserDTO(userDTO, user);
        return userRepository.save(user);
    }

    public Long deleteUser(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
