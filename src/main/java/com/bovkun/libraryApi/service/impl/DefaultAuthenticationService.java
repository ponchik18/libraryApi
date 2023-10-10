package com.bovkun.libraryApi.service.impl;


import com.bovkun.libraryApi.entity.User;
import com.bovkun.libraryApi.entity.auth.AuthenticationRequest;
import com.bovkun.libraryApi.entity.auth.AuthenticationResponse;
import com.bovkun.libraryApi.entity.auth.RegisterRequest;
import com.bovkun.libraryApi.repository.UserRepository;
import com.bovkun.libraryApi.security.JwtService;
import com.bovkun.libraryApi.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultAuthenticationService implements AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder().username(request.getUsername()).password(passwordEncoder.encode(request.getPassword())).role(request.getRole()).build();
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    @Override
    public AuthenticationResponse authentication(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException(String.format("User with username '%s' not found!", request.getUsername())));
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}