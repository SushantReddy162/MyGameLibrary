package com.MyGameLibrary.demo.service;

import com.MyGameLibrary.demo.DTO.AuthRequest;
import com.MyGameLibrary.demo.Security.JwtUtil;
import com.MyGameLibrary.demo.entities.User;
import com.MyGameLibrary.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String register(AuthRequest request){

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        return "user registered successfully";
    }

    public String login(AuthRequest request){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (Exception e) {
            throw e;
        }
        return jwtUtil.generateToken(request.getUsername());
    }

}
