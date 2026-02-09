package ua.duikt.learning.java.pro.spring.individualeighthsprint.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
/**
 * Created by Mykyta Sirobaba on 20.01.2026.
 * email mykyta.sirobaba@gmail.com
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtTool jwtTool;
    // You will also need UserDetailsService to load UserDetails

    public JwtFilter(JwtTool jwtTool) {
        this.jwtTool = jwtTool;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);

            // TODO:
            // 1. Validate the token using jwtUtil
            // 2. If valid -> extract the username
            // 3. Create a UsernamePasswordAuthenticationToken
            // 4. Set it in SecurityContextHolder.getContext().setAuthentication(...)
        }

        filterChain.doFilter(request, response);
    }
}
