package com.university.universitymanagement.util;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    public String generateToken(String username) {
        long EXPIRATION_TIME = 86400000;
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getShaKeyFor(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return getJwtParser().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token, String username) {
        return username.equals(extractUsername(token)) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return getJwtParser().parseClaimsJws(token).getBody().getExpiration().before(new Date());
    }

    private JwtParser getJwtParser() {
        return Jwts.parserBuilder().setSigningKey(getShaKeyFor()).build();
    }

    private SecretKey getShaKeyFor() {
        final String SECRET_KEY = "yourSecretKeyyourSecretKeyyourSecretKeyyourSecretKeyyourSecretKeyyourSecretKeyyourSecretKeyyourSecretKeyyourSecretKey";
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }
}