package ua.duikt.learning.java.pro.spring.individualeighthsprint.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

/**
 * Created by Mykyta Sirobaba on 20.01.2026.
 * email mykyta.sirobaba@gmail.com
 */
@Component
public class JwtTool {

    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expirationMs = 1000 * 60 * 10;

    public String generateToken(String username) {
        // TODO: Use Jwts.builder() to create a token
        // .setSubject(username)
        // .setIssuedAt(new Date())
        // .setExpiration(...)
        // .signWith(secretKey)
        return "";
    }

    public boolean validateToken(String token) {
        // TODO: Check token validity (not expired, correct signature)
        // Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token)
        return false;
    }

    public String extractUsername(String token) {
        // TODO: Extract username from claims
        return null;
    }
}

