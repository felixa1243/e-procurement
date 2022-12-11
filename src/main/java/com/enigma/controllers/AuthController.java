package com.enigma.controllers;

import com.enigma.models.requests.CredentialRequest;
import com.enigma.shared.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    JwtUtils jwtUtils;
    @PostMapping("login")
    public ResponseEntity login(@RequestBody CredentialRequest request)throws Exception{
        if(request.getUsername().equals("enigma")&&request.getPassword().equals("123")){
            return ResponseEntity.status(200).body(jwtUtils.generateToken("login"));
        }
        throw new Exception("incorect username or password");
    }
}
