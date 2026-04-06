package com.MyGameLibrary.demo.Controller;

import com.MyGameLibrary.demo.DTO.AuthRequest;
import com.MyGameLibrary.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request){
        return new ResponseEntity<>(authService.login(request) , HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request){
        return new ResponseEntity<>(authService.register(request) , HttpStatus.CREATED);
    }


}
