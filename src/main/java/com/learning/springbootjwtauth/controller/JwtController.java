package com.learning.springbootjwtauth.controller;

import com.learning.springbootjwtauth.entity.AuthRequest;
import com.learning.springbootjwtauth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @GetMapping("/")
    public String Hello() {
        return "Welcome to learn JWT Auth";
    }
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest auth) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(auth.getUserName(), auth.getPassword())
        );
        } catch (Exception ex){
            throw new Exception("Invalid Username and Password!!");
        }
        return jwtUtil.generateToken(auth.getUserName());
    }
}
