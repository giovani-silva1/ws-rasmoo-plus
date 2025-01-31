package com.client.ws.rasmooplus.services;

import com.client.ws.rasmooplus.dto.LoginDto;
import com.client.ws.rasmooplus.dto.jwt.TokenJwtDto;

public interface AuthenticationService {

    TokenJwtDto auth(LoginDto loginDto);
}
