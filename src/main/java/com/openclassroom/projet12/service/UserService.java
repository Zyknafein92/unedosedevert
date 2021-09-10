package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.exceptions.ErrorCode;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.exceptions.TokenException;
import com.openclassroom.projet12.mapper.UserMapper;
import com.openclassroom.projet12.model.*;
import com.openclassroom.projet12.respository.RoleRepository;
import com.openclassroom.projet12.respository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.*;

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
                .orElseThrow(() -> new NotFoundException(("L'utilisateur recherché n'a pas été trouvé"), ErrorCode.USER_NOT_FOUND_ERROR));
    }

    public UserDTO findUserByToken(String token) throws Exception {
        User user = userRepository.findByForgotPasswordToken(token);
        if (user.getForgotPasswordTokenExpiration().isAfter(LocalDateTime.now())) {
            return UserMapper.toUserDTO(user);
        } else throw new TokenException(("La validité du token a expiré"), ErrorCode.TOKEN_HAS_EXPIRED_ERROR);
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
            User user = UserMapper.createUser(userDTO);
            user.setPassword(encoder.encode(user.getPassword()));
            return userRepository.save(user);
        } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cet email est déjà utilisé");
    }

    public User updateUser(UserDTO userDTO) {
        User user = getUser(userDTO.getId());
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        UserMapper.update(userDTO,user);
        userRepository.save(user);
        return user;
    }

    public Long deleteUser(Long id) {
        userRepository.deleteById(id);
        return id;
    }

    public void save(User user) {
        this.userRepository.save(user);
    }

    public String forgotPassword(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) throw new NotFoundException(("L'utilisateur n'a pas été trouvé"), ErrorCode.USER_NOT_FOUND_ERROR);
        user.setForgotPasswordToken(UUID.randomUUID().toString());
        user.setForgotPasswordTokenExpiration(LocalDateTime.now().plusDays(1));
        userRepository.save(user);
        return user.getForgotPasswordToken();
    }

    public void updatePassword(Long id, String password) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException(("L'utilisateur n'existe pas"), ErrorCode.USER_NOT_FOUND_ERROR));
        user.setPassword(encoder.encode(password));
        userRepository.save(user);
    }

    public void cleanShoppingCart(String currentUsername) {
        UserDTO userDTO = findByEmail(currentUsername);
        userDTO.getShoppingCart().getShoppingCartLines().clear();
        User user = UserMapper.toUser(userDTO);
        userRepository.save(user);
    }
}
