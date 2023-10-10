package com.bovkun.libraryApi.controller;


import com.bovkun.libraryApi.entity.auth.AuthenticationRequest;
import com.bovkun.libraryApi.entity.auth.AuthenticationResponse;
import com.bovkun.libraryApi.entity.auth.RegisterRequest;
import com.bovkun.libraryApi.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> authentication(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authentication(request));
    }

}