package com.bovkun.libraryApi.service;

import com.bovkun.libraryApi.entity.auth.AuthenticationRequest;
import com.bovkun.libraryApi.entity.auth.AuthenticationResponse;
import com.bovkun.libraryApi.entity.auth.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authentication(AuthenticationRequest request);

}