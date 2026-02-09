# Homework: JWT Integration

## Task Description
In this assignment, you will convert **classic session-based authentication** into **modern stateless JWT authentication**.  
Your API should **not create a session (HttpSession)** on the server. Instead, the client receives a token upon login and includes it in every subsequent request.

## Goals
- Add the library **io.jsonwebtoken (JJWT)**.
- Implement a utility class **JwtUtil** for token generation and validation.
- Create a **JwtFilter** that intercepts requests, extracts the token from the Authorization header, and authenticates the user in Spring Security.
- Configure **SecurityConfig** to work in **STATELESS** mode.

## Technical Requirements

### 1. JwtUtil
Implement the following methods:
- `generateToken(String username)`: Creates a token with an expiration time (e.g., 10 minutes) and signs it with a secret key.
- `validateToken(String token)`: Checks the signature and expiration.
- `extractUsername(String token)`: Extracts the username from the token claims.

### 2. JwtFilter
- Create a filter that extends `OncePerRequestFilter`.
- Check for the presence of the `Authorization: Bearer <token>` header.
- If the token is valid, create a `UsernamePasswordAuthenticationToken` and set it in `SecurityContextHolder`.

### 3. AuthController
- Implement the endpoint: `POST /auth/login`.
- Accepts JSON: `{ "username": "...", "password": "..." }`.
- Uses `AuthenticationManager` to validate the password.
- On success — generates a token via `JwtUtil` and returns it.

### 4. SecurityConfig
- Disable CSRF.
- Set `SessionCreationPolicy.STATELESS`.
- Add your `JwtFilter` **before** the standard `UsernamePasswordAuthenticationFilter`.

## How to Verify
1. **Login:** Make a POST request to `/auth/login` with `user/password`. Receive a token.
2. **Access:** Make a GET request to `/secured/info` with the header:  


- If the token is valid → 200 OK.
- If the token is missing or tampered → 403 Forbidden.
