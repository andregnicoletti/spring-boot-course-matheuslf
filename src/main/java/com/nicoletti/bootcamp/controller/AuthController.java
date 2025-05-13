package com.nicoletti.bootcamp.controller;

import com.nicoletti.bootcamp.model.User;
import com.nicoletti.bootcamp.security.JwtUtil;
import com.nicoletti.bootcamp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody Map<String, String> request){
        User user = userService.registrarUsuario(request.get("username"), request.get("password"));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request){
        Optional<User> user = userService.buscarPorUsername(request.get("username"));

        if(user.isPresent() && passwordEncoder.matches(request.get("password"), user.get().getPassword())){
            String token = JwtUtil.generateToken(user.get().getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity.status(401).body("Credenciais inválidas");
    }
}
