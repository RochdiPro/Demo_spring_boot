package com.example.demo.service;

import com.example.demo.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    private static final byte[] SECRET_KEY = Base64.getEncoder().encode("123456dfgdfg@sdfs33333333df".getBytes());
    private Integer timeout = 60 * 180;


    @Autowired
    private UserDetailsService userService;

    public String generateToken(User user) {
        return Jwts.builder().setClaims(Map.of()).setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (timeout * 1000)))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public User validateToken(String token) {
        Claims body = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        String userName = body.getSubject();
        User userDetails = ((User) userService.loadUserByUsername(userName));
        return userDetails;
    }

}
