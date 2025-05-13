package com.nicoletti.bootcamp.service;

import com.nicoletti.bootcamp.model.User;
import com.nicoletti.bootcamp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User registrarUsuario(String username, String password){
        String senhaCrptografada = passwordEncoder.encode(password);
        User user = new User(null, username, senhaCrptografada);
        return userRepository.save(user);
    }

    public Optional<User> buscarPorUsername(String username){
        return userRepository.findByUsername(username);
    }

}
