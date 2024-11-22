package com.example.demo.controller;

import com.example.demo.dto.AuthenticationRequestDto;
import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.model.User;
import com.example.demo.service.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth endpoint", description = "authenticate users")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @RequestMapping(method = RequestMethod.POST)
    @Operation(
            summary = "Authenticate user",
            description = "Authenticate user using userName and password",
            tags = { "User" })
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequestDto authenticationRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
        User principal = (User) authenticate.getPrincipal();
        String token = jwtService.generateToken(principal);
        return ResponseEntity.ok(new AuthenticationResponse(principal.getId(), token));
    }

}
