package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.UserMapper;
import com.openclassroom.projet12.mapper.VariantMapper;
import com.openclassroom.projet12.model.Role;
import com.openclassroom.projet12.model.RoleName;
import com.openclassroom.projet12.model.User;
import com.openclassroom.projet12.model.Variant;
import com.openclassroom.projet12.respository.RoleRepository;
import com.openclassroom.projet12.respository.UserRepository;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("L'utilisateur recherché n'a pas été trouvé"));
    }

    public UserDTO findByEmail(String email) {
        return UserMapper.toUserDTO(userRepository.findByEmail(email));
    }

    public User addUser(UserDTO userDTO) {
        User userFind = userRepository.findByEmail(userDTO.getEmail());

        if (userFind == null) {
            if (userDTO.getRoles() == null) {
                Set<Role> roles = new HashSet<>();
                Role roleUser = roleRepository.findByName(RoleName.ROLE_USER);
                roles.add(roleUser);
                userDTO.setRoles(roles);
            }
            User user = UserMapper.toUser(userDTO);
            user.setPassword(encoder.encode(user.getPassword()));
            user.setNewsletter(false);
            return userRepository.save(user);
        } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cet email est déjà utilisé");
    }

    public User updateUser(UserDTO userDTO) {
        User user = getUser(userDTO.getId());
        UserMapper.update(userDTO,user);
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        return userRepository.save(user);
    }

    public Long deleteUser(Long id) {
        userRepository.deleteById(id);
        return id;
    }

    public void save(User user) {
        this.userRepository.save(user);
    }
}
